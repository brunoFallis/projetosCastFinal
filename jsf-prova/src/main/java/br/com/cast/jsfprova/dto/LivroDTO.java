package br.com.cast.jsfprova.dto;

import java.util.Date;

import javax.validation.GroupSequence;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

interface Grupo1 {}

@GroupSequence({LivroDTO.class, Grupo1.class})
public class LivroDTO {

	private Integer id;
	
	@Size(min=2, max=100)
	@NotBlank(message="campo vazio", groups=Grupo1.class)
	private String titulo;
	
	@NotNull(message="campo vazio")
	private Date publicacao;
	
	private AutorDTO autorDTO;
	private CategoriaDTO categoriaDTO;

	public LivroDTO() {
		this.autorDTO = new AutorDTO();
		this.categoriaDTO = new CategoriaDTO();
	}
	
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

	public Date getPublicacao() {
		return publicacao;
	}

	public void setPublicacao(Date publicacao) {
		this.publicacao = publicacao;
	}

	public AutorDTO getAutorDTO() {
		return autorDTO;
	}

	public void setAutorDTO(AutorDTO autorDTO) {
		this.autorDTO = autorDTO;
	}

	public CategoriaDTO getCategoriaDTO() {
		return categoriaDTO;
	}

	public void setCategoriaDTO(CategoriaDTO categoriaDTO) {
		this.categoriaDTO = categoriaDTO;
	}

}
