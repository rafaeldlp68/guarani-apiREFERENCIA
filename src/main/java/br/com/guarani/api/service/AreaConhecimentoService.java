package br.com.guarani.api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import br.com.guarani.api.controller.dto.AreaConhecimentoDto;
import br.com.guarani.api.model.AreaConhecimento;
import br.com.guarani.api.repository.AreaConhecimentoRepository;
@Service
public class AreaConhecimentoService {
	
	
	private final AreaConhecimentoRepository areaConhecimentoRepository;
	
	
	public AreaConhecimentoService(AreaConhecimentoRepository areaConhecimentoRepository) {
	
		this.areaConhecimentoRepository = areaConhecimentoRepository;
	}
	
	public AreaConhecimento salvar(AreaConhecimento areaConhecimento) {

		return areaConhecimentoRepository.save(areaConhecimento);
	}
	
	
	public Page<AreaConhecimentoDto> listaTudo(
			@PageableDefault(page = 0, size = 15) Pageable paginacao){
		Page<AreaConhecimento> areaConhecimentos = areaConhecimentoRepository.findAll(paginacao);
		return AreaConhecimentoDto.converter(areaConhecimentos);
	}
	
	
	
	

}
