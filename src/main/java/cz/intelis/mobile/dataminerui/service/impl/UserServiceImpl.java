package cz.intelis.mobile.dataminerui.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;

import cz.intelis.mobile.dataminerui.dao.UserDao;
import cz.intelis.mobile.dataminerui.exceptions.IncorrectPasswordOrUnknownUserNameException;
import cz.intelis.mobile.dataminerui.exceptions.ValueRequiredException;
import cz.intelis.mobile.dataminerui.model.User;
import cz.intelis.mobile.dataminerui.service.UserService;

/**
 * @author Ludek Cermak
 * 
 */
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	private static UserServiceImpl instance;

	public static UserServiceImpl getInstance() {
		return instance;
	}

	@Override
	public User loginUser(User user) throws ValueRequiredException, IncorrectPasswordOrUnknownUserNameException {
		return userDao.loginUser(user);
	}

	@PostConstruct
	public void init() {
		System.out.println(getClass().getName() + " bean successfully initialized");
		instance = this;
	}

	@PreDestroy
	public void cleanUp() {
		System.out.println(getClass().getName() + " clean up called");
	}

}
