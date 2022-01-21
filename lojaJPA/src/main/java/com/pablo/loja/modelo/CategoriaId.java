package com.pablo.loja.modelo;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class CategoriaId implements Serializable {
	
	private static final long serialVersionUID = -7154694880226490482L;

	@NonNull
	private String nome;
	
	@NonNull
	private String tipo;

}
