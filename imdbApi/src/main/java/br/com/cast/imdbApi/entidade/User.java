package br.com.cast.imdbApi.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.cast.imdbApi.dto.UserDTO;

@Entity
@Table(name = "user", schema = "movie")
public class User {

	@Id
	@SequenceGenerator(name = "sequence_user", schema = "movie", sequenceName = "user_id_seq", allocationSize = 1)
	@GeneratedValue(generator = "sequence_user", strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String username;
	private String email;
	private String password;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void fromUserDTO(UserDTO dto) {
		this.setEmail(dto.getEmail());
	}

}
