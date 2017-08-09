package com.ych.core.umeng.pushmsg.android;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ych.core.fasterxml.jackson.databind.ser.ObjectStringSerializer;

/**
 * 消息体<br>
 * display_type=message时,body的内容只需填写custom字段。<br>
 * 
 * @author U
 *
 */
@JsonInclude(value = Include.NON_NULL)
public class AndroidSendRequestBody {

	/**
	 * 必填,通知栏提示文字
	 */
	private String ticker;

	/**
	 * 必填,通知标题
	 */
	private String title;

	/**
	 * 必填,通知文字描述
	 */
	private String text;

	/**
	 * 可选,状态栏图标ID, R.drawable.[smallIcon]<br>
	 * 如果没有, 默认使用应用图标。<br>
	 * 图片要求为24*24dp的图标,或24*24px放在drawable-mdpi下。<br>
	 * 注意四周各留1个dp的空白像素
	 */
	private String icon;

	/**
	 * 可选,通知栏拉开后左侧图标ID, R.drawable.[largeIcon].<br>
	 * 图片要求为64*64dp的图标,<Br>
	 * 可设计一张64*64px放在drawable-mdpi下,<br>
	 * 注意图片四周留空，不至于显示太拥挤
	 */
	private String largeIcon;

	/**
	 * 可选,通知栏大图标的URL链接。该字段的优先级大于largeIcon。 该字段要求以http或者https开头。
	 */
	private String img;

	/**
	 * 可选,通知声音，R.raw.[sound]. <br>
	 * 如果该字段为空，采用SDK默认的声音, 即res/raw/下的 umeng_push_notification_default_sound声音文件
	 * <br>
	 * 如果SDK默认声音文件不存在， 则使用系统默认的Notification提示音。
	 */
	private String sound;

	/**
	 * 可选 默认为0，用于标识该通知采用的样式。使用该参数时, 开发者必须在SDK里面实现自定义通知栏样式。
	 */
	@JsonProperty("builder_id")
	private Integer builderId;

	/**
	 * 可选,收到通知是否震动,默认为"true"
	 */
	@JsonProperty("play_vibrate")
	@JsonSerialize(using = ObjectStringSerializer.class)
	private Boolean playVibrate;

	/**
	 * 可选,收到通知是否闪灯,默认为"true"
	 */
	@JsonProperty("play_lights")
	@JsonSerialize(using = ObjectStringSerializer.class)
	private Boolean playLights;

	/**
	 * 可选,收到通知是否发出声音,默认为"true"
	 */
	@JsonProperty("play_sound")
	@JsonSerialize(using = ObjectStringSerializer.class)
	private Boolean playSound;

	/**
	 * 必填,点击"通知"的后续行为
	 */
	@JsonProperty("after_open")
	private AfterOpen afterOpen;

	/**
	 * 可选,当"after_open"为"go_url"时，必填
	 */
	private String url;

	/**
	 * 可选,当"after_open"为"go_activity"时，必填。
	 */
	private String activity;

	/**
	 * 可选 display_type=message, 或者 display_type=notification且
	 * "after_open"为"go_custom"时， 该字段必填。用户自定义内容, 可以为字符串或者JSON格式。
	 */
	private Object custom;

	/**
	 * @return 必填,通知栏提示文字
	 */
	public String getTicker() {
		return ticker;
	}

	/**
	 * @param ticker
	 *            必填,通知栏提示文字
	 */
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	/**
	 * @return 必填,通知标题
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            必填,通知标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return 必填,通知文字描述
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text
	 *            必填,通知文字描述
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return 可选,状态栏图标ID, R.drawable.[smallIcon]<br>
	 *         如果没有, 默认使用应用图标。<br>
	 *         图片要求为24*24dp的图标,或24*24px放在drawable-mdpi下。<br>
	 *         注意四周各留1个dp的空白像素
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * @param icon
	 *            可选,状态栏图标ID, R.drawable.[smallIcon]<br>
	 *            如果没有, 默认使用应用图标。<br>
	 *            图片要求为24*24dp的图标,或24*24px放在drawable-mdpi下。<br>
	 *            注意四周各留1个dp的空白像素
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}

	/**
	 * @return 可选,通知栏拉开后左侧图标ID, R.drawable.[largeIcon].<br>
	 *         图片要求为64*64dp的图标,<Br>
	 *         可设计一张64*64px放在drawable-mdpi下,<br>
	 *         注意图片四周留空，不至于显示太拥挤
	 */
	public String getLargeIcon() {
		return largeIcon;
	}

