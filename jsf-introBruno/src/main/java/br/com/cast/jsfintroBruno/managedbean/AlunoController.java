package br.com.cast.jsfintroBruno.managedbean;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.cast.models.Student;
import br.com.cast.models.StudentDAO;

@ManagedBean(name = "alunocontroller")
public class AlunoController {

	private StudentDAO studentDAO;
	private List<Student> students;
	HttpSession session;

	public AlunoController() {
		
	}

	@PostConstruct
	public void postContruct() {
		this.studentDAO = new StudentDAO();
		this.loadList();
	}
	
	public void loadList() {
		this.students = studentDAO.alunos();
	}
	
	public String deleteStudent(Student student) throws IOException {
		studentDAO.removeStudent(student);
		loadList();
		return "/tofilter/resultado";
	}
	
	public List<Student> getStudents(){
		return students;
	}
	
	public String viewEdit(Student student, boolean op) throws IOException {
		session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		
		session.setAttribute("isDisabled", op);
		
		session.setAttribute("student", student);
		
		return "/tofilter/viewEditPage";
	}

}
