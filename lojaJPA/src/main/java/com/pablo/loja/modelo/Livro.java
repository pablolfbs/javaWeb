package com.pablo.loja.modelo;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Livro extends Produto {
	
	private String autor;
	private Integer numeroDePaginas;

}
