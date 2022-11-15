package com.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

import com.dto.MatriculaDTO;
import com.exception.RegraNegocio;
import com.model.entity.Aluno;
import com.model.entity.Curso;
import com.model.entity.Matricula;
import com.service.AlunoService;
import com.service.CursoService;
import com.service.MatriculaService;

@RestController
@RequestMapping("api/matricula")
public class MatriculaController {

	@Autowired
	private MatriculaService service;
	
	@Autowired
	private AlunoService alunoService;
	
	@Autowired
	private CursoService cursoService;
	
	private Matricula converter(MatriculaDTO dto) {
		Matricula matricula = new Matricula();
		matricula.setId(dto.getId());
		
		Aluno aluno = alunoService.buscarPorId(dto.getAluno()).orElseThrow(
				() -> new RegraNegocio("Aluno com id " + dto.getAluno() + "não encontrado."));
		
		matricula.setAluno(aluno);
		
		Curso curso = cursoService.buscarPorId(dto.getCurso()).orElseThrow(
				() -> new RegraNegocio("Curso com id " + dto.getCurso() + "não encontrado."));
		matricula.setCurso(curso);
		return matricula;
	}
	
	@PostMapping
	public ResponseEntity salvar(@RequestBody MatriculaDTO dto) {
		try {
			Matricula matricula = converter(dto);
			matricula = service.salvarMatricula(matricula);
			return new ResponseEntity(matricula, HttpStatus.CREATED);
		}catch(RegraNegocio e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PutMapping("{id}")
	public ResponseEntity atualizar(@PathVariable Long id, @RequestBody Matricula m) {
		return new ResponseEntity<Matricula>(service.atualizar(m, 1), HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity deletar(@PathVariable("id") Long id) {
		return service.buscaPorId(id).map(entity ->{
			service.deletar(entity);
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}).orElseGet(() -> new ResponseEntity("Matricula não encontrada", HttpStatus.BAD_REQUEST));
	}
	
	
	public ResponseEntity buscar
	(@RequestParam(value = "aluno", required = false) Long idAluno,
	 @RequestParam(value = "curso", required = false) Long idCurso,
	 @RequestParam(value = "dataMatricula", required = false) LocalDate dataMatricula
			) {
		Matricula matriculaSearch = new Matricula();
		matriculaSearch.setDataMatricula(dataMatricula);
		
		Optional<Aluno> aluno = alunoService.buscarPorId(idAluno);
		if(!aluno.isPresent()) {
			return ResponseEntity.badRequest().body("Aluno não encontrado");
		}else {
			matriculaSearch.setAluno(aluno.get());
		}
		
		Optional<Curso> curso = cursoService.buscarPorId(idCurso);
		if(!curso.isPresent()) {
			return ResponseEntity.badRequest().body("Curso não encontrado");
		}else {
			matriculaSearch.setCurso(curso.get());
		}
		
		List<Matricula> matricula = service.buscar(matriculaSearch);
		return ResponseEntity.ok(matricula);
	}
	
	
	@GetMapping
	public ResponseEntity<List<Matricula>> findAll(){
		List<Matricula> matriculas = service.getAllMatriculas();
		return ResponseEntity.ok().body(matriculas);
	}
	
	
	@GetMapping("{id}")
	public ResponseEntity<Matricula> getMatriculaById(@PathVariable("id") long MatriculaId){
		return new ResponseEntity<Matricula>(service.getMatriculaById(MatriculaId),HttpStatus.OK);
	}
}