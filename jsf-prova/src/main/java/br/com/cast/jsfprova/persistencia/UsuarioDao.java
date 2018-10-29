package br.com.cast.jsfprova.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.cast.jsfprova.entidade.Usuario;

public class UsuarioDao {
	
	private EntityManager em;
	
	public UsuarioDao() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("puLivro");
		em = emf.createEntityManager();
	}
	
	public Usuario buscarPorId(Integer id) {
		return em.find(Usuario.class, id);
	}

	public Usuario autenticar(String usuario, String senha) {
		String qlString = "from " + Usuario.class.getName() + " u " +
				"where u.usuario = :usuario " + 
				" and u.senha = :senha";
		
		Query query = em.createQuery(qlString)
				.setParameter("usuario", usuario)
				.setParameter("senha", senha);
		
		List<Usuario> resultado = query.getResultList();
		
		return resultado.size() > 0 ? resultado.get(0) : null;
	}

	public void fechar() {
		em.close();
	}
	
}
