package com.service;

import java.util.List;
import java.util.Optional;

import com.model.entity.Matricula;

public interface MatriculaService {
	
	Matricula salvarMatricula(Matricula matricula);
	
	Matricula atualizar(Matricula matricula, long id);
	
	void deletar(Matricula matricula);
	
	List<Matricula> buscar(Matricula matriculaSearch);
	
	List<Matricula> getAllMatriculas();
			
	Matricula getMatriculaById(long id);
	
	Optional<Matricula> buscaPorId(Long id);
}