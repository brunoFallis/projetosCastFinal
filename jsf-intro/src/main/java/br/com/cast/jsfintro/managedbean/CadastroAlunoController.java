package br.com.cast.jsfintro.managedbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.cast.jsfintro.business.AlunoBusiness;
import br.com.cast.jsfintro.business.ProfessorBusiness;
import br.com.cast.jsfintro.dto.AlunoDTO;
import br.com.cast.jsfintro.dto.ProfessorDTO;

@ManagedBean(name = "cadastroController")
public class CadastroAlunoController {
	
	private AlunoDTO alunoDTO;
	private List<ProfessorDTO> professores;
	
	private AlunoBusiness alunoBusiness;
	private ProfessorBusiness professorBusiness;
	
	/**
	 * chamado pelo JSF
	 */
	@PostConstruct
	public void aposConstrucao() {
		this.alunoDTO = new AlunoDTO();
		this.alunoBusiness = new AlunoBusiness();
		this.professorBusiness = new ProfessorBusiness();
		this.professores = professorBusiness.buscarTodos();
	}
	
	public String initEdicao(Integer id) {
		alunoDTO = alunoBusiness.buscarPorId(id);
		return "edit";
	}
	
	public void salvar() {
		alunoBusiness.salvar(alunoDTO);
		String msg = String.format("Registro %s com sucesso", 
				alunoDTO.getId() != null ? "alterado" : "inserido");
		
		FacesContext.getCurrentInstance().addMessage("mensagens", 
				new FacesMessage(FacesMessage.SEVERITY_INFO, 
						msg, msg));
		
		alunoDTO = new AlunoDTO();
	}
	
	public List<ProfessorDTO> getProfessores() {
		return professores;
	}
	
	public AlunoDTO getAlunoDTO() {
		return alunoDTO;
	}
	
}
