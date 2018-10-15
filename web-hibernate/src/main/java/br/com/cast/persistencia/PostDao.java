package br.com.cast.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.cast.entidade.Post;

public class PostDao {
	
	private EntityManager em;
	
	public PostDao() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("puBancoDeDinheiro");
		em = emf.createEntityManager();
	}
	
	public void inserir(Post post) {
		try {
			em.getTransaction().begin();
			em.persist(post);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}
	
	public Post buscarPorId(Integer id) {
		return em.find(Post.class, id);
	}

	public void fechar() {
		em.close();
	}
	
}
