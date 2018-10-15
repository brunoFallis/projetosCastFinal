package br.com.cast.entidade;

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
@Table(name="filme", schema="filme")
public class Filme {
	
	@Id
	@SequenceGenerator(name="seqGen", 
	    sequenceName="filme.filme_id_seq", 
	    allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqGen")
	private Integer id;
	private String nome;
	private Integer ano;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_genero") //informo a coluna que é a fk
	private Genero genero;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_diretor") //informo a coluna que é a fk
	private Diretor diretor;

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

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Diretor getDiretor() {
		return diretor;
	}

	public void setDiretor(Diretor diretor) {
		this.diretor = diretor;
	}

}
