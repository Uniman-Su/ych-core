package com.ych.core.umeng.pushmsg;

/**
 * 消息类型
 * 
 * @author U
 *
 */
public enum MsgType {
	
	/**
	 * 单播
	 */
	unicast,

	/**
	 * 列播
	 */
	listcast,

	/**
	 * 文件播
	 */
	filecast,

	/**
	 * 广播
	 */
	broadcast,

	/**
	 * 组播
	 */
	groupcast,

	/**
	 * 自定义
	 */
	customizedcast;
}
