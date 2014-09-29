package cz.intelis.mobile.dataminerui.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;

import cz.intelis.mobile.dataminerui.dao.ImportDao;
import cz.intelis.mobile.dataminerui.model.Import;
import cz.intelis.mobile.dataminerui.service.ImportService;

/**
 * @author Ludek Cermak
 * 
 */
public class ImportServiceImpl implements ImportService {

	private static ImportServiceImpl instance;

	@Autowired
	private ImportDao deviceDao;

	public static ImportServiceImpl getInstance() {
		return instance;
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

	@Override
	public List<Import> getAll() {
		return deviceDao.getAll();
	}
	
}
