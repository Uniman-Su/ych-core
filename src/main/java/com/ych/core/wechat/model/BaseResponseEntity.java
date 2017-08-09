package com.ych.core.wechat.model;

public class BaseResponseEntity implements ResponseEntity {

	private static final long serialVersionUID = 7220029101041381909L;

	private boolean success;

	private String errcode;

	private String errmsg;

	@Override
	public boolean isSuccess() {
		return this.success;
	}

	@Override
	public void setSuccess(boolean success) {
		this.success = success;
	}

	@Override
	public String getErrcode() {
		return this.errcode;
	}

	@Override
	public String getErrmsg() {
		return this.errmsg;
	}

	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	@Override
	public String toString() {
		return "BaseResponseEntity [success=" + success + ", errcode=" + errcode + ", errmsg=" + errmsg + "]";
	}

}
