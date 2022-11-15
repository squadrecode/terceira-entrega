package com.service;

import java.util.List;
import java.util.Optional;

import com.model.entity.Aluno;

public interface AlunoService {
	Aluno salvarAluno(Aluno aluno);
	
	Aluno autenticar(String email, String senha);
	
	void validarEmail(String email);
	
	List<Aluno> getAllAlunos();
	
	Aluno getAlunoById(long id);
	
	Optional<Aluno> buscarPorId(Long id);
	
	Aluno atualizar(Aluno aluno, long id);
	
	void deletar(Aluno aluno);
}