package cz.intelis.mobile.dataminerui.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import cz.intelis.mobile.dataminerui.dao.DeviceDao;
import cz.intelis.mobile.dataminerui.model.Device;
import cz.intelis.mobile.dataminerui.model.mapper.DeviceRowMapper;

/**
 * @author Ludek Cermak
 * 
 */

public class DeviceDaoImpl implements DeviceDao {

	@Autowired
	private JdbcTemplate dbTemplate;

	public List<Device> getAll() {
		List<Device> retval = new ArrayList<Device>();
		String sql = "select d.* from \"T_DEVICE\" d order by d.\"CREATE_TIME\" desc";
		retval = dbTemplate.query(sql, new DeviceRowMapper());
		return retval;
	}
	
	@Override
	public Device findByToken(String deviceToken) {
		final String sql = "select * from \"T_DEVICE\" where \"DEVICE_TOKEN\" = ?";
		List<Device> list = dbTemplate.query(sql, new Object[] {deviceToken}, new DeviceRowMapper());
		if ((list == null) || list.isEmpty())
			return null;
		return list.get(0);
	}
	
	@Override
	public Device createDevice(final Device device) {
		final String sql = "insert into \"T_DEVICE\" (\"DEVICE_TOKEN\", \"OS_TYPE\", \"CREATE_TIME\") values (?, ?, ?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		device.setCreateTime(new Date());
		dbTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql, new String[] { "DEVICE_ID" });
				ps.setString(1, device.getDeviceToken());
				ps.setString(2, device.getOsType());
				ps.setTimestamp(3, new Timestamp(device.getCreateTime().getTime()));
				return ps;
			}
		}, keyHolder);
		Integer newId = keyHolder.getKey().intValue();
		device.setDeviceId(newId);
		return device;
	}

	@Override
	public Integer deleteDeviceByToken(String deviceToken) {
		final String sql = "delete from \"T_DEVICE\" where \"DEVICE_TOKEN\" = ?";
		int rowsAffected = dbTemplate.update(sql, deviceToken);
		return new Integer(rowsAffected);
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
