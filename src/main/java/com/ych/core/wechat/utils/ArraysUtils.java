package com.ych.core.wechat.utils;

/**
 * 数组工具类
 * 
 * @author SUNCHUANLIN
 * @since
 *
 */
public class ArraysUtils {

	/**
	 * 将字符串数组按元素下标从小到大连接
	 * 
	 * @param arr
	 *            字符串数组
	 * @return
	 */
	public static String join(String[] arr) {
		return join(arr, null);
	}

	/**
	 * 将字符串数组按元素下标从小到大用分隔符连接
	 * 
	 * @param arr
	 *            字符串数组
	 * @param separator
	 *            分隔符
	 * @return
	 */
	public static String join(String[] arr, String separator) {
		if (arr != null) {
			StringBuilder content = new StringBuilder();
			for (int i = 0; i < arr.length; i++) {
				content.append(arr[i]);
				if (separator != null && i != arr.length - 1) {
					content.append(separator);
				}
			}
			return content.toString();
		}
		return null;
	}

}
