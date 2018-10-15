package br.com.cast.jsfintro.business;

import java.util.List;

import br.com.cast.jsfintro.dto.ProfessorDTO;
import br.com.cast.jsfintro.entidade.Professor;
import br.com.cast.jsfintro.persistencia.ProfessorDao;

//biznes
public class ProfessorBusiness {
	
	private ProfessorDao professorDao;
	
	public ProfessorBusiness() {
		this.professorDao = new ProfessorDao();
	}
	
	public List<ProfessorDTO> buscarTodos() {
		//com pojo
		List<ProfessorDTO> professoresDTO = professorDao.buscarTodosComPojo();
		
		//sem pojo
		/*List<Professor> professores = professorDao.buscarTodos();
		List<ProfessorDTO> professoresDTO = new ArrayList<>();
		
		for (Professor professor : professores) {
			ProfessorDTO dto = new ProfessorDTO();
			dto.setId(professor.getId());
			dto.setMateria(professor.getMateria());
			dto.setNome(professor.getNome());
			professoresDTO.add(dto);
		}*/
		
		return professoresDTO;
	}
	
	public Professor buscarPorId(Integer idProfessor) {
		return professorDao.buscarPorId(idProfessor);
	}

}
