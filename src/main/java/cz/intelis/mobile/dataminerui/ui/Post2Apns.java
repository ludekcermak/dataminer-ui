package cz.intelis.mobile.dataminerui.ui;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cz.intelis.mobile.dataminerui.model.Device;
import cz.intelis.mobile.dataminerui.service.impl.DeviceServiceImpl;
import cz.intelis.mobile.dataminerui.utils.Consts;

public class Post2Apns {

	public static final Logger logger = LoggerFactory.getLogger(Post2Apns.class);
	
	public static void post(String userMessage, String messageTypeValue) {
		String regId = "";
		List<Device> listOfDevices = DeviceServiceImpl.getInstance().getAll();
		for (Device device : listOfDevices) {
			if (Consts.OS_TYPE_IOS.equals(device.getOsType())) {
				regId = device.getDeviceToken();
				try {
					new ApnsConnector().sendMessage(userMessage, messageTypeValue, regId);
					logger.error("Successfully sending message + " + userMessage + ", regId " + regId + ". ");
				} catch (IOException e) {
					logger.error("Error sending message + " + userMessage + ", regId " + regId + ". ", e);
				}
			}
		}
	}
}
