package br.com.guarani.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.guarani.api.model.Especialidade;

public interface EspecialidadeRepository extends JpaRepository<Especialidade, Long>{
	
	Especialidade getById(Long id);
	


}
