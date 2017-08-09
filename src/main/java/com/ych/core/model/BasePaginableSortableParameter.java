package com.ych.core.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 基础可分页可排序查询参数
 * 
 * @author U
 *
 */
public abstract class BasePaginableSortableParameter implements SortableParameter, PaginableParameter {

	/**
	 * 起始页索引
	 */
	private Integer pageIndex;

	/**
	 * 起始行索引
	 */
	private Long startIndex;

	/**
	 * 页行数
	 */
	private Integer pageSize;

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
	 * @see com.ych.core.model.PaginableParameter#getPageIndex()
	 */
	@Override
	public Integer getPageIndex() {
		return pageIndex;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ych.core.model.PaginableParameter#setPageIndex(java.lang.Integer)
	 */
	@Override
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ych.core.model.PaginableParameter#getStartIndex()
	 */
	@Override
	public Long getStartIndex() {
		return startIndex;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ych.core.model.PaginableParameter#setStartIndex(java.lang.Long)
	 */
	@Override
	public void setStartIndex(Long startIndex) {
		this.startIndex = startIndex;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ych.core.model.PaginableParameter#getPageSize()
	 */
	@Override
	public Integer getPageSize() {
		return pageSize;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ych.core.model.PaginableParameter#setPageSize(java.lang.Integer)
	 */
	@Override
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
