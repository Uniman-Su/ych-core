package com.ych.core.event.crossapp;

import com.ych.core.event.EntityRemovedEvent;
import com.ych.core.event.IEntityRemovedEvent;

/**
 * 跨系统的数据删除事件
 * 
 * @author U
 *
 * @param <T>
 *            删除的数据类型
 */
public class CrossAppEntityRemovedEvent<T> extends EntityRemovedEvent<T> implements ICrossAppEntityRemovedEvent<T> {

	private static final long serialVersionUID = -7119510492374137770L;
	
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
	 *            删除的实体
	 */
	public CrossAppEntityRemovedEvent(String sourceAppKey, T entity) {
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
	public CrossAppEntityRemovedEvent(String sourceAppKey, IEntityRemovedEvent<T> sourceEvent) {
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

	/* (non-Javadoc)
	 * @see com.ych.core.event.crossapp.ICrossAppEvent#getWrappedEvent()
	 */
	@Override
	public EntityRemovedEvent<T> getWrappedEvent() {
		return new EntityRemovedEvent<T>(getEntity(), false);
	}

}
