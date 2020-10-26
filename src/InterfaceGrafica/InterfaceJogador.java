package InterfaceGrafica;

import DominioDoProblema.Tabuleiro;
import Rede.InterfaceNetgamesServer;

public class InterfaceJogador {
	
	protected InterfaceNetgamesServer ngServer;
	protected Tabuleiro tabuleiro; // Nosso tabuleiro
	private InterfaceJogo iJogo;

	public InterfaceJogador(InterfaceJogo iJogo) {
		this.iJogo = iJogo;
		ngServer = new InterfaceNetgamesServer();
		tabuleiro = new Tabuleiro();
	}

	public String conectar() {
		String mensagem = "";
		
		boolean conectado = this.ngServer.informarConectado();
			
		if (!conectado) {
			String nomeJogador = this.iJogo.obterNomeJogador();
			String enderecoServidor = this.iJogo.obterEnderecoServidor();
			mensagem = this.ngServer.conectar(enderecoServidor, nomeJogador);
			
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

}
