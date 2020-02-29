package br.senac.rj.controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.senac.rj.modelo.Cliente;
import br.senac.rj.modelo.Produto;
import br.senac.rj.modelo.Venda;
import br.senac.rj.modelo.dao.VendaDAO;

@Named(value = "controleVenda")
@SessionScoped
public class ControleVenda implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private VendaDAO dao;
	private Venda venda;
	private Cliente cliente;
	private List<Produto> produtos;
	
	public void getNewVenda() {
		venda = new Venda();
		venda.setId(null);
		produtos = new ArrayList<Produto>();
	}
	
	public void addProduto(Produto p) {
		produtos.add(p);
	}
	
	public void gravar() {
		venda.setProdutos(produtos);
		venda.setCliente(cliente);
		dao.gravar(venda);
	}
	
	public void editar(Venda v) {
		dao.editar(v);
	}
	
	public void remover(Venda v) {
		dao.remove(v);
	}
	
	public Venda buscaPorId() {
		return dao.buscaPorId(venda.getId());
	}
	
	public List<Venda> listar() {
		return dao.todosObjetos();
	}
	
	public VendaDAO getDao() {
		return dao;
	}
	public void setDao(VendaDAO dao) {
		this.dao = dao;
	}
	public Venda getVenda() {
		return venda;
	}
	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
}
