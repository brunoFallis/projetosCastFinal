package br.com.cast.sigec.entities;

import java.util.ArrayList;
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
@Table(schema="dbpost", name="user")
public class User {

	@Id
	@SequenceGenerator(name="sequence_user", 
					   schema="dbpost", 
					   sequenceName="user_id_seq", 
					   allocationSize=1)
	
	@GeneratedValue(generator="sequence_user",
					strategy=GenerationType.SEQUENCE)
	
	private Integer id;
	private String name;
	private String username;
	private String pass;
	
	@OneToMany(mappedBy="user",
			   cascade=CascadeType.ALL, 
			   orphanRemoval=true)
	private List<Comment> comments = new ArrayList<>();

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public void addComment(Comment comment) {
		this.comments.add(comment);
		comment.setUser(this);
	}
	
	public void removeComment(Comment comment) {
		this.comments.remove(comment);
		comment.setUser(null);
	}
	
}

