package com.pablo.teste;

import java.util.ArrayList;
import java.util.List;

import com.pablo.model.Cliente;
import com.pablo.model.Compra;
import com.pablo.model.Item;
import com.pablo.model.Produto;

public class ClienteTeste {

	public static void main(String[] args) {
		
		Cliente c = new Cliente("Pablo");
		List<Compra> compras = new ArrayList<Compra>();
		
		Produto p1 = new Produto("arroz", 6.0);
		Produto p2 = new Produto("feijão", 8.0);
		Produto p3 = new Produto("farinha", 3.0);
		Produto p4 = new Produto("batata", 4.0);
		Produto p5 = new Produto("cenoura", 3.5);
		
		Compra compra1 = new Compra();
		List<Item> itens1 = new ArrayList<Item>();
		Item item1 = new Item(1, p2);
		Item item2 = new Item(2, p4);
		itens1.add(item1);
		itens1.add(item2);
		compra1.setItens(itens1);
		
		System.out.println(compra1.obterValorCompra());
		
		Compra compra2 = new Compra();
		List<Item> itens2 = new ArrayList<Item>();
		Item item3 = new Item(1, p1);
		Item item4 = new Item(2, p3);
		Item item5 = new Item(2, p5);
		itens2.add(item3);
		itens2.add(item4);
		itens2.add(item5);
		compra2.setItens(itens2);
		
		System.out.println(compra2.obterValorCompra());
		
		compras.add(compra1);
		compras.add(compra2);
		c.setCompras(compras);
		
		System.out.println(c.obterValorTotal());
		
	}

}
