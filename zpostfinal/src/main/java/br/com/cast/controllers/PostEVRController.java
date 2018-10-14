package br.com.cast.controllers;

import javax.faces.bean.ManagedBean;

import br.com.cast.business.PostBusiness;
import br.com.cast.dto.PostDTO;

@ManagedBean(name = "postC")
public class PostEVRController {

	private PostDTO postDTO;
	private PostBusiness postBusiness;

	public PostEVRController() {
		this.postDTO = new PostDTO();
		this.postBusiness = new PostBusiness();
	}

	public String addPost(Integer id) {
		if (this.postBusiness.insertPost(postDTO, id)) {
			return "postlist?faces-redirect=true";
		}
		return "register?faces-redirect=true";
	}

	public PostDTO getPostDTO() {
		return postDTO;
	}

}
