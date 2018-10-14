package br.com.cast.jsfintroBruno.managedbean;

import javax.faces.bean.ManagedBean;

import br.com.cast.models.Student;
import br.com.cast.models.StudentDAO;

@ManagedBean(name="edit")
public class ViewEditController {
	
	private StudentDAO studentDao;
	
	public ViewEditController() {
		studentDao = new StudentDAO();
	}
	
	public String updateStudent(Student student) {
		this.studentDao.update(student);
		return "resultado";
	}
	
}
