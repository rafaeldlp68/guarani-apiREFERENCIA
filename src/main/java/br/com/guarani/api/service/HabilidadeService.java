package br.com.guarani.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import br.com.guarani.api.model.Habilidade;
import br.com.guarani.api.repository.HabilidadeRepository;

@Service
public class HabilidadeService {

	@Autowired
	private HabilidadeRepository habilidadeRepository;

	public Habilidade salvarHabilidade(Habilidade habilidade) {

		Habilidade habilidadeSalva = habilidadeRepository.save(habilidade);

		return habilidadeSalva;
	}

	public Page<Habilidade> listarTudo(@PageableDefault(page = 0, size = 15) Pageable paginacao) {
		Page<Habilidade> habilidades = habilidadeRepository.findAll(paginacao);
		return habilidades;
	}



}
