package com.ych.core.wechat.model.comm.token;

import org.springframework.util.Assert;

import com.ych.core.wechat.model.WeChatCore;

public class CommonAccessTokenSupport implements CommonAccessToken {

	private WeChatCore wechatCore;
	
	public void setWechatCore(WeChatCore wechatCore) {
		this.wechatCore = wechatCore;
	}

	@Override
	public AccessToken getAccessToken(String appId, String secret) {
		Assert.notNull(wechatCore, "the instance of WechatCore didn't inject");
		AccessToken token = wechatCore.getObject(REQUEST_ADDRESS, AccessToken.class, appId, secret);
		return token;
	}

}
