package cz.intelis.mobile.dataminerui.utils;

import java.text.SimpleDateFormat;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author Ludek Cermak
 * 
 */
public class FormatUtils {

	public static final String GLOBAL_DATE_PATTERN = "dd.MM.yyyy HH:mm";
	public static final SimpleDateFormat GLOBAL_SDF = new SimpleDateFormat(GLOBAL_DATE_PATTERN);
	public static final Gson gson = new GsonBuilder().setDateFormat(FormatUtils.GLOBAL_DATE_PATTERN).create();

}
