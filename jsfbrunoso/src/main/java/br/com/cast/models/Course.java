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
@Table(name="course", schema="college")
public class Course {
	
	@Id
	@SequenceGenerator(name="sequence_course",schema="college",sequenceName="course_id_seq",allocationSize=1)
	@GeneratedValue(generator="sequence_course",strategy=GenerationType.SEQUENCE)
	private Integer id;
	private String name;
	private Float duration;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_college")
	private College college;

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

	public Float getDuration() {
		return duration;
	}

	public void setDuration(Float duration) {
		this.duration = duration;
	}

	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

}
