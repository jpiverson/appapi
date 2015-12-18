package com.jipengblog.appapi.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.jipengblog.appapi.entity.AppVersion;
import com.jipengblog.appapi.repository.PageResults;


public interface AppVersionService {

	AppVersion findByVersionId(Long id);
	
	AppVersion findNewestVersion();
	
	void saveOrUpdate(AppVersion appVersion);

	void save(AppVersion appVersion);

	void update(AppVersion appVersion);

	void delete(AppVersion appVersion);

	List<AppVersion> findAll();

	PageResults<AppVersion> findListByDetachedCriteria(DetachedCriteria dc, int pageNo, int pageSize);

}
