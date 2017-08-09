package com.ych.core.event;

import java.io.Serializable;

/**
 * 数据修改的事件
 * 
 * @author U
 *
 * @param <T>
 *            修改的数据类型
 */
public interface IEntityModifiedEvent<T> extends IEvent, Serializable {

	/**
	 * @return 旧数据
	 */
	T getOldEntity();

	/**
	 * @return 新数据
	 */
	T getNewEntity();
	
	/**
     * @return 是否为未经过转发的原始事件
     */
    boolean isOriginal();

}
