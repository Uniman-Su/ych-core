package com.ych.core.model;

/**
 * 基本实现的可分页查询参数基类
 * 
 * @author U
 *
 */
public abstract class BasePaginableParameter implements PaginableParameter {

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

}
