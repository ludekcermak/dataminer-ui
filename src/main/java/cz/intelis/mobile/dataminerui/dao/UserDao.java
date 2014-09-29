package cz.intelis.mobile.dataminerui.dao;

import cz.intelis.mobile.dataminerui.exceptions.IncorrectPasswordOrUnknownUserNameException;
import cz.intelis.mobile.dataminerui.exceptions.ValueRequiredException;
import cz.intelis.mobile.dataminerui.model.User;

/**
 * @author Ludek Cermak
 * 
 */
public interface UserDao {

	public User loginUser(User user) throws ValueRequiredException, IncorrectPasswordOrUnknownUserNameException;

}
