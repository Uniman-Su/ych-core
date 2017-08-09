package com.ych.core.model;

/**
 * 可分页查询参数
 * 
 * @author U
 *
 */
public interface PaginableParameter {

	/**
	 * @return 页索引
	 */
	Integer getPageIndex();

	/**
	 * @param pageIndex
	 *            页索引
	 */
	void setPageIndex(Integer pageIndex);

	/**
	 * @return 起始索引
	 */
	Long getStartIndex();

	/**
	 * @param startIndex
	 *            起始索引
	 */
	void setStartIndex(Long startIndex);

	/**
	 * @return 页行数
	 */
	Integer getPageSize();

	/**
	 * @param pageSize
	 *            页行数
	 */
	void setPageSize(Integer pageSize);

}
