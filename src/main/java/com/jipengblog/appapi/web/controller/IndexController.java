package com.jipengblog.appapi.web.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jipengblog.appapi.entity.User;
import com.jipengblog.appapi.entity.bo.RespGson;
import com.jipengblog.appapi.service.UserService;

import site.penn.common.base.Constants;
import site.penn.common.security.SignatureUtils;

/**
 * 登录, 注册
 * 
 * @author penn
 *
 */
@Controller
public class IndexController extends ParentController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/login/mobsms", method = RequestMethod.POST)
	@ResponseBody
	public String login(@ModelAttribute("params") String params) {
		User user = new Gson().fromJson(params, User.class);
		User existUser = userService.findByMobile(user.getMobile());
		if (existUser != null) {
			existUser.setLastLoginTime(new Date());
		} else {
			existUser = new User();
			existUser.setMobile(user.getMobile());
			existUser.setMobileVer(true);
			SignatureUtils utils = new SignatureUtils();
			existUser.setLoginPass(utils.encrypt(user.getMobile()));
			existUser.setAvatar(Constants.DEFAULT_AVATAR);
			existUser.setEnabled(true);
			existUser.setRegisterTime(new Date());
			existUser.setLastLoginTime(new Date());
		}
		userService.saveOrUpdate(existUser);
		resp = new RespGson(RespGson.CODE_OK, RespGson.DESC_OK, existUser);
		return new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJson(resp);
	}
}