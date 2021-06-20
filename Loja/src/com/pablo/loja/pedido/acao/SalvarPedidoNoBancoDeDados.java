package com.pablo.loja.pedido.acao;

import com.pablo.loja.pedido.Pedido;

public class SalvarPedidoNoBancoDeDados implements AcaoAposGerarPedido {
	
	public void executarAcao(Pedido pedido) {
		System.out.println("Enviando email com dados do pedido.");
	}

}
