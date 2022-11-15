package com.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AlunoDTO {
	
	private String nome;
	
	private String email;
	
	private String senha;
	
	private String idade;
	
	private String sexo;
	
	private String cpf;
	
	private String rg;
	
	private String telefone;
	
	private String endereco;
	
	private String escolaridade;

}