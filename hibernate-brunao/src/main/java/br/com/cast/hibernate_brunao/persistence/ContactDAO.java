package br.com.cast.hibernate_brunao.persistence;

import javax.persistence.*;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.cast.hibernate_brunao.entity.Contact;

public class ContactDAO {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public ContactDAO() {
		this.emf = Persistence.createEntityManagerFactory("puContactsBase");
		this.em = emf.createEntityManager();
	}
	
	public void insertContact(Contact contact) {
		em.getTransaction().begin();
		em.persist(contact);
		em.getTransaction().commit();
	}
	
	public void removeContact(Integer id) {
		em.getTransaction().begin();
		
		if(em.find(Contact.class, id) != null) {
			Contact contact = em.find(Contact.class, id);
			em.remove(contact);
			em.getTransaction().commit();
		}else {
			System.out.println("Contact not found REMOVE");
		}
		
	}
	
	public void updateContact(Contact contact) {
		em.getTransaction().begin();
		
		if(em.find(Contact.class, contact.getId()) != null) {
			em.merge(contact);
			em.getTransaction().commit();
		}else {
			System.out.println("Contact not found UPDATE");
		}
		
	}
	
	public Contact searchById(Integer id) {
		return em.find(Contact.class, id);
	}
	
	public void CloseManager() {
		emf.close();
	}
	
}
