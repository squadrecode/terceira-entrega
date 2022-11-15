package com.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.ResourceNotFoundException;
import com.model.entity.Curso;
import com.repositories.CursoRepository;
import com.service.CursoService;

@Service
public class CursoServiceImpl implements CursoService{

	@Autowired
	private CursoRepository repository;
	
	@Override
	@Transactional
	public Curso salvaCurso(Curso curso) {
		return repository.save(curso);
	}

	@Override
	public List<Curso> getAllCursos() {
		return repository.findAll();
	}

	@Override
	public Curso getCursoById(long id) {
		return repository.findById(id).orElseThrow(() ->
		new ResourceNotFoundException("Curso","id", id));
	}

	@Override
	public Optional<Curso> buscarPorId(Long id) {
		return repository.findById(id);
	}

	@Override
	@Transactional
	public Curso atualizar(Curso curso, long id) {
		Curso cursoExistente = repository.findById(id).orElseThrow(()
				->new ResourceNotFoundException("Curso","id", id));
		cursoExistente.setNome(curso.getNome());
		
		return cursoExistente;
	}

	@Override
	@Transactional
	public void deletar(Curso curso) {
		Objects.requireNonNull(curso.getId());
		repository.delete(curso);
		
	}

}