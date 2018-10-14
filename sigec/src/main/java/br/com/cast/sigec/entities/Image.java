package br.com.cast.sigec.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema="dbpost", name="image")
public class Image {

	@Id
	@SequenceGenerator(name="sequence_image", 
					   schema="dbpost", 
					   sequenceName="image_id_seq", 
					   allocationSize=1)
	
	@GeneratedValue(generator="sequence_image",
					strategy=GenerationType.SEQUENCE)

	private Integer id;
	private String path;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_comment")
	private Comment comment;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

}
