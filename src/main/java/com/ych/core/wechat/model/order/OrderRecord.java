package com.ych.core.wechat.model.order;

public interface OrderRecord {

	void before(String outTradeNo,String xml);
	
	void after(String outTradeNo,String xml);
}
