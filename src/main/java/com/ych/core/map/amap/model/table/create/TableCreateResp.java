package com.ych.core.map.amap.model.table.create;

import com.ych.core.map.amap.model.RespBase;
/**
 * 创建位置数据表响应对象
 * @author sunny
 *
 */
public class TableCreateResp extends RespBase {

	private static final long serialVersionUID = 1065686079159145041L;

	/**
	 * 位置数据表ID
	 */
	private String tableid;

	/**
	 * 返回位置数据表ID
	 * @return
	 */
	public String getTableid() {
		return tableid;
	}

	public void setTableid(String tableid) {
		this.tableid = tableid;
	}
	
	
	
	
}
