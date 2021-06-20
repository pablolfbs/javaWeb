package com.pablo.loja.pedido;

import java.time.LocalDateTime;

import com.pablo.loja.orcamento.Orcamento;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Pedido {
	
	private String cliente;
	private LocalDateTime data;
	private Orcamento orcamento;

}
