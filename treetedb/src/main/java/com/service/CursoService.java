package com.service;

import java.util.List;
import java.util.Optional;

import com.model.entity.Curso;

public interface CursoService {

	Curso salvaCurso(Curso curso);
	
	List<Curso> getAllCursos();
	
	Curso getCursoById(long id);
	
	Optional<Curso> buscarPorId(Long id);
	
	Curso atualizar(Curso curso, long id);
	
	void deletar(Curso curso);
	
}