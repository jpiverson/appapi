package com.jipengblog.appapi.service;

import com.jipengblog.appapi.entity.LocationReport;

public interface LocationService {

	/**
	 * 添加用户设备上报信息
	 * 
	 * @param userDeviceReport
	 */
	void addLocationReport(LocationReport locationReport);

}
