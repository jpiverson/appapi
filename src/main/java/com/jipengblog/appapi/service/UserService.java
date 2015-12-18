package com.jipengblog.appapi.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.jipengblog.appapi.entity.User;
import com.jipengblog.appapi.repository.PageResults;


public interface UserService {

	User findByUserId(Long userId);
	
	User findByMobile(String mobile);

	void saveOrUpdate(User user);

	void save(User user);

	void update(User user);

	void delete(User user);

	List<User> findAll();

	PageResults<User> findListByDetachedCriteria(DetachedCriteria dc, int pageNo, int pageSize);

}
