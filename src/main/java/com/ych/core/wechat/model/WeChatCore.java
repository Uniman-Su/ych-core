package com.ych.core.wechat.model;

import java.util.Map;

import com.ych.core.map.amap.model.RespBase;

public interface WeChatCore {

	<V extends ResponseEntity> V getObject(String urlTemplate, Class<V> clz, String... params);
	
	<V extends RespBase> V postForObject(String relativeUrl, Class<V> clz, Map<String, Object> params);
	
}
