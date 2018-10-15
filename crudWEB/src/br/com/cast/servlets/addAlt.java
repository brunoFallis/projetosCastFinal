package br.com.cast.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cast.models.Contact;
import br.com.cast.persistence.ContactDAO;

/**
 * Servlet implementation class addAlt
 */
@WebServlet("/addAlt")
public class addAlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		ContactDAO cDao = new ContactDAO();
		Contact c = new Contact();
		
		String id = request.getParameter("send");

		c.setName(request.getParameter("name"));
		c.setEmail(request.getParameter("email"));
		c.setAdress(request.getParameter("adress"));
		c.setDateBirth(request.getParameter("date"));
		c.setPass(request.getParameter("pass"));
		
		if(!id.equals("add") && !id.equals("s")) {
			c.setId(Integer.parseInt(id));
			cDao.updateContact(c);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else if(id.equals("add")) {
			cDao.insertContact(c);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			cDao.insertContact(c);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}

}
