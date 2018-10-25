package br.com.cast.imdbApi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.cast.imdbApi.entidade.Comment;
import br.com.cast.imdbApi.entidade.User;

@Repository
public class RepositoryComment {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Comment comment) {
		this.em.persist(comment);
	}

	public User searchUser(Integer id) {
		Query query = this.em.createQuery("from User where id = :id");
		query.setParameter("id", id);
		User user = (User)query.getSingleResult();
		return user;
	}

	@SuppressWarnings("unchecked")
	public List<Comment> returnComments(String id) {
		Query query = this.em.createQuery("select c "
										+ "from Comment c "
										+ "join fetch c.user "
										+ "where id_movie = :id");
		query.setParameter("id", id);
		return query.getResultList();
	}

}
