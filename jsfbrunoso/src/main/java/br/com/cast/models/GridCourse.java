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
@Table(name="gridcourse", schema="college")
public class GridCourse {

	@Id
	@SequenceGenerator(name="sequence_gridcourse",schema="college",sequenceName="gridcourse_id_seq",allocationSize=1)
	@GeneratedValue(generator="sequence_gridcourse",strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_course")
	private Course course;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_subject")
	private Subject subject;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_teacher")
	private Teacher teacher;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

}
