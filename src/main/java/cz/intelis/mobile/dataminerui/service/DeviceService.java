package cz.intelis.mobile.dataminerui.service;

import java.util.List;

import cz.intelis.mobile.dataminerui.model.Device;

/**
 * @author Ludek Cermak
 * 
 */
public interface DeviceService {

	public List<Device> getAll();

	public Device findByToken(String deviceToken);
	
	public Device createDevice(Device device);
	
	public Integer deleteDeviceByToken(String deviceToken);

}
