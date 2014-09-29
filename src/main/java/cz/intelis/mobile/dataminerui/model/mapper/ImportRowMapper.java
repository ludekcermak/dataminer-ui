package cz.intelis.mobile.dataminerui.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import cz.intelis.mobile.dataminerui.model.Import;

public class ImportRowMapper implements ParameterizedRowMapper<Import> {

	@Override
	public Import mapRow(ResultSet rs, int rowNum) throws SQLException {
		Import i = new Import();
		i.setImportId(rs.getInt("timer_id"));
		i.setLastRun(rs.getTimestamp("last_run") != null ? new Date(rs.getTimestamp("tast_run").getTime()) : null);
		i.setActive(rs.getBoolean("active"));
		i.setCity(rs.getString("city"));
		i.setCityName(rs.getString("city_name"));
		i.setCronExpression(rs.getString("cron_expression"));
		i.setLang(rs.getString("lang"));
		i.setLastDuration(rs.getInt("last_duration"));
		i.setModule(rs.getString("module"));
		i.setUrl(rs.getString("url"));
		return i;
	}

}