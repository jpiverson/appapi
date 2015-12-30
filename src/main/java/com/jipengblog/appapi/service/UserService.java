package com.jipengblog.appapi.service;

import com.jipengblog.appapi.entity.Superid;
import com.jipengblog.appapi.entity.User;

public interface UserService {

	User findByMobile(String mobile);

	void saveOrUpdate(User user);

	void save(User user);

	void update(User user);

	// Superid 一登登陆信息
	
	Superid findByPhone(String phone);

	void saveOrUpdate(Superid superid);

	void save(Superid superid);

	void update(Superid superid);
}
