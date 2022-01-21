package com.pablo.loja.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
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
@Table(name = "produtos")
//@NamedQuery(name = "Produto.produtosPorCategoria", query = "select p from Produto p where p.categoria.nome = :nome")
@NamedQuery(name = "Produto.produtosPorCategoria", query = "select p from Produto p where p.categoria.id.nome = :nome")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Inheritance(strategy = InheritanceType.JOINED)
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NonNull
	private String nome;

	@NonNull
	private String descricao;

	@NonNull
	private BigDecimal preco;

	@NonNull
	private LocalDate dataCadastro = LocalDate.now();

	// @Enumerated(EnumType.STRING) // para salvar enum como texto no bd
	@NonNull
	@ManyToOne(fetch = FetchType.LAZY)
	private Categoria categoria;

}
