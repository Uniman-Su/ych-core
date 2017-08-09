package com.ych.core.wechat.model.order;

import java.io.IOException;
import java.math.BigDecimal;
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
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.ych.core.wechat.model.ParameterProvider;
import com.ych.core.wechat.utils.MapUtils;
import com.ych.core.wechat.utils.UniqueUtils;

public class UnifiedorderSupport implements Unifiedorder, InitializingBean {

    private Logger logger = LoggerFactory.getLogger(UnifiedorderSupport.class);

    private RestTemplate restTemplate;

    private ParameterProvider parameterProvider;

    private OrderRecord orderRecord;

    private String defaultCharset;

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void setParameterProvider(ParameterProvider parameterProvider) {
        this.parameterProvider = parameterProvider;
    }

    public void setAfterOrder(OrderRecord orderRecord) {
        this.orderRecord = orderRecord;
    }

    public void setDefaultCharset(String defaultCharset) {
        this.defaultCharset = defaultCharset;
    }

    @Override
    public OrderResp order(String body, String deviceInfo, GoodsList detail, String attach, String outTradeNo, FeeType feeType, BigDecimal total_fee, String spbillCreateIp,
            String timeStart, String timeExpire, String goodsTag, String notifyUrl, TradeType tradeType, String productId, LimitPay limitPay, String openid) {

        String appId = parameterProvider.getAppID();
        String mchId = parameterProvider.getMchId();
        if (StringUtils.isEmpty(notifyUrl)) {
            notifyUrl = parameterProvider.getPayCallbackUrl();
        }
        String nonceStr = UniqueUtils.uniqueString();
        Assert.notNull(tradeType, "tradeType can not be null");
        if (tradeType == TradeType.JSAPI) {
            Assert.isTrue("WEB".equals(deviceInfo), "deviceInfo must be WEB");
            Assert.notNull(openid, "openid can not be null");
        }
        if (tradeType == TradeType.NATIVE) {
            Assert.notNull(productId, "productId can not be null");
        }

        Assert.notNull(appId, "appId can not be null");
        Assert.notNull(mchId, "mchId can not be null");
        Assert.notNull(nonceStr, "nonceStr can not be null");
        Assert.notNull(body, "body can not be null");
        Assert.notNull(outTradeNo, "outTradeNo can not be null");
        Assert.notNull(spbillCreateIp, "spbillCreateIp can not be null");
        Assert.notNull(notifyUrl, "notifyUrl can not be null");

        Map<String, Object> map = new HashMap<>();
        if (!StringUtils.isEmpty(appId)) {
            map.put("appid", appId);
        }
        if (!StringUtils.isEmpty(mchId)) {
            map.put("mch_id", mchId);
        }
        if (!StringUtils.isEmpty(deviceInfo)) {
            map.put("device_info", deviceInfo);
        }
        if (!StringUtils.isEmpty(nonceStr)) {
            map.put("nonce_str", nonceStr);
        }
        if (!StringUtils.isEmpty(body)) {
            map.put("body", body);
        }
        String jsonDetail = null;
        if (detail != null && detail.getGoods_detail() != null && detail.getGoods_detail().size() > 0) {
            ObjectMapper mapper = new ObjectMapper();
            try {
                jsonDetail = mapper.writeValueAsString(detail);
                map.put("detail", jsonDetail);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        
        if (!StringUtils.isEmpty(attach)) {
            map.put("attach", attach);
        }
        if (!StringUtils.isEmpty(outTradeNo)) {
            map.put("out_trade_no", outTradeNo);
        }
        if (feeType!=null) {
            map.put("fee_type", feeType.toString());
        }
        map.put("total_fee", total_fee.longValue());
        if (!StringUtils.isEmpty(spbillCreateIp)) {
            map.put("spbill_create_ip", spbillCreateIp);
        }
        if (!StringUtils.isEmpty(timeStart)) {
            map.put("time_start", timeStart);
        }
        if (!StringUtils.isEmpty(timeExpire)) {
            map.put("time_expire", timeExpire);
        }
        if (!StringUtils.isEmpty(goodsTag)) {
            map.put("goods_tag", goodsTag);
        }
        if (!StringUtils.isEmpty(notifyUrl)) {
            map.put("notify_url", notifyUrl);
        }
        
        if (tradeType!=null) {
            map.put("trade_type", tradeType.toString());
        }
        if (!StringUtils.isEmpty(productId)) {
            map.put("product_id", productId);
        }
        if (limitPay!=null) {
            map.put("limit_pay", limitPay.toString());
        }
        if (!StringUtils.isEmpty(openid)) {
            map.put("openid", openid);
        }
        
        String signTempString = MapUtils.toSortQueryString(map);
        String key = parameterProvider.getSignKey();
        logger.info("sign key[{}]", key);
        String signTempStr = signTempString +"&key=" +key;
        logger.info("signTempStr[{}]", signTempStr);
        String sign = DigestUtils.md5Hex(signTempStr).toUpperCase();

        String xml = getRequestXml(body, deviceInfo, attach, outTradeNo, feeType, total_fee, spbillCreateIp, timeStart, timeExpire, goodsTag, notifyUrl, tradeType, productId,
                limitPay, openid, appId, mchId, nonceStr, jsonDetail, sign);
        logger.info("request xml[{}]", xml);
        if (orderRecord != null) {
            orderRecord.before(outTradeNo, xml);
        }

        HttpEntity<String> entity = new HttpEntity<String>(xml);
        ResponseEntity<String> resp = restTemplate.postForEntity(REQUEST_ADDRESS, entity, String.class);
        logger.info("response xml[{}]", resp.getBody());
        if (orderRecord != null) {
            orderRecord.after(outTradeNo, resp.getBody());
        }
        XmlMapper xmlMapper = new XmlMapper();
        try {
            return xmlMapper.readValue(resp.getBody(), OrderResp.class);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getRequestXml(String body, String deviceInfo, String attach, String outTradeNo, FeeType feeType, BigDecimal total_fee, String spbillCreateIp, String timeStart,
            String timeExpire, String goodsTag, String notifyUrl, TradeType tradeType, String productId, LimitPay limitPay, String openid, String appId, String mchId,
            String nonceStr, String jsonDetail, String sign) {
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
        if (!StringUtils.isEmpty(deviceInfo)) {
            xmlBuffer.append("<device_info>");
            xmlBuffer.append(deviceInfo);
            xmlBuffer.append("</device_info>");
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
        if (!StringUtils.isEmpty(body)) {
            xmlBuffer.append("<body>");
            xmlBuffer.append(body);
            xmlBuffer.append("</body>");
        }
        if (!StringUtils.isEmpty(jsonDetail)) {
            xmlBuffer.append("<detail>");
            if (jsonDetail != null) {
                xmlBuffer.append("<![CDATA[");
                xmlBuffer.append(jsonDetail);
                xmlBuffer.append("]]");
            }
            xmlBuffer.append("</detail>");
        }
        if (!StringUtils.isEmpty(attach)) {
            xmlBuffer.append("<attach>");
            xmlBuffer.append(attach);
            xmlBuffer.append("</attach>");
        }

        if (!StringUtils.isEmpty(outTradeNo)) {
            xmlBuffer.append("<out_trade_no>");
            xmlBuffer.append(outTradeNo);
            xmlBuffer.append("</out_trade_no>");
        }
        if (feeType != null) {
            xmlBuffer.append("<fee_type>");
            xmlBuffer.append(feeType.toString());
            xmlBuffer.append("</fee_type>");
        }
        xmlBuffer.append("<total_fee>");
        xmlBuffer.append(total_fee.longValue());
        xmlBuffer.append("</total_fee>");
        if (!StringUtils.isEmpty(spbillCreateIp)) {
            xmlBuffer.append("<spbill_create_ip>");
            xmlBuffer.append(spbillCreateIp);
            xmlBuffer.append("</spbill_create_ip>");
        }

        if (!StringUtils.isEmpty(timeStart)) {
            xmlBuffer.append("<time_start>");
            xmlBuffer.append(timeStart);
            xmlBuffer.append("</time_start>");
        }

        if (!StringUtils.isEmpty(timeExpire)) {
            xmlBuffer.append("<time_expire>");
            xmlBuffer.append(timeExpire);
            xmlBuffer.append("</time_expire>");
        }
        if (!StringUtils.isEmpty(goodsTag)) {
            xmlBuffer.append("<goods_tag>");
            xmlBuffer.append(goodsTag);
            xmlBuffer.append("</goods_tag>");
        }
        if (!StringUtils.isEmpty(spbillCreateIp)) {
            xmlBuffer.append("<notify_url>");
            xmlBuffer.append(notifyUrl);
            xmlBuffer.append("</notify_url>");
        }
        if (tradeType != null) {
            xmlBuffer.append("<trade_type>");
            xmlBuffer.append(tradeType.toString());
            xmlBuffer.append("</trade_type>");
        }
        if (!StringUtils.isEmpty(productId)) {
            xmlBuffer.append("<product_id>");
            xmlBuffer.append(productId);
            xmlBuffer.append("</product_id>");
        }
        if (limitPay != null) {
            xmlBuffer.append("<limit_pay>");
            xmlBuffer.append(limitPay.toString());
            xmlBuffer.append("</limit_pay>");
        }
        if (!StringUtils.isEmpty(openid)) {
            xmlBuffer.append("<openid>");
            xmlBuffer.append(openid);
            xmlBuffer.append("</openid>");
        }

        xmlBuffer.append("</xml>");
        return xmlBuffer.toString();
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
