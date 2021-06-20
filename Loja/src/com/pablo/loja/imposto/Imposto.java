package com.pablo.loja.imposto;

import java.math.BigDecimal;

import com.pablo.loja.orcamento.Orcamento;

public interface Imposto {
	
	BigDecimal calcular(Orcamento orcamento);

}
