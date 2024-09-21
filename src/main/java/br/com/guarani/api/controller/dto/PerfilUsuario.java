package br.com.guarani.api.controller.dto;

import java.util.List;
import java.util.Optional;

import br.com.guarani.api.model.Especialidade;
import br.com.guarani.api.model.Estudos;
import br.com.guarani.api.model.Instituicao;
import br.com.guarani.api.model.Producao;
import br.com.guarani.api.model.Usuario;

public class PerfilUsuario {
	

	private Long id_usuario;

	private String nome;

	private String email;

	private String senha;
	
	private String linkLattes;
	
	private String nomeImagem;
	

	private List<Instituicao> instituicoes;

	private List<Producao> producoes;

	private Especialidade especialidade;

	private List<Estudos> solicitacaoEnviada;

	private List<Estudos> solicitacaoRecebidas;
	
	
	
	
	

	public PerfilUsuario(Usuario usuario) {
	
		this.id_usuario = usuario.getId_usuario();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.linkLattes = usuario.getLinkLattes();
		this.instituicoes = usuario.getInstituicoes();
		this.producoes = usuario.getProducoes();
		this.especialidade = usuario.getEspecialidade();
		this.solicitacaoEnviada = usuario.getSolicitacaoEnviada();
		this.solicitacaoRecebidas = usuario.getSolicitacaoRecebidas();
	}

	public Long getId_usuario() {
		return id_usuario;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public String getLinkLattes() {
		return linkLattes;
	}

	public String getNomeImagem() {
		return nomeImagem;
	}

	public List<Instituicao> getInstituicoes() {
		return instituicoes;
	}

	public List<Producao> getProducoes() {
		return producoes;
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public List<Estudos> getSolicitacaoEnviada() {
		return solicitacaoEnviada;
	}

	public List<Estudos> getSolicitacaoRecebidas() {
		return solicitacaoRecebidas;
	}
	
	public static Optional<UsuarioListagemDto> converterPerfil(Optional<Usuario> usuarios) {

		return usuarios.map(UsuarioListagemDto::new);

	}
	

}
