package com.ych.core.model;

/**
 * 预排序遍历树调整参数
 * 
 * @author U
 *
 */
public class PreorderTreeCoordinationParameter {

	/**
	 * 左侧起始值
	 */
	private Integer leftBegin;

	/**
	 * 左侧结束值
	 */
	private Integer leftEnd;

	/**
	 * 左侧变更值
	 */
	private Integer leftAlteredValue;

	/**
	 * 右侧起始值
	 */
	private Integer rightBegin;

	/**
	 * 右侧结束值
	 */
	private Integer rightEnd;

	/**
	 * 右侧变更值
	 */
	private Integer rightAlteredValue;

	/**
	 * @return 左侧起始值
	 */
	public Integer getLeftBegin() {
		return leftBegin;
	}

	/**
	 * @param leftBegin
	 *            左侧起始值
	 */
	public void setLeftBegin(Integer leftBegin) {
		this.leftBegin = leftBegin;
	}

	/**
	 * @return 左侧结束值
	 */
	public Integer getLeftEnd() {
		return leftEnd;
	}

	/**
	 * @param leftEnd
	 *            左侧结束值
	 */
	public void setLeftEnd(Integer leftEnd) {
		this.leftEnd = leftEnd;
	}

	/**
	 * @return 左侧变更值
	 */
	public Integer getLeftAlteredValue() {
		return leftAlteredValue;
	}

	/**
	 * @param leftAlteredValue
	 *            左侧变更值
	 */
	public void setLeftAlteredValue(Integer leftAlteredValue) {
		this.leftAlteredValue = leftAlteredValue;
	}

	/**
	 * @return 右侧起始值
	 */
	public Integer getRightBegin() {
		return rightBegin;
	}

	/**
	 * @param rightBegin
	 *            右侧起始值
	 */
	public void setRightBegin(Integer rightBegin) {
		this.rightBegin = rightBegin;
	}

	/**
	 * @return 右侧结束值
	 */
	public Integer getRightEnd() {
		return rightEnd;
	}

	/**
	 * @param rightEnd
	 *            右侧结束值
	 */
	public void setRightEnd(Integer rightEnd) {
		this.rightEnd = rightEnd;
	}

	/**
	 * @return 右侧变更值
	 */
	public Integer getRightAlteredValue() {
		return rightAlteredValue;
	}

	/**
	 * @param rightAlteredValue
	 *            右侧变更值
	 */
	public void setRightAlteredValue(Integer rightAlteredValue) {
		this.rightAlteredValue = rightAlteredValue;
	}

}
