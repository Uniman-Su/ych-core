package com.ych.core.wechat.utils;

import java.util.UUID;

/**
 * 唯一数据生成器
 * 
 * @author &Sunny
 *
 */
public abstract class UniqueUtils {

	/**
	 * 生成16位唯一字符串
	 * 
	 * @return
	 */
	public static String uniqueString() {
		return UUID.randomUUID().toString().replaceAll("-","");
	}
	
}
