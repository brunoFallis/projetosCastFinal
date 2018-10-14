package br.com.cast.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.cast.entidade.Usuario;

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

	public List<Usuario> buscarTodos() {
		Query query = em.createQuery("from " + Usuario.class.getName());
		return query.getResultList();
	}
	
	public List<Usuario> buscarPorNomes(List<String> nomes) {
		Query query = em.createQuery("from Usuario where nome in (:nomes)");
		query.setParameter("nomes", nomes);
		
		return query.getResultList();
	}

	public void fechar() {
		em.close();
	}
	
}
