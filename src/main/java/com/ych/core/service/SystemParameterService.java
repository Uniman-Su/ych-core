package com.ych.core.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.ych.core.dao.SystemParameterDao;
import com.ych.core.model.SystemParameter;

/**
 * 系统参数服务
 * 
 * @author U
 *
 */
public class SystemParameterService {

	/**
	 * 当前应用的AppKey
	 */
	private String appKey;

	/**
	 * 系统参数的数据映射
	 */
	private SystemParameterDao sysParamDao;

	/**
	 * @return 当前应用的AppKey
	 */
	public String getAppKey() {
		return appKey;
	}

	/**
	 * @param appKey
	 *            当前应用的AppKey
	 */
	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	/**
	 * @param sysParamDao
	 *            系统参数的数据映射
	 */
	public void setSysParamDao(SystemParameterDao sysParamDao) {
		this.sysParamDao = sysParamDao;
	}

	/**
	 * 内部获取系统参数的调用
	 * 
	 * @param appKey
	 *            AppKey
	 * @param key
	 *            Key
	 * @return 系统参数,未查询到时返回null
	 */
	private SystemParameter internalGetSystemParameter(String appKey, String key) {
		SystemParameter ret;
		if (appKey == null) {
			ret = sysParamDao.selectAppParam(this.appKey, key);
			if (ret == null) {
				ret = sysParamDao.selectGlobalParam(key);
			}
		} else {
			ret = sysParamDao.selectAppParam(appKey, key);
		}
		return ret;
	}

	/**
	 * 优先查询当前应用的系统参数,未查询到时查询全局系统参数,未查询到时返回null.
	 * 
	 * @param key
	 *            Key
	 * @return 未查询到时返回null
	 */
	public SystemParameter getSystemParameter(String key) {
		return internalGetSystemParameter(null, key);
	}

	/**
	 * 查询指定应用的系统参数,未查询到时返回null.
	 * 
	 * @param appKey
	 *            appKey
	 * @param key
	 *            Key
	 * @return 未查询到时返回null
	 */
	public SystemParameter getSystemParameter(String appKey, String key) {
		return internalGetSystemParameter(appKey, key);
	}

	/**
	 * @param appKey
	 *            appKey
	 * @param key
	 *            Key
	 * @return 存储在数据库中的字符值
	 */
	private String internalGetStringValue(String appKey, String key) {
		SystemParameter param = internalGetSystemParameter(appKey, key);
		return param == null ? null : param.getStringValue();
	}

	/**
	 * @param appKey
	 *            appKey
	 * @param key
	 *            Key
	 * 
	 * @return 存储在数据库中的字符值
	 */
	public String getStringValue(String appKey, String key) {
		return internalGetStringValue(appKey, key);
	}

	/**
	 * @param key
	 *            Key
	 * 
	 * @return 存储在数据库中的字符值
	 */
	public String getStringValue(String key) {
		return internalGetStringValue(null, key);
	}

	/**
	 * @param appKey
	 *            appKey
	 * @param key
	 *            Key
	 * @return 存储在数据库中的整型值
	 */
	private Integer internalGetIntegerValue(String appKey, String key) {
		SystemParameter param = internalGetSystemParameter(appKey, key);
		return param == null ? null : param.getIneterValue();
	}

	/**
	 * @param appKey
	 *            appKey
	 * @param key
	 *            Key
	 * @return 存储在数据库中的整型值
	 */
	public Integer getIneterValue(String appKey, String key) {
		return internalGetIntegerValue(appKey, key);
	}

	/**
	 * @param key
	 *            Key
	 * @return 存储在数据库中的整型值
	 */
	public Integer getIneterValue(String key) {
		return internalGetIntegerValue(null, key);
	}

	/**
	 * @param appKey
	 *            appKey
	 * @param key
	 *            Key
	 * @return 存储在数据库中的长整型值
	 */
	private Long internalGetLongValue(String appKey, String key) {
		SystemParameter param = internalGetSystemParameter(appKey, key);
		return param == null ? null : param.getLongValue();
	}

