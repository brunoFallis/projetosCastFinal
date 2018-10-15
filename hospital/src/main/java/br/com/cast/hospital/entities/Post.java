package br.com.cast.hospital.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "post", schema = "treinamento")
public class Post {

	@Id
	@SequenceGenerator(name = "sequence_post", 
					   schema = "treinamento", 
					   sequenceName = "post_id_seq", 
					   allocationSize = 1)
	@GeneratedValue(generator = "sequence_post", 
				    strategy = GenerationType.SEQUENCE)

	private Integer id;
	private String text;
	private Date datepost;

	@OneToMany(mappedBy = "post", 
			   cascade = CascadeType.ALL,
			   orphanRemoval = true)
	
	private List<Image> images = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDatePost() {
		return datepost;
	}

	public void setDate(Date date) {
		this.datepost = date;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}
 
	public void addImage(Image image) {
		images.add(image);
		image.setPost(this);
	}

	public void removeImage(Image image) {
		images.remove(image);
		image.setPost(null);
	}

}
