package com.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "doacao")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Doacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@Column
	private BigDecimal valor;
	
	@Column
	@Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
	private LocalDate data;
	
	@JoinColumn(name = "id_aluno")
	@ManyToOne
	private Aluno aluno;
}