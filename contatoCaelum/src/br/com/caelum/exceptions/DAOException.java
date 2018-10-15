package br.com.caelum.exceptions;

public class DAOException extends RuntimeException{

	public DAOException(Exception e) {
		super(e);
	}
	
}
