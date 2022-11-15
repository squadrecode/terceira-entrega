package com.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dto.DoacaoDTO;
import com.exception.RegraNegocio;
import com.model.entity.Aluno;
import com.model.entity.Doacao;
import com.service.AlunoService;
import com.service.DoacaoService;

@RestController
@RequestMapping("/api/doacao")
public class DoacaoController {
	
	@Autowired
	private DoacaoService service;
	
	@Autowired
	private AlunoService alunoService;
		
	private Doacao converter(DoacaoDTO dto) {
		Doacao doacao = new Doacao();
		doacao.setId(dto.getId());
		doacao.setValor(dto.getValor());
		
		Aluno aluno = alunoService.buscarPorId(dto.getAluno())
				.orElseThrow(() -> new RegraNegocio("Aluno com id " +dto.getAluno() + " não encontrado."));
		doacao.setAluno(aluno);
		return doacao;
	}
	
	@PostMapping
	public ResponseEntity salvar(@RequestBody DoacaoDTO dto) {
		try {
			Doacao doacao = converter(dto);
			doacao = service.salvarDoacao(doacao);
			return new ResponseEntity(doacao, HttpStatus.CREATED);
		}catch(RegraNegocio e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PutMapping("{id}")
	public ResponseEntity atualizar(@PathVariable Long id, @RequestBody Doacao d) {
		return new ResponseEntity<Doacao>(service.atualizar(d, 1), HttpStatus.BAD_REQUEST);
	}
	
	
	@DeleteMapping("{id}")
	public ResponseEntity deletar(@PathVariable("id") Long id) {
		return service.buscaPorId(id).map(entity -> {
			service.deletar(entity);
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}).orElseGet(() -> new ResponseEntity("Doação não encontrada", HttpStatus.BAD_REQUEST));
	} 
	
	
	public ResponseEntity buscar
	(@RequestParam(value = "valor", required = false) BigDecimal valor,
	 @RequestParam(value = "aluno", required = false) Long idAluno		
			) {
		Doacao doacaoSearch = new Doacao();
		doacaoSearch.setValor(valor);
		
		Optional<Aluno> aluno = alunoService.buscarPorId(idAluno);
		if(!aluno.isPresent()) {
			return ResponseEntity.badRequest().body("Aluno não encontrado");
		}else {
			doacaoSearch.setAluno(aluno.get());
		}
		
		List<Doacao> doacao = service.buscar(doacaoSearch);
		return ResponseEntity.ok(doacao);
	
      }
	
	@GetMapping
	public ResponseEntity<List<Doacao>> findAll(){
		List<Doacao> doacoes = service.getAllDoacoes();
		return ResponseEntity.ok().body(doacoes);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Doacao> getDoacaoById(@PathVariable("id") long DoacaoId ){
		return new ResponseEntity<Doacao>(service.getDoacaoById(DoacaoId),HttpStatus.OK);
	}
}