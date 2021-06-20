package com.pablo.loja.teste;

import java.math.BigDecimal;
import java.util.Arrays;

import com.pablo.loja.pedido.GeraPedido;
import com.pablo.loja.pedido.GeraPedidoHandler;
import com.pablo.loja.pedido.acao.EnviarEmailPedido;
import com.pablo.loja.pedido.acao.SalvarPedidoNoBancoDeDados;

public class TestePedidos {
	
	public static void main(String[] args) {
		String cliente = "Pablo";
		BigDecimal valorOrcamnento = new BigDecimal("300");
		int quantidadeItens = Integer.parseInt("2");
		
		GeraPedido gerador = new GeraPedido(cliente, valorOrcamnento, quantidadeItens);
		GeraPedidoHandler handler = new GeraPedidoHandler(
				Arrays.asList(new SalvarPedidoNoBancoDeDados(),
						new EnviarEmailPedido()));
		handler.execute(gerador);
	}

}
