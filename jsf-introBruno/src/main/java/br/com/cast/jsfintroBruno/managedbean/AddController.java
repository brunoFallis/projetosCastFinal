package br.com.cast.jsfintroBruno.managedbean;

import javax.faces.bean.ManagedBean;

import br.com.cast.models.Student;
import br.com.cast.models.StudentDAO;

@ManagedBean(name="addcontroller")
public class AddController {
	
	private StudentDAO studentDAO;
	private Student student;
	
	public AddController() {
		this.studentDAO = new StudentDAO();
		this.student = new Student();
	}
	
	public Student getStudent() {
		return this.student;
	}
	
	public String insereStudent() {
		this.studentDAO.insertAluno(this.student);
		return "login";
	}
	
}
