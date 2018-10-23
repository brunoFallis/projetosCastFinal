package br.com.cast.imdbApi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.cast.imdbApi.entidade.Movie;

@Repository
public class MovieDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public void insertMovie(Movie movie) {
		this.entityManager.persist(movie);
	}

	public void deleteMovie(String nomeFilme) {
		Movie movie = this.entityManager.find(Movie.class, nomeFilme);
		this.entityManager.remove(movie);
	}

	public void updateMovie(Movie movie) {
		this.entityManager.merge(movie);
	}

	@SuppressWarnings("unchecked")
	public List<Movie> returnMovies() {
		Query query = this.entityManager.createQuery("from Movie");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Movie> moviesByName(String nomeFilme) {
		Query query = this.entityManager.createQuery("from Movie where lower(title) like lower(:title)");
		query.setParameter("title", "%"+nomeFilme+"%");
		return query.getResultList();
	}
	
}
