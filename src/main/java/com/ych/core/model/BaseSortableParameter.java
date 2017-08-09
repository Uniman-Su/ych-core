package com.ych.core.model;

/**
 * 基础可排序查询参数
 * 
 * @author U
 *
 */
public abstract class BaseSortableParameter implements SortableParameter, Cloneable {

	/**
	 * 排序方向
	 */
	private SortOrder order;

	/**
	 * 排序的列
	 */
	private String sort;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ych.core.model.SortableParameter#getOrder()
	 */
	@Override
	public SortOrder getOrder() {
		return order;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ych.core.model.SortableParameter#setOrder(com.ych.core.model.
	 * SortOrder)
	 */
	@Override
	public void setOrder(SortOrder order) {
		this.order = order;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ych.core.model.SortableParameter#getSort()
	 */
	@Override
	public String getSort() {
		return sort;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ych.core.model.SortableParameter#setSort(java.lang.String)
	 */
	@Override
	public void setSort(String sort) {
		this.sort = sort;
	}

	@Override
	public BaseSortableParameter clone() throws CloneNotSupportedException {
		return (BaseSortableParameter) super.clone();
	}
}
