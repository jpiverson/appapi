package com.jipengblog.appapi.common;

public final class SysCons {

	/*
	 * MD5加密的盐
	 */
	public static final String MD5_SALT = "penn";

	/*
	 * 接口请求的签名秘钥
	 */
	public static final String SIGN_KEY = "penn.site";

	/*
	 * 将"penn"(不含引号)进行md5加密后的前24位作为key.将"penn"(不含引号)进行md5加密后的后8位作为iv
	 */
	public static final String DES_KEY = "fba5cae8cd057043d5b90461";
	public static final String DES_IV = "2b9b1ed3";

	/*
	 * 七牛云存储的的域名地址
	 */
	public static final String CDN_SERVER = "http://7nj2vs.com1.z0.glb.clouddn.com/";

}
