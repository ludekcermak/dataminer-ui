package cz.intelis.mobile.dataminerui.service.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import cz.intelis.mobile.dataminerui.exceptions.utils.ExceptionUtils;
import cz.intelis.mobile.dataminerui.model.Device;
import cz.intelis.mobile.dataminerui.service.DeviceService;
import cz.intelis.mobile.dataminerui.service.impl.DeviceServiceImpl;
import cz.intelis.mobile.dataminerui.utils.FormatUtils;

/**
 * @author Ludek Cermak
 * 
 */

@Component
@Path("/devices")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class DeviceApi {

	@GET
	public Response getAll() {
		String json = "";
		DeviceService deviceService = DeviceServiceImpl.getInstance();
		List<Device> devices = deviceService.getAll();
		json = FormatUtils.gson.toJson(devices);
		return Response.status(200).entity(json).build();
	}

	// {"deviceToken": "nejakydlouhyanahodnevybranytokenvygenerovanypanemgooglem", "osType": "TYPE_IOS"}
	// {"deviceToken": "nejakydlouhyanahodnevybranytokenvygenerovanypanemgooglem1", "osType": "TYPE_ANDROID"}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Device device) {
		try {
			String json = "";
			DeviceService deviceService = DeviceServiceImpl.getInstance();
			if (deviceService.findByToken(device.getDeviceToken()) != null)
				return Response.status(500).entity("Device token exists.").build();
			device = deviceService.createDevice(device);
			json = FormatUtils.gson.toJson(device);
			return Response.status(201).entity(json).build();
		} catch (Exception e) {
			return Response.status(500).entity(ExceptionUtils.getStackTrace(e)).build();
		}
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public Response delete(@QueryParam("deviceToken") String deviceToken) {
		try {
			DeviceService deviceService = DeviceServiceImpl.getInstance();
			deviceService.deleteDeviceByToken(deviceToken);
			return Response.status(204).build();
		} catch (Exception e) {
			return Response.status(500).entity(ExceptionUtils.getStackTrace(e)).build();
		}
	}

}
