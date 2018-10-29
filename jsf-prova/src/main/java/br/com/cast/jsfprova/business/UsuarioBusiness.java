package br.com.cast.jsfprova.business;

import br.com.cast.jsfprova.entidade.Usuario;
import br.com.cast.jsfprova.excecao.UsuarioInvalidoException;
import br.com.cast.jsfprova.persistencia.UsuarioDao;

public class UsuarioBusiness {
	
	private UsuarioDao usuarioDAO;

	public UsuarioBusiness() {
		this.usuarioDAO = new UsuarioDao();
	}
	
	public Usuario autenticar(String usuario, String senha) 
			throws UsuarioInvalidoException {
		
		Usuario identidade = usuarioDAO.autenticar(usuario, senha);
		
		if (identidade == null) {
			throw new UsuarioInvalidoException();
		}
		
		return identidade;
	}

}
