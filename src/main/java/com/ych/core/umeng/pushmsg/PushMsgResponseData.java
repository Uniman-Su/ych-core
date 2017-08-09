package com.ych.core.umeng.pushmsg;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 推送得响应数据
 * 
 * @author U
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PushMsgResponseData {

	/**
	 * 当type为unicast、listcast或者customizedcast且alias不为空时
	 */
	@JsonProperty("msg_id")
	private String msgId;

	/**
	 * 当type为于broadcast、groupcast、filecast、customizedcast
	 */
	@JsonProperty("task_id")
	private String taskId;

	/**
	 * 当"ret"为"FAIL"时
	 */
	@JsonProperty("error_code")
	private String errorCode;

	/**
	 * 如果开发者填写了thirdparty_id, 接口也会返回该值
	 */
	@JsonProperty("thirdparty_id")
	private String thirdPartyId;

	/**
	 * @return 当type为unicast、listcast或者customizedcast且alias不为空时
	 */
	public String getMsgId() {
		return msgId;
	}

	/**
	 * @param msgId
	 *            当type为unicast、listcast或者customizedcast且alias不为空时
	 */
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	/**
	 * @return 当type为于broadcast、groupcast、filecast、customizedcast
	 */
	public String getTaskId() {
		return taskId;
	}

	/**
	 * @param taskId
	 *            当type为于broadcast、groupcast、filecast、customizedcast
	 */
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	/**
	 * @return 当"ret"为"FAIL"时
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode
	 *            当"ret"为"FAIL"时
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return 如果开发者填写了thirdparty_id, 接口也会返回该值
	 */
	public String getThirdPartyId() {
		return thirdPartyId;
	}

	/**
	 * @param thirdPartyId
	 *            如果开发者填写了thirdparty_id, 接口也会返回该值
	 */
	public void setThirdPartyId(String thirdPartyId) {
		this.thirdPartyId = thirdPartyId;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
	}

}
