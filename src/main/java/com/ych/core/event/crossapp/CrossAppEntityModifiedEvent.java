package com.ych.core.event.crossapp;

import com.ych.core.event.EntityModifiedEvent;
import com.ych.core.event.IEntityModifiedEvent;

/**
 * 跨系统的数据改变事件
 * 
 * @author U
 *
 * @param <T>
 *            改变的数据类型
 */
public class CrossAppEntityModifiedEvent<T> extends EntityModifiedEvent<T>implements ICrossAppEntityModifiedEvent<T> {

	private static final long serialVersionUID = 7366990817254604455L;
	
	/**
	 * 事件发生的App的Key
	 */
	private String sourceAppKey;

	/**
	 * 构造方法
	 * 
	 * @param sourceAppKey
	 *            事件发生的App的Key
	 * @param oldEntity
	 *            旧数据
	 * @param newEntity
	 *            新数据
	 */
	public CrossAppEntityModifiedEvent(String sourceAppKey, T oldEntity, T newEntity) {
		super(oldEntity, newEntity, false);
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
	public CrossAppEntityModifiedEvent(String sourceAppKey, IEntityModifiedEvent<T> sourceEvent) {
		super(sourceEvent.getOldEntity(), sourceEvent.getNewEntity(), false);
		this.sourceAppKey = sourceAppKey;
	}

	/**
	 * 事件发生的App的Key
	 */
	@Override
	public String getSourceAppKey() {
		return sourceAppKey;
	}

	/* (non-Javadoc)
	 * @see com.ych.core.event.crossapp.ICrossAppEvent#getWrappedEvent()
	 */
	@Override
	public EntityModifiedEvent<T> getWrappedEvent() {
		return new EntityModifiedEvent<T>(getOldEntity(), getNewEntity(), false);
	}

}
