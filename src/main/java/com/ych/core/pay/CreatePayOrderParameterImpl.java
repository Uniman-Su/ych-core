package com.ych.core.pay;

import java.math.BigDecimal;

/**
 * 创建订单请求参数实现
 * 
 * @author U
 *
 */
public class CreatePayOrderParameterImpl implements CreatePayOrderParameter {

	/**
	 * 渠道名称
	 */
	private String channelName;

	/**
	 * 流水号
	 */
	private String flowNo;

	/**
	 * 订单主题
	 */
	private String orderSubject;

	/**
	 * 订单描述
	 */
	private String orderDesc;

	/**
	 * 总金额
	 */
	private BigDecimal totalMoney;

	/**
	 * 超时时长
	 */
	private Long timeout;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ych.core.pay.CreatePayOrderParameter#getChannelName()
	 */
	@Override
	public String getChannelName() {
		return channelName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ych.core.pay.CreatePayOrderParameter#getFlowNo()
	 */
	@Override
	public String getFlowNo() {
		return flowNo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ych.core.pay.CreatePayOrderParameter#getOrderSubject()
	 */
	@Override
	public String getOrderSubject() {
		return orderSubject;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ych.core.pay.CreatePayOrderParameter#getOrderDesc()
	 */
	@Override
	public String getOrderDesc() {
		return orderDesc;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ych.core.pay.CreatePayOrderParameter#getTotalMoney()
	 */
	@Override
	public BigDecimal getTotalMoney() {
		return totalMoney;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ych.core.pay.CreatePayOrderParameter#getTimeout()
	 */
	@Override
	public Long getTimeout() {
		return timeout;
	}

	/**
	 * @param channelName
	 *            渠道名称
	 */
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	/**
	 * @param flowNo
	 *            流水号
	 */
	public void setFlowNo(String flowNo) {
		this.flowNo = flowNo;
	}

	/**
	 * @param orderSubject
	 *            订单主题
	 */
	public void setOrderSubject(String orderSubject) {
		this.orderSubject = orderSubject;
	}

	/**
	 * @param orderDesc
	 *            订单描述
	 */
	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}

	/**
	 * @param totalMoney
	 *            总金额
	 */
	public void setTotalMoney(BigDecimal totalMoney) {
		this.totalMoney = totalMoney;
	}

	/**
	 * @param timeout
	 *            超时时长
	 */
	public void setTimeout(Long timeout) {
		this.timeout = timeout;
	}

}
