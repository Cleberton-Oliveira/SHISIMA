package DominioDoProblema;

public class Jogador {
	
	protected String cor;
	protected String nome;
	protected boolean meuTurno = false;
	protected boolean vencedor = false;
	
	public Jogador() {}
	
	public void definirNome(String nome) {
		
	}
	
	public void definirCor(String cor) {
			
	}
	
	public void definirComoPrimeiro() {
		
	}
	
	public void inverterTurno() {
		this.meuTurno = !meuTurno;
	}
	
	public boolean informarTurno() {
		return this.meuTurno;
	}
}
