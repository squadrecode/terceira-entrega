package com.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.ErroAutenticacao;
import com.exception.RegraNegocio;
import com.exception.ResourceNotFoundException;
import com.model.entity.Aluno;
import com.repositories.AlunoRepository;
import com.service.AlunoService;

@Service
public class AlunoServiceImpl implements AlunoService{

	@Autowired
	private AlunoRepository repository;
	
	@Override
	public Aluno salvarAluno(Aluno aluno) {
		validarEmail(aluno.getEmail());
		return repository.save(aluno);
	}

	@Override
	public Aluno autenticar(String email, String senha) {
		Optional<Aluno> aluno = repository.findByEmail(email);
		
		if(!aluno.isPresent()) {
			throw new ErroAutenticacao("Aluno não encontrado");
		}
		
		if(!aluno.get().getSenha().equals(senha)) {
			throw new ErroAutenticacao("Senha incorreta");
		}
		
		return aluno.get();
	}

	@Override
	public void validarEmail(String email) {
		boolean existe = repository.existsByEmail(email);
		if(existe) {
			throw new RegraNegocio("Já existe aluno cadastrado com esse email.");
		}
		
	}

	@Override
	public List<Aluno> getAllAlunos() {
		return repository.findAll();
	}

	@Override
	public Aluno getAlunoById(long id) {
		return repository.findById(id).orElseThrow(() ->
		new ResourceNotFoundException("Aluno","id", id));
	}

	@Override
	public Aluno atualizar(Aluno aluno, long id) {
		Aluno alunoExistente = repository.findById(id).orElseThrow(()
				-> new ResourceNotFoundException("Aluno","id" , id));
		
		alunoExistente.setNome(aluno.getNome());
		alunoExistente.setEmail(aluno.getEmail());
		alunoExistente.setSenha(aluno.getSenha());
		alunoExistente.setIdade(aluno.getIdade());
		alunoExistente.setSexo(aluno.getSexo());
		alunoExistente.setTelefone(aluno.getTelefone());
		alunoExistente.setEndereco(aluno.getEndereco());
		return alunoExistente;
	}

	@Override
	public void deletar(Aluno aluno) {
		Objects.requireNonNull(aluno.getId());
		repository.delete(aluno);
		
	}

	@Override
	public Optional<Aluno> buscarPorId(Long id) {
		return repository.findById(id);
	}
	
}