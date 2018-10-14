package br.com.cast.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.cast.business.UserBusiness;
import br.com.cast.dto.UserDTO;

@ManagedBean(name = "user")
@SessionScoped
public class LoginController {

	private UserDTO userDTO;
	private UserBusiness userBusiness;

	public LoginController() {
		this.userDTO = new UserDTO();
		this.userBusiness = new UserBusiness();
	}

	public String validateLogin() {
		this.userDTO = userBusiness.searchToLogin(userDTO);
		if (this.userDTO != null) {
			return "postlist?faces-redirect=true";
		} else {
			return "login?faces-redirect=true";
		}
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

}
