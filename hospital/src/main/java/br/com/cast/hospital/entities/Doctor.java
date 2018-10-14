package br.com.cast.hospital.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema = "hospital", name = "doctor")
public class Doctor {

	@Id
	@SequenceGenerator(name = "sequence_doctor", 
	schema = "hospital", sequenceName = "doctor_id_seq", allocationSize = 1)
	@GeneratedValue(generator = "sequence_doctor", strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String name;
	private String area;

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

	
	public String getArea() {
		return area;
	}

	
	public void setArea(String area) {
		this.area = area;
	}

}
