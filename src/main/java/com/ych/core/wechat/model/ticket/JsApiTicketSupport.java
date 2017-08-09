package com.ych.core.wechat.model.ticket;

import org.springframework.util.Assert;

import com.ych.core.wechat.model.WeChatCore;

public class JsApiTicketSupport implements JsApiTicket {

	private WeChatCore wechatCore;
	
	public void setWechatCore(WeChatCore wechatCore) {
		this.wechatCore = wechatCore;
	}

	@Override
	public Ticket getJsApiTicket(String token,String appId) {
		Assert.notNull(wechatCore, "the instance of WechatCore didn't inject");
		Ticket ticket = wechatCore.getObject(REQUEST_ADDRESS, Ticket.class, token);
		return ticket;
	}

}
