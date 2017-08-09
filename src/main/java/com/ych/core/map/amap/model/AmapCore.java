package com.ych.core.map.amap.model;

import java.util.Map;

/**
 * 高德地图接口调用公共类
 * @author sunny
 *
 */
public interface AmapCore {
	/**
	 * Bmap GET 请求，默认使用sn签名模式
	 * 
	 * @param relativeUrl
	 *            请求相对路径:/geocoder/v2
	 * @param clz
	 *            返回数据类型Class
	 * @param params
	 *            请求参数键值对，key与接口参数名相同,不包括ak、sk、sn
	 * @return
	 */
	<V extends RespBase> V getForObject(String relativeUrl, Class<V> clz, Map<String, Object> params);


	/**
	 * Bmap POST 请求，默认使用sn签名模式
	 * 
	 * @param relativeUrl
	 *            请求相对路径:/geocoder/v2
	 * @param clz
	 *            clz 返回数据类型Class
	 * @param params
	 *            params 请求参数键值对，key与接口参数名相同,不包括ak、sk、sn
	 * @return
	 */
	<V extends RespBase> V postForObject(String relativeUrl, Class<V> clz, Map<String, Object> params);


}
