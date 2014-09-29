package cz.intelis.mobile.dataminerui.exceptions;

/**
 * @author Ludek Cermak
 * 
 */
public class IncorrectPasswordOrUnknownUserNameException extends Exception {

	private static final long serialVersionUID = 4316901470549422820L;

	public IncorrectPasswordOrUnknownUserNameException() {
		super("Incorrect password or unknown userName.");
	}

}
