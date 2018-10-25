package br.com.cast.imdbApi.entidade;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.cast.imdbApi.dto.MovieDTO;

@Entity
@Table(name = "movie", schema = "movie")
public class Movie {

	@Id
	private String imdbID;
	private String title;
	private String year;
	private String type;
	private String poster;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "imdb_detail")
	private MovieDetail movieDetail;

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

	public String getImdbID() {
		return imdbID;
	}

	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public MovieDetail getMovieDetail() {
		return movieDetail;
	}

	public void setMovieDetail(MovieDetail movieDetail) {
		this.movieDetail = movieDetail;
	}

	@Override
	public String toString() {
		return "Movie [title=" + title + ", year=" + year + ", imdbID=" + imdbID + ", type=" + type + ", poster="
				+ poster + ", movieDetail=" + movieDetail + "]";
	}

	public void fromMovieDTO(MovieDTO dto) {
		this.setTitle(dto.getTitle());
		this.setType(dto.getType());
		this.setYear(dto.getYear());
		this.setPoster(dto.getPoster());
		this.setImdbID(dto.getImdbID());

		if (dto.getMovieDetailDTO() != null) {
			this.getMovieDetail().fromMovieDetailDTO(dto.getMovieDetailDTO());
		}

	}

}
