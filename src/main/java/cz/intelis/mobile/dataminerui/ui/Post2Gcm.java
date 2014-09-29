package cz.intelis.mobile.dataminerui.ui;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;

import cz.intelis.mobile.dataminerui.model.Device;
import cz.intelis.mobile.dataminerui.service.impl.DeviceServiceImpl;
import cz.intelis.mobile.dataminerui.utils.Consts;

public class Post2Gcm {

	public static final Logger logger = LoggerFactory.getLogger(Post2Gcm.class);
	
	private static final String GOOGLE_SERVER_KEY = "AIzaSyAKogRnkQhJLupkW9YGSL7KyoPIiiXa63g";
	private static final String MESSAGE_KEY = "msg";
	private static final String MESSAGE_TYPE = "type";
	
	public static void post(String userMessage, String messageTypeValue) {
		String regId = "";
		Sender sender = null;
		Message message = null;
		List<Device> listOfDevices = DeviceServiceImpl.getInstance().getAll();
		for (Device device : listOfDevices) {
			if (Consts.OS_TYPE_ANDROID.equals(device.getOsType())) {
				regId = device.getDeviceToken();
				sender = new Sender(GOOGLE_SERVER_KEY);
				message = new Message.Builder().timeToLive(60).delayWhileIdle(true).addData(MESSAGE_KEY, userMessage).addData(MESSAGE_TYPE, messageTypeValue).build();
				try {
					Result mcr = sender.send(message, regId, 1);
					logger.error("Successfully sending message + " + userMessage + ", regId " + regId + ". ", mcr.getErrorCodeName());
				} catch (IOException e) {
					logger.error("Error sending message + " + userMessage + ", regId " + regId + ". ", e);
				}
			}
		}
	}
}
