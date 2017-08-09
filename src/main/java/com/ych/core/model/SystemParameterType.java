package com.ych.core.model;

/**
 * 系统参数类型
 * 
 * @author U
 *
 */
public enum SystemParameterType implements IntValueHolder<SystemParameterType> {

	/**
	 * Integer
	 */
	INTEGER(0),

	/**
	 * Long
	 */
	LONG(1),

	/**
	 * Decimal
	 */
	DECIMAL(2),

	/**
	 * String
	 */
	STRING(3),

	/**
	 * Boolean
	 */
	BOOLEAN(4),
	
	/**
	 * 时间,存储内容为UTC时间戳
	 */
	DATETIME(5),
	
	/**
	 * 字符串列表
	 */
	STRINGLIST(6),

	/**
	 * BigDecimal列表
	 */
	DECIMALLIST(7);

	private int value;

	private SystemParameterType(int value) {
		this.value = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ych.s1.core.model.IntValueHolder#getValue()
	 */
	@Override
	public int getValue() {
		return value;
	}

}
