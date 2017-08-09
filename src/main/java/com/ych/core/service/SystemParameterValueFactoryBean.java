package com.ych.core.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.FactoryBean;

import com.ych.core.model.SystemParameterType;

/**
 * 系统参数值工厂Bean
 * 
 * @author U
 *
 */
public class SystemParameterValueFactoryBean implements FactoryBean<Object> {

	/**
	 * 系统参数服务
	 */
	private SystemParameterService sysParamSvc;

	/**
	 * 取值的Key
	 */
	private String key;

	/**
	 * 系统参数的类型
	 */
	private SystemParameterType type;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.beans.factory.FactoryBean#getObject()
	 */
	@Override
	public Object getObject() throws Exception {
		switch (type) {
		case BOOLEAN:
			return sysParamSvc.getBooleanValue(key);

		case DATETIME:
			return sysParamSvc.getDateValue(key);

		case DECIMAL:
			return sysParamSvc.getDecimalValue(key);

		case INTEGER:
			return sysParamSvc.getIneterValue(key);

		case LONG:
			return sysParamSvc.getLongValue(key);

		case STRING:
			return sysParamSvc.getStringValue(key);

		case STRINGLIST:
			return sysParamSvc.getStringListValue(key);

		default:
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.beans.factory.FactoryBean#getObjectType()
	 */
	@Override
	public Class<?> getObjectType() {
		switch (type) {

		case BOOLEAN:
			return Boolean.class;

		case DATETIME:
			return Date.class;

		case DECIMAL:
			return BigDecimal.class;

		case INTEGER:
			return Integer.class;

		case LONG:
			return Long.class;

		case STRING:
			return String.class;

		case STRINGLIST:
			return List.class;

		default:
			return Object.class;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.beans.factory.FactoryBean#isSingleton()
	 */
	@Override
	public boolean isSingleton() {
		return false;
	}

	/**
	 * @param sysParamSvc
	 *            系统参数服务
	 */
	public void setSysParamSvc(SystemParameterService sysParamSvc) {
		this.sysParamSvc = sysParamSvc;
	}

	/**
	 * @param key
	 *            取值的Key
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @param type
	 *            系统参数的类型
	 */
	public void setType(SystemParameterType type) {
		this.type = type;
	}

}
