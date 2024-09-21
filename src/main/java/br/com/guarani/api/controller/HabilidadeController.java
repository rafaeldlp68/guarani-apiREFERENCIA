package br.com.guarani.api.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.guarani.api.model.Habilidade;
import br.com.guarani.api.repository.filtros.HabilidadeCustomRepository;
import br.com.guarani.api.service.HabilidadeService;

@RestController
@RequestMapping("/habilidades")
public class HabilidadeController {

	
	@Autowired
	private HabilidadeCustomRepository habilidadeCustomRepository;
	@Autowired	
	private HabilidadeService habilidadeService; 

	@PostMapping("/criar")
	@Transactional
	public ResponseEntity<Habilidade> cadastro(@RequestBody @Valid  Habilidade habilidade){
		
		Habilidade habilidadeSalva = habilidadeService.salvarHabilidade(habilidade);
		
		return new ResponseEntity<>	(habilidadeSalva, HttpStatus.CREATED);
	}
	
	@GetMapping("/listar")
	public Page<Habilidade> listar(Pageable paginacao){
		Page<Habilidade> habilidades = habilidadeService.listarTudo(paginacao);
		return habilidades;
	}
	
	
	@GetMapping("/filtro/{id}")
	public List<Habilidade> listarComFiltro(@PathVariable Long id){
		System.out.println(id);
		return this.habilidadeCustomRepository.bucarHabilidadeFiltro(id);
	}
	
	
}
