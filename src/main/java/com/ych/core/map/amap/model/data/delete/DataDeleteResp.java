package com.ych.core.map.amap.model.data.delete;

import com.ych.core.map.amap.model.RespBase;

/**
 * 删除数据响应对象
 * @author sunny
 *
 */
public class DataDeleteResp extends RespBase {

	private static final long serialVersionUID = 8779215409752156954L;
	/**删除成功条数*/
	private int success;
	/**删除失败条数*/
	private int fail;
	
	/**
	 * 返回删除成功条数
	 * @return
	 */
	public int getSuccess() {
		return success;
	}
	public void setSuccess(int success) {
		this.success = success;
	}
	/**
	 * 返回删除失败条数
	 * @return
	 */
	public int getFail() {
		return fail;
	}
	public void setFail(int fail) {
		this.fail = fail;
	}
	
	
}
