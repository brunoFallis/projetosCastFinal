package br.com.cast.jsfintro.entidade;

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
@Table(name = "aluno", schema = "sala")
public class Aluno {

	@Id
	@SequenceGenerator(name = "gerador_aluno_seq", sequenceName = "aluno_id_seq", schema = "sala", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gerador_aluno_seq")
	private Integer id;
	
	private String nome;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_professor")
	private Professor professor;

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

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nome=" + nome + ", professor=" + professor + "]";
	}


}
