package com.ych.core.wechat.model.auth.token;

import org.springframework.util.Assert;

import com.ych.core.wechat.model.WeChatCore;

public class SnsOauth2AccesstokenSupport implements SnsOauth2Accesstoken {

	private WeChatCore wechatCore;
	
	public void setWechatCore(WeChatCore wechatCore) {
		this.wechatCore = wechatCore;
	}

	@Override
	public SnsAccessToken getAccessToken(String appId, String secret, String code) {
		Assert.notNull(wechatCore, "the instance of WechatCore didn't inject");
		SnsAccessToken token = wechatCore.getObject(REQUEST_ADDRESS, SnsAccessToken.class, appId, secret, code);
		return token;
	}

}
