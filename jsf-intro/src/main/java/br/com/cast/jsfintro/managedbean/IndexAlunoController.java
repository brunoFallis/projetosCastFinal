package br.com.cast.jsfintro.managedbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.cast.jsfintro.business.AlunoBusiness;
import br.com.cast.jsfintro.dto.AlunoDTO;

/**
 * um bean tem:
 * - construtor default
 * - getter e setters
 * @author Cast
 */
@ManagedBean(name = "indexController")
public class IndexAlunoController {
	
	private AlunoBusiness alunoBusiness;
	private List<AlunoDTO> listagemDeAlunos;
	
	public IndexAlunoController() {
		//default
	}
	
	/**
	 * chamado pelo JSF
	 */
	@PostConstruct
	public void aposConstrucao() {
		this.alunoBusiness = new AlunoBusiness();
		carregarAlunos();
	}
	
	public void excluir(Integer id) {
		alunoBusiness.excluir(id);
		carregarAlunos();
		String msg = "Registro excluído com sucesso!";
		FacesContext.getCurrentInstance().addMessage("mensagens", 
				new FacesMessage(FacesMessage.SEVERITY_INFO, 
						msg, msg));
	}

	private void carregarAlunos() {
		listagemDeAlunos = alunoBusiness.buscarTodos();
	}
	
	public List<AlunoDTO> getListagemDeAlunos() {
		return listagemDeAlunos;
	}
	
	public void test() {
		System.out.println("chamando!");
	}
	
}
