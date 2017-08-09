package com.ych.core.wechat.model.auth.token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.ych.core.wechat.model.WeChatCore;

public class SnsOauth2RefreshTokenSupport implements SnsOauth2RefreshToken {

	@Autowired
	private WeChatCore wechatCore;
	
	public void setWechatCore(WeChatCore wechatCore) {
		this.wechatCore = wechatCore;
	}

	@Override
	public SnsAccessToken refreshToken(String appId, String refreshToken) {
		Assert.notNull(wechatCore, "the instance of WechatCore didn't inject");
		SnsAccessToken token = wechatCore.getObject(REQUEST_ADDRESS, SnsAccessToken.class, appId, refreshToken);
		return token;
	}

}
