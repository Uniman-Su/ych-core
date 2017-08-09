package com.ych.core.model;

/**
 * 预排序树节点
 * 
 * @author U
 *
 */
public interface IPreorderTreenode {

	/**
	 * @return 获取左侧值
	 */
	int getLeft();

	/**
	 * @param left
	 *            左侧值
	 */
	void setLeft(int left);

	/**
	 * @return 获取右侧值
	 */
	int getRight();

	/**
	 * @param right
	 *            右侧值
	 */
	void setRight(int right);

}
