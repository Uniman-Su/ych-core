package com.ych.core.map.amap.model.table.create;
/**
 * 数据表创建接口
 * @author sunny
 *
 */
public interface TableCreate {
	/**接口相对路径*/
	static final String RELATIVE_URL = "/datamanage/table/create";
	/**
	 * 创建数据表
	 * @param tableName 表名
	 * @return
	 */
	TableCreateResp create(String tableName);
	
}
