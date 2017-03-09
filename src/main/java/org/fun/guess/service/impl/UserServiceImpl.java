package org.fun.guess.service.impl;

import org.fun.guess.dao.UserDao;
import org.fun.guess.entity.UserEntity;
import org.fun.guess.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDao userDao;

	@Override
	// @Transactional(rollbackFor = Exception.class)
	public UserEntity getUser(Long id) {
		return userDao.get(id);
	}

}
