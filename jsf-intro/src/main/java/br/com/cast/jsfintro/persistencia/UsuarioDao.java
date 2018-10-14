package br.com.cast.jsfintro.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.cast.jsfintro.entidade.Usuario;

public class UsuarioDao {
	
	private EntityManager em;
	
	public UsuarioDao() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("puBancoDeDinheiro");
		em = emf.createEntityManager();
	}
	
	public void inserir(Usuario usuario) {
		try {
			em.getTransaction().begin();
			em.persist(usuario);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}
	
	public Usuario buscarPorId(Integer id) {
		return em.find(Usuario.class, id);
	}

	public void remover(Usuario usuario) {
		try {
			em.getTransaction().begin();
			em.remove(usuario);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
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
