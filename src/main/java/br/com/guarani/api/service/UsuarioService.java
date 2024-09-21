package br.com.guarani.api.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.guarani.api.model.Usuario;
import br.com.guarani.api.repository.UsuarioRepository;
import br.com.guarani.api.exception.EntidadeJaExisteException;


@Service
public class UsuarioService {
	
	
	private final UsuarioRepository usuarioRepository;

	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	

	public Usuario salvar(Usuario usuario) throws EntidadeJaExisteException {
		
		boolean emailEmUso = usuarioRepository.findByEmail(usuario.getEmail())
				.stream()
				.anyMatch(usuarioExistente -> !usuarioExistente.equals(usuario));

		if(emailEmUso) {
			throw new EntidadeJaExisteException(String.format("Já existe um cliente cadastrado com esse E-mail"));
		}
		return usuarioRepository.save(usuario);

	}
	
	
	public Page<Usuario> listaUsuario(Pageable paginacao){
		Page<Usuario> pesquisadores = usuarioRepository.findAll(paginacao);
		return pesquisadores;
	}
	
	
	public Optional<Usuario> GetInfoUsuario(Long idUsuario) {
		Optional<Usuario> usuarioInfo = usuarioRepository.findById(idUsuario);
		return usuarioInfo;
	}
	

	

}
