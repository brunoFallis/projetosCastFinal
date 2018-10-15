package br.com.cast.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.cast.models.Contact;
import br.com.cast.persistence.ContactDAO;

/**
 * Servlet implementation class logIn
 */
@WebServlet("/logIn")
public class logIn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		ContactDAO cDao = new ContactDAO();
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		
		Contact userLog = cDao.loginContact(user, pass);
		
		if(userLog == null) {
			request.setAttribute("errorMsg", "Usuário ou senha inválido");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else {
			session.setAttribute("logged user", userLog);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
	}

}
