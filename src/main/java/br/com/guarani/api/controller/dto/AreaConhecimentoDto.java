package br.com.guarani.api.controller.dto;

import java.util.List;

import org.springframework.data.domain.Page;

import br.com.guarani.api.model.AreaConhecimento;
import br.com.guarani.api.model.Habilidade;

public class AreaConhecimentoDto {
	
	private Long id_area_conhecimento;
	private String nomeArea;
	private List<Habilidade> habilidades;
	

	public AreaConhecimentoDto(AreaConhecimento areaConhecimento) {
		this.id_area_conhecimento = areaConhecimento.getId_area_conhecimento();
		this.nomeArea = areaConhecimento.getNomeArea();
		this.habilidades = areaConhecimento.getHabilidades();
	}

	public List<Habilidade> getHabilidades() {
		return habilidades;
	}

	public String getNomeArea() {
		return nomeArea;
	}

	public Long getId_area_conhecimento() {
		return id_area_conhecimento;
	}

	//metodo usado na listagem de usuario
	public static Page<AreaConhecimentoDto> converter(Page<AreaConhecimento> areaConhecimento) {
		
		return areaConhecimento.map(AreaConhecimentoDto::new);

	}
}
