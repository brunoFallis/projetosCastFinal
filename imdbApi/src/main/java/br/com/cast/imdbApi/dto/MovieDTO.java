package br.com.cast.imdbApi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.cast.imdbApi.entidade.Movie;

public class MovieDTO {

	@JsonProperty("Title")
	private String title;

	@JsonProperty("Year")
	private String year;

	@JsonProperty("Runtime")
	private String runtime;

	@JsonProperty("Genre")
	private String genre;

	@JsonProperty("Director")
	private String director;

	@JsonProperty("Plot")
	private String plot;

	@JsonProperty("Poster")
	private String poster;

	@JsonProperty("Type")
	private String type;

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

	public String getRuntime() {
		return runtime;
	}

	public void setRuntime(String runtime) {
		this.runtime = runtime;
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

	@Override
	public String toString() {
		return "MovieDTO [title=" + title + ", year=" + year + ", runtime=" + runtime + ", genre=" + genre
				+ ", director=" + director + ", plot=" + plot + ", poster=" + poster + ", type=" + type + "]";
	}
	
	public void fromMovie(Movie movie) {
		this.setTitle(movie.getTitle());
		this.setDirector(movie.getDirector());
		this.setGenre(movie.getGenre());
		this.setPlot(movie.getPlot());
		this.setRuntime(movie.getRuntime());
		this.setType(movie.getType());
		this.setYear(movie.getYear());
		this.setPoster(movie.getPoster());
	}

}
