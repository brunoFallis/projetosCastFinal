package br.com.cast.jsfprova.business;

import java.util.ArrayList;
import java.util.List;

import br.com.cast.jsfprova.dto.AutorDTO;
import br.com.cast.jsfprova.dto.CategoriaDTO;
import br.com.cast.jsfprova.entidade.Autor;
import br.com.cast.jsfprova.entidade.Categoria;
import br.com.cast.jsfprova.persistencia.CategoriaDAO;

public class CategoriaBusiness {
	
	private CategoriaDAO categoriaDAO;
	
	public CategoriaBusiness() {
		this.categoriaDAO = new CategoriaDAO();
	}
	
	public List<CategoriaDTO> buscaTodos(){
		
		List<CategoriaDTO> categorias = new ArrayList<>();

		for (Categoria c : this.categoriaDAO.buscarTodos()) {
			CategoriaDTO categoriaDTO = new CategoriaDTO();

			categoriaDTO.setId(c.getId());
			categoriaDTO.setDescricao(c.getDescricao());

			categorias.add(categoriaDTO);

		}

		return categorias;
		
	}
	
}
