package com.ych.core.dao;

import com.ych.core.model.SystemParameter;

/**
 * 系统参数数据访问对象
 * 
 * @author U
 *
 */
public interface SystemParameterDao {

	/**
	 * 系统参数缓存名称
	 */
	String SYSTEM_PARAMETER_CACHE_NAME = "SystemParameter";

	/**
	 * 查询指定应用的系统参数
	 * 
	 * @param appKey
	 *            应用ID
	 * @param key
	 *            参数的KEY
	 * @return 参数
	 */
	SystemParameter selectAppParam(String appKey, String key);

	/**
	 * 查询全局系统参数
	 * 
	 * @param key
	 *            参数的KEY
	 * @return 参数
	 */
	SystemParameter selectGlobalParam(String key);

}
