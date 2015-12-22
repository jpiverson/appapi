package com.jipengblog.appapi.web.utils.security;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

import com.jipengblog.appapi.common.SysCons;
import com.jipengblog.appapi.web.utils.PennUtils;

public final class TrippleDes extends PennUtils{

	public static String encrypt(String message) throws Exception {
		final SecretKey key = new SecretKeySpec(SysCons.DES_KEY.getBytes("utf-8"), "DESede");
		final IvParameterSpec iv = new IvParameterSpec(SysCons.DES_IV.getBytes("utf-8"));
		final Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, key, iv);
		final byte[] plainTextBytes = message.getBytes("utf-8");
		final byte[] cipherText = cipher.doFinal(plainTextBytes);
		String ret = new String(Base64.encodeBase64(cipherText), "utf-8");
		return ret;
	}

	public static String decrypt(String message) throws Exception {
		final SecretKey key = new SecretKeySpec(SysCons.DES_KEY.getBytes("utf-8"), "DESede");
		final IvParameterSpec iv = new IvParameterSpec(SysCons.DES_IV.getBytes("utf-8"));
		final Cipher decipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
		decipher.init(Cipher.DECRYPT_MODE, key, iv);
		final byte[] plainText = decipher.doFinal(Base64.decodeBase64(message));
		return new String(plainText, "UTF-8");
	}

	public static void main(String[] args) throws Exception {

		String text = "abcdefg";
		System.out.println("明文字符长度:" + text.length());
		long start = System.currentTimeMillis();
		System.out.println(TrippleDes.encrypt(text));
		System.out.println("耗时:" + (System.currentTimeMillis() - start));

		System.out.println("=================");

		start = System.currentTimeMillis();
		System.out.println(TrippleDes.decrypt("UvP4ASg8SOE="));
		System.out.println("耗时:" + (System.currentTimeMillis() - start));

	}

}
