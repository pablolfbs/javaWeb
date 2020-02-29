package br.senac.rj.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "clientes")
public class Cliente {
	
	@Id
	@GeneratedValue
	@Column(name = "id_cliente")
	private Integer id;
	
	@Column
	private String nome;
	
	@Column
	private String cpf;
	
	@Column
	private String email;
	
	@Column
	private String endereco;
	
	@OneToMany(mappedBy = "cliente")
	private List<Venda> compras; 
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public List<Venda> getCompras() {
		return compras;
	}
	public void setCompras(List<Venda> compras) {
		this.compras = compras;
	}
	
}
