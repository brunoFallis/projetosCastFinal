package br.com.cast.imdbApi.api;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.cast.imdbApi.dto.ResultMovieDTO;

@Component
public class MovieClient {

	private static final String MOVIE_URL = "http://www.omdbapi.com/?apikey=d30f6f6d&s={nomeFilme}";
	
	private final RestTemplate restTemplate;
	
	public MovieClient(RestTemplateBuilder builder) {
		this.restTemplate = builder.build();
	}
	
	public ResultMovieDTO fetchMovie(String nomeFilme) {
		ResultMovieDTO dto = this.restTemplate.getForObject(MovieClient.MOVIE_URL, ResultMovieDTO.class, nomeFilme);
		return dto;
	}
	
}
