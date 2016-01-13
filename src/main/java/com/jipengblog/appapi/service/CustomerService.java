package com.jipengblog.appapi.service;

import com.jipengblog.appapi.entity.CustomerInfo;
import com.jipengblog.appapi.entity.CustomerAccount;

public interface CustomerService {

	// 账号信息

	CustomerAccount findAccountByMobile(String mobile);

	void saveOrUpdate(CustomerAccount userAccount);

	void save(CustomerAccount userAccount);

	void update(CustomerAccount userAccount);

	// 用户信息

	CustomerInfo findInfoByMobile(String mobile);

	void saveOrUpdate(CustomerInfo userInfo);

	void save(CustomerInfo userInfo);

	void update(CustomerInfo userInfo);
}
