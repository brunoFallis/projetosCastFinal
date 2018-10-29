package br.com.cast.jsfprova.business;

import java.util.ArrayList;
import java.util.List;

import br.com.cast.jsfprova.dto.AutorDTO;
import br.com.cast.jsfprova.entidade.Autor;
import br.com.cast.jsfprova.persistencia.AutorDAO;

public class AutorBusiness {

	private AutorDAO autorDAO;

	public AutorBusiness() {
		this.autorDAO = new AutorDAO();
	}

	public List<AutorDTO> buscaTodos() {

		List<AutorDTO> autores = new ArrayList<>();

		for (Autor a : this.autorDAO.buscarTodos()) {
			AutorDTO autorDTO = new AutorDTO();

			autorDTO.setId(a.getId());
			autorDTO.setNome(a.getNome());
			autorDTO.setPseudonimo(a.getPseudonimo());

			autores.add(autorDTO);

		}

		return autores;

	}

}
