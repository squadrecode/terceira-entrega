package com.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import com.exception.ResourceNotFoundException;
import com.model.entity.Doacao;
import com.repositories.DoacaoRepository;
import com.service.DoacaoService;

@Service
public class DoacaoServiceImpl implements DoacaoService{

	@Autowired
	private DoacaoRepository repository;

	@GetMapping("/user")
	public String helloWorld() {
		return "Hello, world!";
	}
	
	@Override
	public Doacao salvarDoacao(Doacao doacao) {
		return repository.save(doacao);
	}
	
	@Override
	public Doacao atualizar(Doacao doacao,long id) {
		Doacao doacaoExistente = repository.findById(id).orElseThrow(()
				-> new ResourceNotFoundException("Doacao","id" , id));
		
		doacaoExistente.setValor(doacao.getValor());
		doacaoExistente.setData(doacao.getData());

		return doacaoExistente;
	}

	@Override
	public void deletar(Doacao doacao) {
		Objects.requireNonNull(doacao.getId());
		repository.delete(doacao);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Doacao> buscar(Doacao doacaoSearch) {
		Example<Doacao> example = Example.of(doacaoSearch, ExampleMatcher.matching().withIgnoreCase().withStringMatcher(StringMatcher.CONTAINING));
		
		return repository.findAll(example);
	}

	@Override
	public List<Doacao> getAllDoacoes() {
		return repository.findAll();
	}

	@Override
	public Doacao getDoacaoById(long id) {
		return repository.findById(id).orElseThrow(() ->
		new ResourceNotFoundException("Doacao", "id", id));
	}

	@Override
	public Optional<Doacao> buscaPorId(Long id) {
		return repository.findById(id);
	}

	
	
	
	
	

}