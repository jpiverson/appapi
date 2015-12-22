package com.jipengblog.appapi.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jipengblog.appapi.entity.bo.RespGson;

@Controller
@RequestMapping(value = "/api")
public class ParentController {

	protected final Logger logger = Logger.getLogger(ParentController.class);

	protected RespGson resp; // 封装返回数据

	/**
	 * 获得拦截器传递的参数
	 * 
	 * @param request
	 * @return
	 */
	@ModelAttribute("params")
	public String getUser(HttpServletRequest request) {
		return (String) request.getAttribute("params");
	}

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
