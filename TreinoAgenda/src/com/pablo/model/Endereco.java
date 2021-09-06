package com.pablo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Endereco {
	
	private String logradouro;
	private String nome;
	private String numero;
	private String complemento;
	private String cep;
	private String bairro;
	private String cidade;
	private String estado;

}
