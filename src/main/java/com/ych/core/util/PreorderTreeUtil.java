package com.ych.core.util;

import java.util.ArrayList;
import java.util.List;

import com.ych.core.model.IPreorderTreenode;
import com.ych.core.model.PreorderTreeCoordinationParameter;

/**
 * 预排序遍历树工具
 * 
 * @author U
 *
 */
public class PreorderTreeUtil {

	/**
	 * 私有构造法方法防止实例化
	 */
	private PreorderTreeUtil() {
	}

	/**
	 * 获取将新节点添加到指定节点作为最后一个子节点的调整参数<br>
	 * 同时填充需要插入的节点left和right值<br>
	 * 调整动作必须发生在插入子节点之前
	 * 
	 * @param parent
	 *            父节点
	 * @param children
	 *            插入的子节点
	 * @return 子节点的调整参数
	 */
	public static PreorderTreeCoordinationParameter append(IPreorderTreenode parent, IPreorderTreenode children) {
		PreorderTreeCoordinationParameter ret = new PreorderTreeCoordinationParameter();
		ret.setLeftBegin(parent.getRight());
		ret.setLeftAlteredValue(2);
		ret.setRightBegin(parent.getRight());
		ret.setRightAlteredValue(2);

		children.setLeft(parent.getRight());
		children.setRight(children.getLeft() + 1);

		return ret;
	}

	/**
	 * 获取将新节点添加到指定节点后一个节点的调整参数<br>
	 * 同时填充需要插入的节点left和right值<br>
	 * 调整动作必须发生在插入节点之前
	 * 
	 * @param previous
	 *            前一个节点,既插入的参照节点
	 * @param next
	 *            下一个节点,既需要插入的节点
	 * @return 子节点的调整参数
	 */
	public static PreorderTreeCoordinationParameter after(IPreorderTreenode previous, IPreorderTreenode next) {
		PreorderTreeCoordinationParameter ret = new PreorderTreeCoordinationParameter();
		ret.setLeftBegin(previous.getRight());
		ret.setLeftAlteredValue(2);
		ret.setRightBegin(previous.getRight() + 1);
		ret.setRightAlteredValue(2);

		next.setLeft(previous.getRight() + 1);
		next.setRight(next.getLeft() + 1);

		return ret;
	}

	/**
	 * 获取将新节点添加到指定节点后一个节点的调整参数<br>
	 * 同时填充需要插入的节点left和right值<br>
	 * 调整动作必须发生在插入节点之前
	 * 
	 * @param previous
	 *            前一个节点,既插入的参照节点
	 * @param next
	 *            下一个节点,既需要插入的节点
	 * @return 子节点的调整参数
	 */
	public static PreorderTreeCoordinationParameter before(IPreorderTreenode previous, IPreorderTreenode next) {
		PreorderTreeCoordinationParameter ret = new PreorderTreeCoordinationParameter();
		ret.setLeftBegin(next.getLeft());
		ret.setLeftAlteredValue(2);
		ret.setRightBegin(next.getLeft());
		ret.setRightAlteredValue(2);

		previous.setLeft(next.getLeft());
		previous.setRight(previous.getLeft() + 1);

		return ret;
	}

	/**
	 * 将节点往同级的前移动(权值更大),并挂在指定节点之后
	 * 
	 * @param previous
	 *            挂载点
	 * @param next
	 *            移动的节点
	 * @return 调整参数列表
	 */
	private static List<PreorderTreeCoordinationParameter> moveForwardAfter(IPreorderTreenode previous,
			IPreorderTreenode next) {
		int subFactor = next.getLeft() - next.getRight() - 1;
		int addFactor = previous.getRight() - next.getRight();

		List<PreorderTreeCoordinationParameter> ret = new ArrayList<PreorderTreeCoordinationParameter>(2);

		PreorderTreeCoordinationParameter preParam = new PreorderTreeCoordinationParameter();
		preParam.setLeftBegin(next.getRight());
		preParam.setLeftEnd(previous.getRight());
		preParam.setLeftAlteredValue(subFactor);
		preParam.setRightBegin(next.getRight() + 1);
		preParam.setRightEnd(previous.getRight());
		preParam.setRightAlteredValue(subFactor);
		ret.add(preParam);

		PreorderTreeCoordinationParameter nextParam = new PreorderTreeCoordinationParameter();
		nextParam.setLeftBegin(next.getLeft());
		nextParam.setLeftEnd(next.getRight());
		nextParam.setLeftAlteredValue(addFactor);
		nextParam.setRightBegin(next.getLeft());
		nextParam.setRightEnd(next.getRight());
		nextParam.setRightAlteredValue(addFactor);
		ret.add(nextParam);

		return ret;
	}

