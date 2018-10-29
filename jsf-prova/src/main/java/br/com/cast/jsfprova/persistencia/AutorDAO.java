package br.com.cast.jsfprova.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.cast.jsfprova.entidade.Autor;

public class AutorDAO {
	EntityManagerFactory emf;
	EntityManager em;
	
	public AutorDAO() {
		this.emf = Persistence.createEntityManagerFactory("puLivro");
		this.em = emf.createEntityManager();
	}
	
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