	/**
	 * @param appKey
	 *            appKey
	 * @param key
	 *            Key
	 * @return 存储在数据库中的长整型值
	 */
	public Long getLongValue(String appKey, String key) {
		return internalGetLongValue(appKey, key);
	}

	/**
	 * @param key
	 *            Key
	 * @return 存储在数据库中的长整型值
	 */
	public Long getLongValue(String key) {
		return internalGetLongValue(null, key);
	}

	/**
	 * @param appKey
	 *            appKey
	 * @param key
	 *            Key
	 * @return 存储在数据库中的Decimal值
	 */
	private BigDecimal internalGetDecimalValue(String appKey, String key) {
		SystemParameter param = internalGetSystemParameter(appKey, key);
		return param == null ? null : param.getDecimalValue();
	}

	/**
	 * @param appKey
	 *            appKey
	 * @param key
	 *            Key
	 * @return 存储在数据库中的Decimal值
	 */
	public BigDecimal getDecimalValue(String appKey, String key) {
		return internalGetDecimalValue(appKey, key);
	}

	/**
	 * @param key
	 *            Key
	 * @return 存储在数据库中的decimal值
	 */
	public BigDecimal getDecimalValue(String key) {
		return internalGetDecimalValue(null, key);
	}

	/**
	 * @param appKey
	 *            appKey
	 * @param key
	 *            Key
	 * @return 存储在数据库中的Boolean值
	 */
	private Boolean internalGetBooleanValue(String appKey, String key) {
		SystemParameter param = internalGetSystemParameter(appKey, key);
		return param == null ? null : param.getBooleanValue();
	}

	/**
	 * @param appKey
	 *            appKey
	 * @param key
	 *            Key
	 * @return 存储在数据库中的Boolean值
	 */
	public Boolean getBooleanValue(String appKey, String key) {
		return internalGetBooleanValue(appKey, key);
	}

	/**
	 * @param key
	 *            Key
	 * @return 存储在数据库中的Boolean值
	 */
	public Boolean getBooleanValue(String key) {
		return internalGetBooleanValue(null, key);
	}

	/**
	 * @param appKey
	 *            appKey
	 * @param key
	 *            Key
	 * @return 存储在数据库中的时间
	 */
	private Date internalGetDateValue(String appKey, String key) {
		SystemParameter param = internalGetSystemParameter(appKey, key);
		return param == null ? null : param.getDateValue();
	}

	/**
	 * @param appKey
	 *            appKey
	 * @param key
	 *            Key
	 * @return 存储在数据库中的时间
	 */
	public Date getDateValue(String appKey, String key) {
		return internalGetDateValue(appKey, key);
	}

	/**
	 * @param key
	 *            Key
	 * @return 存储在数据库中的时间
	 */
	public Date getDateValue(String key) {
		return internalGetDateValue(null, key);
	}

	private List<String> ineternalGetStringList(String appKey, String key) {
		SystemParameter param = internalGetSystemParameter(appKey, key);
		return param == null ? null : param.getStringListValue();
	}

	private List<BigDecimal> ineternalGetBigDecimalList(String appKey, String key) {
		SystemParameter param = internalGetSystemParameter(appKey, key);
		return param == null ? null : param.getBigDecimalListValue();
	}

	/**
	 * @param appKey
	 *            appKey
	 * @param key
	 *            Key
	 * @return 存储在数据库中的字符串列表
	 */
	public List<String> getStringListValue(String appKey, String key) {
		return ineternalGetStringList(appKey, key);
	}

	/**
	 * @param key
	 *            Key
	 * @return 存储在数据库中的字符串列表
	 */
	public List<String> getStringListValue(String key) {
		return ineternalGetStringList(null, key);
	}

	/**
	 * @param appKey
	 *            appKey
	 * @param key
	 *            Key
	 * @return 存储在数据库中的Decimal列表
	 */
	public List<BigDecimal> getBigDecimalListValue(String appKey, String key) {
		return ineternalGetBigDecimalList(appKey, key);
	}

	/**
	 * @param key
	 *            Key
	 * @return 存储在数据库中的Decimal列表
	 */
	public List<BigDecimal> getBigDecimalListValue(String key) {
		return ineternalGetBigDecimalList(null, key);
	}
}
