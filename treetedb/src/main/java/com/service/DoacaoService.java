package com.service;

import java.util.List;
import java.util.Optional;

import com.model.entity.Doacao;

public interface DoacaoService {

	//
    Doacao salvarDoacao(Doacao doacao);
	
	Doacao atualizar(Doacao doacao, long id);
	
	void deletar(Doacao doacao);
	
	List<Doacao> buscar(Doacao doacaoSearch);
		
	List<Doacao> getAllDoacoes();
			
	Doacao getDoacaoById(long id);
	
	Optional<Doacao> buscaPorId(Long id);
	
}	