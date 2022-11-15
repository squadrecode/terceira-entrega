package com.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.exception.ResourceNotFoundException;
import com.model.entity.Matricula;
import com.repositories.MatriculaRepository;
import com.service.MatriculaService;

@Service
public class MatriculaServiceImpl implements MatriculaService{

	@Autowired
	private MatriculaRepository repository;
	
	@GetMapping("/user")
	public String helloWorld() {
		return "Hello, world!";
	}
	
	@Override
	public Matricula salvarMatricula(Matricula matricula) {
		return repository.save(matricula);
	}

	@Override
	public Matricula atualizar(Matricula matricula, long id) {
		Matricula matriculaExistente = repository.findById(id).orElseThrow(()
				-> new ResourceNotFoundException("Doacao","id" , id));
		
		matriculaExistente.setAluno(matricula.getAluno());
		matriculaExistente.setCurso(matricula.getCurso());
		matriculaExistente.setDataMatricula(matricula.getDataMatricula());

		return matriculaExistente;
	}

	@Override
	public void deletar(Matricula matricula) {
		Objects.requireNonNull(matricula.getId());
        repository.delete(matricula);
	}

	@Override
	public List<Matricula> buscar(Matricula matriculaSearch) {
        Example<Matricula> example = Example.of(matriculaSearch, ExampleMatcher.matching().withIgnoreCase().withStringMatcher(StringMatcher.CONTAINING));
		
		return repository.findAll(example);
	}

	@Override
	public List<Matricula> getAllMatriculas() {
		return repository.findAll();
	}

	@Override
	public Matricula getMatriculaById(long id) {
		return repository.findById(id).orElseThrow(()
				-> new ResourceNotFoundException("Matricula", "id", id)) ;
	}

	@Override
	public Optional<Matricula> buscaPorId(Long id) {
		return repository.findById(id);
	}
	
}