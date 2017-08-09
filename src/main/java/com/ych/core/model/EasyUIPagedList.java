package com.ych.core.model;

import java.util.List;

/**
 * EasyUI的分页数据封装
 * 
 * @author U
 *
 * @param <T>
 *            行数据
 */
public class EasyUIPagedList<T> extends PagedList<T> {

	private static final long serialVersionUID = -1929812637654168357L;

	/**
	 * 构造方法
	 */
	public EasyUIPagedList() {
	}

	/**
	 * 构造方法
	 * 
	 * @param list
	 *            行数据
	 */
	public EasyUIPagedList(PagedList<T> list) {
		this.setTotal(list.getTotal());
		this.setList(list.getList());
		this.setPageCount(list.getPageCount());
		this.setPageIndex(list.getPageIndex());
		this.setPageSize(list.getPageSize());
	}

	/**
	 * @return 当前页数据
	 */
	public List<T> getRows() {
		return getList();
	}

	/**
	 * @param rows
	 *            当前页数据
	 */
	public void setRows(List<T> rows) {
		setRows(rows);
	}

}
