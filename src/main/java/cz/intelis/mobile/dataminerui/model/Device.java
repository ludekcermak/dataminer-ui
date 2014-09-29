package cz.intelis.mobile.dataminerui.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Ludek Cermak
 * 
 */
@XmlRootElement(name = "device")
public class Device {

	private Integer deviceId;
	private String deviceToken;
	private String osType;
	
	public String getOsType() {
		return osType;
	}

	public void setOsType(String osType) {
		this.osType = osType;
	}

	private Date createTime;

	public Device() {
		super();
	}

	public Integer getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId;
	}

	public String getDeviceToken() {
		return deviceToken;
	}

	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "Device [deviceId=" + deviceId + ", deviceToken=" + deviceToken
				+ ", osType=" + osType + ", createTime=" + createTime + "]";
	}

	

}
