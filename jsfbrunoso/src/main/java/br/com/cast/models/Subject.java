package br.com.cast.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema="college", name="subject")
public class Subject {

	@Id
	@SequenceGenerator(name="sequence_subject",schema="college",sequenceName="subject_id_seq",allocationSize=1)
	@GeneratedValue(generator="sequence_subject",strategy=GenerationType.SEQUENCE)
	private Integer id;
	private String name;
	private Integer workload;

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

	public Integer getWorkload() {
		return workload;
	}

	public void setWorkload(Integer workload) {
		this.workload = workload;
	}

}
