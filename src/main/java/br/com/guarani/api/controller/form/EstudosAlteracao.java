package br.com.guarani.api.controller.form;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.guarani.api.model.Estudos;
import br.com.guarani.api.model.enuns.StatusSoliciatacoes;

public class EstudosAlteracao {
	private Long id_estudos;
	
	@Enumerated(EnumType.STRING)
	private StatusSoliciatacoes solicitacoesStatus;
	
	
	
	public Estudos alterarEstatus() {
		
		return new Estudos(id_estudos, solicitacoesStatus);
		
	}



	public Long getId_estudos() {
		return id_estudos;
	}



	public StatusSoliciatacoes getSolicitacoesStatus() {
		return solicitacoesStatus;
	}
	
	
	
	
}
