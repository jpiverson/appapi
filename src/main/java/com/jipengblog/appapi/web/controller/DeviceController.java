package com.jipengblog.appapi.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jipengblog.appapi.entity.RespGson;
import com.jipengblog.appapi.entity.UserDeviceReport;
import com.jipengblog.appapi.service.UserDeviceService;

@Controller
public class DeviceController extends ParentController {

	private RespGson resp;

	@Autowired
	UserDeviceService userDeviceService;
	
	@RequestMapping(value = "/interfaces/device/report", method = {
			RequestMethod.POST }, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String report(@Validated UserDeviceReport report, BindingResult result) {
		logger.info(report);
		if (result.hasErrors()) {
			resp = new RespGson(RespGson.BAD_REQUEST, result.getAllErrors().get(0).getDefaultMessage(), null);
			return new Gson().toJson(resp);
		}
		userDeviceService.addUserDeviceReport(report);
		resp = new RespGson(RespGson.OK, "操作成功", report);
		return new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJson(resp);
	}
}