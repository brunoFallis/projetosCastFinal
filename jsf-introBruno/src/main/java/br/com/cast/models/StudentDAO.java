package br.com.cast.models;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class StudentDAO {
	
	private EntityManager em;

	public StudentDAO() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("puJsfintro");
		em = emf.createEntityManager();
	}

	public void insertAluno(Student aluno) {
		try {
			em.getTransaction().begin();
			em.persist(aluno);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}

	public List<Student> alunos() {
		Query query = em.createQuery("from " + Student.class.getName());
		return query.getResultList();
	}
	
	public Student searchForLogin(String user, String pass) {
		
		try {
			String sql = "from " + Student.class.getName() + 
						 " where username = :user "
					   + "   and password = :pass ";
			
			Query query = em.createQuery(sql);
			
			query.setParameter("user", user);
			query.setParameter("pass", pass);
			
			Student stu = (Student)query.getSingleResult();
			
			return stu;
		
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void removeStudent(Student student) {
		try {
			em.getTransaction().begin();
			em.remove(em.find(Student.class, student.getId()));
			em.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}
	
	public void update(Student student) {
		em.getTransaction().begin();
		em.merge(student);
		em.getTransaction().commit();
	}
	
	public void fechar() {
		em.close();
	}

}
