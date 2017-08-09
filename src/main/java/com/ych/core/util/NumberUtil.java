package com.ych.core.util;

import java.math.BigDecimal;

/**
 * 数字相关的工具
 * 
 * @author U
 *
 */
public class NumberUtil {

	private NumberUtil() {
	}

	/**
	 * 判断两个BigDecimal是否相等
	 * 
	 * @param decimal1
	 * @param decimal2
	 * @return 相等则返回true
	 */
	public static boolean equals(BigDecimal decimal1, BigDecimal decimal2) {
		return (decimal1 != null && decimal1.equals(decimal2)) || (decimal1 == null && decimal2 == null);
	}

}
