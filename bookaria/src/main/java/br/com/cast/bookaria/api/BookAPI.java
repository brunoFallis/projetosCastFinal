package br.com.cast.bookaria.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.bookaria.dto.LivroDTO;
import br.com.cast.bookaria.dto.ResultLivroDTO;
import br.com.cast.bookaria.services.BookService;

@RestController
@RequestMapping(path="/bookaria")
public class BookAPI {
	
	@Autowired
	BookService bookService;
	
	@GetMapping()
	public List<ResultLivroDTO> returnBooks(){
		return this.bookService.returnBooks();
	}
	
	@PostMapping()
	public void insertBook(@RequestBody LivroDTO dto) {
		this.bookService.insertBooks(dto);
	}
	
}
