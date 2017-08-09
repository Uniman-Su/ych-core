package com.ych.core.wechat.model.refund.query;

public interface RefundQueryRecord {

	void before(String outTradeNo,String xml);
	
	void after(String outTradeNo,String xml);
}
