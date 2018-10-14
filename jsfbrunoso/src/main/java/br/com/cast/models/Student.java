package br.com.cast.models;

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
@Table(name = "student", schema = "college")
public class Student {

	@Id
	@SequenceGenerator(name = "sequence_student", schema = "college", sequenceName = "student_id_seq", allocationSize = 1)
	@GeneratedValue(generator="sequence_student", strategy=GenerationType.SEQUENCE)
	private Integer id;
	private String name;
	private String lastname;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_course")
	private Course course;

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
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

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

}
