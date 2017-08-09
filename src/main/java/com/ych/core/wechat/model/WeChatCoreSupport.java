package com.ych.core.wechat.model;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import com.ych.core.map.amap.model.RespBase;

public class WeChatCoreSupport implements WeChatCore {

	protected Logger logger = LoggerFactory.getLogger(WeChatCoreSupport.class);

	private RestTemplate restTemplate;
	
	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public <V extends ResponseEntity> V getObject(String urlTemplate, Class<V> clz, String... params) {
		try {
			Assert.notNull(urlTemplate, "the instance of RestTemplate didn't inject");
			logger.info(String.format("Wechat request[%s]", urlTemplate));
			Object[] pArray = new Object[params.length];
			System.arraycopy(params, 0, pArray, 0, params.length);;
			V v = restTemplate.getForObject(urlTemplate, clz, pArray);
			boolean success = v.getErrcode() == null || v.getErrcode().equals(ResponseEntity.SUCCESS_CODE) ? true
					: false;
			v.setSuccess(success);
			logger.info(String.format("Wechat response[%s]", v));
			return v;
		} catch (Exception e) {
			logger.error("Wechat request error", e);
		}
		try {
			return clz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			logger.error("Wechat request error", e);
		}
		return null;
	}

	@Override
	public <V extends RespBase> V postForObject(String relativeUrl, Class<V> clz, Map<String, Object> params) {
		
		return null;
	}

}
