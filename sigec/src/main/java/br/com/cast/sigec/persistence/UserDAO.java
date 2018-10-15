package br.com.cast.sigec.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.cast.sigec.entities.User;


public class UserDAO {

	private EntityManager em;
	
	public UserDAO(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("puSigec");
		em = emf.createEntityManager();
	}
	
	public User searchById(String user, String pass) {
		Query query = em.createQuery("from User where username = :nome and pass = :senha");
		
		query.setParameter("nome", user);
		query.setParameter("senha", pass);
		
		try {
			return (User)query.getSingleResult();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void close() {
		em.close();
	}
	
}

