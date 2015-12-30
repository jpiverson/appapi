package com.jipengblog.appapi.service;

import com.jipengblog.appapi.entity.UserInfo;
import com.jipengblog.appapi.entity.UserAccount;

public interface UserService {

	UserAccount findAccountByMobile(String mobile);
	
	void saveOrUpdate(UserAccount userAccount);

	void save(UserAccount userAccount);

	void update(UserAccount userAccount);

	
	UserInfo findInfoByMobile(String mobile);

	void saveOrUpdate(UserInfo userInfo);

	void save(UserInfo userInfo);

	void update(UserInfo userInfo);
}
