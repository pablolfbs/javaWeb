package br.senac.rj.controle;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.senac.rj.modelo.Produto;
import br.senac.rj.modelo.dao.ProdutoDAO;

@Named(value = "controleProduto")
@SessionScoped
public class ControleProduto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ProdutoDAO dao;
	private Produto produto;
	
	public void getNewProduto() {
		produto = new Produto();
		produto.setId(null);
	}
	
	public void gravar() {
		dao.gravar(produto);
	}
	
	public void editar(Produto p) {
		dao.editar(p);
	}
	
	public void remover(Produto p) {
		dao.remove(p);
	}
	
	public Produto buscaPorId() {
		return dao.buscaPorId(produto.getId());
	}
	
	public List<Produto> listar() {
		return dao.todosObjetos();
	}

	public ProdutoDAO getDao() {
		return dao;
	}

	public void setDao(ProdutoDAO dao) {
		this.dao = dao;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setP(Produto produto) {
		this.produto = produto;
	}
}








