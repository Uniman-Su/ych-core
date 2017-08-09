package com.ych.core.wechat.model.refund.query;
/**
 * 查询退款<br/>
 * 应用场景:<br/>
 * 提交退款申请后，通过调用该接口查询退款状态。退款有一定延时，用零钱支付的退款20分钟内到账，银行卡支付的退款3个工作日后重新查询退款状态。
 * @author sunny
 *
 */
public interface RefundQuery {

	static final String REQUEST_ADDRESS = "https://api.mch.weixin.qq.com/pay/refundquery";
	/**
	 * 查询退款
	 * @param outRefundNo 商户退款单号,String(32),商户侧传给微信的退款单号(参数四选一)
	 * @param outTradeNo 商户订单号,String(32),商户系统内部的订单号(参数四选一)
	 * @param transactionId 微信订单号,String(32)(参数四选一)
	 * @param refundId 微信退款单号,String(28),微信生成的退款单号，在申请退款接口有返回 (参数四选一)
	 * @return
	 */
	RefundQueryResp query(String outRefundNo,String outTradeNo,String transactionId,String refundId);
}
