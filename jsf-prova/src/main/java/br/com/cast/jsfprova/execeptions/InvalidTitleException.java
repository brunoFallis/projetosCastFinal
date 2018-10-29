package br.com.cast.jsfprova.execeptions;

public class InvalidTitleException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidTitleException() {
		super("Titulo ja existente no sistema");
	}
	
}
