package cz.intelis.mobile.dataminerui.exceptions.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

import cz.intelis.mobile.dataminerui.exceptions.ValueRequiredException;
import cz.intelis.mobile.dataminerui.utils.StringUtils;

/**
 * @author Ludek Cermak
 * 
 */
public class ExceptionUtils {

	public static void checkRequiredField(String fieldName, Object fieldValue) throws ValueRequiredException {
		if (fieldValue instanceof String) {
			if (StringUtils.isNullOrEmpty((String) fieldValue))
				throw new ValueRequiredException(fieldName);
		} else if (fieldValue == null) {
			throw new ValueRequiredException(fieldName);
		}
	}

	public static String getStackTrace(final Throwable throwable) {
		final StringWriter sw = new StringWriter();
		final PrintWriter pw = new PrintWriter(sw, true);
		throwable.printStackTrace(pw);
		return sw.getBuffer().toString();
	}

}
