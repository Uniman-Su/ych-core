package com.ych.core.model;

/**
 * 包装数据的通用操作结果
 * 
 * @author U
 *
 * @param <T>
 *            包装的数据
 */
public interface ICommonOperationResultWidthData<T> extends IWithCommonOperationResult {

	/**
	 * @param data
	 *            包装的数据
	 */
	void setData(T data);

	/**
	 * @return 包装的数据
	 */
	T getData();

}
