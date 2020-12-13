	package DominioDoProblema;

public class Tabuleiro {
	
	protected Jogador jogadorLocal;
	protected Jogador jogadorRemoto;
	protected Jogador daVez;
	protected Matriz matriz;
	protected Estado estado;
	protected boolean partidaAndamento = false;
	protected boolean conectado = false;

	public Tabuleiro() {
		matriz = new Matriz();
		estado = new Estado();
	}
	
	public void definirDaVez(Jogador jogador) {
		this.daVez = jogador;
	}
	
	public Jogador obterDaVez() {
		return this.daVez;
	}
	
	public Estado obterEstado() {
		return this.estado;
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
	
	public boolean obterPartidaEmAndamento() {
		return this.partidaAndamento;
	}

	public boolean encerrarHavendoPartida() {
		return true;
	}
	
	public void iniciarTabuleiro() {
//		System.out.println("[Tabuleiro] reiniciarTabuleiro");
		matriz.iniciar();
	}
	
	public void iniciarNovaPartida(Integer ordem, String nomeAdversario) {
//		System.out.println("[iniciarNovaPartida] 2");
		iniciarTabuleiro();
		
		this.jogadorLocal = new Jogador();
		this.jogadorRemoto = new Jogador();
		
		this.jogadorRemoto.definirNome(nomeAdversario);
		
		if (ordem == 1) {
			this.jogadorLocal.definirComoPrimeiro();
			definirDaVez(jogadorLocal);
			matriz.definirOcupantes(jogadorLocal, jogadorRemoto);
		} else {
			this.jogadorRemoto.definirComoPrimeiro();
			definirDaVez(jogadorRemoto);
			matriz.definirOcupantes(jogadorRemoto, jogadorLocal);
		}
//		System.out.println("[iniciarNovaPartida] 3");
		definirPartidaAndamento(true);
	}
	
	public boolean verificarTurno() {
		return obterDaVez().informarCor() == jogadorLocal.informarCor();
	}
	
	public boolean verificarPosicaoVazia(int linha, int coluna) {
		return matriz.posicoes[linha][coluna].ocupante == null;
	}
	
	private boolean verificarLanceValido(Lance lance) {
		int valorLinha = lance.linhaOrigem - lance.linhaDestino;
		int valorColuna = lance.colunaOrigem - lance.colunaDestino;
		
		if((lance.linhaOrigem == 1 && lance.colunaOrigem == 1) || (lance.linhaDestino == 1 && lance.colunaDestino == 1)) {
			return true;
		} else if((valorLinha == 1 && valorColuna == 0) || (valorLinha == -1 && valorColuna == 0)){
			return true;
		}else if((valorColuna == 1 && valorLinha == 0) || (valorColuna == -1 && valorLinha == 0)){
			return true;
		}
		return false;
	}
	
	public boolean verificarPosicaoOrigemValida(int linha, int coluna) {
		boolean valida = false;
		boolean vazia = verificarPosicaoVazia(linha, coluna);
		if (!vazia) {
			valida = matriz.posicoes[linha][coluna].ocupante.informarCor() == obterDaVez().informarCor();
			if (valida) {
				Lance lance = new Lance();
				lance.definirLinhaOrigem(linha);
				lance.definirColunaOrigem(coluna);
				this.estado = new Estado();
				this.estado.definirLance(lance);
			}
		}
		return valida;
	}
	
	public boolean verificarPosicaoDestinoValida(int linha, int coluna) {
		boolean valida = false;
		boolean vazia = verificarPosicaoVazia(linha, coluna);
		if (vazia) {
//			System.out.println("[verificarPosicaoDestinoValida] vazia");
			Lance lance = this.estado.obterLance();
			lance.definirLinhaDestino(linha);
			lance.definirColunaDestino(coluna);
			this.estado.definirLance(lance);
		
			valida = verificarLanceValido(lance);
		}
		return valida;
	}
	
	public void atualizarEstado() {
		Lance lance = this.estado.obterLance();
		matriz.posicoes[lance.linhaOrigem][lance.colunaOrigem].ocupante = null; // desalocar origem
		matriz.posicoes[lance.linhaDestino][lance.colunaDestino].ocupante = obterDaVez(); // alocar destino
//		trocarTurno();
		// matriz.testePrintMatriz(); // TESTE
	}
	
	public void trocarTurno() {
		Jogador daVez = obterDaVez();
		if (daVez.informarCor() == jogadorLocal.informarCor()) {
			definirDaVez(jogadorRemoto);
		} else {
			definirDaVez(jogadorLocal);
		}
	}
	
	public boolean verificarVencedor() {
		return this.matriz.avaliarTresPosicoesAlinhadas(obterDaVez());
	}

	
}
