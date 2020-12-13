package Rede;

import javax.swing.JOptionPane;

import InterfaceGrafica.InterfaceJogador;
import br.ufsc.inf.leobr.cliente.Jogada;
import br.ufsc.inf.leobr.cliente.OuvidorProxy;
import br.ufsc.inf.leobr.cliente.Proxy;
import br.ufsc.inf.leobr.cliente.exception.ArquivoMultiplayerException;
import br.ufsc.inf.leobr.cliente.exception.JahConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoJogandoException;
import br.ufsc.inf.leobr.cliente.exception.NaoPossivelConectarException;

public class InterfaceNetgamesServer implements OuvidorProxy {
	
	private static final long serialVersionUID = 1L;
	protected Proxy proxy;
	protected boolean conectado = false;
	private InterfaceJogador atorJogador;
	
	public InterfaceNetgamesServer(InterfaceJogador atorJogador) {
		super();
		this.proxy = Proxy.getInstance();
		proxy.addOuvinte(this);
		this.atorJogador = atorJogador;
	}
	
	public String conectar(String servidor, String nome) {
			try {
				proxy.conectar(servidor, nome);
			} catch (JahConectadoException e) {
				e.printStackTrace();
				return "Voce ja esta conectado";
			} catch (NaoPossivelConectarException e) {
				e.printStackTrace();
				return "Nao foi possivel conectar";
			} catch (ArquivoMultiplayerException e) {
				e.printStackTrace();
				return "Voce esqueceu o arquivo de propriedades";
			}
			this.definirConectado(true);
			return "Sucesso: conectado a Netgames Server";
	}

	private void definirConectado(boolean valor) {
		this.conectado = valor;
	}

	public String desconectar() {
			try {
				proxy.desconectar();
			} catch (NaoConectadoException e) {
				e.printStackTrace();
				return "Voce nao esta conectado";
			}
			this.definirConectado(false);
			return "Sucesso: desconectado de Netgames Server";
	}

	public String iniciarPartida() {
		try {
			proxy.iniciarPartida(new Integer(2)); // supondo 2 jogadores, o que pode ser alterado
		} catch (NaoConectadoException e) {
			e.printStackTrace();
			return "Falha ao tentar enviar solicitacao de inicio enviada a Netgames Server";
		}
		return "Sucesso: solicitacao de inicio enviada a Netgames Server";
	}

	@Override
	public void iniciarNovaPartida(Integer posicao) {
		JOptionPane.showMessageDialog(null, "[Teste] Netgames enviou partida iniciada");
		String nomeAdversario = this.proxy.obterNomeAdversario(posicao);
		this.atorJogador.iniciarNovaPartida(posicao, nomeAdversario);
	}

	@Override
	public void finalizarPartidaComErro(String message) {		
	}

	@Override
	public void receberMensagem(String msg) {
	}

	@Override
	public void receberJogada(Jogada jogada) {
		atorJogador.tratarReceberJogada(jogada);
	}
	
	public void enviarJogada(Jogada jogada) {
		try {
			this.proxy.enviaJogada(jogada);
		} catch (NaoJogandoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void tratarConexaoPerdida() {		
	}

	@Override
	public void tratarPartidaNaoIniciada(String message) {		
	}

	public boolean informarConectado() {
		return this.conectado;
	}

	public void encerrarPartida() {		
	}

}
