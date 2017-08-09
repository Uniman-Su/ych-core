package com.ych.core.wechat.model.ticket;

public interface JsApiTicket {

	static final String REQUEST_ADDRESS = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token={token}&type=jsapi";

	/**
	 * 获取JSSDK票据
	 * 
	 * @param token
	 *            全局token
	 * @param appId
	 *            用作缓存key的appId
	 * @return
	 */
	Ticket getJsApiTicket(String token, String appId);
}
