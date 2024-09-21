package br.com.guarani.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.guarani.api.model.Instituicao;

public interface InstituicaoRepository extends JpaRepository<Instituicao, Long>{
	
	 
	List<Instituicao> findByNomeInstituicao(String nome);
	
}
