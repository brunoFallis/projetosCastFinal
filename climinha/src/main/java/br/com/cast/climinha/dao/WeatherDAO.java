package br.com.cast.climinha.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
		
		Date now = new Date();
		
		String data = new SimpleDateFormat("yyyy-MM-dd").format(now);
		
		try {
			now = new SimpleDateFormat("yyyy-MM-dd").parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Query query = this.entityManager.createQuery("from Clima where cidade = :cidade and data >= :dataTxt");
		query.setParameter("cidade", cidade).setParameter("dataTxt", now);
		

		return query.getResultList();
	}

	public void deletePorCidade(String cidade) {
		
		Query query = this.entityManager.createQuery("delete from Clima where lower(cidade) = lower(:cidade)");
		query.setParameter("cidade", cidade);
		query.executeUpdate();
		
	}

}
