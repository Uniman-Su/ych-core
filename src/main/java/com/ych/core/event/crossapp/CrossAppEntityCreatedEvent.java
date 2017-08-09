package com.ych.core.event.crossapp;

import com.ych.core.event.EntityCreatedEvent;
import com.ych.core.event.IEntityCreatedEvent;

/**
 * 跨系统的实体创建事件
 * 
 * @author U
 *
 * @param <T>
 *            创建的数据
 */
public class CrossAppEntityCreatedEvent<T> extends EntityCreatedEvent<T>implements ICrossAppEntityCreatedEvent<T> {

	private static final long serialVersionUID = 4894124272331269692L;

	/**
	 * 事件发生的App的Key
	 */
	private String sourceAppKey;

	/**
	 * 构造方法
	 * 
	 * @param sourceAppKey
	 *            事件发生的App的Key
	 * @param entity
	 *            新增的实体
	 */
	public CrossAppEntityCreatedEvent(String sourceAppKey, T entity) {
		super(entity, false);
		this.sourceAppKey = sourceAppKey;
	}

	/**
	 * 构造方法
	 * 
	 * @param sourceAppKey
	 *            事件发生的App的Key
	 * @param sourceEvent
	 *            源引发的事件
	 */
	public CrossAppEntityCreatedEvent(String sourceAppKey, IEntityCreatedEvent<T> sourceEvent) {
		super(sourceEvent.getEntity(), false);
		this.sourceAppKey = sourceAppKey;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ych.core.event.crossapp.ICrossAppEvent#getSourceAppKey()
	 */
	@Override
	public String getSourceAppKey() {
		return this.sourceAppKey;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ych.core.event.crossapp.ICrossAppEvent#getWrappedEvent()
	 */
	@Override
	public EntityCreatedEvent<T> getWrappedEvent() {
		return new EntityCreatedEvent<T>(getEntity(), false);
	}

}
