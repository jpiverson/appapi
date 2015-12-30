package com.jipengblog.appapi.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.GsonBuilder;
import com.jipengblog.appapi.entity.AppVersion;
import com.jipengblog.appapi.service.AppVersionService;
import com.jipengblog.appapi.web.utils.RespGson;

/**
 * 关于我们
 * 
 * 版本检查
 * 
 * @author penn
 *
 */
@Controller
public class AboutController extends ParentController {

	@Autowired
	AppVersionService appVersionService;

	@RequestMapping(value = "/about/checkVersion", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String checkVersion() {
		AppVersion appVersion = appVersionService.findNewestVersion();
		resp = new RespGson(RespGson.CODE_OK, RespGson.DESC_OK, appVersion);
		return new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJson(resp);
	}
}