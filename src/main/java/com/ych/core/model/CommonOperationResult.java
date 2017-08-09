package com.ych.core.model;

/**
 * 用来表示操作结果的通用型枚举
 * 
 * @author U
 *
 */
public enum CommonOperationResult {

	/**
	 * 成功
	 */
	Succeeded,

	/**
	 * 目标不存在
	 */
	NotExists,

	/**
	 * 目标已存在
	 */
	Existed,

	/**
	 * 写文件失败
	 */
	WriteFileFailed,

	/**
	 * 操作失败
	 */
	Failed,

	/**
	 * 部分成功
	 */
	PartialSucceeded,

	/**
	 * 非法操作
	 */
	IllegalOperation,

	/**
	 * 密码错误
	 */
	IllegalPassword,

	/**
	 * 缺少参数
	 */
	ArgumentsRequired,

	/**
	 * 参数错误
	 */
	IllegalArguments,

	/**
	 * 数据状态错误
	 */
	IllegalStatus,

	/**
	 * 未登录
	 */
	NotLogined,

	/**
	 * 无权限
	 */
	IllegalAccess,

	/**
	 * 远端请求失败,系统请求后端系统出现问题
	 */
	RemoteRequestFailed,

	/**
	 * 已禁用
	 */
	Disabled,

	/**
	 * 被其他数据引用
	 */
	Referenced;
}
