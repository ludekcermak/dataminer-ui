package cz.intelis.mobile.dataminerui.exceptions;

/**
 * @author Ludek Cermak
 * 
 */
public class ValueRequiredException extends Exception {

	private static final long serialVersionUID = 7703728837244453610L;

	public ValueRequiredException(String fieldName) {
		super("Required field " + fieldName + " is null or empty!");
	}

}
