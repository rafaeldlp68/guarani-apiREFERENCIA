package br.com.guarani.api.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class AreaConhecimento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_area_conhecimento;
	private String nomeArea;
	
	@OneToMany(mappedBy = "areaConhecimento")
	private List<Producao> producoes;

	@ManyToMany(mappedBy = "areaConhecimento")
	private List<Especialidade> especialidades;

	@OneToMany
	@JoinColumn(name = "id_area_conhecimento") 
	private List<Habilidade> habilidades;

	@JsonIgnore
	public List<Habilidade> getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(List<Habilidade> habilidades) {
		this.habilidades = habilidades;
	}

	@JsonIgnore
	public List<Especialidade> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(List<Especialidade> especialidades) {
		this.especialidades = especialidades;
	}

	@JsonIgnore
	public List<Producao> getProducoes() {
		return producoes;
	}

	//Construtores
	public AreaConhecimento(String nomeArea) {
	
		this.nomeArea = nomeArea;
	}

	public AreaConhecimento() {

	}

	public void setProducoes(List<Producao> producoes) {
		this.producoes = producoes;
	}

	
	public Long getId_area_conhecimento() {
		return id_area_conhecimento;
	}

	public String getNomeArea() {
		return nomeArea;
	}

	public void setNomeArea(String nomeArea) {
		this.nomeArea = nomeArea;
	}

	public void setId_area_conhecimento(Long id_area_conhecimento) {
		this.id_area_conhecimento = id_area_conhecimento;
	}
}
