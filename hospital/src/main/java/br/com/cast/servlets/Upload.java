package br.com.cast.servlets;

import java.io.IOException;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import br.com.cast.hospital.entities.Image;
import br.com.cast.hospital.entities.Post;
import br.com.cast.hospital.entities.PostDAO;

/**
 * Servlet implementation class Upload
 */
@WebServlet("/up")
@MultipartConfig
public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String textPost = request.getParameter("textPost");
		Part part = request.getPart("file");
		
		String originalFile = Paths.get(part.getSubmittedFileName()).toString();	
		String extension = originalFile.substring(originalFile.lastIndexOf("."));
		String nameFile = UUID.randomUUID().toString() + extension;
		
		PostDAO pDao = new PostDAO();
		Post p = new Post();
		Image i = new Image();
		
		i.setPath(nameFile);
		//return the current time of the post
		Date date = java.util.Calendar.getInstance().getTime();
		
		p.setDate(date);
		p.addImage(i);
		p.setText(textPost);
		
		pDao.insertPost(p);
		pDao.close();
		
		part.write("c:\\images\\" + nameFile);
		
	}

}
