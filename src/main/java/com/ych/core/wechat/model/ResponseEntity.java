package com.ych.core.wechat.model;

import java.io.Serializable;

public interface ResponseEntity extends Serializable {

	static final String SUCCESS_CODE = "0";

	boolean isSuccess();

	void setSuccess(boolean success);

	String getErrcode();

	String getErrmsg();
}
