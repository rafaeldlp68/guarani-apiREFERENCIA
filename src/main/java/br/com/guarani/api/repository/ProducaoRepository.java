package br.com.guarani.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.guarani.api.model.Producao;
import br.com.guarani.api.model.enuns.EnumTipoProducao;

public interface ProducaoRepository extends JpaRepository<Producao, Long>{
	
	List<Producao> findByTipoProducao(EnumTipoProducao tipoProducao);;

}
