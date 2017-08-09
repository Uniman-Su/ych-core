package com.ych.core.wechat.model.jsapi.pay;

public class WxJsPayConfig {

	/**支付签名时间戳，注意微信jssdk中的所有使用timestamp字段均为小写。但最新版的支付后台生成签名使用的timeStamp字段名需大写其中的S字符*/
	private long timestamp;
	/**支付签名随机串，不长于 32 位*/
	private String nonceStr;
	/**统一支付接口返回的prepay_id参数值，提交格式如：prepay_id=***）*/
	private String _package;
	/**签名方式，默认为'SHA1'，使用新版支付需传入'MD5'*/
	private String signType;
	/**支付签名*/
	private String paySign;
	/**微信APPID*/
	private String appId;

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public String get_package() {
		return _package;
	}

	public void set_package(String _package) {
		this._package = _package;
	}

	public String getSignType() {
		return signType;
	}

	public void setSignType(String signType) {
		this.signType = signType;
	}

	public String getPaySign() {
		return paySign;
	}

	public void setPaySign(String paySign) {
		this.paySign = paySign;
	}

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }
	
	
}
