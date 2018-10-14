package br.com.cast.business;

import br.com.cast.dto.UserDTO;
import br.com.cast.entities.User;
import br.com.cast.persistence.UserDAO;

public class UserBusiness {

	private UserDAO userDAO;

	public UserBusiness() {
		this.userDAO = new UserDAO();
	}

	public UserDTO searchToLogin(UserDTO userDTO) {

		User user = this.userDAO.searchUser(userDTO.getUsername(), userDTO.getPassword());

		if (user != null) {
			userDTO.setId(user.getId());
			userDTO.setUsername(user.getUsername());
			userDTO.setPassword(user.getPassword());
			return userDTO;
		} else {
			return null;
		}
		
	}
	
	public boolean insertUser(UserDTO userDTO) {
		
		User user = new User();
		user.setUsername(userDTO.getUsername());
		user.setPassword(userDTO.getPassword());
		
		if(this.userDAO.insertUser(user)) {
			return true;
		}else {
			return false;
		}
		
	}

}
