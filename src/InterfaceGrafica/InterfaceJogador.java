package InterfaceGrafica;

import DominioDoProblema.Estado;
import DominioDoProblema.Jogador;
import DominioDoProblema.Lance;
import DominioDoProblema.Tabuleiro;
import Rede.InterfaceNetgamesServer;
import br.ufsc.inf.leobr.cliente.Jogada;

public class InterfaceJogador {
	
	protected InterfaceNetgamesServer ngServer;
	protected Tabuleiro tabuleiro;
	private InterfaceJogo iJogo;

	public InterfaceJogador(InterfaceJogo iJogo) {
		this.iJogo = iJogo;
		ngServer = new InterfaceNetgamesServer(this);
		tabuleiro = new Tabuleiro();
	}

	public String conectar() {
		String mensagem = "";
		
		boolean conectado = this.ngServer.informarConectado();
			
		if (!conectado) {
			String nomeJogador = this.iJogo.obterNomeJogador();
			String enderecoServidor = this.iJogo.obterEnderecoServidor();
			mensagem = this.ngServer.conectar(enderecoServidor, nomeJogador);
			this.tabuleiro.definirConectado(true);
			
		} else {
			mensagem = "Você já está conectado";
		}
		
		return mensagem;
	}
	
	public String desconectar() {
		
		String mensagem = "";
		
		boolean conectado = this.ngServer.informarConectado();
		
		if (!conectado) {
			mensagem = "Você não está conectado";	
		} else {
			boolean atualizarInterface = this.tabuleiro.encerrarHavendoPartida();
			
			if (atualizarInterface) {
				this.ngServer.encerrarPartida();
			}
				
			mensagem = this.ngServer.desconectar();
			this.tabuleiro.definirConectado(false);
			
		}
		return mensagem;
	}
	
	public String iniciarPartida() {
		String mensagem = "Condicao para iniciar partida nao atendida (defina qual)";
		boolean partidaEmAndamento = tabuleiro.obterPartidaEmAndamento();
		if (!partidaEmAndamento) {
			mensagem = ngServer.iniciarPartida();
		}
		return mensagem;
	}
	
	public void iniciarNovaPartida(Integer ordem, String nomeAdversario) {
		this.tabuleiro.iniciarNovaPartida(ordem,nomeAdversario);
	}
	
	public boolean validarClickOrigem(int linha, int coluna) {
		boolean posValida = false;
		boolean partidaEmAndamento = tabuleiro.obterPartidaEmAndamento();
		if (!partidaEmAndamento) {
			this.iJogo.notificar("Não há partida em andamento!");
		} else {
			boolean meuTurno = tabuleiro.verificarTurno();
			if (!meuTurno) {
				this.iJogo.notificar("Não é seu turno!");
			} else {
				posValida = tabuleiro.verificarPosicaoOrigemValida(linha, coluna);
				if (!posValida) {
					this.iJogo.notificar("Posição de origem inválida!");
				}
			}
		}
		return posValida;
	}
	
	public boolean validarClickDestino(int linha, int coluna) {
		boolean posValida = tabuleiro.verificarPosicaoDestinoValida(linha, coluna);
		if (!posValida) {
			this.iJogo.notificar("Posição de destino inválida!");
		} else {
			Estado estado = this.tabuleiro.obterEstado();
			Lance lance = estado.obterLance();
			enviarJogada(lance);
		}
		return posValida;
	}
	
	public void enviarJogada(Lance lance) {
		this.ngServer.enviarJogada(lance);
	}
	
	public void atualizarEstado() {
		this.tabuleiro.atualizarEstado();
		boolean vencedor = this.tabuleiro.verificarVencedor();
		Estado estado = this.tabuleiro.obterEstado();
		Lance lance = estado.obterLance();
		this.iJogo.atualizarEstado(lance);
		if (vencedor) {
			this.tabuleiro.registrarVencedor();
			Jogador jogadorVencedor = this.tabuleiro.obterDaVez();
			int cor = jogadorVencedor.informarCor();
			if (cor == 1) {
				this.iJogo.notificar("Azul venceu!");
			} else {
				this.iJogo.notificar("Vermelho venceu!");
			}
			this.tabuleiro.encerrarPartida();
			this.iJogo.assumirPosicaoInicial();
			this.ngServer.encerrarPartida();
		}
		this.tabuleiro.trocarTurno();
	}
	
	public void tratarReceberJogada(Jogada jogada) {
		Estado estado = this.tabuleiro.obterEstado();
		Lance lance = (Lance) jogada;
		estado.definirLance(lance);
		atualizarEstado();
	}

}
