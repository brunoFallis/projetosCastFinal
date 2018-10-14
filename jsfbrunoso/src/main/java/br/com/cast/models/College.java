package br.com.cast.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "college", schema = "college")
public class College {

	@Id
	@SequenceGenerator(name = "sequence_college", schema = "college", sequenceName = "college_id_seq", allocationSize = 1)
	@GeneratedValue(generator="sequence_college", strategy=GenerationType.SEQUENCE)
	private Integer id;
	private String username;
	private String password;
	private String email;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
