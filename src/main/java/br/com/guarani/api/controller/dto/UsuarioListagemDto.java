package br.com.guarani.api.controller.dto;

import java.util.List;

import org.springframework.data.domain.Page;

import br.com.guarani.api.model.Especialidade;
import br.com.guarani.api.model.Estudos;
import br.com.guarani.api.model.Instituicao;
import br.com.guarani.api.model.Producao;
import br.com.guarani.api.model.Usuario;

public class UsuarioListagemDto {

	private Long id_usuario;
	private String nome;

	private String email;
private Especialidade especialidade;

	private List<Estudos> SolicitacaoEnviada;

	private List<Estudos> SolicitacaoRecebidas;

	private List<Instituicao> instituicoes;
	private List<Producao> producoes;
	
	
	public UsuarioListagemDto(Usuario usuario) {
		this.id_usuario = usuario.getId_usuario();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.instituicoes = usuario.getInstituicoes();
		this.especialidade = usuario.getEspecialidade();
		
		this.SolicitacaoEnviada = usuario.getSolicitacaoEnviada();
		this.SolicitacaoRecebidas=usuario.getSolicitacaoRecebidas();
		this.producoes = usuario.getProducoes();
	}

	

	public String getNome() {
		return nome;
	}



	public Long getId_usuario() {
		return id_usuario;
	}



	public String getEmail() {
		return email;
	}






	public Especialidade getEspecialidade() {
		return especialidade;
	}





	public List<Estudos> getSolicitacaoEnviada() {
		return SolicitacaoEnviada;
	}



	public List<Estudos> getSolicitacaoRecebidas() {
		return SolicitacaoRecebidas;
	}



	public List<Instituicao> getInstituicoes() {
		return instituicoes;
	}



	public List<Producao> getProducoes() {
		return producoes;
	}



	// metodo usado na listagem de usuario
	public static Page<UsuarioListagemDto> converter(Page<Usuario> usuarios) {

		return usuarios.map(UsuarioListagemDto::new);

	}
	

	
	

}
