package com.jipengblog.appapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jipengblog.appapi.entity.LocationReport;
import com.jipengblog.appapi.repository.BaseRepository;
import com.jipengblog.appapi.service.LocationService;

@Service
@Transactional
public class LocationServiceImpl implements LocationService {

	@Autowired
	private BaseRepository<LocationReport, Long> locationRepository;

	@Override
	public void addLocationReport(LocationReport locationReport) {
		locationRepository.save(locationReport);
	}

}
