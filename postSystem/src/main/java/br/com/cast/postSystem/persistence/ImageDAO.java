package br.com.cast.postSystem.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.cast.postSystem.entities.Comment;
import br.com.cast.postSystem.entities.Image;

public class ImageDAO {
	
private EntityManager em;
	
	public ImageDAO() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("puPostSystem");
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
