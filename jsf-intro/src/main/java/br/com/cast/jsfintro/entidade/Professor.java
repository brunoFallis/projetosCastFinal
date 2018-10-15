package br.com.cast.jsfintro.entidade;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "professor", schema = "sala")
public class Professor {

	@Id
	private Integer id;
	private String nome;
	private String materia;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}
	
	@Override
	public String toString() {
		return "Professor [nome=" + nome + ", materia=" + materia + "]";
	}

}
