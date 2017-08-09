package com.ych.core.wechat.model.auth.conn;

/**
 * 应用授权作用域
 * 
 * @author SUNCHUANLIN
 * @since 1.0.0
 *
 */
public enum AuthScope {

	/** 不弹出授权页面，直接跳转，只能获取用户openid */
	SNSAPI_BASE("snsapi_base"),
	/** 弹出授权页面，可通过openid拿到昵称、性别、所在地。并且，即使在未关注的情况下，只要用户授权，也能获取其信息 */
	SCOPE_USERINFO("snsapi_userinfo");

	private final String value;

	AuthScope(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
