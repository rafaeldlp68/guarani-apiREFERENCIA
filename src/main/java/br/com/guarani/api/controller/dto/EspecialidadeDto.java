package br.com.guarani.api.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.guarani.api.model.AreaConhecimento;
import br.com.guarani.api.model.Especialidade;
import br.com.guarani.api.model.Habilidade;
import br.com.guarani.api.model.Producao;
import br.com.guarani.api.model.Usuario;

public class EspecialidadeDto {
	


	private Long id_especialidade;

	private Usuario usuario;
	private List<AreaConhecimento> areaConhecimento;

	private List<Habilidade> habilidades;
	
	
	
	
	public EspecialidadeDto(Especialidade especialidade) {

		this.id_especialidade = especialidade.getId_especialidade();
		this.usuario = especialidade.getUsuario();
		this.areaConhecimento = especialidade.getAreaConhecimento();
		this.habilidades = especialidade.getHabilidades();
	}



	public static List<EspecialidadeDto> converter(List<Especialidade> especialidade) {
		
		return especialidade.stream().map(EspecialidadeDto::new).collect(Collectors.toList());

	}
	
	

	public Long getId_especialidade() {
		return id_especialidade;
	}

	public void setId_especialidade(Long id_especialidade) {
		this.id_especialidade = id_especialidade;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<AreaConhecimento> getAreaConhecimento() {
		return areaConhecimento;
	}

	public void setAreaConhecimento(List<AreaConhecimento> areaConhecimento) {
		this.areaConhecimento = areaConhecimento;
	}

	public List<Habilidade> getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(List<Habilidade> habilidades) {
		this.habilidades = habilidades;
	}



}
