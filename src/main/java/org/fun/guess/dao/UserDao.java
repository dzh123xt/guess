package org.fun.guess.dao;

import org.fun.guess.entity.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

	// @Autowired
	// private SqlSession sqlSession;

	public UserEntity get(Long id) {
		UserEntity user = new UserEntity();
		user.setId(1L);
		user.setUserName("dzh");
		// UserEntity user = sqlSession.selectOne(UserEntity.class.getName() +
		// ".getUser", id);
		return user;
	}

}
