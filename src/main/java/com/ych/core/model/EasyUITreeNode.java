package com.ych.core.model;

import java.util.List;

/**
 * jQueryEasyUI的树节点
 * 
 * @author U
 *
 * @param <I>
 *            ID的数据类型
 * @param <T>
 *            节点包含的数据类型
 */
public class EasyUITreeNode<I, T> {

	/**
	 * ID
	 */
	private I id;

	/**
	 * 节点文本
	 */
	private String text;

	/**
	 * 树节点状态
	 */
	private EasyUITreeNodeState state;

	/**
	 * 图标
	 */
	private String iconCls;

	/**
	 * 是否选中
	 */
	private boolean isChecked;

	/**
	 * 包含的数据
	 */
	private T attributes;

	/**
	 * 子节点
	 */
	private List<EasyUITreeNode<I, T>> children;

	/**
	 * @return ID
	 */
	public I getId() {
		return id;
	}

	/**
	 * @param id
	 *            ID
	 */
	public void setId(I id) {
		this.id = id;
	}

	/**
	 * @return 节点文本
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text
	 *            节点文本
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return 树节点状态
	 */
	public EasyUITreeNodeState getState() {
		return state;
	}

	/**
	 * @param state
	 *            树节点状态
	 */
	public void setState(EasyUITreeNodeState state) {
		this.state = state;
	}

	/**
	 * @return 图标
	 */
	public String getIconCls() {
		return iconCls;
	}

	/**
	 * @param iconCls
	 *            图标
	 */
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	/**
	 * @return 是否选中
	 */
	public boolean isChecked() {
		return isChecked;
	}

	/**
	 * @param isChecked
	 *            是否选中
	 */
	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}

	/**
	 * @return 包含的数据
	 */
	public T getAttributes() {
		return attributes;
	}

	/**
	 * @param attributes
	 *            包含的数据
	 */
	public void setAttributes(T attributes) {
		this.attributes = attributes;
	}

	/**
	 * @return 子节点
	 */
	public List<EasyUITreeNode<I, T>> getChildren() {
		return children;
	}

	/**
	 * @param children
	 *            子节点
	 */
	public void setChildren(List<EasyUITreeNode<I, T>> children) {
		this.children = children;
	}

}
