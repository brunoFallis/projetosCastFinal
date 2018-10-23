package br.com.cast.imdbApi.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultMovieDTO {

	@JsonProperty("Search")
	private List<MovieDTO> search;

	public List<MovieDTO> getSearch() {
		return search;
	}

	public void setSearch(List<MovieDTO> search) {
		this.search = search;
	}

}
