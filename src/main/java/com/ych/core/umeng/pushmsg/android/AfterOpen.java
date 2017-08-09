package com.ych.core.umeng.pushmsg.android;

/**
 * 击"通知"的后续行为，默认为打开app
 * 
 * @author U
 *
 */
public enum AfterOpen {

	/**
	 * 打开应用
	 */
	go_app,

	/**
	 * 跳转到URL
	 */
	go_url,

	/**
	 * 打开特定的activity
	 */
	go_activity,

	/**
	 * 用户自定义内容
	 */
	go_custom;

}
