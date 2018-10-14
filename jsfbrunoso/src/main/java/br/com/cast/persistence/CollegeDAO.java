package br.com.cast.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.cast.models.College;

public class CollegeDAO {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("puJsfBrunoso");
	EntityManager em;
	
	public CollegeDAO() {
		em = emf.createEntityManager();
	}
	
	public College searchToLogin(String user, String pass) {
		try {
			Query query = em.createQuery("from " + College.class.getName() + " where username = :user and password = :pass");
			query.setParameter("user", user).setParameter("pass", pass);
			return (College)query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
	
}
