	package DominioDoProblema;

public class Tabuleiro { // Nosso tabuleiro
	
	protected Jogador jogador1;
	protected Jogador jogador2;
	protected VetorPosicoes vetorPosicoes;
	protected boolean conectado = false;
	protected boolean partidaAndamento = false;

	public Tabuleiro() {
		// TODO Auto-generated constructor stub
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
	
	public boolean informarPartidaAndamento() {
		return partidaAndamento;
	}
	
	public boolean permitidoConectar() {
		return !conectado;
		// defina a l�gica do seu jogo
	}
	
	public boolean permitidoDesconectar() {
		return conectado;
		// defina a l�gica do seu jogo
	}

	public boolean permitidoIniciarPartida() {
		return !partidaAndamento;
		// defina a l�gica do seu jogo
	}


}
