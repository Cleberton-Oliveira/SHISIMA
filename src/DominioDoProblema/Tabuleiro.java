	package DominioDoProblema;

public class Tabuleiro { // Nosso tabuleiro
	
	protected Jogador jogador1;
	protected Jogador jogador2;
	protected Matriz vetorPosicoes;
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

	public boolean obterPartidaEmAndamento() {
		// TODO Auto-generated method stub
		return this.partidaAndamento;
	}

	public boolean encerrarHavendoPartida() {
		// TODO Auto-generated method stub
		return true;
	}


}
