package br.com.cast.business;

import br.com.cast.dtos.CollegeDTO;
import br.com.cast.exceptions.InvalidUserException;
import br.com.cast.models.College;
import br.com.cast.persistence.CollegeDAO;

public class CollegeBusiness {

	private CollegeDAO collegeDAO;
	
	public CollegeBusiness() {
		this.collegeDAO = new CollegeDAO();
	}
	
	public CollegeDTO loginBusiness(CollegeDTO collegeDTO) throws InvalidUserException{
		
		College college = collegeDAO.searchToLogin(collegeDTO.getUsername(), collegeDTO.getPassword());
		
		if(college!=null) {
			collegeDTO.setId(college.getId());
			collegeDTO.setUsername(college.getUsername());
			collegeDTO.setPassword(college.getPassword());
			return collegeDTO;
		}else {
			throw new InvalidUserException();
		}
		
	}
	
}
