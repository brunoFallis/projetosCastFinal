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

	public Movie searchById(String id) {
		Query query = this.entityManager.createQuery("from Movie where imdbid = :id");
		query.setParameter("id", id);
		try {
			Movie movie = (Movie) query.getSingleResult();
			return movie;
		} catch (Exception e) {
			return null;
		}

	}

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
		query.setParameter("title", "%" + nomeFilme + "%");
		return query.getResultList();
	}

	public Movie verifyDetail(String imdbid) {
		Query query = this.entityManager
				.createQuery("select m " + "from Movie m " + "left join m.movieDetail " + "where m.imdbID = :imdbid");
		query.setParameter("imdbid", imdbid);
		return (Movie) query.getSingleResult();
	}

}
