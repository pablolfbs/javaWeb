package com.pablo.loja.desconto;

import java.math.BigDecimal;

import com.pablo.loja.orcamento.Orcamento;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class Desconto {

	protected Desconto proximo;

	public BigDecimal calcular(Orcamento orcamento) {
		if (deveAplicar(orcamento)) {
			return efetuarCalculo(orcamento);
		}
		return proximo.calcular(orcamento);
	}

	protected abstract BigDecimal efetuarCalculo(Orcamento orcamento);

	public abstract boolean deveAplicar(Orcamento orcamento);

}
