package DominioDoProblema;

import br.ufsc.inf.leobr.cliente.Jogada;

public class Lance implements Jogada {
	
	private static final long serialVersionUID = 1L;
	protected int linhaOrigem;
	protected int linhaDestino;
	protected int colunaOrigem;
	protected int colunaDestino;
	
	public Lance() {
	}
	
	public void definirLinhaOrigem(int valor) {
		this.linhaOrigem = valor;
	}
	
	public void definirLinhaDestino(int valor) {
		this.linhaDestino = valor;
	}
	
	public void definirColunaOrigem(int valor) {
		this.colunaOrigem = valor;
	}
	
	public void definirColunaDestino(int valor) {
		this.colunaDestino = valor;
	}
	
	public int obterLinhaOrigem() {
		return this.linhaOrigem;
	}
	
	public int obterColunhaOrigem() {
		return this.colunaOrigem;
	}
	
	public int obterLinhaDestino() {
		return this.linhaDestino;
	}
	
	public int obterColunaDestino() {
		return this.colunaDestino;
	}

}
