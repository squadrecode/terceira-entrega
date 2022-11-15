package com.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.entity.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

	
	boolean existsByEmail(String email);
	
	Optional<Aluno> findByEmail(String email);
}