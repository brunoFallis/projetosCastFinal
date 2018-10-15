package br.com.cast.hospital.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.cast.hospital.entities.Patient;

public class PatientDAO {

	private EntityManager em;
	
	public PatientDAO() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("puHospital");
		em = emf.createEntityManager();
	}
	
	public List<Patient> listPatients(){
		Query query = em.createQuery("from "+Patient.class.getName());
		return query.getResultList();
	} 
	
	public void close() {
		em.close();
	}
	
}
