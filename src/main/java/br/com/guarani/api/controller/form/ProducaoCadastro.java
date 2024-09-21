package br.com.guarani.api.controller.form;

import br.com.guarani.api.model.AreaConhecimento;
import br.com.guarani.api.model.Instituicao;
import br.com.guarani.api.model.Producao;
import br.com.guarani.api.model.Usuario;
import br.com.guarani.api.model.enuns.EnumTipoProducao;

public class ProducaoCadastro {
	
	private String titulo;
	private Integer ano;
	private String resumo;
	private String orientador;
	private EnumTipoProducao tipoProducao;
	private Usuario usuario;
	private AreaConhecimento areaConhecimento;
	private Instituicao instituicao;
	private String linkPublicacao;
	
	
	
	
	
	
	public String getLinkPublicacao() {
		return linkPublicacao;
	}
	public void setLinkPublicacao(String linkPublicacao) {
		this.linkPublicacao = linkPublicacao;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	public String getResumo() {
		return resumo;
	}
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}
	public String getOrientador() {
		return orientador;
	}
	public void setOrientador(String orientador) {
		this.orientador = orientador;
	}
	public EnumTipoProducao getTipoProducao() {
		return tipoProducao;
	}
	public void setTipoProducao(EnumTipoProducao tipoProducao) {
		this.tipoProducao = tipoProducao;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public AreaConhecimento getAreaConhecimento() {
		return areaConhecimento;
	}
	public void setAreaConhecimento(AreaConhecimento areaConhecimento) {
		this.areaConhecimento = areaConhecimento;
	}
	public Instituicao getInstituicao() {
		return instituicao;
	}
	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}
	
	
	public  Producao converterCadastro() {
		
		return new Producao(titulo, ano, resumo, orientador,linkPublicacao,tipoProducao,usuario, areaConhecimento,
				 instituicao);
		
	}
	

}
