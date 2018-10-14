package br.com.cast.jsfintro.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.cast.jsfintro.entidade.Aluno;

public class AlunoDao {
	
	private EntityManager em;
	
	public AlunoDao() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("puBancoDeDinheiro");
		em = emf.createEntityManager();
	}
	
	public List<Aluno> buscarTodos() {
		StringBuilder jpql = new StringBuilder();
		jpql.append("select a ")
			.append("from ").append(Aluno.class.getName()).append(" a ")
			.append("left join fetch a.professor ");
		
		Query query = em.createQuery(jpql.toString());
		return query.getResultList();
	}

	public void inserir(Aluno aluno) {
		em.getTransaction().begin();
		try {
			em.persist(aluno);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}

	public Aluno buscarPorId(Integer id) {
		return em.find(Aluno.class, id);
	}

	public void alterar(Aluno aluno) {
		em.getTransaction().begin();
		try {
			em.merge(aluno);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}

	public void excluir(Aluno aluno) {
		em.getTransaction().begin();
		try {
			em.remove(aluno);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}

}
