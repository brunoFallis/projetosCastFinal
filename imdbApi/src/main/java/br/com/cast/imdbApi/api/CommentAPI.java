package br.com.cast.imdbApi.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.imdbApi.business.BusinessComment;
import br.com.cast.imdbApi.dto.CommentDTO;
import br.com.cast.imdbApi.dto.ResultCommentDTO;

@RestController
@RequestMapping(path = "/comment")
public class CommentAPI {

	@Autowired
	BusinessComment businessComment;
	
	@PostMapping()
	public void insertMovie(@RequestBody CommentDTO dto) {
		businessComment.insertComment(dto);
	}
	
	@GetMapping("/{id}")
	public List<ResultCommentDTO> returnComments(@PathVariable("id") String id){
		return businessComment.returnComments(id);
	}

}
