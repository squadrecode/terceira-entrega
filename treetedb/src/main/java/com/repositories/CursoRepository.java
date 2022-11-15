package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.entity.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long>{

}
