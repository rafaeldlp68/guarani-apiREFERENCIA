package br.com.guarani.api.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.guarani.api.controller.dto.AreaConhecimentoDto;
import br.com.guarani.api.controller.form.AreaConhecimentoCadastro;
import br.com.guarani.api.model.AreaConhecimento;
import br.com.guarani.api.service.AreaConhecimentoService;

@RestController
@RequestMapping("/areaConhecimento")
public class AreaConhecimentoController {
	
	@Autowired
	private AreaConhecimentoService areaConhecimentoService;
	

	@PostMapping
	@Transactional
	public ResponseEntity<AreaConhecimento> cadastrarAreaConhecimento(@RequestBody @Valid AreaConhecimentoCadastro areaConhecimentoCadastro){
		AreaConhecimento areaConhecimentoSalvo = areaConhecimentoService.salvar(areaConhecimentoCadastro.converterCadastro());

		return new ResponseEntity<>(areaConhecimentoSalvo, HttpStatus.CREATED);
		
	}
	
	@GetMapping
	public Page<AreaConhecimentoDto> lista(Pageable paginacao){
		Page<AreaConhecimentoDto> areaConhecimentos = areaConhecimentoService.listaTudo(paginacao);
		return areaConhecimentos;
	}
}
