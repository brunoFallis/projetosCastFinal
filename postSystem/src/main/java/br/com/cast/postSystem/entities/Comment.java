package br.com.cast.postSystem.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema="dbpost", name="comment")
public class Comment {

	@Id
	@SequenceGenerator(name="sequence_comment", 
					   schema="dbpost", 
					   sequenceName="comment_id_seq", 
					   allocationSize=1)
	
	@GeneratedValue(generator="sequence_comment",
					strategy=GenerationType.SEQUENCE)
	private Integer id;
	private String title;
	private String description;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_user")
	private User user;

	@OneToMany(mappedBy="comment",
			   cascade=CascadeType.ALL, 
			   orphanRemoval=true)
	private List<Image> images = new ArrayList<>();
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void addImage(Image image) {
		this.images.add(image);
		image.setComment(this);
	}
	
	public void removeImage(Image image) {
		this.images.add(image);
		image.setComment(null);
	}
	
	@Override
	public int hashCode() {
		return 31;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
