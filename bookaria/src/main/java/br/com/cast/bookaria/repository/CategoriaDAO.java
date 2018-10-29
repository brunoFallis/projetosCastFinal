package br.com.cast.bookaria.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.cast.bookaria.entity.Categoria;

@Repository
public class CategoriaDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Categoria> buscarTodos(){
		try {
			Query query = this.em.createQuery("from Categoria");
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Categoria buscaPorId(Integer id) {
		return em.find(Categoria.class, id);
	}
	
}
