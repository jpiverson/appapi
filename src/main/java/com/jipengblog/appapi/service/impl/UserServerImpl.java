package com.jipengblog.appapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jipengblog.appapi.entity.User;
import com.jipengblog.appapi.repository.BaseRepository;
import com.jipengblog.appapi.service.UserService;

@Service
@Transactional
public class UserServerImpl implements UserService {

	@Autowired
	private BaseRepository<User, Long> baseRepository;

	@Override
	public User findByUserId(Long userId) {
		return baseRepository.getOneByHQL("from User where userId = ?0", userId);
	}

	@Override
	public User findByMobile(String mobile) {
		return baseRepository.getOneByHQL("from User where mobile = ?0", mobile);
	}

	@Override
	public void saveOrUpdate(User user) {
		baseRepository.saveOrUpdate(user);
	}

	@Override
	public void save(User user) {
		baseRepository.save(user);
	}

	@Override
	public void update(User user) {
		baseRepository.update(user);
	}

	@Override
	public void delete(User user) {
		baseRepository.delete(user);
	}

}
