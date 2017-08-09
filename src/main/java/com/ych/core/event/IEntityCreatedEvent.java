package com.ych.core.event;

import java.io.Serializable;

/**
 * 创建实体的事件
 * 
 * @author U
 *
 * @param <T>
 *            创建的类型
 */
public interface IEntityCreatedEvent<T> extends IEvent, Serializable {

	T getEntity();
	
	/**
	 * @return 是否为未经过转发的原始事件
	 */
	boolean isOriginal();

}
