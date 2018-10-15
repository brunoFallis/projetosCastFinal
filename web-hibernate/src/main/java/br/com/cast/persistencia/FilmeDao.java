package br.com.cast.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.cast.entidade.Filme;

public class FilmeDao {
	
private EntityManager em;
	
	public FilmeDao() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("puBancoDeDinheiro");
		em = emf.createEntityManager();
	}
	
	public void inserir(Filme filme) {
		try {
			em.getTransaction().begin();
			em.persist(filme);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}
	
	public Filme buscarPorId(Integer id) {
		return em.find(Filme.class, id);
	}

	public void remover(Filme filme) {
		try {
			em.getTransaction().begin();
			em.remove(filme);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

	public List<Filme> buscarTodos() {
		
		String sql = "select f "
				   + "from Filme f "
				   + "join fetch f.genero g "
				   + "join fetch f.diretor d ";
		
		Query query = em.createQuery(sql);
		
		return query.getResultList();
	}

	public void fechar() {
		em.close();
	}

}
