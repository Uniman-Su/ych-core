package com.ych.core.map.amap.model.data.create;
/**
 * 位置类型
 * @author sunny
 *
 */
public enum LocType {

	/**经纬度定位*/LOCATION(1),/**地址字符串*/ADDRESS(2),;
	private int value;

	LocType(final int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
}
