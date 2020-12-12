package InterfaceGrafica;

import DominioDoProblema.Estado;
import DominioDoProblema.Lance;
import DominioDoProblema.Tabuleiro;
import Rede.InterfaceNetgamesServer;

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
			
			boolean partidaEmAndamento = this.tabuleiro.obterPartidaEmAndamento();
			
			if (partidaEmAndamento) {
				// T0D0
				// encerra partida localmente
			}

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
		boolean permitido = tabuleiro.permitidoIniciarPartida();
		if (permitido) {
			mensagem = ngServer.iniciarPartida();
		}
		return mensagem;
	}
	
	public void iniciarNovaPartida(Integer ordem, String nomeAdversario) {
		System.out.println("[iniciarNovaPartida] 1");
		this.tabuleiro.iniciarNovaPartida(ordem,nomeAdversario);
	}
	
	public String lidarComClickOrigem(int linha, int coluna) {
		boolean partidaEmAndamento = tabuleiro.obterPartidaEmAndamento();
		if (!partidaEmAndamento) {
			return "Não há partida em andamento!";
		} else {
			boolean meuTurno = tabuleiro.verificarTurno();
			if (!meuTurno) {
				return "Não é seu turno!";
			} else {
				boolean posValida = tabuleiro.verificarPosicaoOrigemValida(linha, coluna);
				if (!posValida) {
					return "Posição inválida!";
				}
			}
		}
		return "[Teste] OK";
	}
	
	public String lidarComClickDestino(int linha, int coluna) {
		boolean posValida = tabuleiro.verificarPosicaoDestinoValida(linha, coluna);
		if (!posValida) {
			return "Posição inválida!";
		} else {
			Estado estado = this.tabuleiro.obterEstado();
			Lance lance = estado.obterLance();
			enviarJogada(lance);
		}
		return "[Teste] OK";
	}
	
	public void enviarJogada(Lance lance) {
		this.ngServer.enviarJogada(lance);
	}
	

}