	/**
	 * 将节点往同级的前移动(权值更小),并挂在指定节点之后
	 * 
	 * @param previous
	 *            挂载点
	 * @param next
	 *            移动的节点
	 * @return 调整参数列表
	 */
	private static List<PreorderTreeCoordinationParameter> moveBackwardAfter(IPreorderTreenode previous,
			IPreorderTreenode next) {
		int subFactor = previous.getRight() - next.getLeft() + 1;
		int addFactor = next.getRight() - next.getLeft() + 1;

		List<PreorderTreeCoordinationParameter> ret = new ArrayList<PreorderTreeCoordinationParameter>(2);

		PreorderTreeCoordinationParameter preParam = new PreorderTreeCoordinationParameter();
		preParam.setLeftBegin(previous.getRight());
		preParam.setLeftEnd(next.getLeft() - 1);
		preParam.setLeftAlteredValue(addFactor);
		preParam.setRightBegin(previous.getRight());
		preParam.setRightEnd(next.getLeft() - 1);
		preParam.setRightAlteredValue(addFactor);
		ret.add(preParam);

		PreorderTreeCoordinationParameter nextParam = new PreorderTreeCoordinationParameter();
		nextParam.setLeftBegin(next.getLeft());
		nextParam.setLeftEnd(next.getRight());
		nextParam.setLeftAlteredValue(subFactor);
		nextParam.setRightBegin(next.getLeft());
		nextParam.setRightEnd(next.getRight());
		nextParam.setRightAlteredValue(subFactor);
		ret.add(nextParam);

		return ret;
	}

	/**
	 * 将某个节点移动到指定的节点之后
	 * 
	 * @param previous
	 *            前一位节点
	 * @param next
	 *            移动的节点
	 * @return 调整参数列表
	 */
	public static List<PreorderTreeCoordinationParameter> moveAfter(IPreorderTreenode previous,
			IPreorderTreenode next) {
		if (next.getLeft() == previous.getLeft()) {
			throw new IllegalArgumentException("previous and next are the same node");
		} else if (next.getLeft() < previous.getLeft() && next.getRight() > previous.getRight()) {
			throw new IllegalArgumentException("next can not be previous's ancestor");
		} else if (previous.getRight() + 1 == next.getLeft()) {
			throw new IllegalArgumentException("next is just ater previous");
		}

		if (next.getLeft() < previous.getLeft()
				|| (previous.getLeft() < next.getLeft() && previous.getRight() > next.getRight())) {
			return moveForwardAfter(previous, next);
		} else {
			return moveBackwardAfter(previous, next);
		}
	}

	/**
	 * 将children移动到parent下作为parent的子节点的最后一个<br>
	 * 此方法只能移动到没有孩子节点的parent下,如果parent存在子节点,请使用moveAfter将节点添加到parent的最后一个子节点下
	 * 
	 * @param parent
	 *            父节点
	 * @param children
	 *            子节点
	 * @return 调整参数
	 */
	public static List<PreorderTreeCoordinationParameter> moveAppend(IPreorderTreenode parent,
			IPreorderTreenode children) {
		if (children.getLeft() < parent.getLeft() && children.getRight() > parent.getRight()) {
			throw new IllegalArgumentException("children can not be parent's ancestor");
		}

		List<PreorderTreeCoordinationParameter> ret = new ArrayList<>();
		int childrenWideFactor = children.getRight() - children.getLeft() + 1;
		int moveWide = parent.getRight() - children.getLeft();

		PreorderTreeCoordinationParameter gapParam = new PreorderTreeCoordinationParameter();
		PreorderTreeCoordinationParameter moveParam = new PreorderTreeCoordinationParameter();

		moveParam.setLeftBegin(children.getLeft());
		moveParam.setLeftEnd(children.getRight());
		moveParam.setLeftAlteredValue(moveWide);
		moveParam.setRightBegin(children.getLeft());
		moveParam.setRightEnd(children.getRight());
		moveParam.setRightAlteredValue(moveWide);

		if (parent.getLeft() > children.getLeft()) {
			gapParam.setLeftBegin(children.getRight());
			gapParam.setLeftEnd(parent.getRight());
			gapParam.setLeftAlteredValue(-childrenWideFactor);
			gapParam.setRightBegin(children.getRight() + 1);
			gapParam.setRightEnd(parent.getRight() - 1);
			gapParam.setRightAlteredValue(-childrenWideFactor);
		} else {
			gapParam.setLeftBegin(parent.getRight());
			gapParam.setLeftEnd(children.getLeft() - 1);
			gapParam.setLeftAlteredValue(childrenWideFactor);
			gapParam.setRightBegin(parent.getRight());
			gapParam.setRightEnd(children.getLeft());
			gapParam.setRightAlteredValue(childrenWideFactor);
		}

		ret.add(gapParam);
		ret.add(moveParam);

		return ret;
	}

}
