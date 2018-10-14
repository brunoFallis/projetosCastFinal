package br.com.cast.exceptions;

public class InvalidUserException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidUserException() {
		super("Username or password invalid");
	}
	
}
