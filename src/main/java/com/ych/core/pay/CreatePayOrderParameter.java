package com.ych.core.pay;

import java.math.BigDecimal;

/**
 * 创建支付单据的参数
 * 
 * @author U
 *
 */
public interface CreatePayOrderParameter {

	/**
	 * @return 渠道名称
	 */
	String getChannelName();

	/**
	 * @return 获取流水号
	 */
	String getFlowNo();

	/**
	 * @return 订单的主题
	 */
	String getOrderSubject();

	/**
	 * @return 订单的描述
	 */
	String getOrderDesc();

	/**
	 * @return 订单的总金额
	 */
	BigDecimal getTotalMoney();

	/**
	 * @return 订单的超时时长
	 */
	Long getTimeout();

}
