package com.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.dto.AlunoDTO;
import com.exception.ErroAutenticacao;
import com.exception.RegraNegocio;
import com.model.entity.Aluno;
import com.repositories.AlunoRepository;
import com.service.AlunoService;
import com.service.DoacaoService;
import com.service.impl.AlunoServiceImpl;

@RestController
@RequestMapping("api/aluno")
public class AlunoController {
	
	@Autowired
	private AlunoRepository repository;
	
	@Autowired
	private AlunoServiceImpl service;
	
	@Autowired
	private AlunoService alunoService;
		
	@GetMapping("/user")
	public String hello() {
		return "Hello world!";
	}
	
	@PostMapping
	public ResponseEntity salvar(@RequestBody AlunoDTO dto) {
		Aluno aluno = Aluno.builder().nome(dto.getNome()).email(dto.getEmail()).senha(dto.getSenha()).idade(dto.getIdade())
				      .sexo(dto.getSexo()).cpf(dto.getCpf()).rg(dto.getRg()).telefone(dto.getTelefone())
				      .endereco(dto.getEndereco()).escolaridade(dto.getEscolaridade()).build();
		
		try {
			Aluno alunoSalvo = service.salvarAluno(aluno);
			return new ResponseEntity(alunoSalvo, HttpStatus.CREATED);
		}catch(RegraNegocio e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	
	@PostMapping("/autenticar")
	public ResponseEntity autenticar(@RequestBody AlunoDTO dto) {
		try {
			Aluno alunoAutenticado = service.autenticar(dto.getEmail(), dto.getSenha());
			return ResponseEntity.ok(alunoAutenticado);
		}catch(ErroAutenticacao e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping
	public ResponseEntity<List<Aluno>> findAll(){
		List<Aluno> alunos = service.getAllAlunos();
		return ResponseEntity.ok().body(alunos);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Aluno> getAlunoById(@PathVariable("id") long UsuarioId ){
		return new ResponseEntity<Aluno>(service.getAlunoById(UsuarioId),HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity atualizar(@PathVariable Long id, @RequestBody Aluno a) {
		return new ResponseEntity<Aluno>(service.atualizar(a, 1), HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity deletar(@PathVariable("id") Long id) {
		return service.buscarPorId(id).map(entity ->{
			service.deletar(entity);
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}).orElseGet(() -> new ResponseEntity("Aluno não encontrado", HttpStatus.BAD_REQUEST));
	}
}