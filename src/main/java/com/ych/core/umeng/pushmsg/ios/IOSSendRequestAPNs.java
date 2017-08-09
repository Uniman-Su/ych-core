package com.ych.core.umeng.pushmsg.ios;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 严格按照APNs定义来填写
 * 
 * @author U
 *
 */
@JsonInclude(value = Include.NON_NULL)
public class IOSSendRequestAPNs {

	/**
	 * 必填
	 */
	private String alert;

	/**
	 * 可选
	 */
	private Integer badge = 1;

	/**
	 * 可选
	 */
	private String sound = "default";

	/**
	 * 可选
	 */
	@JsonProperty("content-available")
	private Integer contentAvailable;

	/**
	 * 可选, 注意: ios8才支持该字段。
	 */
	private String category;

	/**
	 * @return 必填
	 */
	public String getAlert() {
		return alert;
	}

	/**
	 * @param alert
	 *            必填
	 */
	public void setAlert(String alert) {
		this.alert = alert;
	}

	/**
	 * @return 可选
	 */
	public String getSound() {
		return sound;
	}

	/**
	 * @param sound
	 *            可选
	 */
	public void setSound(String sound) {
		this.sound = sound;
	}

	/**
	 * @return 可选
	 */
	public Integer getBadge() {
		return badge;
	}

	/**
	 * @param badge
	 *            可选
	 */
	public void setBadge(Integer badge) {
		this.badge = badge;
	}

	/**
	 * @return 可选
	 */
	public Integer getContentAvailable() {
		return contentAvailable;
	}

	/**
	 * @param contentAvailable
	 *            可选
	 */
	public void setContentAvailable(Integer contentAvailable) {
		this.contentAvailable = contentAvailable;
	}

	/**
	 * @return 可选, 注意: ios8才支持该字段。
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category
	 *            可选, 注意: ios8才支持该字段。
	 */
	public void setCategory(String category) {
		this.category = category;
	}
}
