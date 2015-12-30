package com.jipengblog.appapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jipengblog.appapi.entity.UserInfo;
import com.jipengblog.appapi.entity.UserAccount;
import com.jipengblog.appapi.repository.BaseRepository;
import com.jipengblog.appapi.service.UserService;

@Service
@Transactional
public class UserServerImpl implements UserService {

	@Autowired
	private BaseRepository<UserAccount, Long> accountRepository;

	@Autowired
	private BaseRepository<UserInfo, Long> infoRepository;

	@Override
	public UserAccount findAccountByMobile(String mobile) {
		return accountRepository.getOneByHQL("from UserAccount where mobile = ?0", mobile);
	}

	@Override
	public void saveOrUpdate(UserAccount userAccount) {
		accountRepository.saveOrUpdate(userAccount);
	}

	@Override
	public void save(UserAccount userAccount) {
		accountRepository.save(userAccount);
	}

	@Override
	public void update(UserAccount userAccount) {
		accountRepository.update(userAccount);
	}

	@Override
	public UserInfo findInfoByMobile(String mobile) {
		return infoRepository.getOneByHQL("from UserInfo where mobile = ?0", mobile);
	}

	@Override
	public void saveOrUpdate(UserInfo userInfo) {
		infoRepository.saveOrUpdate(userInfo);
	}

	@Override
	public void save(UserInfo userInfo) {
		infoRepository.save(userInfo);
	}

	@Override
	public void update(UserInfo userInfo) {
		infoRepository.update(userInfo);
	}

}
