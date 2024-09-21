package br.com.guarani.api.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Especialidade {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_especialidade;
	
	
	
	@OneToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
	

	@ManyToMany
	@JoinTable(name = "especialidades_usuario", joinColumns = @JoinColumn(name = "id_especialidade"), inverseJoinColumns = @JoinColumn(name = "id_area_conhecimento"))
	private List<AreaConhecimento> areaConhecimento;
	

	
	@ManyToMany
	@JoinTable(name = "habilidade_usuario", joinColumns = @JoinColumn(name = "id_especialidade"), inverseJoinColumns = @JoinColumn(name = "id_habilidade"))
	private List<Habilidade> habilidades;



	public Long getId_especialidade() {
		return id_especialidade;
	}

	
	@JsonIgnore
	public Usuario getUsuario() {
		return usuario;
	}



	public List<AreaConhecimento> getAreaConhecimento() {
		return areaConhecimento;
	}



	public void setId_especialidade(Long id_especialidade) {
		this.id_especialidade = id_especialidade;
	}


	public List<Habilidade> getHabilidades() {
		return habilidades;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	public void setAreaConhecimento(List<AreaConhecimento> areaConhecimento) {
		this.areaConhecimento = areaConhecimento;
	}



	public void setHabilidades(List<Habilidade> habilidades) {
		this.habilidades = habilidades;
	}
	


	
	





}