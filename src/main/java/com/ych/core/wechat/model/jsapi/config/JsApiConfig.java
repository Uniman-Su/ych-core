package com.ych.core.wechat.model.jsapi.config;
/**
 * JS SDK Api 配置接口
 * @author &Sunny
 *
 */
public interface JsApiConfig {

	/**
	 * 获取JS SDK Api 配置对象
	 * @param url 当前请求地址
	 * @return
	 */
	WxJsConfig getJsApiConfig(String url);
}
