package br.com.cast.bookaria.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.cast.bookaria.entity.Livro;

@Repository
public class LivroDAO {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<Livro> buscarTodos() {
		Query query = this.em
				.createQuery("select l " + 
							 "from Livro l " + 
							 "join fetch l.autor " + 
							 "join fetch l.categoria");
		List<Livro> l = query.getResultList();
		return l;
	}

	public void insereLivro(Livro livro) {
		this.em.persist(livro);
	}

	public boolean atualizaLivro(Livro livro) {
		this.em.getTransaction().begin();
		try {
			this.em.merge(livro);
			this.em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			this.em.getTransaction().rollback();
			return false;
		}

	}

	public void deleteLivro(Integer id) {
		this.em.getTransaction().begin();
		try {
			this.em.remove(em.find(Livro.class, id));
			this.em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Livro buscaLivroPorId(Integer id) {
		return em.find(Livro.class, id);
	}

}
