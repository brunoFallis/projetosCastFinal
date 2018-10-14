package br.com.cast.sigec.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.cast.sigec.entities.Image;


public class ImageDAO {
	
private EntityManager em;
	
	public ImageDAO() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("puSigec");
		em = emf.createEntityManager();
	}
	
	public void insertImage(Image image) {
		em.getTransaction().begin();
		em.persist(image);
		em.getTransaction().commit();
	}
	
	public Image imageById(Integer id){
		Query query = em.createQuery("from Image where id_comment = (:id)");
		query.setParameter("id", id);
		return (Image)query.getSingleResult();
	}
	
	public void close() {
		em.close();
	}
	
}
