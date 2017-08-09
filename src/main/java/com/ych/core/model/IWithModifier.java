package com.ych.core.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 有修改者数据的实体
 * 
 * @author U
 *
 */
public interface IWithModifier {

	/**
	 * @return 修改者ID
	 */
	BigDecimal getModifierId();

	/**
	 * @param modifierId
	 *            修改者ID
	 */
	void setModifierId(BigDecimal modifierId);

	/**
	 * @return 修改时间
	 */
	Date getModifyTime();

	/**
	 * 
	 * @param modifyTime
	 *            修改时间
	 */
	void setModifyTime(Date modifyTime);

}
