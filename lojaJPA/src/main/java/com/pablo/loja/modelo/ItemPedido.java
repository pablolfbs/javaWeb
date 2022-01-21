package com.pablo.loja.modelo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "itens_pedido")
public class ItemPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NonNull
	@ManyToOne(fetch = FetchType.LAZY)
	private Produto produto;

	@NonNull
	@ManyToOne(fetch = FetchType.LAZY)
	private Pedido pedido;

	@NonNull
	private Integer quantidade;

	@NonNull
	@Column(name = "preco_unitario")
	private BigDecimal precoUnitario;
	
	public BigDecimal getValor() {
		return  this.precoUnitario.multiply(new BigDecimal(this.quantidade));
	}
	
}
