package com.ych.core.model;

/**
 * 保存整型数枚举的接口
 * 
 * @author U
 *
 */
public interface IntValueHolder<T extends Enum<T>> {

	/**
	 * @return 获取数值
	 */
	int getValue();
}
