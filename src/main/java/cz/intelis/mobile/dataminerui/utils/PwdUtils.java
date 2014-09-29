package cz.intelis.mobile.dataminerui.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

import org.apache.commons.lang.RandomStringUtils;

/**
 * @author Ludek Cermak
 * 
 */
public class PwdUtils {

	public static final int PWD_GEN_LENGTH = 10;
	public static final String TOKEN_FIELD_SEPARATOR = "#";
	public static final int MAX_TIME_DELTA_IN_MILLIS = 2 * 60 * 60 * 1000; // dve hodiny

	public static String generateSaltedHash(String password, String salt) {
		String generatedPassword = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(salt.getBytes());
			byte[] bytes = md.digest(password.getBytes());
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			generatedPassword = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		return generatedPassword;
	}

	public static String generateRandomPassword(int length) {
		return RandomStringUtils.randomAlphanumeric(length);
	}

	public static String[] decode(String auth) {
		//Replacing "Basic THE_BASE_64" to "THE_BASE_64" directly
		auth = auth.replaceFirst("[B|b]asic ", "");
		//Decode the Base64 into byte[]
		byte[] decodedBytes = DatatypeConverter.parseBase64Binary(auth);
		//If the decode fails in any case
		if (decodedBytes == null || decodedBytes.length == 0) {
			return null;
		}
		//Now we can convert the byte[] into a splitted array :
		//  - the first one is login,
		//  - the second one password
		return new String(decodedBytes).split(":", 2);
	}

	//-----------------------------------------------------

	public static void main(String[] args) {
		//System.out.println(generateSaltedHash("veverka98", "Šílená Veverka"));
		//System.out.println(Base64.encodeBase64String("ludek.cermak@intelis.cz:heslo".getBytes()));
	}

}
