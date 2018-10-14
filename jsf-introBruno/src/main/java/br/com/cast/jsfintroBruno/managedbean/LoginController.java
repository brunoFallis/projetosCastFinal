package br.com.cast.jsfintroBruno.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.cast.models.Student;
import br.com.cast.models.StudentDAO;

@ManagedBean(name = "logincontroller")
@SessionScoped
public class LoginController {

	private StudentDAO studentDAO;
	private Student student;
	private HttpSession session;

	public LoginController() {
		student = new Student();
		studentDAO = new StudentDAO();
	}

	public String login() {
		Student studentLog = studentDAO.searchForLogin(student.getUsername(), student.getPassword());
		if (studentLog == null) {
			return "login";
		}
		session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		session.setAttribute("logged", studentLog);
		student = null;
		return "/tofilter/resultado";
	}

	public Student getStudent() {
		return student;
	}

}
