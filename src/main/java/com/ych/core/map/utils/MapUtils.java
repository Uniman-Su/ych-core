package com.ych.core.map.utils;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * Map工具类
 * @author sunny
 *
 */
public abstract class MapUtils {

	/**
	 * 将map转换为查询字符串
	 * @param map
	 * @return
	 */
	public static String toQueryString(Map<String, Object> map) {
		StringBuffer buffer = new StringBuffer();
		if (map != null) {
			for (Entry<String, Object> entry : map.entrySet()) {
				if (entry.getValue() != null) {
					buffer.append(entry.getKey());
					buffer.append("=");

					if (entry.getValue() instanceof String) {
						buffer.append(String.valueOf(entry.getValue()));
					} else {
						buffer.append(entry.getValue());
					}

					buffer.append("&");
				}
			}
		}

		if (buffer.length() >= 0) {
			buffer = buffer.deleteCharAt(buffer.length() - 1);
		}

		return buffer.toString();
	}

	/**
	 * 将map转换为查询字符串，参数按字母字典顺序排序
	 * @param map
	 * @return
	 */
	public static String toSortQueryString(Map<String, Object> map) {
		Map<String, Object> treeMap = new TreeMap<>(map);
		return toQueryString(treeMap);
	}

}
