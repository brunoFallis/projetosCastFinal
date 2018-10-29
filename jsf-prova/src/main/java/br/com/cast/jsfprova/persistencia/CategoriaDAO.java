package br.com.cast.jsfprova.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.cast.jsfprova.entidade.Autor;
import br.com.cast.jsfprova.entidade.Categoria;

public class CategoriaDAO {
	
	EntityManagerFactory emf;
	EntityManager em;
	
	public CategoriaDAO() {
		this.emf = Persistence.createEntityManagerFactory("puLivro");
		this.em = emf.createEntityManager();
	}
	
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
