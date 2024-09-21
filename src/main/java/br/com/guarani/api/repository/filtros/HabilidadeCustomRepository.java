package br.com.guarani.api.repository.filtros;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import br.com.guarani.api.model.Habilidade;

@Repository
public class HabilidadeCustomRepository {
	

	private final EntityManager em;
	
	
	
	
	public HabilidadeCustomRepository(EntityManager em) {
		this.em = em;
	}




	public List<Habilidade> bucarHabilidadeFiltro(Long id){
		
		String query = "select h from Habilidade as h ";
		String condicao =" where ";
		
		
		if(id != null) {
			query += condicao + "h.id_area_conhecimento = :id ";
			condicao = " and ";
		}
		

		var q = em.createQuery(query, Habilidade.class);
		
		
		if(id != null ){
			q.setParameter("id", id);
		}
		
	
		
		
		return q.getResultList();
		
		
		
		
	}
	

}
