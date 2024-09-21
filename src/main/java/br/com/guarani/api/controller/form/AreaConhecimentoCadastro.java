package br.com.guarani.api.controller.form;

import br.com.guarani.api.model.AreaConhecimento;

public class AreaConhecimentoCadastro {
	
	private String nomeArea;
		
	


	public String getNomeArea() {
		return nomeArea;
	}




	public void setNomeArea(String nomeArea) {
		this.nomeArea = nomeArea;
	}




	public AreaConhecimento converterCadastro() {
		
		return new AreaConhecimento(nomeArea);
		
	}

	

}
