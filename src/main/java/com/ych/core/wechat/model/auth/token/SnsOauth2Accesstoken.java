package com.ych.core.wechat.model.auth.token;


/**
 * 通过code换取网页授权access_token
 * 
 * @author SUNCHUANLIN
 * @since 1.0.0
 *
 */
public interface SnsOauth2Accesstoken{

	static final String REQUEST_ADDRESS = "https://api.weixin.qq.com/sns/oauth2/access_token?appid={appId}&secret={secret}&code={code}&grant_type=authorization_code";

	/**
	 * 通过code换取网页授权access_token
	 * 
	 * @param appId
	 * @param secret
	 * @param code
	 * @return
	 */
	SnsAccessToken getAccessToken(String appId, String secret, String code);
}
