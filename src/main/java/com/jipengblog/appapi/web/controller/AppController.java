package com.jipengblog.appapi.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.GsonBuilder;
import com.jipengblog.appapi.entity.AppVersion;
import com.jipengblog.appapi.entity.RespGson;
import com.jipengblog.appapi.entity.User;
import com.jipengblog.appapi.service.AppVersionService;
import com.jipengblog.appapi.service.UserService;
import com.jipengblog.appapi.web.utils.security.SignatureUtils;

@Controller
public class AppController extends ParentController {

	private RespGson resp;

	@Autowired
	AppVersionService appVersionService;
	UserService userService;

	@RequestMapping(value = "/interfaces/app/checkVersion", method = {
			RequestMethod.POST }, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String checkVersion() {
		AppVersion appVersion = appVersionService.findNewestVersion();
		resp = new RespGson(RespGson.OK, "", appVersion);
		return new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJson(resp);
	}

	@RequestMapping(value = "/interfaces/app/mobsmslogin", method = {
			RequestMethod.POST }, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String login(
			@RequestParam(value = "mobile", required = true) String mobile,
			@RequestParam(value = "nickName", required = true) String nickName,
			@RequestParam(value = "uid", required = false) String uid) {
		User user = new User();
		user.setMobile(mobile);
		SignatureUtils utils = new SignatureUtils();
		user.setLoginPass(utils.encrypt(mobile, null));
		user.setNickName(nickName);
		user.setDescription(uid);
		
		userService.saveOrUpdate(user);
		resp = new RespGson(RespGson.OK, "", user);
		return new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJson(resp);
	}

}