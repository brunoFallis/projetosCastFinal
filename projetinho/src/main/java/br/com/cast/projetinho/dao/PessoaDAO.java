package br.com.cast.projetinho.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.cast.projetinho.models.Pessoa;

@Repository
public class PessoaDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Pessoa> buscaTodos() {
		Query query = entityManager.createQuery("select p "
										+ "from Pessoa p "
										+ "join fetch p.endereco");
		return query.getResultList();
	}

	public void inserirPessoa(Pessoa pessoa) {
		entityManager.persist(pessoa);
	}

	public void deletePessoa(String cpf) {
		entityManager.remove(entityManager.find(Pessoa.class, cpf));
	}

	public void alterarPessoa(Pessoa pessoa) {
		entityManager.merge(pessoa);
	}

}