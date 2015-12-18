package com.jipengblog.appapi.entity;

public class RespGson {

	public static final int OK = 200;
	public static final int BAD_REQUEST = 400;
	public static final int SERVER_ERROR = 500;

	private int code;
	private String desc;
	private Object content;

	public RespGson() {
	}

	public RespGson(int code, String desc, Object content) {
		this.code = code;
		this.desc = desc;
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

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}

}
