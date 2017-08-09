package com.ych.core.wechat.utils;

/**
 * 十六进制工具类
 * 
 * @author SUNCHUANLIN
 * @since 1.0.0
 *
 */
public class HexUtils {

	private static final char[] digit = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c',
			'd', 'e', 'f' };

	/**
	 * 将字节转换为十六进制字符串表示
	 * 
	 * @param abyte
	 *            字节
	 * @return
	 */
	public static String toHex(byte abyte) {
		char[] hexArr = new char[2];
		hexArr[0] = digit[(abyte >>> 4) & 0X0F];
		hexArr[1] = digit[abyte & 0X0F];
		return new String(hexArr);
	}

	/**
	 * 将字节数组转换为十六进制字符串表示
	 * 
	 * @param byteArr
	 *            字节数组
	 * @return
	 */
	public static String toHex(byte[] byteArr) {
		StringBuilder sb = new StringBuilder();
		for (byte abyte : byteArr) {
			sb.append(toHex(abyte));
		}
		return sb.toString();
	}

}
