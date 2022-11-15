package com.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DoacaoDTO {

	private Long id;
	
	private BigDecimal valor;
		
	private Long aluno;
}