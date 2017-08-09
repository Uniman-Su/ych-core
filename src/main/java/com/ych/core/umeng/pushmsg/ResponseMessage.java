package com.ych.core.umeng.pushmsg;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 发送推送消息的响应
 * 
 * @author U
 *
 */
public class ResponseMessage<T> {

	/**
	 * 操作结果
	 */
	@JsonProperty("ret")
	private Result result;

	/**
	 * 返回数据
	 */
	private T data;

	/**
	 * @return 操作结果
	 */
	public Result getResult() {
		return result;
	}

	/**
	 * @param result
	 *            操作结果
	 */
	public void setResult(Result result) {
		this.result = result;
	}

	/**
	 * @return 返回数据
	 */
	public T getData() {
		return data;
	}

	/**
	 * @param data
	 *            返回数据
	 */
	public void setData(T data) {
		this.data = data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
	}

}
