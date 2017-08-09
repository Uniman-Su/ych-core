package com.ych.core.wechat.model.auth.conn;

public interface ConnectOauth2Authorize {

	/** 发起微信授权地址模板 */
	static final String REQUEST_ADDRESS = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=code&scope=%s&state=%s#wechat_redirect";

	/**
	 * 获取微信授权重定向地址
	 * 
	 * @param appId
	 *            公众号的唯一标识
	 * @param redirectUri
	 *            授权后重定向的回调链接地址
	 * @param scope
	 *            应用授权作用域
	 * @param state
	 *            重定向后会带上state参数，开发者可以填写a-zA-Z0-9的参数值，最多128字节
	 * @return 微信授权请求地址
	 */
	public String auth(String appId, String redirectUri, AuthScope scope, String state);

	/**
	 * 获取微信授权重定向地址
	 * 
	 * @param appId
	 *            公众号的唯一标识
	 * @param redirectUri
	 *            授权后重定向的回调链接地址
	 * @param scope
	 *            应用授权作用域
	 * @return 微信授权请求地址
	 */
	public String auth(String appId, String redirectUri, AuthScope scope);
}
