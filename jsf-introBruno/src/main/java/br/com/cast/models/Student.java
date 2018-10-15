package br.com.cast.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "student", schema = "escola")
public class Student {

	private static final String MAX_100 = "field cannot contains more than 100 (a hundred) characters";
	private static final String MAX_20 = "field cannot contains more than 20 characters";
	private static final String NOT_BLANK = "field cannot be empty";
	
	@Id
	@SequenceGenerator(name = "sequence_student", schema = "escola", sequenceName = "student_id_seq", allocationSize = 1)
	@GeneratedValue(generator = "sequence_student", strategy = GenerationType.SEQUENCE)

	private Integer id;
	
	@NotBlank(message=NOT_BLANK)
	@Size(max=100, message=MAX_100)
	private String name;
	
	@NotBlank(message=NOT_BLANK)
	@Max(value=100, message=MAX_100)
	private String lastname;
	
	@NotBlank(message=NOT_BLANK)
	private String username;
	
	@NotBlank(message=NOT_BLANK)
	@Max(value=100, message=MAX_100)
	private String email;
	
	@NotBlank(message=NOT_BLANK)
	@Size(min=6,max=20, message=MAX_20)
	private String password;

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

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
