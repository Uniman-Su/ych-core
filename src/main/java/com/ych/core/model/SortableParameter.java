package com.ych.core.model;

/**
 * 可排序参数
 * 
 * @author U
 *
 */
public interface SortableParameter {

	/**
	 * @return 排序方向
	 */
	SortOrder getOrder();

	/**
	 * @param order
	 *            排序方向
	 */
	void setOrder(SortOrder order);

	/**
	 * @return 排序的列
	 */
	String getSort();

	/**
	 * @param sort
	 *            排序的列
	 */
	void setSort(String sort);

}
