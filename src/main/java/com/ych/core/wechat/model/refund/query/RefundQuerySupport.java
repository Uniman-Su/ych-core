package com.ych.core.wechat.model.refund.query;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.ych.core.wechat.model.ParameterProvider;
import com.ych.core.wechat.utils.MapUtils;
import com.ych.core.wechat.utils.UniqueUtils;

public class RefundQuerySupport implements RefundQuery {

	  private Logger logger = LoggerFactory.getLogger(RefundQuerySupport.class);
		
	  private RestTemplate restTemplate;
		
	  private ParameterProvider parameterProvider;
		
	  private RefundQueryRecord refundQueryRecord;
	  
	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public void setParameterProvider(ParameterProvider parameterProvider) {
		this.parameterProvider = parameterProvider;
	}

	public void setRefundQueryRecord(RefundQueryRecord refundQueryRecord) {
		this.refundQueryRecord = refundQueryRecord;
	}

	@Override
	public RefundQueryResp query(String outRefundNo, String outTradeNo, String transactionId, String refundId) {
		String appId = parameterProvider.getAppID();
		String mchId =parameterProvider.getMchId();
		String nonceStr = UniqueUtils.uniqueString();
		String signKey = parameterProvider.getSignKey();
		Assert.isTrue(StringUtils.isEmpty(outTradeNo) && StringUtils.isEmpty(transactionId) && StringUtils.isEmpty(outRefundNo) && StringUtils.isEmpty(refundId), "parameter can not all be null");
		Assert.isNull(appId, "appId can not be null");
		Assert.isNull(mchId, "mchId can not be null");
		Assert.isNull(signKey, "signKey can not be null");
		
		Map<String,Object> map = new HashMap<>();
		map.put("appid", appId);
		map.put("mch_id", mchId);
		map.put("nonce_str ", nonceStr);
		if(!StringUtils.isEmpty(outRefundNo)){
			map.put("out_refund_no", outRefundNo);
		}else if(!StringUtils.isEmpty(outTradeNo)){
			map.put("out_trade_no", outTradeNo);
		}else if(!StringUtils.isEmpty(transactionId)){
			map.put("transaction_id", transactionId);
		}else if(!StringUtils.isEmpty(refundId)){
			map.put("refund_id", refundId);
		}
		
		
		String signTempString = MapUtils.toSortQueryString(map);
		logger.info("signTempString[{}]",signTempString);
		String sign = DigestUtils.md5Hex(signTempString+signKey);
		
		String xml = getReqXml(outRefundNo,outTradeNo, transactionId,  refundId, appId, mchId, nonceStr, sign);
		
		logger.info("request xml[{}]"+xml);
		if(refundQueryRecord!=null){
			String no = null;
			if(!StringUtils.isEmpty(outRefundNo)){
				no = outRefundNo;
			}else if(!StringUtils.isEmpty(outTradeNo)){
				no = outTradeNo;
			}else if(!StringUtils.isEmpty(transactionId)){
				no = transactionId;
			}else if(!StringUtils.isEmpty(refundId)){
				no = refundId;
			}
			refundQueryRecord.before(no, xml);
		}
		HttpEntity<String> entity = new HttpEntity<String>(xml);
		ResponseEntity<String> resp = restTemplate.postForEntity(REQUEST_ADDRESS, entity, String.class);
		logger.info("response xml[{}]"+resp.getBody());
		if(refundQueryRecord!=null){
			String no = null;
			if(!StringUtils.isEmpty(outRefundNo)){
				no = outRefundNo;
			}else if(!StringUtils.isEmpty(outTradeNo)){
				no = outTradeNo;
			}else if(!StringUtils.isEmpty(transactionId)){
				no = transactionId;
			}else if(!StringUtils.isEmpty(refundId)){
				no = refundId;
			}
			refundQueryRecord.after(no, resp.getBody());
		}
		XmlMapper xmlMapper = new XmlMapper();
		try {
			return xmlMapper.readValue(resp.getBody(), RefundQueryResp.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private String getReqXml(String outRefundNo,String outTradeNo, String transactionId,  String refundId,String appId, String mchId, String nonceStr,
			String sign) {
		StringBuffer xmlBuffer = new StringBuffer();
		xmlBuffer.append("<xml>");
		xmlBuffer.append("<appid>");
		xmlBuffer.append(appId);
		xmlBuffer.append("</appid>");
		xmlBuffer.append("<mch_id>");
		xmlBuffer.append(mchId);
		xmlBuffer.append("</mch_id>");
		xmlBuffer.append("<nonce_str>");
		xmlBuffer.append(nonceStr);
		xmlBuffer.append("</nonce_str>");
		xmlBuffer.append("<sign>");
		xmlBuffer.append(sign);
		xmlBuffer.append("</sign>");
		if(!StringUtils.isEmpty(outRefundNo)){
			xmlBuffer.append("<out_refund_no>");
			xmlBuffer.append(outRefundNo);
			xmlBuffer.append("</out_refund_no>");
		}else if(!StringUtils.isEmpty(outTradeNo)){
			xmlBuffer.append("<out_trade_no>");
			xmlBuffer.append(outTradeNo);
			xmlBuffer.append("</out_trade_no>");
		}else if(!StringUtils.isEmpty(transactionId)){
			xmlBuffer.append("<transaction_id>");
			xmlBuffer.append(transactionId);
			xmlBuffer.append("</transaction_id>");
		}else if(!StringUtils.isEmpty(refundId)){
			xmlBuffer.append("<refund_id>");
			xmlBuffer.append(refundId);
			xmlBuffer.append("</refund_id>");
		}
		xmlBuffer.append("</xml>");
		String xml =  xmlBuffer.toString();
		return xml;
	}
}
