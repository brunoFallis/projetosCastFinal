package br.com.cast.hospital.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema="hospital", name="plan")
public class Plan {

	@Id
	@SequenceGenerator(name="sequence_plan",
					   schema="hospital",
					   sequenceName="plan_id_seq",
					   allocationSize=1)
	@GeneratedValue(generator="sequence_plan",
					strategy=GenerationType.SEQUENCE)
	
	private Integer id;
	private String name;
	private Double value;

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

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

}
