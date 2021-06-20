package com.pablo.loja.pedido.acao;

import com.pablo.loja.pedido.Pedido;

public class EnviarEmailPedido implements AcaoAposGerarPedido {
	
	public void executarAcao(Pedido pedido) {
		System.out.println("Salvando pedido no banco de dados.");
	}

}
