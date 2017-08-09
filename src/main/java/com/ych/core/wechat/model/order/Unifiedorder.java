package com.ych.core.wechat.model.order;

import java.math.BigDecimal;

/**
 * 微信统一下单接口
 * 
 * @author &Sunny
 *
 */
public interface Unifiedorder {
	
	static final String REQUEST_ADDRESS = "https://api.mch.weixin.qq.com/pay/unifiedorder";

	/**
	 * 下单
	 * @param body 必填，String(128),商品简单描述<br/>
	 * 							1.PC网站 	扫码支付 	浏览器打开的网站主页title名 -商品概述(样例:腾讯充值中心-QQ会员充值)<br/>
	 * 							2.微信浏览器 	公众号支付 	商家名称-销售商品类目(样例:罗辑思维-图书,线上电商;备注:商家名称必须为实际销售商品的商家)<br/>
	 * 							3.门店扫码 	公众号支付 	店名-销售商品类目(样例:天虹南山店-超市;备注:线下门店支付)<br/>
	 * 							4.门店扫码 	扫码支付 	店名-销售商品类目(样例:天虹南山店-超市;备注:线下门店支付)<br/>
	 * 							5.门店刷卡 	刷卡支付 	店名-销售商品类目(样例:天虹南山店-超市;备注:线下门店支付)<br/>
	 * 							6.第三方手机浏览器 	H5支付 	浏览器打开的移动网页的主页title名-商品概述(样例:腾讯充值中心-QQ会员充值)<br/>
	 * 							7.第三方APP 	APP支付 	应用市场上的APP名字-商品概述(样例:天天爱消除-游戏充值 	)<br/>
	 * @param deviceInfo 可选，String(32)，终端设备号(门店号或收银设备ID)，注意：PC网页或公众号内支付请传"WEB"
	 * @param detail 可选，商品详细列表
	 * @param attach 可选，String(127)，附加数据，在查询API和支付通知中原样返回，该字段主要用于商户携带订单的自定义数据
	 * @param outTradeNo 必填，String(32)，商户系统内部的订单号,32个字符内、可包含字母
	 * @param feeType 可选，String(16)，符合ISO 4217标准的三位字母代码，默认人民币：CNY
	 * @param total_fee 必填，订单总金额，单位为分
	 * @param spbillCreateIp 必填，String(16)，APP和网页支付提交用户端ip，Native支付填调用微信支付API的机器IP。
	 * @param timeStart 可选，String(14)，订单生成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010。
	 * @param timeExpire 可选，String(14)，订单失效时间，格式为yyyyMMddHHmmss，如2009年12月27日9点10分10秒表示为20091227091010。
	 * @param goodsTag 可选，String(32)，商品标记，代金券或立减优惠功能的参数
	 * @param notifyUrl 必填，String(256)，接收微信支付异步通知回调地址，通知url必须为直接可访问的url，不能携带参数。
	 * @param tradeType 必填，交易类型
	 * @param productId 可选，String(32)，trade_type=NATIVE，此参数必传。此id为二维码中包含的商品ID，商户自行定义。
	 * @param limitPay 可选，String(32)，no_credit--指定不能使用信用卡支付
	 * @param openid 可选，String(128)，trade_type=JSAPI，此参数必传，用户在商户appid下的唯一标识。
	 * @return
	 */
	OrderResp order(String body, String deviceInfo, GoodsList detail, String attach, String outTradeNo, FeeType feeType,
			BigDecimal total_fee, String spbillCreateIp, String timeStart, String timeExpire, String goodsTag,
			String notifyUrl, TradeType tradeType, String productId, LimitPay limitPay, String openid);

}
