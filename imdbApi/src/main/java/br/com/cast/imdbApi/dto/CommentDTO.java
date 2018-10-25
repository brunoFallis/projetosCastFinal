package br.com.cast.imdbApi.dto;

import java.util.Date;

public class CommentDTO {

	private Integer id;
	private String movie;
	private Integer user;
	private String comment;
	private Date data;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	// public MovieDTO getMovie() {
	// return movie;
	// }
	//
	// public void setMovie(MovieDTO movie) {
	// this.movie = movie;
	// }

	public String getMovie() {
		return movie;
	}

	public void setMovie(String movie) {
		this.movie = movie;
	}

	public Integer getUser() {
		return user;
	}

	public void setUser(Integer user) {
		this.user = user;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
