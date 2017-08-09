package com.ych.core.event.crossapp;

import java.io.Serializable;

import com.ych.core.event.IEvent;

/**
 * 跨应用的事件
 * 
 * @author U
 *
 */
public interface ICrossAppEvent extends Serializable {

	/**
	 * @return 事件发生的App的Key
	 */
	String getSourceAppKey();

	/**
	 * @return 包装的事件
	 */
	IEvent getWrappedEvent();

}
