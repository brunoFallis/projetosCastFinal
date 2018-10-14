package br.com.cast.postSystem.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.cast.postSystem.entities.Comment;

public class CommentDAO {
	
	private EntityManager em;
	
	public CommentDAO() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("puPostSystem");
		em = emf.createEntityManager();
	}
	
	public void insertComment(Comment comment) {
		em.getTransaction().begin();
		em.persist(comment);
		em.getTransaction().commit();
	}
	
	public List<Comment> commentsById(Integer id){
		Query query = em.createQuery("from Comment where id_user = (:id)");
		query.setParameter("id", id);
		return query.getResultList();
	}
	
	public void updateComment(Comment comment) {
		em.getTransaction().begin();
		em.merge(comment);
		em.getTransaction().commit();
	}
	
	public void removeComment(Integer id) {
		em.getTransaction().begin();
		em.remove(em.find(Comment.class, id));
		em.getTransaction().commit();
	}
	
	public Comment searchById(Integer id) {
		return em.find(Comment.class, id);
	}
	
	public void close() {
		em.close();
	}
	
}
