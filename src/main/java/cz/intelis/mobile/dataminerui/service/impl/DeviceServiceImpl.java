package cz.intelis.mobile.dataminerui.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;

import cz.intelis.mobile.dataminerui.dao.DeviceDao;
import cz.intelis.mobile.dataminerui.model.Device;
import cz.intelis.mobile.dataminerui.service.DeviceService;

/**
 * @author Ludek Cermak
 * 
 */
public class DeviceServiceImpl implements DeviceService {

	private static DeviceServiceImpl instance;

	@Autowired
	private DeviceDao deviceDao;

	public static DeviceServiceImpl getInstance() {
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
	public List<Device> getAll() {
		return deviceDao.getAll();
	}
	
	@Override
	public Device findByToken(String deviceToken) {
		return deviceDao.findByToken(deviceToken);
	}

	@Override
	public Device createDevice(Device device) {
		return deviceDao.createDevice(device);
	}

	@Override
	public Integer deleteDeviceByToken(String deviceToken) {
		return deviceDao.deleteDeviceByToken(deviceToken);
	}

}
