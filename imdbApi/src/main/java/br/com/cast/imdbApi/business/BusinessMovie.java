package br.com.cast.imdbApi.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cast.imdbApi.api.MovieClient;
import br.com.cast.imdbApi.dao.MovieDAO;
import br.com.cast.imdbApi.dto.MovieDTO;
import br.com.cast.imdbApi.entidade.Movie;

@Service
public class BusinessMovie {

	@Autowired
	private MovieClient movieClient;

	@Autowired
	private MovieDAO movieDAO;

	public void insert(MovieDTO dto) {
		Movie m = new Movie();
		m.fromMovieDTO(dto);
		movieDAO.insertMovie(m);
	}
	
	@Transactional
	public MovieDTO returnMovie(String nomeFilme) {
		Movie movie = movieDAO.searchByName(nomeFilme);
		MovieDTO movieDTO = new MovieDTO();
		if(movie == null) {
			movieDTO = movieClient.fetchMovie(nomeFilme);
			this.insert(movieDTO);
			return movieDTO;
		}
		
		movieDTO.fromMovie(movie);
		return movieDTO;
		
	}

	@Transactional
	public void delete(String nomeFilme) {
		movieDAO.deleteMovie(nomeFilme);
	}

	@Transactional
	public void update(MovieDTO dto) {
		Movie m = new Movie();
		m.fromMovieDTO(dto);
		movieDAO.updateMovie(m);
	}

	public List<MovieDTO> returnMovies() {
		List<Movie> movies = movieDAO.returnMovies();

		List<MovieDTO> moviesDTO = new ArrayList<>();
		for (Movie m : movies) {

			MovieDTO dto = new MovieDTO();
			dto.fromMovie(m);
			moviesDTO.add(dto);

		}
		
		return moviesDTO;
		
	}

}
