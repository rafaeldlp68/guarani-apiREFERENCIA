package br.com.guarani.api.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.guarani.api.controller.dto.EspecialidadeDto;
import br.com.guarani.api.model.Especialidade;
import br.com.guarani.api.model.Usuario;
import br.com.guarani.api.repository.AreaConhecimentoRepository;
import br.com.guarani.api.repository.EspecialidadeRepository;
import br.com.guarani.api.repository.HabilidadeRepository;
import br.com.guarani.api.repository.filtros.EspecialidadeCustomRepository;

@RestController
@RequestMapping("/especialidade")
public class EspecialidadeController {
	
	@Autowired
	private EspecialidadeCustomRepository especialidadeCustomRepository;


	
	@Autowired
	private EspecialidadeRepository especialidadeRepository;
	
	@Autowired
	private AreaConhecimentoRepository areaConhecimentoRepository;
	
	@Autowired
	private HabilidadeRepository habilidadeRepository;
	
	
	
	@GetMapping("/listar")
	public List<EspecialidadeDto> listar(@AuthenticationPrincipal Usuario logado){
		
		List<Especialidade> especialidades = especialidadeRepository.findAll();
	
		
		return EspecialidadeDto.converter(especialidades);
	}
	
	
	@PostMapping("/criar")
	@Transactional
	public ResponseEntity<Especialidade> cadastrar(@RequestBody @Valid Especialidade especialidade, @AuthenticationPrincipal Usuario logado){
		
		
		if(logado.getEspecialidade() != null) {
			
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}
		
		
		especialidade.setUsuario(logado);
		Especialidade  especialidadeSalvo = especialidadeRepository.save(especialidade);

		return new ResponseEntity<>(especialidadeSalvo, HttpStatus.CREATED);

	}

	@DeleteMapping("/removerAreaConhecimento/{idArea}")
	@Transactional
	public ResponseEntity<?>  removerArea(@AuthenticationPrincipal Usuario logado,@PathVariable Long idArea){
		
		Optional<Especialidade> findArea = especialidadeRepository.findById(logado.getEspecialidade().getId_especialidade());
		for(int i = 0; i<findArea.get().getAreaConhecimento().size();i++) {
			
			if(idArea == findArea.get().getAreaConhecimento().get(i).getId_area_conhecimento()) {
				findArea.get().getAreaConhecimento().remove(i);
				return new ResponseEntity<>(HttpStatus.OK);
			}
		}
		
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	
	@PutMapping("/addAreaAreaConhecimento/{idArea}")
	@Transactional
	public  ResponseEntity<?> addArea(@AuthenticationPrincipal Usuario logado,@PathVariable Long idArea){
		
		Optional<Especialidade> findArea = especialidadeRepository.findById(logado.getEspecialidade().getId_especialidade());
		
		for(int i = 0; i<findArea.get().getAreaConhecimento().size();i++) {
			if(idArea == findArea.get().getAreaConhecimento().get(i).getId_area_conhecimento()) {
				return new ResponseEntity<>(HttpStatus.ACCEPTED);
			
			}
		}
		
		Especialidade addArea = especialidadeRepository.getById(logado.getEspecialidade().getId_especialidade());
		addArea.getAreaConhecimento().add(areaConhecimentoRepository.getById(idArea));
	
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	

	@DeleteMapping("/removerHabilidade/{idHabi}")
	@Transactional
	public ResponseEntity<?>  removerHabilidade(@AuthenticationPrincipal Usuario logado,@PathVariable Long idHabi){
		
		Optional<Especialidade> findEspe = especialidadeRepository.findById(logado.getEspecialidade().getId_especialidade());
		for(int i = 0; i<findEspe.get().getHabilidades().size();i++) {
			
			if(idHabi == findEspe.get().getHabilidades().get(i).getId_habilidade()) {
				findEspe.get().getHabilidades().remove(i);
				return new ResponseEntity<>(HttpStatus.OK);
			}
		}
		
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	
	@PutMapping("/addHabilidade/{idHabi}")
	@Transactional
	public  ResponseEntity<?> addHabi(@AuthenticationPrincipal Usuario logado,@PathVariable Long idHabi){
		
		Optional<Especialidade> findEspe = especialidadeRepository.findById(logado.getEspecialidade().getId_especialidade());
		
		for(int i = 0; i<findEspe.get().getHabilidades().size();i++) {
			if(idHabi == findEspe.get().getHabilidades().get(i).getId_habilidade()) {
				return new ResponseEntity<>(HttpStatus.ACCEPTED);
			
			}
		}
		
		Especialidade addHabilidade= especialidadeRepository.getById(logado.getEspecialidade().getId_especialidade());
		addHabilidade.getHabilidades().add(habilidadeRepository.getById(idHabi));
	
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	

	
	
	
	
	@GetMapping("/tutores")
	public List<EspecialidadeDto> buscarTutor(
			@RequestParam(required = false) String nome,
			@RequestParam(required = false) Long IdHabilidade,
			@RequestParam(required = false) Long IdAreaConhecimento
		
			){
			

		List<Especialidade> tutores = this.especialidadeCustomRepository.bucarTutorFiltro(nome, IdHabilidade,IdAreaConhecimento);
	
		return EspecialidadeDto.converter(tutores);
	
	}
	
	
}
