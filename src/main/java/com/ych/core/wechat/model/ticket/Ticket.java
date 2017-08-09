package com.ych.core.wechat.model.ticket;

import com.ych.core.wechat.model.BaseResponseEntity;

public class Ticket extends BaseResponseEntity {

	private static final long serialVersionUID = 3932680213919409815L;

	/** 获取到的票据 */
	private String ticket;
	/** 凭证有效时间，单位：秒 */
	private int expires_in;

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public int getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}

	@Override
	public String toString() {
		return "Ticket [ticket=" + ticket + ", expires_in=" + expires_in + ", isSuccess()=" + isSuccess()
				+ ", getErrcode()=" + getErrcode() + ", getErrmsg()=" + getErrmsg() + "]";
	}

}
