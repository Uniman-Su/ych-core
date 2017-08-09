package com.ych.core.umeng.pushmsg.android;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.ych.core.umeng.pushmsg.Policy;

/**
 * Andorid发送策略
 * 
 * @author U
 *
 */
@JsonInclude(value = Include.NON_NULL)
public class AndroidPolicy extends Policy {

	/**
	 * 可选 开发者对消息的唯一标识，服务器会根据这个标识避免重复发送。<br>
	 * 有些情况下（例如网络异常）开发者可能会重复调用API导致 消息多次下发到客户端。如果需要处理这种情况，可以考虑此参数。 注意,
	 * out_biz_no只对任务生效。
	 */
	@JsonProperty("out_biz_no")
	private String outBizNo;

	/**
	 * @return 可选 开发者对消息的唯一标识，服务器会根据这个标识避免重复发送。<br>
	 *         有些情况下（例如网络异常）开发者可能会重复调用API导致 消息多次下发到客户端。如果需要处理这种情况，可以考虑此参数。 注意,
	 *         out_biz_no只对任务生效。
	 */
	public String getOutBizNo() {
		return outBizNo;
	}

	/**
	 * @param outBizNo
	 *            可选 开发者对消息的唯一标识，服务器会根据这个标识避免重复发送。<br>
	 *            有些情况下（例如网络异常）开发者可能会重复调用API导致 消息多次下发到客户端。如果需要处理这种情况，可以考虑此参数。
	 *            注意, out_biz_no只对任务生效。
	 */
	public void setOutBizNo(String outBizNo) {
		this.outBizNo = outBizNo;
	}

}
