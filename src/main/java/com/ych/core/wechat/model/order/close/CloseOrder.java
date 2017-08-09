package com.ych.core.wechat.model.order.close;

/**
 * 关闭订单<br/>
 * 应用场景： <br/>
 * 以下情况需要调用关单接口：商户订单支付失败需要生成新单号重新发起支付，要对原订单号调用关单，避免重复支付；系统下单后，用户支付超时，系统退出不再受理，避免用户继续，请调用关单接口。注意：订单生成后不能马上调用关单接口，最短调用时间间隔为5分钟。
 * @author sunny
 *
 */
public interface CloseOrder {

	static final String REQUEST_ADDRESS = "https://api.mch.weixin.qq.com/pay/closeorder";
	/**
	 * 关闭订单
	 * @param outTradeNo 商户系统内部的订单号
	 * @return
	 */
	CloseOrderResp close(String outTradeNo);
}
