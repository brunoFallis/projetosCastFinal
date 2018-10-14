package br.com.cast.postSystem.servlet;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import br.com.cast.postSystem.entities.Comment;
import br.com.cast.postSystem.entities.Image;
import br.com.cast.postSystem.entities.User;
import br.com.cast.postSystem.persistence.CommentDAO;

/**
 * Servlet implementation class altAdd
 */
@MultipartConfig
public class altAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String op = request.getParameter("save");
		HttpSession session =  request.getSession();
		Comment comment = new Comment();
		CommentDAO cDao = new CommentDAO();
		Image image = new Image();
		
		String title = request.getParameter("title");
		String description = request.getParameter("description");	
		Part part = request.getPart("file");
		
		String originalFile = Paths.get(part.getSubmittedFileName()).toString();	
		String extension = originalFile.substring(originalFile.lastIndexOf("."));
		String nameFile = UUID.randomUUID().toString() + extension;
		
		image.setPath(nameFile);
		
		part.write("c:\\images\\" + nameFile);
		
		if("add".equals(op)) {
			comment.setTitle(title);
			comment.setDescription(description);
			comment.setUser((User)session.getAttribute("logged"));
			comment.addImage(image);
			cDao.insertComment(comment);
			request.getRequestDispatcher("listComments.jsp").forward(request, response);
		}else if("back".equals(op)) {
			request.getRequestDispatcher("listComments.jsp").forward(request, response);
		}else {
			comment = cDao.searchById(Integer.parseInt(op));
			comment.setTitle(title);
			comment.setDescription(description);
			cDao.updateComment(comment);
			request.getRequestDispatcher("listComments.jsp").forward(request, response);
		}
		
	}

}
