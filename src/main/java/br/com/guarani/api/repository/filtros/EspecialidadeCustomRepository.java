package br.com.guarani.api.repository.filtros;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import br.com.guarani.api.model.Especialidade;

@Repository
public class EspecialidadeCustomRepository {

	private final EntityManager em;
	
	
	
	
	public EspecialidadeCustomRepository(EntityManager em) {
		this.em = em;
	}




	public List<Especialidade> bucarTutorFiltro(String nome, Long IdHabilidade,
			Long IdAreaConhecimento){
		
		String query = "select e from Especialidade as e "
				+ "left join e.areaConhecimento as aC "
				+ "left join e.habilidades as h "
				+ "left join e.usuario as u";
		String condicao =" where ";
		
		
		if(nome != null ) {
			query += condicao + "u.nome like CONCAT('%', :nome ,'%') ";
			condicao = " and ";
		}
		
		if(IdAreaConhecimento != null ) {
						
				query += condicao + " aC.id_area_conhecimento =:IdAreaConhecimento ";
				condicao = " and ";
			
		}
		
		
		if(IdHabilidade != null)  {

				query += condicao + "h.id_habilidade =:IdHabilidade ";
			
		}
		
	
		
		var q = em.createQuery(query, Especialidade.class);
		
		
		if(nome != null){
			q.setParameter("nome", nome);
		}
		
		if(IdAreaConhecimento != null )  {
			q.setParameter("IdAreaConhecimento", IdAreaConhecimento);
			
		}
		if(IdHabilidade != null  ) {
			q.setParameter("IdHabilidade", IdHabilidade);
			
		}
		
		
		return q.getResultList();
		
		
		
		
	}
	
	

	
	
	
	
	
}
