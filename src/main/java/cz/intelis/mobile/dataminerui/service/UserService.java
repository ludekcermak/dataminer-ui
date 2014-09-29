package cz.intelis.mobile.dataminerui.service;

import cz.intelis.mobile.dataminerui.exceptions.IncorrectPasswordOrUnknownUserNameException;
import cz.intelis.mobile.dataminerui.exceptions.ValueRequiredException;
import cz.intelis.mobile.dataminerui.model.User;

/**
 * @author Ludek Cermak
 * 
 */
public interface UserService {

	public User loginUser(User user) throws ValueRequiredException, IncorrectPasswordOrUnknownUserNameException;

}
