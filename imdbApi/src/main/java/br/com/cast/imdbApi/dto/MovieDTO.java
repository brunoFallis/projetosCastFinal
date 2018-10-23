package br.com.cast.imdbApi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.cast.imdbApi.entidade.Movie;

public class MovieDTO {

	@JsonProperty("Title")
	private String title;

	@JsonProperty("Year")
	private String year;

	@JsonProperty("Poster")
	private String poster;

	@JsonProperty("Type")
	private String type;

	@JsonProperty("imdbID")
	private String imdbID;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getImdbID() {
		return imdbID;
	}

	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}

	public void fromMovie(Movie movie) {
		this.setTitle(movie.getTitle());
		this.setType(movie.getType());
		this.setYear(movie.getYear());
		this.setPoster(movie.getPoster());
		this.setImdbID(movie.getImdbID());
	}

}
