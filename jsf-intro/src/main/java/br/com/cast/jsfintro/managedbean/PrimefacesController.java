package br.com.cast.jsfintro.managedbean;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="prime")
public class PrimefacesController {
	
	private String texto1;
	private String texto2;

	public void submit() {
		System.out.println(texto1);
		System.out.println(texto2);
	}
	
	public String getTexto1() {
		return texto1;
	}

	public void setTexto1(String texto1) {
		this.texto1 = texto1;
	}

	public String getTexto2() {
		return texto2;
	}

	public void setTexto2(String texto2) {
		this.texto2 = texto2;
	}

}
