package com.ych.core.event;

import java.lang.reflect.TypeVariable;

import org.springframework.context.ApplicationEvent;
import org.springframework.core.ResolvableType;
import org.springframework.core.ResolvableTypeProvider;

/**
 * 创建实体的事件
 * 
 * @author U
 *
 * @param <T>
 *            创建的类型
 */
public class EntityCreatedEvent<T> extends ApplicationEvent implements IEntityCreatedEvent<T>, ResolvableTypeProvider {

    private static final long serialVersionUID = -4088623649525696894L;

    /**
	 * 创建的数据
	 */
	private T entity;
	
	/**
	 * 是否为未经过转发的原始事件
	 */
	private boolean isOriginal = true;

	/**
	 * 构造方法
	 * 
	 * @param entity
	 *            创建的数据
	 */
	public EntityCreatedEvent(T entity) {
		super(entity);
		this.entity = entity;
	}
	
    /**
     * 构造方法
     * 
     * @param entity
     *            创建的数据
     * @param isOriginal
     *            是否为未经过转发的原始事件
     */
    public EntityCreatedEvent(T entity, boolean isOriginal) {
        super(entity);
        this.entity = entity;
        this.isOriginal = isOriginal;
    }

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ych.core.event.IEntityCreatedEvent#getEntity()
	 */
	@Override
	public T getEntity() {
		return entity;
	}

    /* (non-Javadoc)
     * @see com.ych.core.event.IEntityCreatedEvent#isOriginal()
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
			return ResolvableType.forClassWithGenerics(getClass(), ResolvableType.forInstance(entity));
		}
	}

}
