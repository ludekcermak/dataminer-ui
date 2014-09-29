package cz.intelis.mobile.dataminerui.utils;

/**
 * @author Ludek Cermak
 * 
 */
public class StringUtils {

	public static boolean isNullOrEmpty(String s) {
		if ((s == null) || (s.trim().isEmpty())) {
			return true;
		}
		return false;
	}

}
