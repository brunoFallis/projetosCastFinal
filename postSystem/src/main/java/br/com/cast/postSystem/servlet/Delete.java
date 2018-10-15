package br.com.cast.postSystem.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cast.postSystem.persistence.CommentDAO;

/**
 * Servlet implementation class Delete
 */
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CommentDAO cDao = new CommentDAO();
		cDao.removeComment(Integer.parseInt(request.getParameter("del")));
		request.getRequestDispatcher("listComments.jsp").forward(request, response);
		
	}

}
