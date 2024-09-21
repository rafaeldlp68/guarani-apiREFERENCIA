package br.com.guarani.api.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import br.com.guarani.api.model.Producao;
import br.com.guarani.api.model.Usuario;
import br.com.guarani.api.repository.ProducaoRepository;

@Service
public class ProducaoService {

	private final ProducaoRepository producaoRepository;

	public ProducaoService(ProducaoRepository producaoRepository) {
		this.producaoRepository = producaoRepository;
	}
	
	public Producao salvar(Producao producao, Usuario logado) {
		producao.setUsuario(logado);
		return producaoRepository.save(producao);
	}
	
	
	public Page<Producao> listarTodasProducoes(@PageableDefault(page = 0, size = 15) Pageable paginacao){
		Page<Producao> producoes = producaoRepository.findAll(paginacao);
		
		return producoes;
	}

	public void deletar(Long idProducao) {

		producaoRepository.deleteById(idProducao);
		
	}
	
	
	public Optional<Producao> buscarPeloId(Long idProducao) {

		return producaoRepository.findById(idProducao);
		
	}
	
	
	
	
	
	
	
	
	
	
}




