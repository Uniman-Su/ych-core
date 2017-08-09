package com.ych.core.event;

import java.io.Serializable;

/**
 * 数据删除的事件
 * 
 * @author U
 *
 * @param <T>
 *            删除的数据类型
 */
public interface IEntityRemovedEvent<T> extends IEvent, Serializable {

	/**
	 * 删除的数据
	 */
	T getEntity();
	
	/**
     * @return 是否为未经过转发的原始事件
     */
    boolean isOriginal();

}
