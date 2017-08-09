package com.ych.core.event.crossapp;

import com.ych.core.event.IEntityModifiedEvent;

/**
 * 跨系统的数据改变事件
 * 
 * @author U
 *
 * @param <T>
 *            改变的数据类型
 */
public interface ICrossAppEntityModifiedEvent<T> extends IEntityModifiedEvent<T>, ICrossAppEvent {

}
