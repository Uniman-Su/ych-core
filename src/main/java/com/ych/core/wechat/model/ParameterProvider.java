package com.ych.core.wechat.model;
/**
 * 参数提供接口
 * @author sunny
 *
 */
public interface ParameterProvider {

	/**
	 * 获取appid
	 * @return
	 */
	String getAppID();
	/**
	 * 获取appSecret
	 * @return
	 */
	String getAppSecret();
	/**
	 * 获取验证服务器加密token
	 * @return
	 */
	String getEncryptionToken();
	/**
	 * 获取统一分享地址
	 * @return
	 */
	String getShareUrl();
	/**
	 * 获取授权认证回调地址
	 * @return
	 */
	String getAuthCallbackUrl();
	/**
	 * 获取支付回调地址
	 * @return
	 */
	String getPayCallbackUrl();
	/**
	 * 获取微信支付商户号
	 * @return
	 */
	String getMchId();
	/**
	 * 获取微信支付终端设备号
	 * @return
	 */
	String getDeviceInfo();
	/**
	 * 获取微信支付签名key
	 * @return
	 */
	String getSignKey();
	/**
	 * 获取微信下单标题前缀
	 * @return
	 */
	String getOrderBodyPrefix();
	/**获取消息模板ID*/
	String getMessageTemplateId();
	/**获取已支付消息推送内容*/
	String getPayedMessageContent();
	/**获取已确认消息推送内容*/
	String getConfirmedMessageContent();
	/**获取已服务消息推送内容*/
	String getServicedMessageContent();
	/**
	 * 获取消息推送客户称呼模板
	 * @return
	 */
	String getNameTemplate();
	/**
	 * 获取微信认证授权产品环境回调地址
	 * @return
	 */
	String getProdAuthCallbackUrl();
	/**
     * 获取微信认证授权测试环境回调地址
     * @return
     */
	String getTestAuthCallbackUrl();
	/**
	 * 获取部署环境
	 * @return
	 */
	String getDevEnv();
}
