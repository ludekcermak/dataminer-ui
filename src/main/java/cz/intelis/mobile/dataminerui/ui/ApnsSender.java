package cz.intelis.mobile.dataminerui.ui;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class ApnsSender {

	private static final String KEYSTORE_NAME = "apns_kodsalomon_prod.p12";

	private static final char[] KEYSTORE_PASSWORD = "5a6rhio2".toCharArray();

	private static final int PORT = 2195;

	private static final int SO_TIMEOUT = 5 * 1000; // 5 seconds
	
	private static final long sslSocketMaxAge = 1*60*1000;

	private String hostName = "gateway.push.apple.com"; //gateway.sandbox.push.apple.com

	private SSLSocketFactory sslSocketFactory;
	
	private SSLSocket sslSocket;
	private long sslSocketTime;
	
	private static ApnsSender instance;

	public ApnsSender() throws GeneralSecurityException, IOException {
		KeyStore keyStore = KeyStore.getInstance("PKCS12");
		keyStore.load(ApnsSender.class.getResourceAsStream("/" + KEYSTORE_NAME), KEYSTORE_PASSWORD);

		KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
		keyManagerFactory.init(keyStore, KEYSTORE_PASSWORD);

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keyManagerFactory.getKeyManagers(), null, null);

        sslSocketFactory = sslContext.getSocketFactory();
	}

	public SSLSocket createSocket() throws IOException {
		if(sslSocket == null || (System.nanoTime() > (sslSocketMaxAge + sslSocketTime))) {
			sslSocketTime = System.nanoTime();
			sslSocket = (SSLSocket) sslSocketFactory.createSocket(hostName, PORT);
			sslSocket.setSoTimeout(SO_TIMEOUT);
			sslSocket.startHandshake();
		}
		
		return sslSocket;
	}
	
	public static ApnsSender getInstance() {
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
	
}
