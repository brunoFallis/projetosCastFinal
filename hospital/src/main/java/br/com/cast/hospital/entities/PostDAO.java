
package br.com.cast.hospital.entities;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class PostDAO {
	
	private EntityManager em;
	
	public PostDAO() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("puHospital");
		em = emf.createEntityManager();
	}
	
	public List<Post> listPosts(){
		String sql = "from " + Post.class.getName();
		Query query = em.createQuery(sql);
		return query.getResultList();
	}
	
	public void insertPost(Post post) {
		em.getTransaction().begin();
		em.persist(post);
		em.getTransaction().commit();
	}
	
	public Post searchById(Integer id) {
		return em.find(Post.class, id);
	}
	
	public void close() {
		em.close();
	}
	
}
