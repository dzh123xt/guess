package org.fun.guess.controller;

import org.fun.guess.entity.UserEntity;
import org.fun.guess.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserServiceImpl userService;

	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	public UserEntity getUser() {
		logger.debug("Enter UserController");
		return userService.getUser(1L);
	}

}
