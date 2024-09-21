package br.com.guarani.api.repository.filtros;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import br.com.guarani.api.model.Producao;


@Repository
public class ProducaoCustomRepository {
	
private final EntityManager em;

public ProducaoCustomRepository(EntityManager em) {

	this.em = em;
}
	
	


public List<Producao> filtroProducao(String titulo, String nomePesq, String nomeOrientador, Long areaConhecimento,Enum tipo, Long instituicao, Integer ano){
	
	
	
	String query = "select p from Producao as p "
			+ "left join p.usuario as u "
			+ "left join p.areaConhecimento as a "
			+ "left join p.instituicao as i ";
	
	String condicao ="where";
	

	if(titulo != null) {
		query += condicao + " p.titulo like CONCAT('%', :titulo ,'%') ";
		condicao = " and ";
	}
	if(nomeOrientador != null) {
		query += condicao + " p.orientador like CONCAT('%', :nomeOrientador ,'%') ";
		condicao = " and ";
	}
	if(tipo != null) {
		query += condicao + " p.tipoProducao =:tipoProducao ";
		condicao = " and ";
	}

	if(ano != null) {
		query += condicao + " p.ano >=:ano ";
		condicao = " and ";
	}
	
	if(nomePesq != null) {
		query += condicao + " u.nome like CONCAT('%',:nome,'%') ";
		condicao = " and ";
	}
	
	

	if(instituicao != null) {
		query += condicao + " i.id_instituicao =:idInstituicao ";
		condicao = " and ";
	}
	
	
	if(areaConhecimento != null) {
		query += condicao + " a.id_area_conhecimento =:idAreaConhecimento ";
	}
	System.out.println(query);
	
   var q = em.createQuery(query, Producao.class);
 
	
	if(titulo != null) {
		q.setParameter("titulo", titulo);
	}
	
	if(tipo != null) {
		q.setParameter("tipoProducao", tipo);
	}
	
	if(ano != null) {
		q.setParameter("ano", ano);
		
	}
	
	if(nomePesq != null) {
		q.setParameter("nome", nomePesq);
	}
	if(nomeOrientador != null) {
		q.setParameter("nomeOrientador", nomeOrientador);
	}
	
	
	if(areaConhecimento != null) {
		q.setParameter("idAreaConhecimento", areaConhecimento);
		
	}
	
	if(instituicao != null) {
		q.setParameter("idInstituicao", instituicao);
		
	}
	System.out.println();
	return q.getResultList();
//	
//	
	
	
}

	
	
	
	


}
