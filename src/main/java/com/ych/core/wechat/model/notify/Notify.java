package com.ych.core.wechat.model.notify;
/**
 * 微信支付回调接口
 * @author sunny
 *
 */
public interface Notify {

	String notify(String xml);
}
