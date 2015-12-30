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
import com.jipengblog.appapi.entity.LocationReport;
import com.jipengblog.appapi.service.LocationService;
import com.jipengblog.appapi.service.UserService;
import com.jipengblog.appapi.web.utils.RespGson;

@Controller
public class LocationController extends ParentController {

	@Autowired
	LocationService locationService;

	@Autowired
	UserService userService;

	@RequestMapping(value = "/location/report", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String report(@ModelAttribute("params") String params) {
		LocationReport report = new Gson().fromJson(params, LocationReport.class);
		report.setReportTime(new Date());
		logger.info(report.toString());
		locationService.addLocationReport(report);
		resp = new RespGson(RespGson.CODE_OK, RespGson.DESC_OK, report);
		return new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJson(resp);
	}
}