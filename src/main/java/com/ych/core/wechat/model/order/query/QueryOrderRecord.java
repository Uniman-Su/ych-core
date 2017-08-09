package com.ych.core.wechat.model.order.query;

public interface QueryOrderRecord {

	void before(String outTradeNo,String xml);
	
	void after(String outTradeNo,String xml);
}
