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
import br.senac.rj.modelo.dao.ClienteDAO;
import br.senac.rj.modelo.dao.ProdutoDAO;
import br.senac.rj.modelo.dao.VendaDAO;

@Named(value="controleVenda")
@SessionScoped
public class ControleVenda implements Serializable {
	
	@EJB
	private VendaDAO dao;
	@EJB
	private ProdutoDAO daoP;
	@EJB
	private ClienteDAO daoC;
	
	private Cliente cliente;
	private List<Produto> produtos;
	
	private Venda venda;
	
	public void zerarVenda() {
		venda = new Venda();
		produtos = new ArrayList<Produto>();
		venda.setId(null);
	}
	
	public void gravarVenda() {
		/*
		cliente = daoC.buscaPorId(9);
		produtos.add(daoP.buscaPorId(5));
		produtos.add(daoP.buscaPorId(6));
		
		venda.setCliente(cliente);
		venda.setProdutos(produtos);
		
		dao.gravar(venda);
		*/
		
		cliente = daoC.buscaPorId(9);
		for (Venda v : cliente.getCompras()) {
			for (Produto p : v.getProdutos()) {
				System.out.println("Compra: " + v.getId() + "Produto: " + p.getNome());
			}
		}
	}
	
	public void editar(Venda v) {
		dao.editar(v);
	}
	
	public void remover(Integer id) {
		dao.remove(id);
	}
	
	public List<Venda> listarVendas() {
		return dao.todosObjetos();
	}
	
	public Venda buscaPorId(Integer id) {
		return dao.buscaPorId(id);
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

}
