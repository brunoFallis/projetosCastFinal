package br.com.cast.hospital.entities;

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
@Table(name = "image", schema = "treinamento")
public class Image {

	@Id
	@SequenceGenerator(name = "sequence_image", schema = "treinamento", sequenceName = "image_id_seq", allocationSize = 1)
	@GeneratedValue(generator = "sequence_image", strategy = GenerationType.SEQUENCE)

	private Integer id;
	private String path;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_post")
	private Post post;

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

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			System.out.println("passei 1");
			return true;
		}
		if (!(obj instanceof Image))
			return false;

		return id != null && id.equals(((Image) obj).id);
	}

	@Override
	public int hashCode() {
		return 31;
	}

}
