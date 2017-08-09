package com.ych.core.wechat.model.jsapi.config;

import org.springframework.util.Assert;

import com.ych.core.wechat.model.ParameterProvider;
import com.ych.core.wechat.model.comm.token.AccessToken;
import com.ych.core.wechat.model.comm.token.CommonAccessToken;
import com.ych.core.wechat.model.ticket.JsApiTicket;
import com.ych.core.wechat.model.ticket.Ticket;
import com.ych.core.wechat.utils.SHA1Utils;
import com.ych.core.wechat.utils.UniqueUtils;

public class JsApiConfigSupport implements JsApiConfig {

	private ParameterProvider parameterProvider;
	
	private JsApiTicket jsApiTicket;

	private CommonAccessToken commonAccessToken;
	

	public void setParameterProvider(ParameterProvider parameterProvider) {
		this.parameterProvider = parameterProvider;
	}

	public void setJsApiTicket(JsApiTicket jsApiTicket) {
		this.jsApiTicket = jsApiTicket;
	}

	public void setCommonAccessToken(CommonAccessToken commonAccessToken) {
		this.commonAccessToken = commonAccessToken;
	}


	@Override
	public WxJsConfig getJsApiConfig(String url) {
		Assert.notNull(url, "url can not be null");
		int index = url.indexOf("#");
		if (index != -1) {
			url= url.substring(0, index);
		}

		String appId = parameterProvider.getAppID();
		String appSecret=parameterProvider.getAppSecret();
		//获取接口调用token
		AccessToken token = commonAccessToken.getAccessToken(appId, appSecret);
		Assert.isTrue(token.isSuccess(), "get wechat token error");
		//获取JS API 调用ticket
		Ticket ticket = jsApiTicket.getJsApiTicket(token.getAccess_token(), appId);
		Assert.isTrue(ticket.isSuccess(), "get wechat jsApiTicke error");
		//生成签名的随机串
		String nonceStr = UniqueUtils.uniqueString();
		//生成签名的时间戳
		long timestamp = System.currentTimeMillis();
		//待签名字符串
		String signString = String.format("jsapi_ticket=%s&noncestr=%s&timestamp=%s&url=%s", ticket.getTicket(),
				nonceStr, timestamp, url);
		//签名串
		String signature = SHA1Utils.encrypt(signString);
		WxJsConfig config = new WxJsConfig();
		config.setAppId(appId);
		config.setNonceStr(nonceStr);
		config.setSignature(signature);
		config.setTimestamp(timestamp);
		return config;
	}

}
