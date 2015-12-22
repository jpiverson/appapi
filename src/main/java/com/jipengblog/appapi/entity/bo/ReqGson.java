package com.jipengblog.appapi.entity.bo;

import org.apache.commons.lang.StringUtils;

import com.google.gson.GsonBuilder;
import com.jipengblog.appapi.common.SysCons;
import com.jipengblog.appapi.web.utils.security.SignatureUtils;
import com.jipengblog.appapi.web.utils.security.TrippleDes;
import com.jipengblog.appapi.web.utils.security.enums.Algorithm;

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
		SignatureUtils utils = new SignatureUtils(Algorithm.MD5);
		String toEncrypt = this.params + SysCons.SIGN_KEY + this.timestamp;
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
		String params = "{'a':1}";
		req.setParams(params);
		SignatureUtils utils = new SignatureUtils(Algorithm.MD5);
		String toEncrypt = params + SysCons.SIGN_KEY + timestamp;
		String toSign = utils.encrypt(toEncrypt);
		req.setSign(toSign);
		String json = new GsonBuilder().create().toJson(req);
		System.out.println(json);
		System.out.println(TrippleDes.encrypt(json));
	}
}
