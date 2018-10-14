package br.com.cast.jsfintro.excecao;

public class UsuarioInvalidoException extends Exception {
	
	public UsuarioInvalidoException() {
		super("Usuário inválido!");
	}

}
