package com.ych.core.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 系统参数
 * 
 * @author U
 *
 */
public interface ISystemParameter {

	/**
	 * @return 应用Key
	 */
	String getAppKey();

	/**
	 * @return key
	 */
	String getKey();

	/**
	 * @return 系统参数类型
	 */
	SystemParameterType getType();

	/**
	 * @return 存储在数据库中的字符值
	 */
	String getStringValue();

	/**
	 * 
	 * @return 整型值
	 */
	Integer getIneterValue();

	/**
	 * @return 获取Long值
	 */
	Long getLongValue();

	/**
	 * @return 获取Decimal值
	 */
	BigDecimal getDecimalValue();

	/**
	 * @return boolean值
	 */
	Boolean getBooleanValue();

	/**
	 * @return 获取Date值
	 */
	Date getDateValue();

	/**
	 * @return 字符串列表
	 */
	List<String> getStringListValue();

	/**
	 * @return BigDecimal列表
	 */
	List<BigDecimal> getBigDecimalListValue();
}
