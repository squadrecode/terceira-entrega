package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.entity.Doacao;

@Repository
public interface DoacaoRepository extends JpaRepository<Doacao, Long>{

}
