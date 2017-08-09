package com.ych.core.event.crossapp;

import com.ych.core.event.IEntityCreatedEvent;

/**
 * 跨系统的实体创建事件
 * 
 * @author U
 *
 * @param 系统
 */
public interface ICrossAppEntityCreatedEvent<T> extends IEntityCreatedEvent<T>, ICrossAppEvent {

}
