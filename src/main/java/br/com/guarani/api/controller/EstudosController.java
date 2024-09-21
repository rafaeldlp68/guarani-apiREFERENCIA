package br.com.guarani.api.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.guarani.api.model.Estudos;
import br.com.guarani.api.model.Usuario;
import br.com.guarani.api.model.enuns.StatusSoliciatacoes;
import br.com.guarani.api.repository.EstudosRepository;

@RestController
@RequestMapping("/estudos")
public class EstudosController {
	
	@Autowired
	private EstudosRepository estudosRepository;
	
	
	
	@GetMapping("/listar")
	public List<Estudos> listar(){
		
		List<Estudos> estudos = estudosRepository.findAll();
		
		return estudos;
	}
	
	
	
	@PostMapping("/criar")
	@Transactional
	public ResponseEntity<Estudos> cadastrar(@RequestBody @Valid Estudos estudos, @AuthenticationPrincipal Usuario logado){
		estudos.setFk_usuario_solicitante(logado.getId_usuario());
		estudos.setSolicitacoesStatus(StatusSoliciatacoes.PENDENTE);
		Estudos estudosSalvo = estudosRepository.save(estudos);
		
		
		return new ResponseEntity<>(estudosSalvo, HttpStatus.CREATED);
	}
	
	
	@PutMapping("/alterStatus")
	@Transactional
	public  ResponseEntity<?> alterarStatus(@RequestBody @Valid Estudos estudos){
		
		Optional<Estudos> findEstudo = estudosRepository.findById(estudos.getId_estudos());
		findEstudo.get().setSolicitacoesStatus(estudos.getSolicitacoesStatus());
		
		return new ResponseEntity<>(findEstudo,HttpStatus.ACCEPTED);
	}

}
