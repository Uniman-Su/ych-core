package com.ych.core.model;

import java.io.Serializable;
import java.util.List;

/**
 * 分页数据结果
 * 
 * @author U
 *
 */
public class PagedList<T>  implements Serializable{

	private static final long serialVersionUID = -1589842116452346939L;

	/**
	 * 最大页行数
	 */
	public static final int MAX_PAGE_SIZE = 2000;

	/**
	 * 页索引,0为起始
	 */
	private int pageIndex;

	/**
	 * 页行数
	 */
	private int pageSize;

	/**
	 * 总行数
	 */
	private long total;

	/**
	 * 页数
	 */
	private int pageCount;

	/**
	 * 当前页数据
	 */
	private List<T> list;

	/**
	 * @return 页索引,0为起始
	 */
	public int getPageIndex() {
		return pageIndex;
	}

	/**
	 * @param pageIndex
	 *            页索引,0为起始
	 */
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	/**
	 * @return 页行数
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize
	 *            页行数
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize > MAX_PAGE_SIZE ? MAX_PAGE_SIZE : pageSize;
	}

	/**
	 * @return 总行数
	 */
	public long getTotal() {
		return total;
	}

	/**
	 * @param total
	 *            总行数
	 */
	public void setTotal(long total) {
		this.total = total;
	}

	/**
	 * @return 页数
	 */
	public int getPageCount() {
		return pageCount;
	}

	/**
	 * @param pageCount
	 *            页数
	 */
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	/**
	 * @return 当前页数据
	 */
	public List<T> getList() {
		return list;
	}

	/**
	 * @param list
	 *            当前页数据
	 */
	public void setList(List<T> list) {
		this.list = list;
	}

}
