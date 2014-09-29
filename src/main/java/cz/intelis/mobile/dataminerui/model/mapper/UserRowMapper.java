package cz.intelis.mobile.dataminerui.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import cz.intelis.mobile.dataminerui.model.User;

/**
 * @author Ludek Cermak
 * 
 */
public class UserRowMapper implements ParameterizedRowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setUserId(rs.getInt("USER_ID"));
		user.setUserName(rs.getString("USER_NAME"));
		user.setUserEmail(rs.getString("USER_EMAIL"));
		user.setUserPwd(rs.getString("USER_PWD"));
		user.setCatNum06(rs.getInt("CAT_NUM_06"));
		user.setCatNum0710(rs.getInt("CAT_NUM_07_10"));
		user.setCatNum1116(rs.getInt("CAT_NUM_11_16"));
		user.setCatNum16(rs.getInt("CAT_NUM_16"));
		user.setCreateTime(rs.getTimestamp("CREATE_TIME") != null ? new Date(rs.getTimestamp("CREATE_TIME").getTime()) : null);
		return user;
	}

}
