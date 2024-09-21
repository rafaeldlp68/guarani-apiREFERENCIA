package br.com.guarani.api.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.guarani.api.model.Habilidade;


public interface HabilidadeRepository extends JpaRepository<Habilidade, Long>{
	


	Habilidade getById(Long id);
	 
	 
}
