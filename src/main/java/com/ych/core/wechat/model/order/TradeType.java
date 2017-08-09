package com.ych.core.wechat.model.order;
/**
 * 交易类型
 * @author &Sunny
 *
 */
public enum TradeType {
	/**公众号支付*/JSAPI,/**原生扫码支付*/NATIVE,/**app支付*/APP,/**刷卡支付，刷卡支付有单独的支付接口，不调用统一下单接口*/MICROPAY
}
