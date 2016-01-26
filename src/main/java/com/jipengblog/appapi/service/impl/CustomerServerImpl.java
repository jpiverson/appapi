package com.jipengblog.appapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jipengblog.appapi.entity.CustomerAccount;
import com.jipengblog.appapi.repository.BaseRepository;
import com.jipengblog.appapi.service.CustomerService;

@Service
@Transactional
public class CustomerServerImpl implements CustomerService {

	@Autowired
	private BaseRepository<CustomerAccount, Long> accountRepository;

	@Override
	public CustomerAccount findAccountByMobile(String mobile) {
		return accountRepository.getOneByHQL("from CustomerAccount where mobile = ?0", mobile);
	}

	@Override
	public void saveOrUpdate(CustomerAccount userAccount) {
		accountRepository.saveOrUpdate(userAccount);
	}

	@Override
	public void save(CustomerAccount userAccount) {
		accountRepository.save(userAccount);
	}

	@Override
	public void update(CustomerAccount userAccount) {
		accountRepository.update(userAccount);
	}
}
