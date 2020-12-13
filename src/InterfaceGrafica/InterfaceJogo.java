package InterfaceGrafica;

import java.awt.EventQueue;

import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import DominioDoProblema.Jogador;
import DominioDoProblema.Lance;
import DominioDoProblema.Posicao;

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
	private JLabel[][] JLabels;

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

		// TABULEIRO
		Icon iconeVazio = new ImageIcon(getClass().getResource("vazio.png"));
		Icon iconeAzul = new ImageIcon(getClass().getResource("azul.png"));
		Icon iconeVermelho = new ImageIcon(getClass().getResource("vermelho.png"));
		Icon template = new ImageIcon(getClass().getResource("template.png"));
		
		JLabel background = new JLabel();
		background.setBounds(new Rectangle(00, 00, 600, 600));
		background.setIcon(template);				
		
		JLabel vPosicao0 = new JLabel();
		vPosicao0.setBounds(new Rectangle(274, 242, 170, 170));
		vPosicao0.setIcon(iconeVazio);				
		vPosicao0.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				click(1,1);
			}
		});
		
		JLabel vPosicao1 = new JLabel();
		vPosicao1.setBounds(new Rectangle(274, 44, 170, 170));
		vPosicao1.setIcon(iconeAzul);				
		vPosicao1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				click(0,1);
			}
		});
	
		JLabel vPosicao2 = new JLabel();
		vPosicao2.setBounds(new Rectangle(414, 102, 170, 170));
		vPosicao2.setIcon(iconeAzul);				
		vPosicao2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				click(0,2);
			}
		});
		JLabel vPosicao3 = new JLabel();
		vPosicao3.setBounds(new Rectangle(472, 242, 170, 170));
		vPosicao3.setIcon(iconeVazio);				
		vPosicao3.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				click(1,2);
			}
		});
	
		JLabel vPosicao4 = new JLabel();
		vPosicao4.setBounds(new Rectangle(414, 380, 170, 170));
		vPosicao4.setIcon(iconeVermelho);				
		vPosicao4.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				click(2,2);
			}
		});
		JLabel vPosicao5 = new JLabel();
		vPosicao5.setBounds(new Rectangle(274, 440, 170, 170));
		vPosicao5.setIcon(iconeVermelho);				
		vPosicao5.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				click(2,1);
			}
		});
		
		JLabel vPosicao6 = new JLabel();
		vPosicao6.setBounds(new Rectangle(134, 380, 170, 170));
		vPosicao6.setIcon(iconeVermelho);				
		vPosicao6.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				click(2,0);
			}
		});
		JLabel vPosicao7 = new JLabel();
		vPosicao7.setBounds(new Rectangle(76, 242, 170, 170));
		vPosicao7.setIcon(iconeVazio);				
		vPosicao7.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				click(1,0);
			}
		});
		
		JLabel vPosicao8 = new JLabel();
		vPosicao8.setBounds(new Rectangle(134, 102, 170, 170));
		vPosicao8.setIcon(iconeAzul);				
		vPosicao8.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				click(0,0);
			}
		});
		
		JLabels = new JLabel[3][3];
		for(int i = 0; i < 3; i++){
		    for(int j = 0; j < 3; j++){
		    	JLabels[i][j] = new JLabel();
		    }
		}
		
		JLabels[0][0] = vPosicao8;
		JLabels[0][1] = vPosicao1;
		JLabels[0][2] = vPosicao2;
		
		JLabels[1][0] = vPosicao7;
		JLabels[1][1] = vPosicao0;
		JLabels[1][2] = vPosicao3;
		
		JLabels[2][0] = vPosicao6;
		JLabels[2][1] = vPosicao5;
		JLabels[2][2] = vPosicao4;
		
		
		frame.getContentPane().add(JLabels[0][0]);
		frame.getContentPane().add(JLabels[0][1]);
		frame.getContentPane().add(JLabels[0][2]);
		frame.getContentPane().add(JLabels[1][0]);
		frame.getContentPane().add(JLabels[1][1]);
		frame.getContentPane().add(JLabels[1][2]);
		frame.getContentPane().add(JLabels[2][0]);
		frame.getContentPane().add(JLabels[2][1]);
		frame.getContentPane().add(JLabels[2][2]);
		frame.getContentPane().add(background);
		
	}
	
	public void click(int linha, int coluna) {
		System.out.println("Usuario click");
		boolean origemSelecionada = obterPosOrigemSelecionada();
		if (origemSelecionada) {
			boolean posValida = atorJogador.validarClickDestino(linha, coluna);
			if (posValida) {
				System.out.println("[Teste] destino selecionada");
				System.out.printf("linha: %d colunha: %d\n", linha, coluna);
				inverterValorPosOrigemSelecionada();
				atorJogador.atualizarEstado();
			}
		} else {
			boolean posValida = atorJogador.validarClickOrigem(linha, coluna);
			if (posValida) {
				System.out.println("[Teste] origem selecionada");
				System.out.printf("linha: %d colunha: %d\n", linha, coluna);
				inverterValorPosOrigemSelecionada();
			}
		}
	}
	
	public void atualizarEstado(Lance lance) {
		int linhaOrigem = lance.obterLinhaOrigem();
		int colunaOrigem = lance.obterColunhaOrigem();
		int linhaDestino = lance.obterLinhaDestino();
		int colunaDestino = lance.obterColunaDestino();
		
		JLabel jLabelOrigem = JLabels[linhaOrigem][colunaOrigem];
		JLabel jLabelDestino = JLabels[linhaDestino][colunaDestino];
		
		Icon iconeOrigem = jLabelOrigem.getIcon();
		Icon iconeDestino = jLabelDestino.getIcon();

		jLabelOrigem.setIcon(iconeDestino);
		jLabelDestino.setIcon(iconeOrigem);
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
	
	
	
}
