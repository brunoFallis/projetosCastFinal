package br.com.cast.bookaria.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cast.bookaria.dto.LivroDTO;
import br.com.cast.bookaria.dto.ResultLivroDTO;
import br.com.cast.bookaria.entity.Autor;
import br.com.cast.bookaria.entity.Categoria;
import br.com.cast.bookaria.entity.Livro;
import br.com.cast.bookaria.repository.AutorDAO;
import br.com.cast.bookaria.repository.CategoriaDAO;
import br.com.cast.bookaria.repository.LivroDAO;

@Service
public class BookService {

	@Autowired
	LivroDAO livroDAO;

	@Autowired
	AutorDAO autorDAO;

	@Autowired
	CategoriaDAO categoriaDAO;

	public List<ResultLivroDTO> returnBooks() {
		List<Livro> livros = livroDAO.buscarTodos();
		List<ResultLivroDTO> livrosDTO = new ArrayList<>();

		for (Livro l : livros) {
			ResultLivroDTO dto = new ResultLivroDTO();
			dto.setAutor(l.getAutor().getNome());
			dto.setTitulo(l.getTitulo());
			dto.setCategoria(l.getCategoria().getDescricao());
			dto.setId(l.getId());
			dto.setPublicacao(l.getPublicacao());

			livrosDTO.add(dto);
		}

		return livrosDTO;
	}

	@Transactional
	public void insertBooks(LivroDTO dto) {
		Livro livro = new Livro();

		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

		try {
			Date data = formato.parse(dto.getPublicacao());
			livro.setPublicacao(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		livro.setTitulo(dto.getTitulo());

		Autor autor = autorDAO.buscaPorId(dto.getAutor());
		Categoria categoria = categoriaDAO.buscaPorId(dto.getCategoria());

		livro.setAutor(autor);
		livro.setCategoria(categoria);

		livroDAO.insereLivro(livro);

	}

}
