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

import com.dto.CursoDTO;
import com.exception.RegraNegocio;
import com.model.entity.Curso;
import com.repositories.CursoRepository;
import com.service.CursoService;
import com.service.impl.CursoServiceImpl;

@RestController
@RequestMapping("api/curso")
public class CursoController {

	@Autowired
	private CursoRepository repository;
	
	@Autowired
	private CursoServiceImpl service;
	
	@Autowired
	private CursoService cursoService;
	
	@PostMapping
	public ResponseEntity salvar(@RequestBody Curso curso) {
		Curso curso1 = Curso.builder().nome(curso.getNome()).build();
		
		try {
			Curso cursoSalvo = service.salvaCurso(curso1);
			return new ResponseEntity(cursoSalvo, HttpStatus.CREATED);
		}catch(RegraNegocio e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping
	public ResponseEntity<List<Curso>> findAll(){
		List<Curso> cursos = service.getAllCursos();
		return ResponseEntity.ok().body(cursos);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Curso> getCursoById(@PathVariable("id") long CursoId){
		return new ResponseEntity<Curso>(service.getCursoById(CursoId),HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity atualizar(@PathVariable Long id, @RequestBody Curso c) {
		return new ResponseEntity<Curso>(service.atualizar(c, 1),HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity deletar(@PathVariable("id") Long id) {
		return service.buscarPorId(id).map(entity ->{
			service.deletar(entity);
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}).orElseGet(() -> new ResponseEntity("Curso não encontrado",HttpStatus.BAD_REQUEST));
	}
}