	/**
	 * @param largeIcon
	 *            可选,通知栏拉开后左侧图标ID, R.drawable.[largeIcon].<br>
	 *            图片要求为64*64dp的图标,<Br>
	 *            可设计一张64*64px放在drawable-mdpi下,<br>
	 *            注意图片四周留空，不至于显示太拥挤
	 */
	public void setLargeIcon(String largeIcon) {
		this.largeIcon = largeIcon;
	}

	/**
	 * @return 可选,通知栏大图标的URL链接。该字段的优先级大于largeIcon。 该字段要求以http或者https开头。
	 */
	public String getImg() {
		return img;
	}

	/**
	 * @param img
	 *            可选,通知栏大图标的URL链接。该字段的优先级大于largeIcon。 该字段要求以http或者https开头。
	 */
	public void setImg(String img) {
		this.img = img;
	}

	/**
	 * @return 可选,通知声音，R.raw.[sound]. <br>
	 *         如果该字段为空，采用SDK默认的声音, 即res/raw/下的
	 *         umeng_push_notification_default_sound声音文件 <br>
	 *         如果SDK默认声音文件不存在， 则使用系统默认的Notification提示音。
	 */
	public String getSound() {
		return sound;
	}

	/**
	 * @param sound
	 *            可选,通知声音，R.raw.[sound]. <br>
	 *            如果该字段为空，采用SDK默认的声音, 即res/raw/下的
	 *            umeng_push_notification_default_sound声音文件 <br>
	 *            如果SDK默认声音文件不存在， 则使用系统默认的Notification提示音。
	 */
	public void setSound(String sound) {
		this.sound = sound;
	}

	/**
	 * @return 可选 默认为0，用于标识该通知采用的样式。使用该参数时, 开发者必须在SDK里面实现自定义通知栏样式。
	 */
	public Integer getBuilderId() {
		return builderId;
	}

	/**
	 * @param builderId
	 *            可选 默认为0，用于标识该通知采用的样式。使用该参数时, 开发者必须在SDK里面实现自定义通知栏样式。
	 */
	public void setBuilderId(Integer builderId) {
		this.builderId = builderId;
	}

	/**
	 * @return 可选,收到通知是否震动,默认为"true"
	 */
	public Boolean getPlayVibrate() {
		return playVibrate;
	}

	/**
	 * @param playVibrate
	 *            可选,收到通知是否震动,默认为"true"
	 */
	public void setPlayVibrate(Boolean playVibrate) {
		this.playVibrate = playVibrate;
	}

	/**
	 * @return 可选,收到通知是否闪灯,默认为"true"
	 */
	public Boolean getPlayLights() {
		return playLights;
	}

	/**
	 * @param playLights
	 *            可选,收到通知是否闪灯,默认为"true"
	 */
	public void setPlayLights(Boolean playLights) {
		this.playLights = playLights;
	}

	/**
	 * @return 可选,收到通知是否发出声音,默认为"true"
	 */
	public Boolean getPlaySound() {
		return playSound;
	}

	/**
	 * @param playSound
	 *            可选,收到通知是否发出声音,默认为"true"
	 */
	public void setPlaySound(Boolean playSound) {
		this.playSound = playSound;
	}

	/**
	 * @return 必填,点击"通知"的后续行为
	 */
	public AfterOpen getAfterOpen() {
		return afterOpen;
	}

	/**
	 * @param afterOpen
	 *            必填,点击"通知"的后续行为
	 */
	public void setAfterOpen(AfterOpen afterOpen) {
		this.afterOpen = afterOpen;
	}

	/**
	 * @return 可选,当"after_open"为"go_url"时，必填
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            可选,当"after_open"为"go_url"时，必填
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return 可选,当"after_open"为"go_activity"时，必填。
	 */
	public String getActivity() {
		return activity;
	}

	/**
	 * @param activity
	 *            可选,当"after_open"为"go_activity"时，必填。
	 */
	public void setActivity(String activity) {
		this.activity = activity;
	}

	/**
	 * @return 可选 display_type=message, 或者 display_type=notification且
	 *         "after_open"为"go_custom"时， 该字段必填。用户自定义内容, 可以为字符串或者JSON格式。
	 */
	public Object getCustom() {
		return custom;
	}

	/**
	 * @param custom
	 *            可选 display_type=message, 或者 display_type=notification且
	 *            "after_open"为"go_custom"时， 该字段必填。用户自定义内容, 可以为字符串或者JSON格式。
	 */
	public void setCustom(Object custom) {
		this.custom = custom;
	}

}
