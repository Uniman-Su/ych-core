package com.ych.core.wechat.model.refund;

import java.math.BigDecimal;

import com.ych.core.wechat.model.order.FeeType;
import com.ych.core.wechat.model.order.query.RefundAccount;

/**
 * 微信申请退款接口<br/>
 * 应用场景:<br/>
 *当交易发生之后一段时间内，由于买家或者卖家的原因需要退款时，卖家可以通过退款接口将支付款退还给买家，微信支付将在收到退款请求并且验证成功之后，按照退款规则将支付款按原路退到买家帐号上。
 *注意：
 *1、交易时间超过一年的订单无法提交退款；
 *2、微信支付退款支持单笔交易分多次退款，多次退款需要提交原支付订单的商户订单号和设置不同的退款单号。一笔退款失败后重新提交，要采用原来的退款单号。总退款金额不能超过用户实际支付金额。
 * @author sunny
 *
 */
public interface Refund {

	static final String REQUEST_ADDRESS = "https://api.mch.weixin.qq.com/secapi/pay/refund";
	/**
	 * 退款
	 * @param outTradeNo 商户订单号,String(32),与微信订单号二选一
	 * @param transactionId 微信订单号,String(28),微信生成的订单号，在支付通知中有返回，与商户订单号二选一
	 * @param outRefundNo 必填，商户退款单号，String(32)，商户系统内部的退款单号，商户系统内部唯一，同一退款单号多次请求只退一笔
	 * @param totalFee 必填，订单总金额，单位为分，只能为整数
	 * @param refundFee 必填，退款总金额，订单总金额，单位为分，只能为整数
	 * @param refundFeeType 可选，货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY
	 * @param refund_account 可选，退款资金来源，String(30)，仅针对老资金流商户使用
	 * @return
	 */
	RefundResp refund(String outTradeNo,String transactionId,String outRefundNo,BigDecimal totalFee,BigDecimal refundFee,FeeType refundFeeType,RefundAccount refundAccount);
	
}
