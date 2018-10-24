package br.com.cast.imdbApi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.cast.imdbApi.entidade.MovieDetail;

public class MovieDetailDTO {

	@JsonProperty("imdbID")
	private String imdbid;

	@JsonProperty("Released")
	private String released;

	@JsonProperty("Genre")
	private String genre;

	@JsonProperty("Director")
	private String director;

	@JsonProperty("Plot")
	private String plot;

	public String getImdbid() {
		return imdbid;
	}

	public void setImdbid(String imdbid) {
		this.imdbid = imdbid;
	}

	public String getReleased() {
		return released;
	}

	public void setReleased(String released) {
		this.released = released;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}
	
	public void fromMovieDetail(MovieDetail movieDetail) {
		this.setDirector(movieDetail.getDirector());
		this.setGenre(movieDetail.getGenre());
		this.setImdbid(movieDetail.getImdbid());
		this.setPlot(movieDetail.getPlot());
		this.setReleased(movieDetail.getReleased());
	}

}
