package cz.intelis.mobile.dataminerui.ui;

import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

import javax.net.ssl.SSLSocket;

public class ApnsConnector {

	public boolean sendMessage(String message, String messageType, String deviceTokenStr) throws IOException {
		byte[] deviceToken = unhex(deviceTokenStr);
		byte[] payload = createPayload(message, messageType);

		SSLSocket sslSocket = ApnsSender.getInstance().createSocket();
		DataOutputStream output = new DataOutputStream(sslSocket.getOutputStream());

		output.writeByte(0);
		output.writeShort(deviceToken.length);
		output.write(deviceToken);
		output.writeShort(payload.length);
		output.write(payload);
		output.flush();

		output.close();
		sslSocket.close();

		return true;
	}

	private static byte[] createPayload(String message, String messageType) {
		StringBuilder payload = new StringBuilder();
		payload.append("{\"aps\":{\"alert\":\"");
		payload.append(message);
		payload.append("\"},\"type\":\"");
		payload.append(messageType);
		payload.append("\"}");
		return payload.toString().getBytes(Charset.forName("UTF-8"));
	}

	private static byte[] unhex(String data) {
		int len = data.length();
		byte[] output = new byte[len / 2];
		for (int i = 0; i < len; i += 2) {
			output[i / 2] = (byte) ((Character.digit(data.charAt(i), 16) << 4) + Character.digit(data.charAt(i + 1), 16));
		}
		return output;
	}

}
