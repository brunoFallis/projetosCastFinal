package br.com.cast.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.cast.business.CollegeBusiness;
import br.com.cast.dtos.CollegeDTO;

@ManagedBean(name="user")
@SessionScoped
public class LoginController {
	
	private CollegeDTO collegeDTO;
	private CollegeBusiness collegeBusiness;
	private boolean isLogged;
	
	public LoginController() {
		this.collegeDTO = new CollegeDTO();
		this.collegeBusiness = new CollegeBusiness();
	}
	
	public String validateLogin() {
		try {
			this.collegeBusiness.loginBusiness(this.collegeDTO);
			return "index";
		} catch (Exception e) {
			System.out.println("user not found");
			return "login";
		}
	}
	
	public CollegeDTO getCollegeDTO() {
		return collegeDTO;
	}
	
}
