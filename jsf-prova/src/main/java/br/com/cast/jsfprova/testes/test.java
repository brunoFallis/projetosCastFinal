package br.com.cast.jsfprova.testes;

import java.util.ArrayList;
import java.util.List;

import br.com.cast.jsfprova.dto.AutorDTO;
import br.com.cast.jsfprova.dto.LivroDTO;
import br.com.cast.jsfprova.entidade.Livro;
import br.com.cast.jsfprova.persistencia.LivroDAO;

public class test {
	
	public static void main(String[] args) {
		
		List<LivroDTO> livros = new ArrayList<>();
		
		for(Livro l : new LivroDAO().buscarTodos()) {
			LivroDTO livroDTO = new LivroDTO();
			livroDTO.setId(l.getId());
			livroDTO.setTitulo(l.getTitulo());
			livroDTO.setPublicacao(l.getPublicacao());
			
			System.out.println(l.getAutor().getNome());
			
		}
		
	}
	
}
