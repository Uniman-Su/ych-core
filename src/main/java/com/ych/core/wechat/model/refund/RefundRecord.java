package com.ych.core.wechat.model.refund;

public interface RefundRecord {

	void before(String outTradeNo,String xml);
	
	void after(String outTradeNo,String xml);
}
