package com.jipengblog.appapi.service;

import com.jipengblog.appapi.entity.UserDevice;
import com.jipengblog.appapi.entity.UserDeviceReport;

public interface UserDeviceService {

	/**
	 * 添加用户设备
	 * 
	 * @param userDevice
	 */
	void addUserDevice(UserDevice userDevice);

	/**
	 * 添加用户设备上报信息
	 * 
	 * @param userDeviceReport
	 */
	void addUserDeviceReport(UserDeviceReport userDeviceReport);

}
