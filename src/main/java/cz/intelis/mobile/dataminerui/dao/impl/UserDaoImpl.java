package cz.intelis.mobile.dataminerui.dao.impl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import cz.intelis.mobile.dataminerui.dao.UserDao;
import cz.intelis.mobile.dataminerui.exceptions.IncorrectPasswordOrUnknownUserNameException;
import cz.intelis.mobile.dataminerui.exceptions.ValueRequiredException;
import cz.intelis.mobile.dataminerui.exceptions.utils.ExceptionUtils;
import cz.intelis.mobile.dataminerui.model.User;
import cz.intelis.mobile.dataminerui.model.mapper.UserRowMapper;
import cz.intelis.mobile.dataminerui.utils.PwdUtils;

/**
 * @author Ludek Cermak
 * 
 */
public class UserDaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate dbTemplate;

	public void setDbTemplate(JdbcTemplate dbTemplate) {
		this.dbTemplate = dbTemplate;
	}

	@Override
	public User loginUser(User user) throws ValueRequiredException, IncorrectPasswordOrUnknownUserNameException {
		final String userEmail = user.getUserEmail();
		ExceptionUtils.checkRequiredField("userEmail", userEmail);
		final String userPwd = user.getUserPwd();
		ExceptionUtils.checkRequiredField("userPwd", userPwd);
		user = userExistsByEmail(userEmail);
		if (user == null)
			throw new IncorrectPasswordOrUnknownUserNameException();
		else {
			String hashDb = user.getUserPwd();
			String hashPwd = PwdUtils.generateSaltedHash(userPwd, user.getUserName());
			if (hashDb.equals(hashPwd))
				return user;
			else
				throw new IncorrectPasswordOrUnknownUserNameException();
		}
	}

	private User userExistsByEmail(String userEmail) {
		String sql = "select * from \"T_USER\" where upper(\"USER_EMAIL\") = ?";
		try {
			User user = dbTemplate.queryForObject(sql, new Object[] { userEmail.toUpperCase() }, new UserRowMapper());
			return user;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@PostConstruct
	public void init() {
		System.out.println(getClass().getName() + " bean successfully initialized");
	}

	@PreDestroy
	public void cleanUp() {
		System.out.println(getClass().getName() + " clean up called");
	}

}
