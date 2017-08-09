package com.ych.core.map.amap.model;

import java.io.Serializable;

/**
 * 接口响应基础类
 * @author sunny
 *
 */
public class RespBase implements Serializable {

	private static final long serialVersionUID = 6385022102521671807L;
	/**响应状态码*/
	private int status;
	/**响应信息*/
	private String info;

	/**
	 * 返回响应状态码
	 * @return
	 */
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	/**
	 * 返回响应信息
	 * @return
	 */
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	

}
