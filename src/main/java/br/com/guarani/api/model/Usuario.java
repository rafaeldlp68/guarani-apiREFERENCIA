package br.com.guarani.api.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id_usuario")
public class Usuario implements UserDetails{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name="increment", strategy="increment")
	private Long id_usuario;

	@NotBlank
	private String nome;
	@NotBlank
	@Email
	private String email;
	@NotBlank
	private String senha;
	
	private String linkLattes;

	@ManyToMany(fetch = FetchType.EAGER)
	private List<Perfil> perfis = new ArrayList<>();


	@ManyToMany
	@JoinTable(name = "usuario_instituicao", joinColumns = @JoinColumn(name = "id_usuario") , inverseJoinColumns = @JoinColumn(name = "id_instituicao"))
	private List<Instituicao> instituicoes;


	@OneToMany(mappedBy = "usuario", orphanRemoval = true)
	private List<Producao> producoes;
	
	
	@OneToOne(mappedBy="usuario")
	private Especialidade especialidade;
	
	
	@OneToMany
	@JoinColumn(name="fk_usuario_solicitante")
	private List<Estudos> solicitacaoEnviada;
	
	@OneToMany
	@JoinColumn(name="fk_usuario_receber")
	private List<Estudos> solicitacaoRecebidas;


	@PrePersist
	public void codificarSenha() {
		this.senha = new BCryptPasswordEncoder().encode(this.senha);
	}

	public Usuario(String nome , String email, String senha) {

		this.nome = nome;
		this.email = email;
		this.senha = senha;

	}

	public Usuario(){}

	@JsonIgnore
	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

	public String getLinkLattes() {
		return linkLattes;
	}

	public void setLinkLattes(String linkLattes) {
		this.linkLattes = linkLattes;
	}
	@JsonIgnore
	public List<Estudos> getSolicitacaoEnviada() {
		return solicitacaoEnviada;
	}

	public void setSolicitacaoEnviada(List<Estudos> solicitacaoEnviada) {
		this.solicitacaoEnviada = solicitacaoEnviada;
	}
	@JsonIgnore
	public List<Estudos> getSolicitacaoRecebidas() {
		return solicitacaoRecebidas;
	}

	public void setSolicitacaoRecebidas(List<Estudos> solicitacaoRecebidas) {
		this.solicitacaoRecebidas = solicitacaoRecebidas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email.toLowerCase();
	}
	@JsonIgnore
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	@JsonIgnore
	public List<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}
	@JsonIgnore
	public List<Instituicao> getInstituicoes() {
		return instituicoes;
	}

	public void setInstituicoes(List<Instituicao> instituicoes) {
		this.instituicoes = instituicoes;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	@JsonIgnore
	public List<Producao> getProducoes() {
		return producoes;
	}

	public void setProducoes(List<Producao> producoes) {
		this.producoes = producoes;
	}

	public Long getId_usuario() {
		return id_usuario;
	}

	@JsonIgnore
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.perfis;
	}
	@JsonIgnore
	@Override
	public String getPassword() {

		return this.senha;
	}
	@JsonIgnore
	@Override
	public String getUsername() {

		return this.email;
	}
	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {

		return true;
	}
	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {

		return true;
	}
	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}
	@JsonIgnore
	@Override
	public boolean isEnabled() {

		return true;
	}

}
