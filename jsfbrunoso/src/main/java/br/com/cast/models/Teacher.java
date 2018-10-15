package br.com.cast.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "teacher", schema = "college")
public class Teacher {

	@Id
	@SequenceGenerator(name = "sequence_teacher", schema = "college", sequenceName = "teacher_id_seq")
	@GeneratedValue(generator = "sequence_teacher", strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String name;
	private String lastname;

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

}
