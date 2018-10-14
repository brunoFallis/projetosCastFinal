package br.com.cast.sigec.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.cast.sigec.entities.User;
import br.com.cast.sigec.persistence.UserDAO;


/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
			session.setAttribute("page", 0);
			request.getRequestDispatcher("listComments.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("login.jsp");
		}
		
	}

}
