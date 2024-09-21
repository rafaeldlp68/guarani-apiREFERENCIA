package br.com.guarani.api.controller.dto;

import org.springframework.data.domain.Page;

import br.com.guarani.api.model.Instituicao;

public class InstituicaoDto {

	private Long id_instituicao;
	private String nomeInstituicao;
	private String endereco;

	
	
	
	public InstituicaoDto(Instituicao instituicao) {
		this.id_instituicao = instituicao.getId_instituicao();
		this.nomeInstituicao = instituicao.getNomeInstituicao();
		this.endereco = instituicao.getEndereco();
	}
	
	//metodo usado na listagem de usuario
	public static Page<InstituicaoDto> converter(Page<Instituicao> instituicoes) {
		
		return instituicoes.map(InstituicaoDto::new);

	}

	public Long getId_instituicao() {
		return id_instituicao;
	}

	public String getNomeInstituicao() {
		return nomeInstituicao;
	}

	public String getEndereco() {
		return endereco;
	}	
	
	
	
	
	
	
	
}
