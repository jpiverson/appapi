package com.jipengblog.appapi.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jipengblog.appapi.entity.AppVersion;
import com.jipengblog.appapi.repository.BaseRepository;
import com.jipengblog.appapi.repository.PageResults;
import com.jipengblog.appapi.service.AppVersionService;

@Service
@Transactional
public class AppVersionServiceImpl implements AppVersionService {

	@Autowired
	private BaseRepository<AppVersion, Long> baseRepository;

	@Override
	public AppVersion findByVersionId(Long id) {
		return baseRepository.getOneByHQL("from AppVersion where id = ?0", id);
	}
	
	@Override
	public AppVersion findNewestVersion() {
		return baseRepository.getOneByHQL("from AppVersion order by id desc");
	}
	
	@Override
	public void saveOrUpdate(AppVersion appVersion){
		baseRepository.saveOrUpdate(appVersion);
	}

	@Override
	public void save(AppVersion appVersion) {
		baseRepository.save(appVersion);
	}

	@Override
	public void update(AppVersion appVersion) {
		baseRepository.update(appVersion);
	}

	@Override
	public void delete(AppVersion appVersion) {
		baseRepository.delete(appVersion);
	}

	@Override
	public List<AppVersion> findAll() {
		return baseRepository.getListByHQL("from AppVersion order by id desc");
	}

	@Override
	public PageResults<AppVersion> findListByDetachedCriteria(DetachedCriteria dc, int pageNo, int pageSize) {
		return baseRepository.findPageByDetachedCriteria(dc, pageNo, pageSize);
	}

}
