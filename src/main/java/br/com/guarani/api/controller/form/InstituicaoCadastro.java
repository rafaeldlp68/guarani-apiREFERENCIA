package br.com.guarani.api.controller.form;

import br.com.guarani.api.model.Instituicao;

public class InstituicaoCadastro {

	private String nomeInstituicao;
	private String endereco;
	
	public Instituicao converterCadastro() {
		
		return new Instituicao(nomeInstituicao, endereco);
		
	}
	
	
	
	public String getNomeInstituicao() {
		return nomeInstituicao;
	}

	public String getEndereco() {
		return endereco;
	}


}
