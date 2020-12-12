	package DominioDoProblema;

public class Tabuleiro {
	
	protected Jogador jogador1;
	protected Jogador jogador2;
	protected Matriz matriz;
	protected boolean conectado = false;
	protected boolean partidaAndamento = false;

	public Tabuleiro() {
		matriz = new Matriz();
	}

	public void definirConectado(boolean valor) {
		conectado = valor;
	}
	
	public boolean estaConectado() {
		return conectado;
	}
	
	public void definirPartidaAndamento(boolean valor) {
		partidaAndamento = valor;
	}
	
	public boolean permitidoConectar() {
		return !conectado;
	}
	
	public boolean permitidoDesconectar() {
		return conectado;
	}

	public boolean permitidoIniciarPartida() {
		return !partidaAndamento;
	}

	public boolean obterPartidaEmAndamento() {
		return this.partidaAndamento;
	}

	public boolean encerrarHavendoPartida() {
		return true;
	}
	
	public void reiniciarTabuleiro() {
		matriz.iniciar();
	}
	
	public void iniciarNovaPartida(Integer ordem, String nomeAdversario) {
		reiniciarTabuleiro();
		
		this.jogador1 = new Jogador();
		this.jogador2 = new Jogador();
		
		this.jogador2.definirNome(nomeAdversario);
		
		if (ordem == 1) {
			this.jogador1.definirComoPrimeiro();
			matriz.definirOcupantes(jogador1, jogador2);
		} else {
			this.jogador2.definirComoPrimeiro();
			matriz.definirOcupantes(jogador2, jogador1);
		}
		definirPartidaAndamento(true);
	}

}
