package br.com.guarani.api.controller;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import br.com.guarani.api.exception.EntidadeJaExisteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.guarani.api.controller.dto.PerfilUsuario;
import br.com.guarani.api.controller.dto.UsuarioListagemDto;
import br.com.guarani.api.controller.form.UsuarioCadastro;
import br.com.guarani.api.model.Usuario;
import br.com.guarani.api.service.UsuarioService;




@RestController
@RequestMapping("/usuarios")
public class UsuarioController {


	@Autowired
	private UsuarioService usuarioService;

	@PostMapping("/cadastrar")
	public ResponseEntity<?> cadastrar(@RequestBody @Valid UsuarioCadastro usuarioDto){
		try{
			Usuario usuarioSalvo = usuarioService.salvar(usuarioDto.converterCadastro());
			return new ResponseEntity(usuarioSalvo, HttpStatus.CREATED);
		}catch (EntidadeJaExisteException e){
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}


	}

	@GetMapping("/listar")
	public Page<UsuarioListagemDto> listar(
			@PageableDefault(page = 0, size = 15) Pageable paginacao){

		Page<Usuario> pesquisadores = usuarioService.listaUsuario(paginacao);
		
		return UsuarioListagemDto.converter(pesquisadores);
	}
	
	
	//Enpoint para pegar as informações do usuario que foi logado
	@GetMapping("/perfil")
	public Optional<UsuarioListagemDto>  infoUsuario(@AuthenticationPrincipal Usuario logado) {
		Optional<Usuario> usuarioSalvo = usuarioService.GetInfoUsuario(logado.getId_usuario());

		return PerfilUsuario.converterPerfil(usuarioSalvo);
	}
	
	
	
	@GetMapping("/id/{id}")
	public Optional<UsuarioListagemDto>  buscaPorId(@PathVariable Long id) {
		Optional<Usuario> usuarioSalvo = usuarioService.GetInfoUsuario(id);

		return PerfilUsuario.converterPerfil(usuarioSalvo);
	}


	
//	@PutMapping("/instCadastro")
//	public ResponseEntity<Usuario> adicionarAreaConhecimento(@RequestBody Usuario novo, @AuthenticationPrincipal Usuario logado) {
//		
//		novo = logado;
//		novo = usuarioRepository.save(novo);
//		return ResponseEntity.ok(novo);
//	} 
//	
//	@PostMapping("/usuarioComImagem")
//	public void cadastrarUserImg(@RequestParam MultipartFile imagem){
//		
//		
//	
//		disco.salvarFoto(imagem);
//		
//		
//	
//	}
//	

	
	
	

}
