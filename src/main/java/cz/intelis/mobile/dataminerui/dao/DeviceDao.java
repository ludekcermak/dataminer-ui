package cz.intelis.mobile.dataminerui.dao;

import java.util.List;

import cz.intelis.mobile.dataminerui.model.Device;

/**
 * @author Ludek Cermak
 * 
 */
public interface DeviceDao {

	public List<Device> getAll();
	
	public Device findByToken(String deviceToken);
	
	public Device createDevice(final Device device);

	public Integer deleteDeviceByToken(String deviceToken);

}
