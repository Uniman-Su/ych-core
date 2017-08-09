package com.ych.core.wechat.model.comm.token;

public interface CommonAccessToken {
	
	static final String REQUEST_ADDRESS = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid={appId}&secret={secret}";

	AccessToken getAccessToken(String appId, String secret);
}
