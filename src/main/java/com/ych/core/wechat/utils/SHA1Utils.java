package com.ych.core.wechat.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * SHA-1 Utility class
 * 
 * @author SUNCHUANLIN
 * @since 1.0.0
 *
 */
public class SHA1Utils {

	private static Logger logger = LoggerFactory.getLogger(SHA1Utils.class);
	public static final String DEFAULT_CHARSET = "UTF-8";
	public static final String ALGORITHM = "SHA-1";

	public static String encrypt(String content) {
		return encrypt(content, DEFAULT_CHARSET);
	}

	public static String encrypt(String content, String charset) {
		try {
			MessageDigest digest = java.security.MessageDigest.getInstance(ALGORITHM);
			digest.update(content.getBytes(charset));
			byte messageDigest[] = digest.digest();
			return HexUtils.toHex(messageDigest);
		} catch (NoSuchAlgorithmException e) {
			logger.error("SHA-1 Encryption failed", e);
		} catch (UnsupportedEncodingException e) {
			logger.error("SHA-1 Encryption failed", e);
		}
		return content;
	}

}
