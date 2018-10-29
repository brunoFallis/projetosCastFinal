package br.com.cast.jsfprova.business;

import java.util.ArrayList;
import java.util.List;

import br.com.cast.jsfprova.dto.AutorDTO;
import br.com.cast.jsfprova.dto.CategoriaDTO;
import br.com.cast.jsfprova.dto.LivroDTO;
import br.com.cast.jsfprova.entidade.Autor;
import br.com.cast.jsfprova.entidade.Categoria;
import br.com.cast.jsfprova.entidade.Livro;
import br.com.cast.jsfprova.execeptions.InvalidTitleException;
import br.com.cast.jsfprova.persistencia.AutorDAO;
import br.com.cast.jsfprova.persistencia.CategoriaDAO;
import br.com.cast.jsfprova.persistencia.LivroDAO;

public class LivroBusiness {

	private LivroDAO livroDAO;
	private AutorDAO autorDAO;
	private CategoriaDAO categoriaDAO;

	public LivroBusiness() {
		this.livroDAO = new LivroDAO();
		this.autorDAO = new AutorDAO();
		this.categoriaDAO = new CategoriaDAO();
	}

	public List<LivroDTO> buscaTodos() {

		List<LivroDTO> livros = new ArrayList<>();

		for (Livro l : this.livroDAO.buscarTodos()) {

			LivroDTO livroDTO = new LivroDTO();
			livroDTO.setId(l.getId());
			livroDTO.setTitulo(l.getTitulo());
			livroDTO.setPublicacao(l.getPublicacao());

			Autor autor = l.getAutor();

			AutorDTO autorDTO = new AutorDTO();
			autorDTO.setId(autor.getId());
			autorDTO.setNome(autor.getNome());
			autorDTO.setPseudonimo(autor.getPseudonimo());

			Categoria categoria = l.getCategoria();

			CategoriaDTO categoriaDTO = new CategoriaDTO();
			categoriaDTO.setId(categoria.getId());
			categoriaDTO.setDescricao(categoria.getDescricao());

			livroDTO.setAutorDTO(autorDTO);
			livroDTO.setCategoriaDTO(categoriaDTO);

			livros.add(livroDTO);

		}

		return livros;

	}

	public void salvar(LivroDTO livroDTO) throws InvalidTitleException {
		Autor autor = autorDAO.buscaPorId(livroDTO.getAutorDTO().getId());
		Categoria categoria = categoriaDAO.buscaPorId(livroDTO.getCategoriaDTO().getId());

		Livro livro = new Livro();
		livro.setId(livroDTO.getId());
		livro.setTitulo(livroDTO.getTitulo());
		livro.setPublicacao(livroDTO.getPublicacao());
		livro.setAutor(autor);
		livro.setCategoria(categoria);
		
		
		if (livroDTO.getId() == null) {
			if (livroDAO.insereLivro(livro) == false)
				throw new InvalidTitleException();
		} else {
			if (livroDAO.atualizaLivro(livro) == false)
				throw new InvalidTitleException();
		}

	}

	public void deleteLivro(Integer id) {
		this.livroDAO.deleteLivro(id);
	}

	public LivroDTO buscaLivro(Integer id) {
		Livro livro  = livroDAO.buscaLivroPorId(id);
		
		LivroDTO livroDTO = new LivroDTO();
		livroDTO.setId(livro.getId());
		livroDTO.setTitulo(livro.getTitulo());
		livroDTO.setPublicacao(livro.getPublicacao());
		
		Autor autor = livro.getAutor();

		AutorDTO autorDTO = new AutorDTO();
		autorDTO.setId(autor.getId());
		autorDTO.setNome(autor.getNome());
		autorDTO.setPseudonimo(autor.getPseudonimo());

		Categoria categoria = livro.getCategoria();

		CategoriaDTO categoriaDTO = new CategoriaDTO();
		categoriaDTO.setId(categoria.getId());
		categoriaDTO.setDescricao(categoria.getDescricao());

		livroDTO.setAutorDTO(autorDTO);
		livroDTO.setCategoriaDTO(categoriaDTO);
		
		return livroDTO;
		
	}

}
