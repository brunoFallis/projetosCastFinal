package br.com.cast.jsfintro.lifecycle;

import java.util.ArrayList;
import java.util.List;

public class Principal {
	
	public static void main(String[] args) {
		new CicloDeVida().executar();
	}
	
}

class CicloDeVida {
	
	private Fase[] fases = new Fase[] {
		new RestoreView(),
		new ApplyRequestValues(), 
		new ProcessValidation()
	};
	
	public void executar() {
		for (Fase fase : fases) {
			fase.executaFase();
		}
	}

}

abstract class Fase {
	
	public abstract void executaFase();
	
}

class RestoreView extends Fase {
	
	@Override
	public void executaFase() {
		//simulando a fase de restore view
		System.out.println("Recuperando ViewRoot");
	}
	
}

class ApplyRequestValues extends Fase {

	@Override
	public void executaFase() {
		//recupera o viewroot e percorro toda a estrutura
		Component viewRoot = FacesContext.getInstance().getViewRoot();
		viewRoot.processDecode();
	}
	
}

class ProcessValidation extends Fase {
	
	@Override
	public void executaFase() {
		Component viewRoot = FacesContext.getInstance().getViewRoot();
		viewRoot.validate();
	}
	
}

class FacesContext {
	
	private Component viewRoot;
	private static FacesContext instance = new FacesContext();
	
	
	private FacesContext() {
		//simulação de uma view criada previamente (arvore)
		viewRoot = new Component();
		
		UIForm form2 = new UIForm();
		form2.children.add(new UISelect());
		
		UIInput input = new UIInput();
		input.children.add(new UIInput());
		input.children.add(form2);
		
		UIForm form =  new UIForm();
		form.children.add(input);
		form.children.add(new UISelect());
		
		viewRoot.children.add(form);
	}
	
	public Component getViewRoot() {
		return viewRoot;
	}
	
	public static FacesContext getInstance() {
		return instance;
	}
	
}

class Component {
	
	public List<Component> children = new ArrayList<>();
	protected String tipo;
	
	public void processDecode() {
		if (children.size() > 0) {
			for (Component component : children) {
				component.processDecode();
			}
		}
	}
	
	public void validate() {
		if (children.size() > 0) {
			for (Component component : children) {
				component.validate();
			}
		}
	}
	
}

class UIForm extends Component {
	public UIForm() {
		this.tipo = "Form";
	}
	
	public void processDecode() {
		System.out.println("process decode do Form");
		super.processDecode();
	}
	
	public void validate() {
		System.out.println("validate do UIForm");
		super.validate();
	}
	
}

class UIInput extends Component {
	
	public UIInput() {
		this.tipo = "Input";
	}
	
	public void processDecode() {
		System.out.println("process decode do UIInput");
		super.processDecode();
	}
	
	public void validate() {
		System.out.println("validate do UIInput");
		super.validate();
	}
	
}

class UISelect extends Component {
	
	public UISelect() {
		this.tipo = "Select";
	}
	
	public void processDecode() {
		System.out.println("process decode do UISelect");
		super.processDecode();
	}
	
	public void validate() {
		System.out.println("validate do UISelect");
		super.validate();
	}
	
}


