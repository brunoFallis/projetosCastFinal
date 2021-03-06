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
 * Servlet implementation class TesteDois
 */
@WebServlet("/TesteDois")
public class TesteDois extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String option = request.getParameter("option");
		
		
		if("add".equals(option)) {
			ContactDAO cDao = new ContactDAO();
			Contact c = new Contact();
			
			c.setName(request.getParameter("name"));
			c.setEmail(request.getParameter("email"));
			c.setAdress(request.getParameter("adress"));
			c.setDateBirth(request.getParameter("date"));
			c.setPass(request.getParameter("pass"));	
			
			cDao.insertContact(c);
			
			response.sendRedirect("teste.html");
		}else if("x".equals(option)){
			ContactDAO cDao = new ContactDAO();
			String id = request.getParameter("id");
			cDao.deleteContact(Integer.parseInt(id));
			response.sendRedirect("list.jsp");
		}else if("a".equals(option)){
			ContactDAO cDao = new ContactDAO();
			String id = request.getParameter("id");
			
			response.sendRedirect("list.jsp");
		}
	}

}
