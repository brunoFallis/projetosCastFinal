package br.com.cast.jsfprova.managedbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.cast.jsfprova.business.AutorBusiness;
import br.com.cast.jsfprova.business.CategoriaBusiness;
import br.com.cast.jsfprova.business.LivroBusiness;
import br.com.cast.jsfprova.dto.AutorDTO;
import br.com.cast.jsfprova.dto.CategoriaDTO;
import br.com.cast.jsfprova.dto.LivroDTO;
import br.com.cast.jsfprova.execeptions.InvalidTitleException;

@ManagedBean(name = "cadastro")
public class CadastroController {

	private LivroDTO livroDTO;
	private LivroBusiness livroBusiness;

	private List<AutorDTO> autores;
	private AutorBusiness autorBusiness;
	
	private List<CategoriaDTO> categorias;
	private CategoriaBusiness categoriaBusiness ;

	@PostConstruct
	public void posConstruct() {
		this.livroDTO = new LivroDTO();
		this.autorBusiness = new AutorBusiness();
		this.categoriaBusiness = new CategoriaBusiness();
		this.livroBusiness = new LivroBusiness();
		carregaAutores();
		carregaCategorias();
	}
	
	public String initEdit(Integer id) {
		this.livroDTO = livroBusiness.buscaLivro(id);
		return "addOrEdit";
	}
	
	public void salvar() {
		try {
			System.out.println(livroDTO.getPublicacao());
			this.livroBusiness.salvar(livroDTO);
			String msg = String.format("Registro %s com sucesso", 
					livroDTO.getId() != null ? "alterado" : "inserido");
			
			FacesContext.getCurrentInstance().addMessage("mensagens", 
					new FacesMessage(FacesMessage.SEVERITY_INFO, 
							msg, msg));
			
		} catch (InvalidTitleException e) {
			FacesContext.getCurrentInstance().addMessage("mensagens", 
					new FacesMessage(FacesMessage.SEVERITY_INFO, 
							e.getMessage(),e.getMessage() ));
		}
		
		
	}

	public List<AutorDTO> getAutores() {
		return autores;
	}

	public void carregaAutores() {
		this.autores = autorBusiness.buscaTodos();
	}
	
	public List<CategoriaDTO> getCategorias() {
		return categorias;
	}

	public void carregaCategorias() {
		this.categorias = categoriaBusiness.buscaTodos();
	}

	public LivroDTO getLivroDTO() {
		return livroDTO;
	}

}
