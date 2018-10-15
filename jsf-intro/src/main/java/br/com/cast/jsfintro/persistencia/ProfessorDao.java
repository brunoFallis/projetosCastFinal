package br.com.cast.jsfintro.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.cast.jsfintro.dto.ProfessorDTO;
import br.com.cast.jsfintro.entidade.Professor;

public class ProfessorDao {
	
	private EntityManager em;
	
	public ProfessorDao() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("puBancoDeDinheiro");
		em = emf.createEntityManager();
	}
	
	public List<ProfessorDTO> buscarTodos() {
		StringBuilder jpql = new StringBuilder();
		jpql.append("select p ")
			.append("from ").append(Professor.class.getName()).append(" p ");
		
		Query query = em.createQuery(jpql.toString());
		return query.getResultList();
	}
	
	public List<ProfessorDTO> buscarTodosComPojo() {
		StringBuilder jpql = new StringBuilder();
		jpql.append("select new br.com.cast.jsfintro.dto.ProfessorDTO( ")
		.append(" p.id, p.nome, p.materia ")
		.append(")")
		.append("from ").append(Professor.class.getName()).append(" p ");
		
		Query query = em.createQuery(jpql.toString());
		return query.getResultList();
	}

	public Professor buscarPorId(Integer idProfessor) {
		return em.find(Professor.class, idProfessor);
	}

}
