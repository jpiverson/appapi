package com.jipengblog.appapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jipengblog.appapi.entity.Superid;
import com.jipengblog.appapi.entity.User;
import com.jipengblog.appapi.repository.BaseRepository;
import com.jipengblog.appapi.service.UserService;

@Service
@Transactional
public class UserServerImpl implements UserService {

	@Autowired
	private BaseRepository<User, Long> userRepository;

	@Autowired
	private BaseRepository<Superid, Long> superidRepository;

	@Override
	public User findByMobile(String mobile) {
		return userRepository.getOneByHQL("from User where mobile = ?0", mobile);
	}

	@Override
	public void saveOrUpdate(User user) {
		userRepository.saveOrUpdate(user);
	}

	@Override
	public void save(User user) {
		userRepository.save(user);
	}

	@Override
	public void update(User user) {
		userRepository.update(user);
	}

	@Override
	public Superid findByPhone(String phone) {
		return superidRepository.getOneByHQL("from Superid where phone = ?0", phone);
	}

	@Override
	public void saveOrUpdate(Superid superid) {
		superidRepository.saveOrUpdate(superid);
	}

	@Override
	public void save(Superid superid) {
		superidRepository.save(superid);
	}

	@Override
	public void update(Superid superid) {
		superidRepository.update(superid);
	}

}
