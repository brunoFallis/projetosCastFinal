package br.com.cast.hospital.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.cast.hospital.entities.Image;
import br.com.cast.hospital.entities.Post;

public class ImageDAO {
	
private EntityManager em;
	
	public ImageDAO() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("puHospital");
		em = emf.createEntityManager();
	}
	
	public List<Image> listImage(Integer id){
		Query query = em.createQuery("from Image where id_post = (:id)");
		query.setParameter("id", id);
		return query.getResultList();
	}
	
}
