package br.com.cast.jsfintro.business;

import br.com.cast.jsfintro.entidade.Usuario;
import br.com.cast.jsfintro.excecao.UsuarioInvalidoException;
import br.com.cast.jsfintro.persistencia.UsuarioDao;

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
