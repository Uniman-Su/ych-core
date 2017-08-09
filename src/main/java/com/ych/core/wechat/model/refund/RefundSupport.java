package com.ych.core.wechat.model.refund;

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
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.ych.core.wechat.model.ParameterProvider;
import com.ych.core.wechat.model.order.FeeType;
import com.ych.core.wechat.model.order.query.RefundAccount;
import com.ych.core.wechat.utils.MapUtils;
import com.ych.core.wechat.utils.UniqueUtils;

public class RefundSupport implements Refund, InitializingBean {

    private Logger logger = LoggerFactory.getLogger(RefundSupport.class);

    private RestTemplate restTemplate;

    private ParameterProvider parameterProvider;

    private RefundRecord refundRecord;

    private String defaultCharset;


    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void setParameterProvider(ParameterProvider parameterProvider) {
        this.parameterProvider = parameterProvider;
    }

    public void setRefundRecord(RefundRecord refundRecord) {
        this.refundRecord = refundRecord;
    }

    public void setDefaultCharset(String defaultCharset) {
        this.defaultCharset = defaultCharset;
    }

    @Override
    public RefundResp refund(String outTradeNo, String transactionId, String outRefundNo, BigDecimal totalFee, BigDecimal refundFee, FeeType refundFeeType,
            RefundAccount refundAccount) {
        String appId = parameterProvider.getAppID();
        String mchId = parameterProvider.getMchId();
        String nonceStr = UniqueUtils.uniqueString();
        String signKey = parameterProvider.getSignKey();
        Assert.isTrue(!(StringUtils.isEmpty(outTradeNo) && StringUtils.isEmpty(transactionId)), "outTradeNo and transactionId is null");
        Assert.notNull(appId, "appId can not be null");
        Assert.notNull(mchId, "mchId can not be null");
        Assert.notNull(signKey, "signKey can not be null");

        Map<String, Object> map = new HashMap<>();
        if (!StringUtils.isEmpty(appId)) {
            map.put("appid", appId);
        }
        if (!StringUtils.isEmpty(mchId)) {
            map.put("mch_id", mchId);
        }
        if (!StringUtils.isEmpty(nonceStr)) {
            map.put("nonce_str", nonceStr);
        }

        if (!StringUtils.isEmpty(outTradeNo)) {
            map.put("out_trade_no", outTradeNo);
        } else if (!StringUtils.isEmpty(transactionId)) {
            map.put("transaction_id", transactionId);
        }
        if (!StringUtils.isEmpty(outRefundNo)) {
            map.put("out_refund_no", outRefundNo);
        }
        map.put("total_fee", totalFee.longValue());
        map.put("refund_fee", refundFee.longValue());
        if (refundFeeType != null) {
            map.put("refund_fee_type", refundFeeType);
        }
        if (!StringUtils.isEmpty(mchId)) {
            map.put("op_user_id", mchId);
        }
        if (refundAccount != null) {
            map.put("refund_account", refundAccount.toString());
        }

        String signTempString = MapUtils.toSortQueryString(map) + "&key=" + signKey;
        logger.info("signTempString[{}]", signTempString);
        String sign = DigestUtils.md5Hex(signTempString).toUpperCase();

        String xml = getReqXml(outTradeNo, transactionId, outRefundNo, totalFee, refundFee, refundFeeType, refundAccount, appId, mchId, nonceStr, sign);

        logger.info("request xml[{}]", xml);
        if (refundRecord != null) {
            refundRecord.before(StringUtils.isEmpty(outTradeNo) ? transactionId : outTradeNo, xml);
        }
        HttpEntity<String> entity = new HttpEntity<String>(xml);
        ResponseEntity<String> resp = restTemplate.postForEntity(REQUEST_ADDRESS, entity, String.class);
        logger.info("response xml[{}]",resp.getBody());
        if (refundRecord != null) {
            refundRecord.after(StringUtils.isEmpty(outTradeNo) ? transactionId : outTradeNo, resp.getBody());
        }
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            return xmlMapper.readValue(resp.getBody(), RefundResp.class);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getReqXml(String outTradeNo, String transactionId, String outRefundNo, BigDecimal totalFee, BigDecimal refundFee, FeeType refundFeeType,
            RefundAccount refundAccount, String appId, String mchId, String nonceStr, String sign) {
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

        if (!StringUtils.isEmpty(outTradeNo)) {
            xmlBuffer.append("<out_trade_no>");
            xmlBuffer.append(outTradeNo);
            xmlBuffer.append("</out_trade_no>");
        } else {
            xmlBuffer.append("<transaction_id>");
            xmlBuffer.append(transactionId);
            xmlBuffer.append("</transaction_id>");
        }
        if (!StringUtils.isEmpty(outRefundNo)) {
            xmlBuffer.append("<out_refund_no>");
            xmlBuffer.append(outRefundNo);
            xmlBuffer.append("</out_refund_no>");
        }

        xmlBuffer.append("<total_fee>");
        xmlBuffer.append(totalFee.longValue());
        xmlBuffer.append("</total_fee>");
        xmlBuffer.append("<refund_fee>");
        xmlBuffer.append(refundFee.longValue());
        xmlBuffer.append("</refund_fee>");
        if (refundFeeType != null) {
            xmlBuffer.append("<refund_fee_type>");
            xmlBuffer.append(refundFeeType.toString());
            xmlBuffer.append("</refund_fee_type>");
        }

        if (!StringUtils.isEmpty(mchId)) {
            xmlBuffer.append("<op_user_id>");
            xmlBuffer.append(mchId);
            xmlBuffer.append("</op_user_id>");
        }
        if (refundAccount != null) {
            xmlBuffer.append("<refund_account>");
            xmlBuffer.append(refundAccount.toString());
            xmlBuffer.append("</refund_account>");
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
