package com.ych.core.map.amap.model;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import com.ych.core.map.utils.MapUtils;

public class AmapCoreSupport implements AmapCore {
	
	private Logger logger =  LoggerFactory.getLogger(AmapCoreSupport.class);

	private KeyProvider keyProvider;
	
	private RestTemplate restTemplate;
	

	public void setKeyProvider(KeyProvider keyProvider) {
		this.keyProvider = keyProvider;
	}

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public <V extends RespBase> V getForObject(String relativeUrl, Class<V> clz, Map<String, Object> params) {
		Assert.notNull(keyProvider, "the instance of KeyProvider didn't inject");
		Assert.notNull(restTemplate, "the instance of RestTemplate didn't inject");
		String sortQueryStr = MapUtils.toSortQueryString(params);
		String privateKey = keyProvider.getPrivateKey();
		String sig=null;
		try {
			sig = DigestUtils.md5Hex(new String(sortQueryStr+privateKey).getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			logger.error("amap[MD5 encript failure,UnsupportedEncodingException]");
		}
		String queryStr = sortQueryStr+"&sig="+sig;
		return restTemplate.getForObject(keyProvider.getDomain() + relativeUrl+"?"+queryStr, clz, new Object[]{});
	}

	@Override
	public <V extends RespBase> V postForObject(String relativeUrl, Class<V> clz, Map<String, Object> params) {
		Assert.notNull(keyProvider, "the instance of KeyProvider didn't inject");
		Assert.notNull(restTemplate, "the instance of RestTemplate didn't inject");
		String sortQueryStr = MapUtils.toSortQueryString(params);
		String privateKey = keyProvider.getPrivateKey();
		String sig=null;
		try {
			sig = DigestUtils.md5Hex(new String(sortQueryStr+privateKey).getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			logger.error("amap[MD5 encript failure,UnsupportedEncodingException]");
		}
		String queryStr = sortQueryStr+"&sig="+sig;
		HttpEntity<String> entity = new HttpEntity<String>(queryStr);
		return restTemplate.postForObject(keyProvider.getDomain() + relativeUrl, entity, clz);
	}



}
