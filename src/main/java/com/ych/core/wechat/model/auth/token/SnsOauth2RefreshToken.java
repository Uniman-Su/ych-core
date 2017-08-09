package com.ych.core.wechat.model.auth.token;

/**
 * 刷新access_token
 * <p>
 * 由于access_token拥有较短的有效期，当access_token超时后，可以使用refresh_token进行刷新，
 * refresh_token拥有较长的有效期（7天、30天、60天、90天），当refresh_token失效的后，需要用户重新授权。
 * </p>
 * 
 * @author SUNCHUANLIN
 * @since
 *
 */
public interface SnsOauth2RefreshToken {

	static final String REQUEST_ADDRESS = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=%s&grant_type=refresh_token&refresh_token=%s";

	SnsAccessToken refreshToken(String appId, String refreshToken);
}
