package com.ych.core.wechat.model.jsapi.pay;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.util.Assert;

import com.ych.core.wechat.model.ParameterProvider;
import com.ych.core.wechat.utils.UniqueUtils;

public class JsApiPayConfigSupport implements JsApiPayConfig {

	private ParameterProvider parameterProvider;
	
	public void setParameterProvider(ParameterProvider parameterProvider) {
		this.parameterProvider = parameterProvider;
	}

	@Override
	public WxJsPayConfig getJsApiPayConfig(String prepayId) {
		Assert.notNull(prepayId, "prepayId can not be null");
		String signType = "MD5";
		String appId = parameterProvider.getAppID();
		//生成签名的随机串
		String nonceStr = UniqueUtils.uniqueString();
		//生成签名的时间戳
		long timestamp = System.currentTimeMillis()/1000;
		//待签名字符串
		String package_="prepay_id="+prepayId;
		String signString = String.format("appId=%s&nonceStr=%s&package=%s&signType=%s&timeStamp=%s", appId,
				nonceStr,package_, signType,timestamp);
		String key = parameterProvider.getSignKey();
		//签名串
		String signature = DigestUtils.md5Hex(signString+"&key="+key).toUpperCase();
		WxJsPayConfig config = new WxJsPayConfig();
		config.setNonceStr(nonceStr);
		config.setTimestamp(timestamp);
		config.setPaySign(signature);
		config.setSignType(signType);
		config.set_package(package_);
		config.setAppId(appId);
		return config;
	}

}
