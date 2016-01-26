package com.jipengblog.appapi.service;

import com.jipengblog.appapi.entity.CustomerAccount;

public interface CustomerService {

	CustomerAccount findAccountByMobile(String mobile);

	void saveOrUpdate(CustomerAccount userAccount);

	void save(CustomerAccount userAccount);

	void update(CustomerAccount userAccount);
}
