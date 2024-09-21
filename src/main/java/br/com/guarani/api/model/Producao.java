package br.com.guarani.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import br.com.guarani.api.model.enuns.EnumTipoProducao;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id_producao")
public class Producao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name="increment", strategy="increment")
	private Long id_producao;
	@NotBlank
	private String titulo;
	
	private Integer ano;
	@NotBlank
	private String resumo;

	private String orientador;
	
	private Boolean solicitacaoAceite;
	
	private String linkPublicacao;

	@Enumerated(EnumType.STRING)
	private EnumTipoProducao tipoProducao;
	
	
	@ManyToOne
	@JoinColumn(name = "fk_usuario")
	private Usuario usuario;
	

	@ManyToOne
	@JoinColumn(name = "fk_area_conhecimento")
	private AreaConhecimento areaConhecimento;
	
	@ManyToOne
	@JoinColumn(name = "fk_instituicao")
	private Instituicao instituicao;

	public Producao(String titulo, Integer ano, String resumo, String orientador, AreaConhecimento areaConhecimento) {

		this.titulo = titulo;
		this.ano = ano;
		this.resumo = resumo;
		this.orientador = orientador;
		this.areaConhecimento = areaConhecimento;

	}

	public Producao(String titulo, Integer ano, String resumo, String orientador,String linkPublicacao, EnumTipoProducao tipoProducao,
			Usuario usuario, AreaConhecimento areaConhecimento, Instituicao instituicao) {

		this.titulo = titulo;
		this.linkPublicacao = linkPublicacao;
		this.ano = ano;
		this.resumo = resumo;
		this.orientador = orientador;
		this.tipoProducao = tipoProducao;
		this.usuario = usuario;
		this.areaConhecimento = areaConhecimento;
		this.instituicao = instituicao;
	}

	public Producao() {
		super();
	}



	public String getLinkPublicacao() {
		return linkPublicacao;
	}

	public void setLinkPublicacao(String linkPublicacao) {
		this.linkPublicacao = linkPublicacao;
	}

	public Boolean getSolicitacaoAceite() {
		return solicitacaoAceite;
	}

	public void setSolicitacaoAceite(Boolean solicitacaoAceite) {
		this.solicitacaoAceite = solicitacaoAceite;
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

	//@JsonIgnore
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

	public Long getId_producao() {
		return id_producao;
	}

}
