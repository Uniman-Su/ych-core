package com.ych.core.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.ObjectUtils;

/**
 * 克隆用的工具
 * 
 * @author U
 *
 */
public final class CloneUtil {

	private CloneUtil() {
	}

	/**
	 * 克隆List
	 * 
	 * @param list
	 *            要克隆的List
	 * @return 克隆后的List
	 */
	static public <T extends Cloneable> List<T> cloneList(List<T> list) {
		List<T> ret = null;

		if (list != null) {
			if (list.size() == 0) {
				ret = Collections.emptyList();
			} else {
				ret = new ArrayList<>(list.size());
				for (T ele : list) {
					ret.add(ObjectUtils.clone(ele));
				}
			}
		}

		return ret;
	}

}
