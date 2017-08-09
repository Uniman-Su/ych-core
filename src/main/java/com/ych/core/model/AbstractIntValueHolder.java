package com.ych.core.model;

/**
 * 抽象的包含整形值的枚举
 * 
 * @author U
 *
 */
public abstract class AbstractIntValueHolder<T extends Enum<T>> implements IntValueHolder<T> {

	/**
	 * 通过整型值获取枚举
	 * 
	 * @param clazz
	 *            枚举类
	 * @param value
	 *            整型值
	 * @return 枚举
	 * @throws IllegalArgumentException
	 *             当传入的枚举值不支持时
	 * @throws ClassCastException
	 *             当传入的枚举类不是IntValueHolder接口时
	 * @throws NullPointerException
	 *             clazz为null时
	 */
	@SuppressWarnings({"rawtypes", "unchecked"})
	public static <K extends Enum<K>> K valueOf(Class<? extends IntValueHolder<K>> clazz, int value) {
		for (IntValueHolder<K> entry : clazz.getEnumConstants()) {
			if (entry.getValue() == value) {
				return (K) entry;
			}
		}

		throw new IllegalArgumentException("Unsupported value of " + clazz.getName() + ":" + value);
	}

}
