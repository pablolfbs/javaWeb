package com.pablo.ex2;

public class Livro implements Publicacao {

	private String titulo;
	private String autor;
	private int totPaginas;
	private int pagAtual;
	private boolean aberto;
	private Pessoa leitor;

	public Livro(String titulo, String autor, int totPaginas, Pessoa leitor) {
		this.titulo = titulo;
		this.autor = autor;
		this.totPaginas = totPaginas;
		this.aberto = false;
		this.pagAtual = 0;
		this.leitor = leitor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getTotPaginas() {
		return totPaginas;
	}

	public void setTotPaginas(int totPaginas) {
		this.totPaginas = totPaginas;
	}

	public int getPagAtual() {
		return pagAtual;
	}

	public void setPagAtual(int pagAtual) {
		this.pagAtual = pagAtual;
	}

	public boolean isAberto() {
		return aberto;
	}

	public void setAberto(boolean aberto) {
		this.aberto = aberto;
	}

	public Pessoa getLeitor() {
		return leitor;
	}

	public void setLeitor(Pessoa leitor) {
		this.leitor = leitor;
	}

	@Override
	public void abrir() {
		this.aberto = true;
	}

	@Override
	public void fechar() {
		this.aberto = false;
	}

	@Override
	public void folhear(int pagina) {
		if (pagina > this.totPaginas)
			this.pagAtual = this.totPaginas;
		else
			this.pagAtual = pagina;
	}

	@Override
	public void avancarPag() {
		if (this.pagAtual < this.totPaginas)
			this.pagAtual++;
	}

	@Override
	public void voltarPag() {
		if (this.pagAtual > 0)
			this.pagAtual--;
	}

	public String detalhes() {
		return "Livro [titulo=" + this.titulo + ", autor=" + this.autor + ", totPaginas=" + this.totPaginas + ", pagAtual=" + this.pagAtual
				+ ", aberto=" + this.aberto + ", leitor=" + this.leitor.getNome() + "]";
	}

}
