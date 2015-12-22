package com.jipengblog.appapi.entity.bo;

/**
 * 接口返回时候的数据格式封装
 * 
 * @author penn
 *
 */
public class RespGson {

	// 成功
	public static final int CODE_OK = 0;
	// 格式错误
	public static final int CODE_WRONG_FORMAT = 97;
	// 非法请求
	public static final int CODE_ILLEGAL = 98;
	// 其他错误
	public static final int CODE_ERROR = 99;
	// 成功描述
	public static final String DESC_OK = "SUCCESS";

	private int code; // 状态码
	private String desc; // 描述
	private long timestamp; // 时间戳
	private Object content; // 内容

	/**
	 * 内容为空的json
	 * 
	 * @param code
	 *            代码
	 * @param desc
	 *            描述
	 */
	public RespGson(int code, String desc) {
		this.code = code;
		this.desc = desc;
		this.timestamp = System.currentTimeMillis();
	}

	public RespGson(int code, String desc, Object content) {
		this.code = code;
		this.desc = desc;
		this.timestamp = System.currentTimeMillis();
		this.content = content;
	}

	public RespGson(int code, String desc, Long timestamp, Object content) {
		this.code = code;
		this.desc = desc;
		this.timestamp = timestamp;
		this.content = content;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}
}
