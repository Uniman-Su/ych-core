package com.ych.core.event;

import java.lang.reflect.TypeVariable;

import org.springframework.context.ApplicationEvent;
import org.springframework.core.ResolvableType;
import org.springframework.core.ResolvableTypeProvider;

/**
 * 数据删除的事件
 * 
 * @author U
 *
 * @param <T>
 *            删除的数据类型
 */
public class EntityRemovedEvent<T> extends ApplicationEvent implements IEntityRemovedEvent<T>, ResolvableTypeProvider {
	
    private static final long serialVersionUID = 1358148568167950419L;

    /**
	 * 删除的数据
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
	 *            删除的数据
	 */
	public EntityRemovedEvent(T entity) {
		super(entity);
		this.entity = entity;
	}
	
    /**
     * 构造方法
     * 
     * @param entity
     *            删除的数据
     * @param isOriginal
     *            是否为未经过转发的原始事件
     */
    public EntityRemovedEvent(T entity, boolean isOriginal) {
        super(entity);
        this.entity = entity;
        this.isOriginal = isOriginal;
    }

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ych.core.event.IEntityRemovedEvent#getEntity()
	 */
	@Override
	public T getEntity() {
		return entity;
	}
	
    /* (non-Javadoc)
     * @see com.ych.core.event.IEntityRemovedEvent#isOriginal()
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
