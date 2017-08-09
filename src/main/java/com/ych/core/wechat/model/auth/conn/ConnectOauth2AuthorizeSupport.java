package com.ych.core.wechat.model.auth.conn;

import java.net.URLEncoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectOauth2AuthorizeSupport implements ConnectOauth2Authorize {

	private Logger logger = LoggerFactory.getLogger(ConnectOauth2AuthorizeSupport.class);
	/** 回调URL编码类型 */
	private static final String URL_CHARSET = "utf-8";

	@Override
	public String auth(String appId, String redirectUri, AuthScope scope, String state) {
		String url = null;
		try {
			redirectUri = URLEncoder.encode(redirectUri, URL_CHARSET);
			url = String.format(REQUEST_ADDRESS, appId, redirectUri, scope.getValue(), state);
			return url;
		} catch (Exception e) {
			logger.error(String.format("WeChat authorization error address structure[url=%s]", url), e);
			throw new RuntimeException(String.format("WeChat authorization error address structure[url=%s]", url), e);
		}
	}

	@Override
	public String auth(String appId, String redirectUri, AuthScope scope) {
		return auth(appId, redirectUri, scope, "state");
	}

}
