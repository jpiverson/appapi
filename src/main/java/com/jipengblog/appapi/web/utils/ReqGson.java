package com.jipengblog.appapi.web.utils;

import org.apache.commons.lang.StringUtils;

import com.google.gson.GsonBuilder;
import com.jipengblog.appapi.entity.User;

import site.penn.common.base.Constants;
import site.penn.common.security.SignatureUtils;
import site.penn.common.security.TrippleDesUtils;

/**
 * 接口请求的数据格式封装
 * 
 * @author penn
 *
 */
public class ReqGson {

	public static final int TIMEOUT = 1000 * 60;

	private long timestamp; // 时间戳
	private String params; // 参数
	private String sign; // 签名

	@Override
	public String toString() {
		return "params:" + this.params + ",sign:" + this.sign + ",timestamp" + this.timestamp;
	}

	/**
	 * 签名验证
	 * 
	 * @return
	 */
	public boolean signVerificate() {
		if (StringUtils.isEmpty(this.sign) || this.timestamp <= 0) {
			return false;
		}
		SignatureUtils utils = new SignatureUtils();
		String toEncrypt = this.params + Constants.SIGN_KEY + this.timestamp;
		String toSign = utils.encrypt(toEncrypt);
		if (this.sign.equalsIgnoreCase(toSign)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 时间戳验证
	 * 
	 * @return
	 */
	public boolean timestampVerificate() {
		if ((System.currentTimeMillis() - this.timestamp) > TIMEOUT) {
			return false;
		}
		return true;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public static void main(String[] args) throws Exception {
		// 模拟请求参数的demo
		ReqGson req = new ReqGson();
		long timestamp = System.currentTimeMillis();
		req.setTimestamp(timestamp);

		// 设置参数
		User user = new User();
		user.setMobile("18520808831");
		String params = new GsonBuilder().create().toJson(user);
		// 设置参数

		req.setParams(params);
		SignatureUtils utils = new SignatureUtils();
		String toEncrypt = params + Constants.SIGN_KEY + timestamp;
		String toSign = utils.encrypt(toEncrypt);
		req.setSign(toSign);
		String json = new GsonBuilder().create().toJson(req);
		System.out.println(json);
		System.out.println(TrippleDesUtils.encrypt(json));
	}
}
