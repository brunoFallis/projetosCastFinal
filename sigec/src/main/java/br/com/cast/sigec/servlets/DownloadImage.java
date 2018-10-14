package br.com.cast.sigec.servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cast.sigec.entities.Image;
import br.com.cast.sigec.persistence.ImageDAO;



/**
 * Servlet implementation class DownloadImage
 */
@WebServlet("/Download")
public class DownloadImage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id_comment"));
		
		Image image = new ImageDAO().imageById(id);
		String dirUpload = "C:\\images\\";
		String nameFile = image.getPath();
		
		File file = new File(dirUpload + nameFile);
		
		FileInputStream in = new FileInputStream(file);
		byte[] bytes = new byte[(int)file.length()];
		in.read(bytes);
		
		response.setContentType("image/jpeg");
		
		response.getOutputStream().write(bytes);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
