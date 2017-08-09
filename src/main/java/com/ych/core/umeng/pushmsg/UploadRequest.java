package com.ych.core.umeng.pushmsg;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ych.core.fasterxml.jackson.databind.ser.ObjectStringSerializer;

/**
 * 上传文件的请求
 * 
 * @author U
 *
 */
public class UploadRequest {

	/**
	 * 必填,应用唯一标识
	 */
	@JsonProperty("appkey")
	private String appKey;

	/**
	 * 必填,时间戳
	 */
	@JsonSerialize(using = ObjectStringSerializer.class)
	private Long timestamp;

	/**
	 * 文件内容
	 */
	private String content;

	/**
	 * @return 必填,应用唯一标识
	 */
	public String getAppKey() {
		return appKey;
	}

	/**
	 * @param appKey
	 *            必填,应用唯一标识
	 */
	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	/**
	 * @return 必填,时间戳
	 */
	public Long getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp
	 *            必填,时间戳
	 */
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * @return 文件内容
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 *            文件内容
	 */
	public void setContent(String content) {
		this.content = content;
	}

}
