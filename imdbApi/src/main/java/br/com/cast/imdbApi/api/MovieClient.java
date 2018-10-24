package br.com.cast.imdbApi.api;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.cast.imdbApi.dto.MovieDetailDTO;
import br.com.cast.imdbApi.dto.ResultMovieDTO;

@Component
public class MovieClient {

	private static final String MOVIE_URL = "http://www.omdbapi.com/?apikey=d30f6f6d&s={nomeFilme}";
	private static final String MOVIE_DETAIL_URL = "http://www.omdbapi.com/?i={id}&apikey=e3c4e473";
	
	private final RestTemplate restTemplate;
	
	public MovieClient(RestTemplateBuilder builder) {
		this.restTemplate = builder.build();
	}
	
	public ResultMovieDTO fetchMovies(String nomeFilme) {
		ResultMovieDTO dto = this.restTemplate.getForObject(MovieClient.MOVIE_URL, ResultMovieDTO.class, nomeFilme);
		return dto;
	}
	
	public MovieDetailDTO fetchMovieDetail(String id) {
		MovieDetailDTO dto = this.restTemplate.getForObject(MovieClient.MOVIE_DETAIL_URL, MovieDetailDTO.class, id);
		return dto;
	}
	
}
