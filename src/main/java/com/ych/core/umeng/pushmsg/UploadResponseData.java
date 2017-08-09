package com.ych.core.umeng.pushmsg;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 上传的响应数据
 * 
 * @author U
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UploadResponseData {

	/**
	 * 当"ret"为"SUCCESS"时
	 */
	@JsonProperty("file_id")
	private String fileId;

	/**
	 * 当"ret"为"FAIL"时
	 */
	@JsonProperty("error_code")
	private String errorCode;

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
	 * @return 当"ret"为"SUCCESS"时
	 */
	public String getFileId() {
		return fileId;
	}

	/**
	 * @param fileId
	 *            当"ret"为"SUCCESS"时
	 */
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

}
