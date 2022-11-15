package com.model.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "matricula")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Matricula {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	
	
	@Column
	@Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
	private LocalDate dataMatricula;
	
	@JoinColumn(name = "id_aluno")
	@OneToOne
	private Aluno aluno;
	
	@JoinColumn(name = "id_curso")
	@OneToOne
	private Curso curso;
	
}