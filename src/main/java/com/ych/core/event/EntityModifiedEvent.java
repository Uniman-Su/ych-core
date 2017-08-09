package com.ych.core.event;

import java.lang.reflect.TypeVariable;

import org.springframework.context.ApplicationEvent;
import org.springframework.core.ResolvableType;
import org.springframework.core.ResolvableTypeProvider;

/**
 * 数据修改的事件
 * 
 * @author U
 *
 * @param <T>
 *            修改的数据类型
 */
public class EntityModifiedEvent<T> extends ApplicationEvent implements IEntityModifiedEvent<T>, ResolvableTypeProvider {

    private static final long serialVersionUID = 8443631889476432328L;

    /**
	 * 旧数据
	 */
	private T oldEntity;

	/**
	 * 新数据
	 */
	private T newEntity;
	
	/**
     * 是否为未经过转发的原始事件
     */
    private boolean isOriginal = true;

	/**
	 * 构造方法
	 * 
	 * @param oldEntity
	 *            旧数据
	 * @param newEntity
	 *            新数据
	 */
	public EntityModifiedEvent(T oldEntity, T newEntity) {
		super(new Object[] { oldEntity, newEntity });
		this.oldEntity = oldEntity;
		this.newEntity = newEntity;
	}
	
    /**
     * 构造方法
     * 
     * @param oldEntity
     *            旧数据
     * @param newEntity
     *            新数据
     * @param isOriginal
     *            是否为未经过转发的原始事件
     */
    public EntityModifiedEvent(T oldEntity, T newEntity, boolean isOriginal) {
        super(new Object[] { oldEntity, newEntity });
        this.oldEntity = oldEntity;
        this.newEntity = newEntity;
        this.isOriginal = isOriginal;
    }

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ych.core.event.IEntityModifiedEvent#getOldEntity()
	 */
	@Override
	public T getOldEntity() {
		return oldEntity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ych.core.event.IEntityModifiedEvent#getNewEntity()
	 */
	@Override
	public T getNewEntity() {
		return newEntity;
	}

    /* (non-Javadoc)
     * @see com.ych.core.event.IEntityModifiedEvent#isOriginal()
     */
    public boolean isOriginal() {
        return isOriginal;
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.core.ResolvableTypeProvider#getResolvableType()
	 */
	@Override
	public ResolvableType getResolvableType() {
		TypeVariable<?>[] variables = getClass().getTypeParameters();
		if (variables.length == 0) {
			return ResolvableType.forClass(getClass());
		} else {
			return ResolvableType.forClassWithGenerics(getClass(), ResolvableType.forInstance(oldEntity));
		}
	}

}
