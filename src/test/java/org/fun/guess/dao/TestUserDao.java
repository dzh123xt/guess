package org.fun.guess.dao;

import org.fun.guess.core.SpringBaseTestCase;
import org.fun.guess.entity.UserEntity;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestUserDao extends SpringBaseTestCase {

	@Autowired
	private UserDao userDao;

	@Test
	public void testGetUser() {
		UserEntity userEntity = userDao.get(1L);
		System.out.println(userEntity.getId());
		System.out.println(userEntity.getUserName());
	}

}
