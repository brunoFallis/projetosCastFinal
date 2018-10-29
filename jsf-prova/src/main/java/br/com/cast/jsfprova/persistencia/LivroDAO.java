package br.com.cast.jsfprova.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.cast.jsfprova.entidade.Livro;

public class LivroDAO {

	EntityManagerFactory emf;
	EntityManager em;

	public LivroDAO() {
		this.emf = Persistence.createEntityManagerFactory("puLivro");
		this.em = emf.createEntityManager();
	}

	public List<Livro> buscarTodos() {
		try {
			Query query = this.em.createQuery("from Livro");
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean insereLivro(Livro livro) {
		this.em.getTransaction().begin();
		try {
			this.em.persist(livro);
			this.em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			this.em.getTransaction().rollback();
			return false;
		}

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
