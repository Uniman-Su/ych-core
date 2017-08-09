package com.ych.core.wechat.model.order.query;

/**
 * 微信查询订单接口
 * @author sunny
 *
 */
public interface QueryOrder {

	static final String REQUEST_ADDRESS = "https://api.mch.weixin.qq.com/pay/orderquery";
	/**
	 * 查询订单
	 * @param outTradeNo 商户订单号(与微信订单号二选一)
	 * @param transactionId 微信订单号(与商户订单号二选一)
	 * @return
	 */
	QueryOrderResp query(String outTradeNo,String transactionId);
}
