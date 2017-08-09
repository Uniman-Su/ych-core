package com.ych.core.wechat.model.order;

import java.io.Serializable;
import java.util.List;
/**
 * 微信统一下单商品列表
 * @author &Sunny
 *
 */
public class GoodsList implements Serializable{

	private static final long serialVersionUID = 4761389300984352248L;
	
	private List<Goods> goods_detail;

	public List<Goods> getGoods_detail() {
		return goods_detail;
	}

	public void setGoods_detail(List<Goods> goods_detail) {
		this.goods_detail = goods_detail;
	}
	
	
	
}
