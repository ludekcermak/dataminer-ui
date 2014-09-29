package cz.intelis.mobile.dataminerui.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import cz.intelis.mobile.dataminerui.model.Device;

public class DeviceRowMapper implements ParameterizedRowMapper<Device> {

	@Override
	public Device mapRow(ResultSet rs, int rowNum) throws SQLException {
		Device device = new Device();
		device.setDeviceId(rs.getInt("DEVICE_ID"));
		device.setCreateTime(rs.getTimestamp("CREATE_TIME") != null ? new Date(rs.getTimestamp("CREATE_TIME").getTime()) : null);
		device.setOsType(rs.getString("OS_TYPE"));
		device.setDeviceToken(rs.getString("DEVICE_TOKEN"));
		return device;
	}

}