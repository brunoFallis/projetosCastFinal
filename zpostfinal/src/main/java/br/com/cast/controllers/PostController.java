package br.com.cast.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.com.cast.business.PostBusiness;
import br.com.cast.dto.PostDTO;

@ManagedBean(name = "postlist")
public class PostController {

	private PostBusiness postBusiness;
	private List<PostDTO> listPosts;

	@PostConstruct
	public void posConstruct() {
		this.postBusiness = new PostBusiness();
		loadPostList();
	}
	
	public List<PostDTO> getListPosts() {
		return listPosts;
	}
	
	public void loadPostList() {
		this.listPosts = this.postBusiness.bringAllPosts();
	}

	public void delete(PostDTO postDTO) {
		this.postBusiness.deletePost(postDTO.getId());
		this.loadPostList();
	}

}
