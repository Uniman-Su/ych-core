package com.ych.core.wechat.model.order.close;

public interface CloseOrderRecord {

	void before(String outTradeNo,String xml);
	
	void after(String outTradeNo,String xml);
}
