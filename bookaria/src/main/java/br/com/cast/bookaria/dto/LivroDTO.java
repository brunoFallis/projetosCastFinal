package br.com.cast.bookaria.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LivroDTO {

	private Integer id;
	
	@JsonProperty("titulo")
	private String titulo;
	
	@JsonProperty("publicacao")
	private String publicacao;
	
	@JsonProperty("autor")
	private Integer autor;
	
	@JsonProperty("categoria")
	private Integer categoria;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getPublicacao() {
		return publicacao;
	}

	public void setPublicacao(String publicacao) {
		this.publicacao = publicacao;
	}

	public Integer getAutor() {
		return autor;
	}

	public void setAutor(Integer autor) {
		this.autor = autor;
	}

	public Integer getCategoria() {
		return categoria;
	}

	public void setCategoria(Integer categoria) {
		this.categoria = categoria;
	}

}
