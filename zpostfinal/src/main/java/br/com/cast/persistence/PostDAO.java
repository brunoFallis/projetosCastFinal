package br.com.cast.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.cast.entities.Post;

public class PostDAO {

	EntityManagerFactory emf;
	EntityManager em;

	public PostDAO() {
		this.emf = Persistence.createEntityManagerFactory("puPostFinal");
		this.em = emf.createEntityManager();
	}

	public List<Post> postsByUser(Integer id) {

		Query query = em.createQuery("from Post where id_user = :id");
		query.setParameter("id", id);
		return (List<Post>) query.getResultList();

	}
	
	public boolean insertPost(Post post) {
		try {
			this.em.getTransaction().begin();
			this.em.persist(post);
			this.em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			this.em.getTransaction().rollback();
			return false;
		}
	}

	public boolean deletePostById(Integer id) {
		try {
			this.em.getTransaction().begin();
			this.em.remove(em.find(Post.class, id));
			this.em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			this.em.getTransaction().rollback();
			return false;
		}
	}

}
