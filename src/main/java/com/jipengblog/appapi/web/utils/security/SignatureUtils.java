package com.jipengblog.appapi.web.utils.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.jipengblog.appapi.common.SysCons;
import com.jipengblog.appapi.web.utils.PennUtils;
import com.jipengblog.appapi.web.utils.security.enums.Algorithm;

/**
 * 签名算法，包括32位的md5和40位的sha-1
 * 
 * @author penn
 *
 */
public class SignatureUtils extends PennUtils {

	private MessageDigest messageDigest;
	private Algorithm defaulAlgorithm = Algorithm.MD5;

	/**
	 * 默认使用MD5算法
	 */
	public SignatureUtils() {// 默认使用MD5算法
		try {
			messageDigest = MessageDigest.getInstance(defaulAlgorithm.toString());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			logger.error("实例化时参数[" + defaulAlgorithm + "]错误");
		}
	}

	/**
	 * 使用参数指定的算法
	 * 
	 * @param algorithm
	 *            算法名称
	 */
	public SignatureUtils(Algorithm algorithm) {
		try {
			messageDigest = MessageDigest.getInstance(algorithm.toString());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			logger.error("实例化时参数[" + algorithm + "]错误");
		}
	}

	/**
	 * 使用默认盐加密
	 * 
	 * @param plaintext
	 *            明文
	 * @return 密文
	 */
	public String encrypt(String plaintext) {
		return encrypt(plaintext, SysCons.MD5_SALT);
	}

	/**
	 * 加密方法。 如果salt.equals("")， 不带盐加密
	 * 
	 * @param plaintext
	 *            明文
	 * @param salt
	 *            盐
	 * @return 密文
	 */
	public String encrypt(String plaintext, String salt) {
		if (salt == null) {
			salt = "";
		}
		String finaltext = plaintext + salt;
		messageDigest.update(finaltext.getBytes());
		byte[] buffer = messageDigest.digest();
		StringBuffer sb = new StringBuffer(buffer.length * 2);
		for (int i = 0; i < buffer.length; i++) {
			sb.append(Character.forDigit((buffer[i] & 240) >> 4, 16));
			sb.append(Character.forDigit(buffer[i] & 15, 16));
		}
		return sb.toString();
	}
}
