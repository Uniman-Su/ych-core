package com.ych.core.map.amap.model.data.delete;
/**
 * 删除数据接口
 * @author sunny
 *
 */
public interface DataDelete {

	/**
	 * 接口相对路径
	 */
	static final String RELATIVE_URL = "/datamanage/data/delete";
	/**
	 * 删除数据
	 * @param tableId 数据表ID
	 * @param ids 数据ID(一次请求限制1-50条数据，多个id用逗号隔开)
	 * @return
	 */
	DataDeleteResp delete(String tableId,String... ids);
}
