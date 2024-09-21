package br.com.guarani.api.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.guarani.api.controller.dto.ProducaoDto;
import br.com.guarani.api.controller.form.ProducaoCadastro;
import br.com.guarani.api.model.Producao;
import br.com.guarani.api.model.Usuario;
import br.com.guarani.api.model.enuns.EnumTipoProducao;
import br.com.guarani.api.repository.filtros.ProducaoCustomRepository;
import br.com.guarani.api.service.ProducaoService;

@RestController
@RequestMapping("/producoes")
public class ProducaoController {

//	
//	@Autowired
//	private ProducaoRepository producaoRepository;
	
	@Autowired
	private ProducaoCustomRepository producaoCustomRepository;
	
	@Autowired
	private ProducaoService producaoService;

	
	
	
	
	//Lista todos as produçoes
	@GetMapping
	public Page<Producao> listarProducao(@PageableDefault(page = 0, size = 15) Pageable paginacao){
		Page<Producao> producoes = producaoService.listarTodasProducoes(paginacao);
		
		return producoes;
	}

	//=============================== Metodos de Cadastros ================================================================
	
	@PostMapping("/livro")
	@Transactional
	public ResponseEntity<Producao> cadastrarLivro(@RequestBody @Valid ProducaoCadastro producaoCadastro, @AuthenticationPrincipal Usuario logado){
		Producao livroSalvo = producaoService.salvar(producaoCadastro.converterCadastro(),logado);
		livroSalvo.setTipoProducao(EnumTipoProducao.LIVRO);//define o tipo de produção salva
		return new ResponseEntity<>(livroSalvo, HttpStatus.CREATED);
	}
	
	@PostMapping("/tese")
	@Transactional
	public ResponseEntity<Producao> cadastrarTese(@RequestBody @Valid ProducaoCadastro producaoCadastro, @AuthenticationPrincipal Usuario logado){
		Producao teseSalvo = producaoService.salvar(producaoCadastro.converterCadastro(),logado);
		
		teseSalvo.setTipoProducao(EnumTipoProducao.TESE);//define o tipo de produção salva
		return new ResponseEntity<>(teseSalvo, HttpStatus.CREATED);
	}
	
	@PostMapping("/artigo")
	@Transactional
	public ResponseEntity<Producao> cadastrarArtigo(@RequestBody @Valid ProducaoCadastro producaoCadastro, @AuthenticationPrincipal Usuario logado){
		Producao artigoSalvo = producaoService.salvar(producaoCadastro.converterCadastro(),logado);
		artigoSalvo.setTipoProducao(EnumTipoProducao.ARTIGO); //define o tipo de produção salva
		return new ResponseEntity<>(artigoSalvo, HttpStatus.CREATED);
	}
	
	@PostMapping("/dissertacao")
	@Transactional
	public ResponseEntity<Producao> cadastrarDissertacao(@RequestBody @Valid ProducaoCadastro producaoCadastro, @AuthenticationPrincipal Usuario logado){
		Producao dissertacaoSalvo = producaoService.salvar(producaoCadastro.converterCadastro(),logado);

		dissertacaoSalvo.setTipoProducao(EnumTipoProducao.DISSERTACAO);//define o tipo de produção salva
		return new ResponseEntity<>(dissertacaoSalvo, HttpStatus.CREATED);
	}
	
	
	@PostMapping("/projeto")
	@Transactional
	public ResponseEntity<Producao> cadastrarProjeto(@RequestBody @Valid ProducaoCadastro producaoCadastro, @AuthenticationPrincipal Usuario logado){
		
		
		Producao projetoSalvo = producaoService.salvar(producaoCadastro.converterCadastro(),logado);
	
		projetoSalvo.setTipoProducao(EnumTipoProducao.PROJETO);
		return new ResponseEntity<>(projetoSalvo, HttpStatus.CREATED);
	}
	
	
//================================= Filtros =============================	
	
