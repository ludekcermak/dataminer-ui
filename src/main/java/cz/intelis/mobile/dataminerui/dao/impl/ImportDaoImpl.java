package cz.intelis.mobile.dataminerui.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import cz.intelis.mobile.dataminerui.dao.ImportDao;
import cz.intelis.mobile.dataminerui.model.Import;
import cz.intelis.mobile.dataminerui.model.mapper.ImportRowMapper;

/**
 * @author Ludek Cermak
 * 
 */

public class ImportDaoImpl implements ImportDao {

	@Autowired
	private JdbcTemplate dbTemplate;

	public List<Import> getAll() {
		List<Import> retval = new ArrayList<Import>();
		String sql = "select t.* from timer t order by t.city, t.module";
		retval = dbTemplate.query(sql, new ImportRowMapper());
		return retval;
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
