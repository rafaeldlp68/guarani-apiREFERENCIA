package br.com.guarani.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.guarani.api.model.AreaConhecimento;


public interface AreaConhecimentoRepository extends JpaRepository<AreaConhecimento, Long> {
	
	AreaConhecimento getById(Long id);
}
