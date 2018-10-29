package br.com.cast.jsfprova.managedbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.cast.jsfprova.business.LivroBusiness;
import br.com.cast.jsfprova.dto.LivroDTO;
import br.com.cast.jsfprova.entidade.Livro;

@ManagedBean(name="indexlivro")
public class IndexLivroController {
	
	private List<LivroDTO> livros;
	private LivroBusiness livroBusiness;
	
	@PostConstruct
	public void posContruct() {
		this.livroBusiness = new LivroBusiness();
		this.carregaLivros();
	}

	public List<LivroDTO> getLivros() {
		return livros;
	}
	
	public void carregaLivros() {
		this.livros = livroBusiness.buscaTodos();
	}
	
	public void delete(Integer id) {
		livroBusiness.deleteLivro(id);
		carregaLivros();
		String msg = "Registro excluido com sucesso";
		FacesContext.getCurrentInstance().addMessage("mensagens", 
				new FacesMessage(FacesMessage.SEVERITY_INFO, 
						msg,msg));
	}
	
}
