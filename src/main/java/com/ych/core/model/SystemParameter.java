package com.ych.core.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * 系统参数
 *
 * @author U
 *
 */
public class SystemParameter implements ISystemParameter, Serializable {

	private static final long serialVersionUID = -3521488020382994529L;

	/**
	 * 列表值得分隔符
	 */
	public static final String LIST_SEPERATOR = ";";

	/**
	 * ID
	 */
	private BigDecimal id;

	/**
	 * 应用ID
	 */
	private String appKey;

	/**
	 * key
	 */
	private String key;

	/**
	 * 系统参数类型
	 */
	private SystemParameterType type;

	/**
	 * 存储在数据库中的字符值
	 */
	private String stringValue;

	/**
	 * 不是字符串时转换后的值
	 */
	private Object transfered;

	/**
	 * @return 应用ID
	 */
	public String getAppKey() {
		return appKey;
	}

	/**
	 * @param appKey
	 *            应用ID
	 */
	public void setAppId(String appKey) {
		this.appKey = appKey;
	}

	/**
	 * @return key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key
	 *            key
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return 系统参数类型
	 */
	public SystemParameterType getType() {
		return type;
	}

	/**
	 * @param type
	 *            系统参数类型
	 */
	public void setType(SystemParameterType type) {
		this.type = type;
	}

	/**
	 * @return 存储在数据库中的字符值
	 */
	public String getStringValue() {
		return stringValue;
	}

	/**
	 * @param stringValue
	 *            存储在数据库中的字符值
	 */
	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.ych.s1.core.model.ISystemParameter#getIneterValue()
	 */
	@Override
	public Integer getIneterValue() {
		if (stringValue == null) {
			return null;
		} else if (transfered == null) {
			transfered = Integer.valueOf(stringValue);
		}
		return (Integer) transfered;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.ych.s1.core.model.ISystemParameter#getLongValue()
	 */
	@Override
	public Long getLongValue() {
		if (stringValue == null) {
			return null;
		} else if (transfered == null) {
			transfered = Long.valueOf(stringValue);
		}
		return (Long) transfered;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.ych.s1.core.model.ISystemParameter#getDecimalValue()
	 */
	@Override
	public BigDecimal getDecimalValue() {
		if (stringValue == null) {
			return null;
		} else if (transfered == null) {
			transfered = new BigDecimal(stringValue);
		}
		return (BigDecimal) transfered;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.ych.s1.core.model.ISystemParameter#getBooleanValue()
	 */
	@Override
	public Boolean getBooleanValue() {
		if (stringValue == null) {
			return null;
		} else if (transfered == null) {
			transfered = Boolean.valueOf(stringValue);
		}
		return (Boolean) transfered;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.ych.s1.core.model.ISystemParameter#getDateValue()
	 */
	@Override
	public Date getDateValue() {
		if (stringValue == null) {
			return null;
		} else if (transfered == null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTimeInMillis(Long.valueOf(stringValue));
			transfered = calendar.getTime();
		}

		return (Date) transfered;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.ych.core.model.ISystemParameter#getStringListValue()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<String> getStringListValue() {
		if (stringValue == null) {
			return Collections.emptyList();
		} else if (transfered == null) {
			String[] array = StringUtils.split(stringValue, LIST_SEPERATOR);
			if (ArrayUtils.isNotEmpty(array)) {
				transfered = Arrays.asList(array);
			} else {
				transfered = Collections.emptyList();
			}
		}
		return (List<String>) transfered;
	}
	/*
	 * (non-Javadoc)
	 *
	 * @see com.ych.core.model.ISystemParameter#getStringListValue()
	 */
	@SuppressWarnings("unchecked")
	public List<BigDecimal> getBigDecimalListValue() {
		if (stringValue == null) {
			return Collections.emptyList();
		} else if (transfered == null) {
			String[] array = StringUtils.split(stringValue, LIST_SEPERATOR);
			if (ArrayUtils.isNotEmpty(array)) {
				List<BigDecimal> result = new ArrayList<BigDecimal>();
				for (String str : array) {
					result.add(new BigDecimal(str));
				}
				transfered = result;
			} else {
				transfered = Collections.emptyList();
			}
		}
		return (List<BigDecimal>) transfered;
	}
	/**
	 * @return ID
	 */
	public BigDecimal getId() {
		return id;
	}

	/**
	 * @param id
	 *            ID
	 */
	public void setId(BigDecimal id) {
		this.id = id;
	}

	/**
	 * 初始化转换值
	 */
	public void initTransferedValue() {
		switch (type) {
		case BOOLEAN:
			getBooleanValue();
			break;

		case DATETIME:
			getDateValue();
			break;

		case DECIMAL:
			getDecimalValue();
			break;

		case INTEGER:
			getIneterValue();
			break;

		case LONG:
			getLongValue();
			break;

		case STRINGLIST:
			getStringListValue();
			break;

		case DECIMALLIST:
			getBigDecimalListValue();
			break;
		default:
			break;
		}
	}

}
