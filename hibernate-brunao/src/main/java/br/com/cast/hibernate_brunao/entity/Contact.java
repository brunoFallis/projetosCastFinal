package br.com.cast.hibernate_brunao.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema = "contacts", name = "contact")
public class Contact {

	@Id
	@SequenceGenerator(name = "sequence_do_brunao", 
					   schema = "contacts", 
					   sequenceName = "contact_id_seq", 
					   allocationSize = 1)
	@GeneratedValue(generator = "sequence_do_brunao", 
					strategy = GenerationType.SEQUENCE)
	
	private Integer id;
	private String name;
	private String email;
	private String adress;
	private String datebirth;
	private String pass;
	
	@Override
	public String toString() {
		return this.name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getDatebirth() {
		return datebirth;
	}

	public void setDatebirth(String datebirth) {
		this.datebirth = datebirth;
	}

}
