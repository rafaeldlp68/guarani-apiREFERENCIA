package br.com.guarani.api.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Habilidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_habilidade;
	
	private String nomeHabilidade;
	
	
	@ManyToMany(mappedBy = "habilidades")
	private List<Especialidade> especialidades;

	private Long id_area_conhecimento;
	
	@JsonIgnore
	public Long getId_area_conhecimento() {
		return id_area_conhecimento;
	}

	public void setId_area_conhecimento(Long id_area_conhecimento) {
		this.id_area_conhecimento = id_area_conhecimento;
	}

	public String getNomeHabilidade() {
		return nomeHabilidade;
	}

	public void setNomeHabilidade(String nomeHabilidade) {
		this.nomeHabilidade = nomeHabilidade;
	}
	
	
	public Long getId_habilidade() {
		return id_habilidade;
	}

	@JsonIgnore
	public List<Especialidade> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(List<Especialidade> especialidades) {
		this.especialidades = especialidades;
	}
	

	

	
	
	
	
		
}
