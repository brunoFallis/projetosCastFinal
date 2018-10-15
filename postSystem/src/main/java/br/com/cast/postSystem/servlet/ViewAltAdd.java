package br.com.cast.postSystem.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cast.postSystem.entities.Comment;
import br.com.cast.postSystem.entities.Image;
import br.com.cast.postSystem.persistence.CommentDAO;
import br.com.cast.postSystem.persistence.ImageDAO;

/**
 * Servlet implementation class viewAltAdd
 */
public class ViewAltAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String op = "";
		Image image = new Image();
		Comment comment = new Comment();
		String id = request.getParameter("id_comment");
		if("add".equals(request.getParameter("view"))){
			op = "add";
			comment.setTitle("");comment.setDescription("");
		}
//	}else if("disabled".equals(request.getParameter("view"))){
//		image = new ImageDAO().imageById(Integer.parseInt(id));
//		op = "back";
//		comment = new CommentDAO().searchById(Integer.parseInt(id));
//	}else{
//		op = String.valueOf(id);
//		comment = new CommentDAO().searchById(Integer.parseInt(id));
//	
		request.getSession().setAttribute("comment", comment);
		request.getSession().setAttribute("op", op);
		request.getRequestDispatcher("viewEditAdd.jsp").forward(request, response);
		
		}

}
