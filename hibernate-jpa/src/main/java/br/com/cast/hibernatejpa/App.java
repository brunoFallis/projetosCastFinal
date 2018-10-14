package br.com.cast.hibernatejpa;

import java.util.Arrays;
import java.util.List;

import br.com.cast.hibernatejpa.entidade.Usuario;
import br.com.cast.hibernatejpa.persistencia.UsuarioDao;

public class App {
	
	public static void main(String[] args) {
		
		Usuario usuario = new Usuario();
		usuario.setNome("Eric Gump");
		usuario.setUsuario("eric-vigilante");
		usuario.setSenha("123");
		
		UsuarioDao dao = new UsuarioDao();
		dao.inserir(usuario);
		
		//busca por chave primária
		//java reflections
		Usuario usu = dao.buscarPorId(1);
		
		dao.remover(usu);
		
		System.out.println(usu.getNome());
		
		List<Usuario> usuarios = dao.buscarTodos();
		
		for (Usuario u : usuarios) {
			System.out.println(u.getNome());
		}
		
		usuarios = dao.buscarPorNomes(
				Arrays.asList("Jailson", "Walter White"));
		
		System.out.println("Só os jailsons...");
		for (Usuario u : usuarios) {
			System.out.println(u.getNome());
		}
		
		dao.fechar();

	}
}
