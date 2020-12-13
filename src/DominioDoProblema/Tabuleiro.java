	package DominioDoProblema;

public class Tabuleiro {
	
	protected Jogador jogador1;
	protected Jogador jogador2;
	protected Jogador daVez;
	protected Matriz matriz;
	protected Estado estado;
	protected boolean conectado = false;
	protected boolean partidaAndamento = false;

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
		System.out.println("[Tabuleiro] reiniciarTabuleiro");
		matriz.iniciar();
	}
	
	public void iniciarNovaPartida(Integer ordem, String nomeAdversario) {
		System.out.println("[iniciarNovaPartida] 2");
		reiniciarTabuleiro();
		
		this.jogador1 = new Jogador();
		this.jogador2 = new Jogador();
		
		this.jogador2.definirNome(nomeAdversario);
		
		if (ordem == 1) {
			this.jogador1.definirComoPrimeiro();
			definirDaVez(jogador1);
			matriz.definirOcupantes(jogador1, jogador2);
		} else {
			this.jogador2.definirComoPrimeiro();
			definirDaVez(jogador2);
			matriz.definirOcupantes(jogador2, jogador1);
		}
		System.out.println("[iniciarNovaPartida] 3");
		definirPartidaAndamento(true);
	}
	
	public boolean verificarTurno() {
		return obterDaVez().informarCor() == jogador1.informarCor();
	}
	
	public boolean verificarPosicaoVazia(int linha, int coluna) {
		return matriz.posicoes[linha][coluna].ocupante == null;
	}
	
	// TODO CORRIGIR
	private boolean verificarLanceValido(Lance lance) {
		boolean logico = false;
		int valorLinha = lance.linhaOrigem - lance.linhaDestino;
		int valorColuna = lance.colunaOrigem - lance.colunaDestino;
		
		System.out.println("================================");
		System.out.println("Linha destino : " + lance.linhaDestino);
		System.out.println("Coluna destino : " + lance.colunaDestino);
		System.out.println("================================");
		System.out.println("Linha Origem : " + lance.linhaOrigem);
		System.out.println("Coluna Origem : " + lance.colunaOrigem);
		System.out.println("================================");
		System.out.println("valorLinha: " + valorLinha);
		System.out.println("valorColuna: " + valorColuna);
		
		if (lance.linhaOrigem == 1 && lance.colunaOrigem == 1){
			logico =  true;
		}else if(  lance.linhaDestino == 1 && lance.colunaDestino == 1) {  
			logico =  true;
		}else if (valorLinha == 1 && valorColuna == 0) {
			logico =  true;
		}else if(valorLinha == -1 && valorColuna == 0) {
			logico =  true;
		}else if(valorColuna == 1 && valorLinha == 0) {
			logico =  true;
		}else if(valorColuna == -1 && valorLinha == 0) {
			logico =  true;
		}

		return logico;
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
			System.out.println("[verificarPosicaoDestinoValida] vazia");
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
		trocarTurno();
		matriz.testePrintMatriz(); // TESTE
		matriz.atualizaMatriz();
	}
	
	private void trocarTurno() {
		Jogador daVez = obterDaVez();
		if (daVez.informarCor() == jogador1.informarCor()) {
			definirDaVez(jogador2);
		} else {
			definirDaVez(jogador1);
		}
	}

	
}
