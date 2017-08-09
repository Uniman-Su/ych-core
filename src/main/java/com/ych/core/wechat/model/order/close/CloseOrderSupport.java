package com.ych.core.wechat.model.order.close;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.ych.core.wechat.model.ParameterProvider;
import com.ych.core.wechat.utils.MapUtils;
import com.ych.core.wechat.utils.UniqueUtils;

public class CloseOrderSupport implements CloseOrder, InitializingBean {

    Logger logger = LoggerFactory.getLogger(CloseOrderSupport.class);

    private RestTemplate restTemplate;

    private ParameterProvider parameterProvider;

    private CloseOrderRecord closeOrderRecord;

    private String defaultCharset;

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void setParameterProvider(ParameterProvider parameterProvider) {
        this.parameterProvider = parameterProvider;
    }

    public void setCloseOrderRecord(CloseOrderRecord closeOrderRecord) {
        this.closeOrderRecord = closeOrderRecord;
    }

    public void setDefaultCharset(String defaultCharset) {
        this.defaultCharset = defaultCharset;
    }

    @Override
    public CloseOrderResp close(String outTradeNo) {
        String appId = parameterProvider.getAppID();
        String mchId = parameterProvider.getMchId();
        String nonceStr = UniqueUtils.uniqueString();
        String signKey = parameterProvider.getSignKey();

        Assert.notNull(appId, "appId can not be null");
        Assert.notNull(mchId, "mchId can not be null");
        Assert.notNull(signKey, "signKey can not be null");
        Assert.notNull(outTradeNo, "outTradeNo can not be null");

        Map<String, Object> map = new HashMap<>();
        if (!StringUtils.isEmpty(appId)) {
            map.put("appid", appId);
        }
        if (!StringUtils.isEmpty(mchId)) {
            map.put("mch_id", mchId);
        }
        if (!StringUtils.isEmpty(outTradeNo)) {
            map.put("out_trade_no", outTradeNo);
        }
        if (!StringUtils.isEmpty(nonceStr)) {
            map.put("nonce_str", nonceStr);
        }

        String signTempString = MapUtils.toSortQueryString(map)+"&key=" + signKey;
        logger.info("signTempString[{}]", signTempString);
        String sign = DigestUtils.md5Hex(signTempString).toUpperCase();
        String xml = getReqXml(outTradeNo, appId, mchId, nonceStr, sign);
        logger.info("request xml[{}]", xml);
        if (closeOrderRecord != null) {
            closeOrderRecord.before(outTradeNo, xml);
        }
        HttpEntity<String> entity = new HttpEntity<String>(xml);
        ResponseEntity<String> resp = restTemplate.postForEntity(REQUEST_ADDRESS, entity, String.class);
        logger.info("response xml[{}]", resp.getBody());
        if (closeOrderRecord != null) {
            closeOrderRecord.after(outTradeNo, resp.getBody());
        }
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            CloseOrderResp closeOrderResp =  xmlMapper.readValue(resp.getBody(), CloseOrderResp.class);
            return closeOrderResp;
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getReqXml(String outTradeNo, String appId, String mchId, String nonceStr, String sign) {
        StringBuffer xmlBuffer = new StringBuffer();
        xmlBuffer.append("<xml>");
        if (!StringUtils.isEmpty(appId)) {
            xmlBuffer.append("<appid>");
            xmlBuffer.append(appId);
            xmlBuffer.append("</appid>");
        }
        if (!StringUtils.isEmpty(mchId)) {
            xmlBuffer.append("<mch_id>");
            xmlBuffer.append(mchId);
            xmlBuffer.append("</mch_id>");
        }
        if (!StringUtils.isEmpty(outTradeNo)) {
            xmlBuffer.append("<out_trade_no>");
            xmlBuffer.append(outTradeNo);
            xmlBuffer.append("</out_trade_no>");
        }
        if (!StringUtils.isEmpty(nonceStr)) {
            xmlBuffer.append("<nonce_str>");
            xmlBuffer.append(nonceStr);
            xmlBuffer.append("</nonce_str>");
        }
        if (!StringUtils.isEmpty(sign)) {
            xmlBuffer.append("<sign>");
            xmlBuffer.append(sign);
            xmlBuffer.append("</sign>");
        }
        xmlBuffer.append("</xml>");

        String xml = xmlBuffer.toString();
        return xml;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (defaultCharset != null && restTemplate != null) {
            for (Iterator<HttpMessageConverter<?>> iter = restTemplate.getMessageConverters().iterator(); iter.hasNext();) {
                HttpMessageConverter<?> converter = iter.next();

                if (converter instanceof StringHttpMessageConverter) {
                    iter.remove();
                    StringHttpMessageConverter c = new StringHttpMessageConverter(Charset.forName("UTF-8"));
                    List<MediaType> list = new ArrayList<>();
                    list.add(MediaType.TEXT_PLAIN);
                    c.setSupportedMediaTypes(list);
                    c.setWriteAcceptCharset(true);
                    restTemplate.getMessageConverters().add(0, c);
                    break;
                }
            }
        }
    }

}
