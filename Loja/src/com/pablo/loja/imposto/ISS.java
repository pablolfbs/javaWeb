package com.pablo.loja.imposto;

import java.math.BigDecimal;

import com.pablo.loja.orcamento.Orcamento;

public class ISS implements Imposto {
	
	public BigDecimal calcular (Orcamento orcamento) {
		return orcamento.getValor().multiply(new BigDecimal("0.06"));
	}

}
