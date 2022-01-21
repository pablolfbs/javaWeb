package com.pablo.loja.modelo;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Embeddable
public class DadosPessoais {
	
	@NonNull
	private String nome;
	
	@NonNull
	private String cpf;

}
