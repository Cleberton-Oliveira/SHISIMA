package DominioDoProblema;

public class Jogador {
	
	protected int cor = 0;
	protected String nome;
	protected boolean meuTurno = false;
	protected boolean vencedor = false;
	
	public Jogador() {}
	
	public void definirNome(String nome) {
		this.nome = nome;
	}
	
	public String informarNome() {
		return this.nome;
	}
	
	public void definirCor(int cor) {
		this.cor = cor;
	}
	
	public int informarCor() {
		return this.cor;
	}
	
	public void definirComoPrimeiro() {
		inverterTurno();
		definirCor(1);
	}
	
	private void inverterTurno() {
		this.meuTurno = !meuTurno;
	}
	
	public boolean informarTurno() {
		return this.meuTurno;
	}
	
	public void definirVencedor() {
		this.vencedor = true;
	}
}
