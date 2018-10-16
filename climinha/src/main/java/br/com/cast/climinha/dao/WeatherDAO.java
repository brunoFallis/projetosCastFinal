package br.com.cast.climinha.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.cast.climinha.entidade.Clima;

@Repository
public class WeatherDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public void insere(Clima clima) {
		this.entityManager.persist(clima);
	}

	@SuppressWarnings("unchecked")
	public List<Clima> buscaPorCidade(String cidade) {

		Query query = this.entityManager.createQuery("from Clima where cidade = :cidade");
		query.setParameter("cidade", cidade);

		return query.getResultList();
	}

	public void deletePorCidade(String cidade) {
		
		Query query = this.entityManager.createQuery("delete from Clima where cidade = :cidade");
		query.setParameter("cidade", cidade);
		query.executeUpdate();
		
	}

}
