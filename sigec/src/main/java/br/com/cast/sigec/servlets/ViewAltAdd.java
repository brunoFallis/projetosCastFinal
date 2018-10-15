package br.com.cast.sigec.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cast.sigec.entities.Comment;
import br.com.cast.sigec.entities.Image;
import br.com.cast.sigec.persistence.CommentDAO;
import br.com.cast.sigec.persistence.ImageDAO;

/**
 * Servlet implementation class ViewAltAdd
 */
@WebServlet("/ViewAltAdd")
public class ViewAltAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String opPage = request.getParameter("page");
		Integer nPage = (Integer) request.getSession().getAttribute("page");
		
		if("next".equals(opPage)) {
			request.getSession().setAttribute("page", nPage+3);
			request.getRequestDispatcher("listComments.jsp").forward(request, response);
		}else {
			request.getSession().setAttribute("page", nPage-3);
			request.getRequestDispatcher("listComments.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op = "";
		Image image = new Image();
		Comment comment = new Comment();
		String id = request.getParameter("id_comment");

		if ("add".equals(request.getParameter("view"))) {

			op = "add";
			comment.setTitle("");
			comment.setDescription("");

		} else if ("disabled".equals(request.getParameter("view"))) {

			image = new ImageDAO().imageById(Integer.parseInt(id));
			comment = new CommentDAO().searchById(Integer.parseInt(id));
			request.getSession().setAttribute("image", image);
			op = "back";

		}
		// }else{
		// op = String.valueOf(id);
		// comment = new CommentDAO().searchById(Integer.parseInt(id));
		//
		request.getSession().setAttribute("comment", comment);
		request.getSession().setAttribute("op", op);
		request.getRequestDispatcher("viewEditAdd.jsp").forward(request, response);
	}

}
