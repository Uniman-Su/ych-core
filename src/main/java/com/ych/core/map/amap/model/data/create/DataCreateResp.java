package com.ych.core.map.amap.model.data.create;

import com.ych.core.map.amap.model.RespBase;
/**
 * 数据创建响应对象
 * @author sunny
 *
 */
public class DataCreateResp extends RespBase {

	private static final long serialVersionUID = -2672592382919877842L;
	/**新建数据ID*/
	private String _id;

	/**
	 * 返回新建数据ID
	 * @return
	 */
	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}
	
	
}
