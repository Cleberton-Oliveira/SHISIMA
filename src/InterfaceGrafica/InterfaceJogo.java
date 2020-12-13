package InterfaceGrafica;

import java.awt.EventQueue;

import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import DominioDoProblema.Lance;

import javax.swing.JMenu;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class InterfaceJogo {

	private JFrame frame;
	private final Action actionConectar = new SwingActionConectar();
	private final Action actionDesconectar = new SwingActionDesconectar();
	private final Action actionIniciarPartida = new SwingActionIniciarPartida();
	private InterfaceJogador atorJogador;
	private boolean posOrigemSelecionada = false;

	
	// TABULEIRO
	Icon iconeVazio = new ImageIcon(getClass().getResource("vazio.png"));
	Icon iconeVazioClicado = new ImageIcon(getClass().getResource("vazio-clicavel.png"));
	Icon iconeAzul = new ImageIcon(getClass().getResource("azul.png"));
	Icon iconeVermelho = new ImageIcon(getClass().getResource("vermelho.png"));
	Icon template = new ImageIcon(getClass().getResource("template.png"));
	Icon iconeAzulClicado = new ImageIcon(getClass().getResource("azul-clicado.png"));
	Icon iconeVermelhoClicado = new ImageIcon(getClass().getResource("vermelho-clicado.png"));
	
	
	JLabel vPosicao11 = new JLabel();
	JLabel vPosicao01 = new JLabel();
	JLabel vPosicao02 = new JLabel();
	JLabel vPosicao12 = new JLabel();
	JLabel vPosicao22 = new JLabel();
	JLabel vPosicao21 = new JLabel();
	JLabel vPosicao20 = new JLabel();
	JLabel vPosicao10 = new JLabel();
	JLabel vPosicao00 = new JLabel();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceJogo window = new InterfaceJogo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public InterfaceJogo() {
		initialize();
	}

	private void initialize() {
		atorJogador = new InterfaceJogador(this);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 610, 660);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Shisima");

		JMenuItem menuItemConectar = new JMenuItem("conectar");
		menuItemConectar.setAction(actionConectar);
		JMenuItem menuItemDesconectar = new JMenuItem("desconectar");
		menuItemDesconectar.setAction(actionDesconectar);
		JMenuItem menuItemIniciarPartida = new JMenuItem("iniciar partida");
		menuItemIniciarPartida.setAction(actionIniciarPartida);
		
		// ICONES
		Icon iconeIniciar = new ImageIcon(getClass().getResource("iniciar.png"));
		Icon iconeIniciarClicado = new ImageIcon(getClass().getResource("iniciar-clicado.png"));
		Icon iconeConectar = new ImageIcon(getClass().getResource("conectar.png"));
		Icon iconeConectarClicado = new ImageIcon(getClass().getResource("conectar-clicado.png"));
		Icon iconeDesconectar = new ImageIcon(getClass().getResource("desconectar.png"));
		Icon iconeDesconectarClicado = new ImageIcon(getClass().getResource("desconectar-clicado.png"));
		
		//	BOTOES
		JLabel botaoConectar = new JLabel();
		JLabel botaoDesconectar = new JLabel();
		JLabel botaoIniciar = new JLabel();
		
		botaoConectar.setBounds(new Rectangle(450, -30, 190, 170));
		botaoConectar.setIcon(iconeConectar);		
		botaoConectar.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				botaoConectar.setIcon(iconeConectarClicado);
				menuItemConectar.doClick();
				botaoConectar.setIcon(iconeConectar);
				if (atorJogador.ngServer.informarConectado()) {
					botaoConectar.setVisible(false);
				}
			}
		});
		
		botaoDesconectar.setBounds(new Rectangle(450, -30, 190, 170));
		botaoDesconectar.setIcon(iconeDesconectar);				
		botaoDesconectar.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				botaoDesconectar.setIcon(iconeDesconectarClicado);	 
				menuItemDesconectar.doClick();
				botaoDesconectar.setIcon(iconeDesconectar);
				if (!atorJogador.ngServer.informarConectado()) {
					botaoConectar.setVisible(true);
				}
			}
		});
		
		botaoIniciar.setBounds(new Rectangle(20, -30, 190, 170));
		botaoIniciar.setIcon(iconeIniciar);
		botaoIniciar.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				botaoIniciar.setIcon(iconeIniciarClicado);
				menuItemIniciarPartida.doClick();
				botaoIniciar.setIcon(iconeIniciar);
			}
		});
		
		frame.getContentPane().add(botaoConectar);
		frame.getContentPane().add(botaoDesconectar);
		frame.getContentPane().add(botaoIniciar);


		
		JLabel background = new JLabel();
		background.setBounds(new Rectangle(00, 00, 600, 600));
		background.setIcon(template);				
		
		
		vPosicao11.setBounds(new Rectangle(274, 242, 190, 170));
		vPosicao11.setIcon(iconeVazio);				
		vPosicao11.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				click(1,1);
			}
		});
		
	
		vPosicao01.setBounds(new Rectangle(274, 44, 190, 170));
		vPosicao01.setIcon(iconeAzul);				
		vPosicao01.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				click(0,1);
				vPosicao01.setIcon(iconeAzulClicado);
			}
		});
	

		vPosicao02.setBounds(new Rectangle(414, 102, 190, 170));
		vPosicao02.setIcon(iconeAzul);				
		vPosicao02.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				click(0,2);
				vPosicao02.setIcon(iconeAzulClicado);
			}
		});
	
		vPosicao12.setBounds(new Rectangle(472, 242, 190, 170));
		vPosicao12.setIcon(iconeVazio);				
		vPosicao12.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				click(1,2);
				vPosicao12.setIcon(iconeVazioClicado);
			}
		});
	

		vPosicao22.setBounds(new Rectangle(414, 380, 190, 170));
		vPosicao22.setIcon(iconeVermelho);				
		vPosicao22.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				click(2,2);
				vPosicao22.setIcon(iconeVermelhoClicado);
			}
		});

		vPosicao21.setBounds(new Rectangle(274, 440, 190, 170));
		vPosicao21.setIcon(iconeVermelho);				
		vPosicao21.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				click(2,1);
				vPosicao21.setIcon(iconeVermelhoClicado);
			}
		});
		

		vPosicao20.setBounds(new Rectangle(134, 380, 190, 170));
		vPosicao20.setIcon(iconeVermelho);				
		vPosicao20.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				click(2,0);
				vPosicao20.setIcon(iconeVermelhoClicado);
			}
		});

		vPosicao10.setBounds(new Rectangle(76, 242, 190, 170));
		vPosicao10.setIcon(iconeVazio);				
		vPosicao10.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				click(1,0);
			}
		});
		

		vPosicao00.setBounds(new Rectangle(134, 102, 190, 170));
		vPosicao00.setIcon(iconeAzul);				
		vPosicao00.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				vPosicao00.setIcon(iconeAzulClicado);
				click(0,0);
			}
		});
		
		frame.getContentPane().add(vPosicao11);
		frame.getContentPane().add(vPosicao01);
		frame.getContentPane().add(vPosicao02);
		frame.getContentPane().add(vPosicao12);
		frame.getContentPane().add(vPosicao22);
		frame.getContentPane().add(vPosicao21);
		frame.getContentPane().add(vPosicao20);
		frame.getContentPane().add(vPosicao10);
		frame.getContentPane().add(vPosicao00);
		frame.getContentPane().add(background);

	}
	
	public void click(int linha, int coluna) {
		System.out.print("Usuario click");
		boolean origemSelecionada = obterPosOrigemSelecionada();
		System.out.println(" --   Linha: " + linha + " coluna: " + coluna );
		if (origemSelecionada) {
			String mensagem = atorJogador.lidarComClickDestino(linha, coluna);
			if (!mensagem.equals("[Teste] OK")) {
				notificar(mensagem);
			} else {
				System.out.println("[Teste] destino selecionada");
				inverterValorPosOrigemSelecionada(); // desmarco origem como selecionada
				// atualizar o estado do tabuleiro
				atorJogador.atualizarEstado();
			}
		} else {
			String mensagem = atorJogador.lidarComClickOrigem(linha, coluna);
			if (!mensagem.equals("[Teste] OK")) {
				notificar(mensagem);
			} else {
				System.out.println("[Teste] origem selecionada");
				inverterValorPosOrigemSelecionada(); // marco origem como selecionada
			}
		}
	}

	
	public boolean obterPosOrigemSelecionada() {
		return posOrigemSelecionada;
	}
	
	public void inverterValorPosOrigemSelecionada() {
		this.posOrigemSelecionada = ! posOrigemSelecionada;
	}
	
	
	private class SwingActionConectar extends AbstractAction {

		private static final long serialVersionUID = 1L;
		
		public SwingActionConectar() {
			putValue(NAME, "conectar");
			putValue(SHORT_DESCRIPTION, "conectar a Netgames Server");
		}
		
		public void actionPerformed(ActionEvent e) {
			String mensagem = atorJogador.conectar();
			notificar(mensagem);
		}
	}
	
	private class SwingActionDesconectar extends AbstractAction {

		private static final long serialVersionUID = 1L;
		public SwingActionDesconectar() {
			putValue(NAME, "desconectar");
			putValue(SHORT_DESCRIPTION, "desconectar de Netgames Server");
		}
		public void actionPerformed(ActionEvent e) {
			String mensagem = atorJogador.desconectar();
			notificar(mensagem);
		}
	}
	
	private class SwingActionIniciarPartida extends AbstractAction {

		private static final long serialVersionUID = 1L;
		public SwingActionIniciarPartida() {
			putValue(NAME, "iniciar partida");
			putValue(SHORT_DESCRIPTION, "iniciar partida do seu jogo");
		}
		public void actionPerformed(ActionEvent e) {
			String mensagem = atorJogador.iniciarPartida();
			notificar(mensagem);
		}
	}
	
	public String obterNomeJogador() {
		String nome = JOptionPane.showInputDialog("Insira o nome do jogador"); 
		return nome;
	}


	public String obterEnderecoServidor() {
		String enderecoServidor = JOptionPane.showInputDialog("Insira o endereco do servidor"); 
		return enderecoServidor;
	}
	
	public void notificar(String notificacao) {
		JOptionPane.showMessageDialog(null, notificacao);
	}

	public void addSemPeca(int i, int j) {

		vPosicao00.setIcon(iconeVazio);	
		System.out.println("passei por aqui");
	}
	public void addVermelho(int i, int j) {

		vPosicao11.setIcon(iconeVermelho);				
	}
	public void addAzul(int i, int j) {

		vPosicao20.setIcon(iconeAzul);				
	}
}
