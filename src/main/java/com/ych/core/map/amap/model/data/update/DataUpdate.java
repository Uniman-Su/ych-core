package com.ych.core.map.amap.model.data.update;

import java.util.Map;

import com.ych.core.map.amap.model.RespBase;

/**
 * 数据更新接口
 * @author sunny
 *
 */
public interface DataUpdate {
	/**
	 * 接口相对路径
	 */
	static final String RELATIVE_URL = "/datamanage/data/update";
	/**
	 * 更新数据
	 * @param tableId 位置表ID
	 * @param id 数据ID
	 * @param name 数据名称
	 * @param location 经纬度(规则：经度,纬度，经纬度支持到小数点后6位 格式示例：104.394729,31.125698 )
	 * @param columns 用户自定义字段Map
	 * @return
	 */
	RespBase update(String tableId,String id,String name,String location,Map<String,Object> columns);
}
