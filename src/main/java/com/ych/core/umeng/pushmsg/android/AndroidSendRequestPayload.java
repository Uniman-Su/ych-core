package com.ych.core.umeng.pushmsg.android;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.ych.core.umeng.pushmsg.DisplayType;

/**
 * 消息内容(Android最大为1840B)
 * 
 * @author U
 *
 */
@JsonInclude(value = Include.NON_NULL)
public class AndroidSendRequestPayload {

	/**
	 * 必填,消息类型
	 */
	@JsonProperty("display_type")
	private DisplayType displayType;

	/**
	 * 必填,消息体
	 */
	private AndroidSendRequestBody body;

	/**
	 * 选填, 用户自定义key-value。只对"通知" (display_type=notification)生效。
	 * 可以配合通知到达后,打开App,打开URL,打开Activity使用。
	 */
	private Map<String, String> extra;

	/**
	 * @return 必填,消息体
	 */
	public AndroidSendRequestBody getBody() {
		return body;
	}

	/**
	 * @param 必填,消息体
	 */
	public void setBody(AndroidSendRequestBody body) {
		this.body = body;
	}

	/**
	 * @return 必填,消息类型
	 */
	public DisplayType getDisplayType() {
		return displayType;
	}

	/**
	 * @param 必填,消息类型
	 */
	public void setDisplayType(DisplayType displayType) {
		this.displayType = displayType;
	}

	/**
	 * @return 选填, 用户自定义key-value。只对"通知" (display_type=notification)生效。
	 *         可以配合通知到达后,打开App,打开URL,打开Activity使用。
	 */
	public Map<String, String> getExtra() {
		return extra;
	}

	/**
	 * @param extra
	 *            选填, 用户自定义key-value。只对"通知" (display_type=notification)生效。
	 *            可以配合通知到达后,打开App,打开URL,打开Activity使用。
	 */
	public void setExtra(Map<String, String> extra) {
		this.extra = extra;
	}

}
