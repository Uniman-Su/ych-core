package com.ych.core.umeng.pushmsg.ios;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 消息内容(iOS最大为2012B)
 * 
 * @author U
 *
 */
@JsonInclude(value = Include.NON_NULL)
public class IOSSendRequestPayload extends HashMap<String, Object> {

	private static final long serialVersionUID = -6183824379883427861L;

	/**
	 * APNs存放的Key
	 */
	public static final String APN_KEY = "aps";

	/**
	 * @return 必填 严格按照APNs定义来填写
	 */
	public IOSSendRequestAPNs getAps() {
		return (IOSSendRequestAPNs) get(APN_KEY);
	}

	/**
	 * @param aps
	 *            必填 严格按照APNs定义来填写
	 */
	public void setAps(IOSSendRequestAPNs aps) {
		put(APN_KEY, aps);
	}

	/**
	 * 获取指定扩展键的值
	 * 
	 * @param key
	 *            扩展键
	 * @return 值
	 */
	public String getValue(String key) {
		return (String) getValue(key);
	}

	/**
	 * 设置指定扩展键的值
	 * 
	 * @param key
	 *            扩展键
	 * @param value
	 *            值
	 */
	public void setValue(String key, String value) {
		put(key, value);
	}

	/**
	 * 移除指定扩展键的值
	 * 
	 * @param key
	 *            扩展键
	 */
	public void removeValue(String key) {
		remove(key);
	}

}
