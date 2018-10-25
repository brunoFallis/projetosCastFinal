package br.com.cast.imdbApi.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cast.imdbApi.dao.MovieDAO;
import br.com.cast.imdbApi.dao.RepositoryComment;
import br.com.cast.imdbApi.dto.CommentDTO;
import br.com.cast.imdbApi.dto.ResultCommentDTO;
import br.com.cast.imdbApi.entidade.Comment;

@Service
public class BusinessComment {

	@Autowired
	RepositoryComment repository;

	@Autowired
	MovieDAO movieDAO;

	@Transactional
	public void insertComment(CommentDTO dto) {

		Comment comment = new Comment();
		comment.setComment(dto.getComment());

		comment.setData(new Date());

		comment.setMovie(movieDAO.searchById(dto.getMovie()));
		comment.setUser(repository.searchUser(dto.getUser()));

		repository.insert(comment);
	}

	public List<ResultCommentDTO> returnComments(String id) {
		List<Comment> comments = repository.returnComments(id);
		List<ResultCommentDTO> resultCommentsDTO = new ArrayList<>();

		for (Comment c : comments) {
			
			ResultCommentDTO dto = new ResultCommentDTO();
			
			dto.setId(c.getId());
			dto.setComment(c.getComment());
			dto.setData(c.getData());
			dto.setUser(c.getUser().getUsername());

			resultCommentsDTO.add(dto);
			
		}

		return resultCommentsDTO;

	}

}
