package br.com.cast.bookaria.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.cast.bookaria.entity.Autor;

@Repository
public class AutorDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Autor> buscarTodos(){
		try {
			Query query = this.em.createQuery("from Autor");
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Autor buscaPorId(Integer id) {
		return em.find(Autor.class, id);
	}
}
