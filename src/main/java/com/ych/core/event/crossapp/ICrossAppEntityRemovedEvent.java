package com.ych.core.event.crossapp;

import com.ych.core.event.IEntityRemovedEvent;

/**
 * 跨系统的数据删除事件
 * 
 * @author U
 *
 * @param <T>
 *            删除的数据类型
 */
public interface ICrossAppEntityRemovedEvent<T> extends IEntityRemovedEvent<T>, ICrossAppEvent {

}
