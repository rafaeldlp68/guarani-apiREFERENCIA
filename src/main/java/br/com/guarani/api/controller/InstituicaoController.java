package br.com.guarani.api.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.guarani.api.controller.dto.InstituicaoDto;
import br.com.guarani.api.controller.form.InstituicaoCadastro;
import br.com.guarani.api.model.Instituicao;
import br.com.guarani.api.service.InstituicaoService;

@RestController
@RequestMapping("/instituicoes") 
public class InstituicaoController {
	
	

	
	@Autowired
	private InstituicaoService instituicaoService;
	
	@GetMapping("/listar")
	public Page<InstituicaoDto> listar(
			@PageableDefault(page = 0, size = 15) Pageable paginacao){
		Page<Instituicao> instituicoes = instituicaoService.listarTudo(paginacao);
		
		return InstituicaoDto.converter(instituicoes);
	}
	
	
	
	@PostMapping("/criar")
	@Transactional
	public ResponseEntity<Instituicao> cadastrar(@RequestBody @Valid InstituicaoCadastro instituicaoCadastro){
		Instituicao instituicaoSalva = instituicaoService.salvarInstituicao(instituicaoCadastro);
		return new ResponseEntity<>(instituicaoSalva, HttpStatus.CREATED);
	}
	
	

}
