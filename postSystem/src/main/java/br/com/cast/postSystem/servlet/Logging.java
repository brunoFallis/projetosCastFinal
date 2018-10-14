package br.com.cast.postSystem.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.cast.postSystem.entities.User;
import br.com.cast.postSystem.persistence.UserDAO;



/**
 * Servlet implementation class Logging
 */
public class Logging extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user = request.getParameter("userName");
		String pass = request.getParameter("password");
		UserDAO uDao = new UserDAO();
		User loggedUser = uDao.searchById(user, pass);
				
		if(loggedUser != null) {
			HttpSession session = request.getSession();
			session.setAttribute("logged", loggedUser);
			request.getRequestDispatcher("listComments.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("login.jsp");
		}
		
	}

}
