package com.ych.core.model;

/**
 * 携带返回数据的操作结果
 * 
 * @author U
 *
 * @param <T>
 *            携带的数据
 */
public class CommonOperationResultWidthData<T> extends BaseWithCommonOperationResult implements ICommonOperationResultWidthData<T> {

	/**
	 * 携带的数据
	 */
	private T data;

	/**
	 * 默认构造方法
	 */
	public CommonOperationResultWidthData() {

	}

	public CommonOperationResultWidthData(CommonOperationResult result, String description) {
		super(result, description);
	}

	/**
	 * 构造方法
	 * 
	 * @param result
	 *            结果
	 * @param data
	 *            携带的数据
	 */
	public CommonOperationResultWidthData(CommonOperationResult result, T data) {
		super(result);
		this.data = data;
	}

	public CommonOperationResultWidthData(CommonOperationResult result, String description, T data) {
		super(result, description);
		this.data = data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ych.core.model.ICommonOperationResultWidthData#setData(java.lang.
	 * Object)
	 */
	@Override
	public void setData(T data) {
		this.data = data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ych.core.model.ICommonOperationResultWidthData#getData()
	 */
	@Override
	public T getData() {
		return data;
	}

}
