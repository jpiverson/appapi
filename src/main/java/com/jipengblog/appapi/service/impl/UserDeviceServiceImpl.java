package com.jipengblog.appapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jipengblog.appapi.entity.UserDevice;
import com.jipengblog.appapi.entity.UserDeviceReport;
import com.jipengblog.appapi.repository.BaseRepository;
import com.jipengblog.appapi.service.UserDeviceService;

@Service
@Transactional
public class UserDeviceServiceImpl implements UserDeviceService {

	@Autowired
	private BaseRepository<UserDevice, Long> userDeviceRepository;

	@Autowired
	private BaseRepository<UserDeviceReport, Long> userDeviceReportRepository;


	@Override
	public void addUserDevice(UserDevice userDevice) {
		userDeviceRepository.save(userDevice);
	}

	@Override
	public void addUserDeviceReport(UserDeviceReport userDeviceReport) {
		userDeviceReportRepository.save(userDeviceReport);
	}

}
