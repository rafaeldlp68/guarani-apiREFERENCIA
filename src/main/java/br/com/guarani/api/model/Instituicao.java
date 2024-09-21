package br.com.guarani.api.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Instituicao {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_instituicao;
	@NotBlank
	private String nomeInstituicao;
	@NotBlank
	private String endereco;
	
	
	@OneToMany(mappedBy = "instituicao")
	private List<Producao> producoes;


	public Instituicao(String nomeInstituicao, String endereco) {
		this.nomeInstituicao = nomeInstituicao;
		this.endereco = endereco;
	}



	public Instituicao() {}



	public void setId_instituicao(Long id_instituicao) {
		this.id_instituicao = id_instituicao;
	}

	
	@JsonIgnore
	public List<Producao> getProducoes() {
		return producoes;
	}

	public void setProducoes(List<Producao> producoes) {
		this.producoes = producoes;
	}

	

	public String getNomeInstituicao() {
		return nomeInstituicao;
	}



	public void setNomeInstituicao(String nomeInstituicao) {
		this.nomeInstituicao = nomeInstituicao;
	}



	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Long getId_instituicao() {
		return id_instituicao;
	}
	
	
	
	

}
