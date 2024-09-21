package br.com.guarani.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.guarani.api.controller.form.InstituicaoCadastro;
import br.com.guarani.api.model.Instituicao;
import br.com.guarani.api.repository.InstituicaoRepository;

@Service
public class InstituicaoService {
	
	@Autowired
	private InstituicaoRepository instituicaoRepository;
	
	
	public Page<Instituicao> listarTudo(
			Pageable paginacao){
		Page<Instituicao> instituicoes = instituicaoRepository.findAll(paginacao);
		
		return instituicoes;
	}
	
	
	public Instituicao salvarInstituicao(InstituicaoCadastro instituicaoCadastro) {
		Instituicao instituicaoSalva = instituicaoRepository.save(instituicaoCadastro.converterCadastro());
	
	return instituicaoSalva;
	}
	

}
