package com.jipengblog.appapi.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jipengblog.appapi.entity.UserDeviceReport;
import com.jipengblog.appapi.entity.bo.RespGson;
import com.jipengblog.appapi.service.UserDeviceService;
import com.jipengblog.appapi.service.UserService;

@Controller
public class DeviceController extends ParentController {

	@Autowired
	UserDeviceService userDeviceService;

	@Autowired
	UserService userService;

	@RequestMapping(value = "/device/report", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String report(@ModelAttribute("params") String params) {
		UserDeviceReport report = new Gson().fromJson(params, UserDeviceReport.class);
		userDeviceService.addUserDeviceReport(report);
		resp = new RespGson(RespGson.CODE_OK, RespGson.DESC_OK, report);
		return new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJson(resp);
	}
}