	@GetMapping("/artigo/filtro")
	public List<ProducaoDto> filtroArtigo (
			@RequestParam(required = false) String titulo,
			@RequestParam(required = false) Long IdAreaConhecimento,
			@RequestParam(required = false) String nomePesq,
			@RequestParam(required = false) String orientador,
			@RequestParam(required = false) Long IdInstituicao,
			@RequestParam(required = false) Integer ano
			){
			
		Enum<?> tipo = EnumTipoProducao.ARTIGO;
		System.out.println(titulo+" " + nomePesq+" "+orientador+" " + IdAreaConhecimento+" " +IdInstituicao+" " + ano);
		
		
		
		List<Producao> artigos = this.producaoCustomRepository.filtroProducao(titulo, nomePesq, orientador, IdAreaConhecimento,tipo, IdInstituicao, ano );
		
	return ProducaoDto.converter(artigos);
	
	}
	
	
	@GetMapping("/dissertacao/filtro")
	public List<ProducaoDto> filtroDissertacao (
			@RequestParam(required = false) String titulo,
			@RequestParam(required = false) Long IdAreaConhecimento,
			@RequestParam(required = false) String nomePesq,
			@RequestParam(required = false) String orientador,
			@RequestParam(required = false) Long IdInstituicao,
			@RequestParam(required = false) Integer ano
			){
			
		Enum<?> tipo = EnumTipoProducao.DISSERTACAO;
		System.out.println(titulo+" " + nomePesq+" " + IdAreaConhecimento+" " +IdInstituicao+" " + ano);
		List<Producao> dissertacoes =  this.producaoCustomRepository.filtroProducao(titulo, nomePesq,orientador, IdAreaConhecimento,tipo, IdInstituicao, ano );
		return ProducaoDto.converter(dissertacoes);
		
	}
	
	
	
	@GetMapping("/livro/filtro")
	public List<ProducaoDto> filtroLivro(
			@RequestParam(required = false) String titulo,
			@RequestParam(required = false) Long IdAreaConhecimento,
			@RequestParam(required = false) String nomePesq,
			@RequestParam(required = false) String orientador,
			@RequestParam(required = false) Long IdInstituicao,
			@RequestParam(required = false) Integer ano
			){
			
		Enum<?> tipo = EnumTipoProducao.LIVRO;
		System.out.println(titulo+" " + nomePesq+" " + IdAreaConhecimento+" " +IdInstituicao+" " + ano);
		List<Producao> livros =this.producaoCustomRepository.filtroProducao(titulo, nomePesq,orientador, IdAreaConhecimento,tipo, IdInstituicao, ano );
		return ProducaoDto.converter(livros);
	}

	
	@GetMapping("/tese/filtro")
	public List<ProducaoDto> filtroTese(
			@RequestParam(required = false) String titulo,
			@RequestParam(required = false) Long IdAreaConhecimento,
			@RequestParam(required = false) String nomePesq,
			@RequestParam(required = false) String orientador,
			@RequestParam(required = false) Long IdInstituicao,
			@RequestParam(required = false) Integer ano
			){
			
		Enum<?> tipo = EnumTipoProducao.TESE;
		System.out.println(titulo+" " + nomePesq+" " + IdAreaConhecimento+" " +IdInstituicao+" " + ano);
		List<Producao> tese = this.producaoCustomRepository.filtroProducao(titulo, nomePesq,orientador, IdAreaConhecimento,tipo, IdInstituicao, ano );
		return ProducaoDto.converter(tese);
	}
	
	@GetMapping("/projeto/filtro")
	public List<ProducaoDto> filtroProjeto(
			@RequestParam(required = false) String titulo,
			@RequestParam(required = false) Long IdAreaConhecimento,
			@RequestParam(required = false) String nomePesq,
			@RequestParam(required = false) String orientador,
			@RequestParam(required = false) Long IdInstituicao,
			@RequestParam(required = false) Integer ano
			){
			
		Enum<?> tipo = EnumTipoProducao.PROJETO;
		List<Producao> projeto  =this.producaoCustomRepository.filtroProducao(titulo, nomePesq,orientador, IdAreaConhecimento,tipo, IdInstituicao, ano);
		return ProducaoDto.converter(projeto);
	}
	
	//=============================Buscar pelo id==============================================
	
	@GetMapping("/id/{id}")
	public Optional<Producao> getById(@PathVariable Long id){
			
		Optional<Producao> prod = producaoService.buscarPeloId(id);
		return prod;
		
	}
	
	
	
	//============ Deletar ============
	@DeleteMapping("/deletar/{idProducao}")
	public void deletarProducao(@PathVariable Long idProducao) {
		producaoService.deletar(idProducao);
	}
	
	
	
	
}
