package br.com.guarani.api.controller.dto;


import java.util.List;
import java.util.stream.Collectors;

import br.com.guarani.api.model.AreaConhecimento;
import br.com.guarani.api.model.Instituicao;
import br.com.guarani.api.model.Producao;
import br.com.guarani.api.model.Usuario;

public class ProducaoDto {

	private Long id_producao;
	private String titulo;
	private Integer ano;
	private String resumo;
	private String orientador;
	private Usuario usuario;
	private AreaConhecimento areaConhecimento;
	private Instituicao instituicao;
	private String linkPublicacao;
	
	
	
	
	
	
	public ProducaoDto(Producao producao) {
		

	this.id_producao = producao.getId_producao();
	this.titulo = producao.getTitulo();
	this.ano = producao.getAno();
	this.resumo = producao.getResumo();
	this.orientador = producao.getOrientador();
	this.usuario = producao.getUsuario();
	this.areaConhecimento = producao.getAreaConhecimento();
	this.instituicao = producao.getInstituicao();
	this.linkPublicacao = producao.getLinkPublicacao();
	}
	
	
	public static List<ProducaoDto> converter(List<Producao> producoes) {
		
		return producoes.stream().map(ProducaoDto::new).collect(Collectors.toList());

	}
	


	
	
	public String getLinkPublicacao() {
		return linkPublicacao;
	}


	public Long getId_producao() {
		return id_producao;
	}
	public String getTitulo() {
		return titulo;
	}
	public Integer getAno() {
		return ano;
	}
	public String getResumo() {
		return resumo;
	}
	public String getOrientador() {
		return orientador;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public AreaConhecimento getAreaConhecimento() {
		return areaConhecimento;
	}


	public Instituicao getInstituicao() {
		return instituicao;
	}

	
	
	

	
	
	
}
