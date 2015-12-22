package com.jipengblog.appapi.service;

import com.jipengblog.appapi.entity.User;

public interface UserService {

	User findByUserId(Long userId);

	User findByMobile(String mobile);

	void saveOrUpdate(User user);

	void save(User user);

	void update(User user);

	void delete(User user);

}
