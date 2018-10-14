package br.com.cast.dto;

public class PostDTO {

	private Integer id;
	private String title;
	private String text;
	private Integer idUser;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getIdUser() {
		return idUser;
	}

	
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

}
