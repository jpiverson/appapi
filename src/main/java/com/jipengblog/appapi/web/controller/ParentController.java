package com.jipengblog.appapi.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

public class ParentController {

	protected final Logger logger = Logger.getLogger(ParentController.class);

	protected String redirect = "redirect:"; // 执行redirect操作的前缀

	/**
	 * 将参数中日期的格式yyyy-MM-dd HH:mm:ss转换成对象中的Date格式
	 * 
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

}
