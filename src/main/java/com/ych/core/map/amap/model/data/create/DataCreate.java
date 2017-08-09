package com.ych.core.map.amap.model.data.create;

import java.util.Map;
/**
 * 数据创建接口
 * @author sunny
 *
 */
public interface DataCreate {

	/**
	 * 接口相对路径
	 */
	static final String RELATIVE_URL = "/datamanage/data/create";
	/**
	 * 创建单条位置数据
	 * @param tableId 数据表ID
	 * @param name 数据名称
	 * @param location 经纬度(规则：经度,纬度，经纬度支持到小数点后6位 格式示例：104.394729,31.125698 )
	 * @param columns 用户自定义字段Map
	 * @return
	 */
	DataCreateResp create(String tableId,String name,String location,Map<String,Object> columns);
}
