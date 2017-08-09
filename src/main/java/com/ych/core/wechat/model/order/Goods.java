package com.ych.core.wechat.model.order;

import java.io.Serializable;

/**
 * 微信统一下单商品对象
 * 
 * @author &Sunny
 *
 */
public class Goods implements Serializable {

	private static final long serialVersionUID = -9166528288584320089L;
	/** String 必填 32 商品的编号 */
	private String goods_id;
	/** String 可选 32 微信支付定义的统一商品编号 */
	private String wxpay_goods_id;
	/** String 必填 256 商品名称 */
	private String goods_name;
	/** Int 必填 商品数量 */
	private int quantity;
	/** Int 必填 商品单价，单位为分 */
	private int price;
	/** String 可选 32 商品类目ID */
	private String goods_category;
	/** String 可选 1000 商品描述信息 */
	private String body;
	
	public String getGoods_id() {
		return goods_id;
	}
	/** String 必填 32 商品的编号 */
	public void setGoods_id(String goods_id) {
		this.goods_id = goods_id;
	}
	public String getWxpay_goods_id() {
		return wxpay_goods_id;
	}
	/** String 可选 32 微信支付定义的统一商品编号 */
	public void setWxpay_goods_id(String wxpay_goods_id) {
		this.wxpay_goods_id = wxpay_goods_id;
	}
	public String getGoods_name() {
		return goods_name;
	}
	/** String 必填 256 商品名称 */
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public int getQuantity() {
		return quantity;
	}
	/** Int 必填 商品数量 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	/** Int 必填 商品单价，单位为分 */
	public void setPrice(int price) {
		this.price = price;
	}
	public String getGoods_category() {
		return goods_category;
	}
	/** String 可选 32 商品类目ID */
	public void setGoods_category(String goods_category) {
		this.goods_category = goods_category;
	}
	public String getBody() {
		return body;
	}
	/** String 可选 1000 商品描述信息 */
	public void setBody(String body) {
		this.body = body;
	}
	
	
}
