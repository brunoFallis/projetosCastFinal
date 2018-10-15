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
@Table(name = "imagem", schema = "blog")
public class Imagem {

	@Id
	@SequenceGenerator(name = "seqGenImagem", sequenceName = "blog.imagem_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGenImagem")
	private Integer id;
	private String arquivo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_post")
	private Post postagem;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getArquivo() {
		return arquivo;
	}

	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}

	public Post getPostagem() {
		return postagem;
	}

	public void setPostagem(Post postagem) {
		this.postagem = postagem;
	}

}
