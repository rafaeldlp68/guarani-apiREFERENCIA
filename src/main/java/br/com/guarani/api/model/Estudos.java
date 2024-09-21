package br.com.guarani.api.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import br.com.guarani.api.model.enuns.StatusSoliciatacoes;
@Entity
public class Estudos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_estudos;
	private String sobre;
	private String comentario;
	
	
	
	@Enumerated(EnumType.STRING)
	private StatusSoliciatacoes solicitacoesStatus;
	
	
	private Long fk_usuario_solicitante;//id do usuario dono da solicitação
	
	private Long fk_usuario_receber; //id do usuario que vai receber a soilicitação
	
	
	
	
	
	
	public Estudos(Long id_estudos, StatusSoliciatacoes solicitacoesStatus) {
	
		this.id_estudos = id_estudos;
		this.solicitacoesStatus = solicitacoesStatus;
	}
	
	
	
	
	public Estudos() {
		
	}




	@ManyToMany
    @JoinTable(
            name = "estudos_habilidade",
            joinColumns = @JoinColumn(name = "id_estudos"),
            inverseJoinColumns = @JoinColumn(name = "id_habilidade"))
	private List<Habilidade> habilidades;
	
	
	
	
	


	
	public Long getFk_usuario_solicitante() {
		return fk_usuario_solicitante;
	}


	public Long getFk_usuario_receber() {
		return fk_usuario_receber;
	}
	
	
	
	public void setFk_usuario_receber(Long fk_usuario_receber) {
		this.fk_usuario_receber = fk_usuario_receber;
	}
	public void setFk_usuario_solicitante(Long fk_usuario_solicitante) {
		this.fk_usuario_solicitante = fk_usuario_solicitante;
	}
	
	
	
	public void setId_estudos(Long id_estudos) {
		this.id_estudos = id_estudos;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	


	public List<Habilidade> getHabilidades() {
		return habilidades;
	}
	public void setHabilidades(List<Habilidade> habilidades) {
		this.habilidades = habilidades;
	}
	public String getSobre() {
		return sobre;
	}
	public void setSobre(String sobre) {
		this.sobre = sobre;
	}
	public Long getId_estudos() {
		return id_estudos;
	}
	public StatusSoliciatacoes getSolicitacoesStatus() {
		return solicitacoesStatus;
	}
	public void setSolicitacoesStatus(StatusSoliciatacoes solicitacoesStatus) {
		this.solicitacoesStatus = solicitacoesStatus;
	}
	
	
	
	
	
	
	
}
