package com.ych.core.wechat.model.order.query;
/**
 * 退款资金来源
 * @author sunny
 *
 */
public enum RefundAccount {
	/**未结算资金退款（默认使用未结算资金退款）*/REFUND_SOURCE_UNSETTLED_FUNDS,/**可用余额退款*/REFUND_SOURCE_RECHARGE_FUNDS
}
