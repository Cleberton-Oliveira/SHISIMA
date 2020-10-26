package InterfaceGrafica;

import java.awt.EventQueue;

import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import javax.swing.JMenu;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class InterfaceJogo { // InterfaceShisima

	private JFrame frame;
	private final Action action = new SwingAction(); // action do conectar
	private final Action action_1 = new SwingAction_1(); // action do desconectar
	private final Action action_2 = new SwingAction_2();
	private InterfaceJogador atorJogador;

	/**
	 * Launch the application.
	 */
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
	

	

	/**
	 * Create the application.
	 */
	public InterfaceJogo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		atorJogador = new InterfaceJogador(this);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 610, 660);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Shisima");
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 57, 21);
		frame.setJMenuBar(menuBar);
			
		JMenu mnNewMenu = new JMenu("Jogo");
		mnNewMenu.setBounds(new Rectangle(1, 0, 57, 21));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmConectar = new JMenuItem("conectar");
		mntmConectar.setAction(action);
		mnNewMenu.add(mntmConectar);
		
		JMenuItem mntmDesconectar = new JMenuItem("desconectar");
		mntmDesconectar.setAction(action_1);
		mnNewMenu.add(mntmDesconectar);
		
		JMenuItem mntmIniciarPartida = new JMenuItem("iniciar partida");
		mntmIniciarPartida.setAction(action_2);
		mnNewMenu.add(mntmIniciarPartida);
		
		
//		BOT�ES
		
		Icon iniciar = new ImageIcon(getClass().getResource("iniciar.png"));
		Icon iniciar_clicado = new ImageIcon(getClass().getResource("iniciar-clicado.png"));
		Icon conectar = new ImageIcon(getClass().getResource("conectar.png"));
		Icon conectar_clicado = new ImageIcon(getClass().getResource("conectar-clicado.png"));
		Icon desconectar = new ImageIcon(getClass().getResource("desconectar.png"));
		Icon desconectar_clicado = new ImageIcon(getClass().getResource("desconectar-clicado.png"));
		
		
		JLabel iniciar_botao = new JLabel();
		iniciar_botao.setBounds(new Rectangle(20, -30, 190, 170));
		iniciar_botao.setIcon(iniciar);				
		iniciar_botao.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				iniciar_botao.setIcon(iniciar_clicado);
				//esperar 0.3segundos 
				//iniciar_botao.setIcon(iniciar);
			}
		});
		JLabel conectar_botao = new JLabel();
		conectar_botao.setBounds(new Rectangle(450, -30, 190, 170));
		conectar_botao.setIcon(conectar);				
		conectar_botao.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				conectar_botao.setIcon(conectar_clicado);	
				//esperar 0.3segundos 
				//conectar_botao.setIcon(conectar);
			}
		});
		
		JLabel desconectar_botao = new JLabel();
		desconectar_botao.setBounds(new Rectangle(450, -30, 190, 170));
		desconectar_botao.setIcon(desconectar);				
		desconectar_botao.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				desconectar_botao.setIcon(desconectar_clicado);	 
				//esperar 0.3segundos 
				//conectar_botao.setIcon(desconectar);
			}
		});
		
//	
		frame.getContentPane().add(iniciar_botao);
		if(true) {
			frame.getContentPane().add(conectar_botao);
		}else {
			frame.getContentPane().add(desconectar_botao);
		};
		
		
		

		
		
		
		
//		TABULEIRO 
		
		
		Icon vazio = new ImageIcon(getClass().getResource("vazio.png"));
		Icon azul = new ImageIcon(getClass().getResource("azul.png"));
		Icon vermelho = new ImageIcon(getClass().getResource("vermelho.png"));
		Icon template = new ImageIcon(getClass().getResource("template.png"));
		Icon azul_clicado = new ImageIcon(getClass().getResource("azul-clicado.png"));
		Icon vermelho_clicado = new ImageIcon(getClass().getResource("vermelho-clicado.png"));
		Icon vazio_clicavel = new ImageIcon(getClass().getResource("vazio-clicavel.png"));

	
		
		JLabel background = new JLabel();
		background.setBounds(new Rectangle(00, 00, 600, 600));
		background.setIcon(template);				
		background.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {

			}
		});

		
		JLabel vPosicao0 = new JLabel();
		vPosicao0.setBounds(new Rectangle(274, 242, 190, 170));
		vPosicao0.setIcon(vazio);				
		vPosicao0.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
			
			}
		});
		
		JLabel vPosicao1 = new JLabel();
		vPosicao1.setBounds(new Rectangle(274, 44, 190, 170));
		vPosicao1.setIcon(azul);				
		vPosicao1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				vPosicao1.setIcon(azul_clicado);
			}
		});
	
		JLabel vPosicao2 = new JLabel();
		vPosicao2.setBounds(new Rectangle(414, 102, 190, 170));
		vPosicao2.setIcon(azul);				
		vPosicao2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				vPosicao2.setIcon(azul_clicado);
			}
		});
		JLabel vPosicao3 = new JLabel();
		vPosicao3.setBounds(new Rectangle(472, 242, 190, 170));
		vPosicao3.setIcon(vazio);				
		vPosicao3.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {

			}
		});
	
		JLabel vPosicao4 = new JLabel();
		vPosicao4.setBounds(new Rectangle(414, 380, 190, 170));
		vPosicao4.setIcon(vermelho);				
		vPosicao4.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				vPosicao4.setIcon(vermelho_clicado);
			}
		});
		JLabel vPosicao5 = new JLabel();
		vPosicao5.setBounds(new Rectangle(274, 440, 190, 170));
		vPosicao5.setIcon(vermelho);				
		vPosicao5.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				vPosicao5.setIcon(vermelho_clicado);
			}
		});
		
		JLabel vPosicao6 = new JLabel();
		vPosicao6.setBounds(new Rectangle(134, 380, 190, 170));
		vPosicao6.setIcon(vermelho);				
		vPosicao6.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				vPosicao6.setIcon(vermelho_clicado);
			}
		});
		JLabel vPosicao7 = new JLabel();
		vPosicao7.setBounds(new Rectangle(76, 242, 190, 170));
		vPosicao7.setIcon(vazio);				
		vPosicao7.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {

			}
		});
		
		JLabel vPosicao8 = new JLabel();
		vPosicao8.setBounds(new Rectangle(134, 102, 190, 170));
		vPosicao8.setIcon(azul);				
		vPosicao8.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				vPosicao8.setIcon(azul_clicado);
			}
		});
	
		
		
//		JLabel VetorPosicao[] = new JLabel[9];
		frame.getContentPane().add(vPosicao0);
		frame.getContentPane().add(vPosicao1);
		frame.getContentPane().add(vPosicao2);
		frame.getContentPane().add(vPosicao3);
		frame.getContentPane().add(vPosicao4);
		frame.getContentPane().add(vPosicao5);
		frame.getContentPane().add(vPosicao6);
		frame.getContentPane().add(vPosicao7);
		frame.getContentPane().add(vPosicao8);
		frame.getContentPane().add(background);

	}
	

	// SwingAction do conectar
	private class SwingAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public SwingAction() {
			putValue(NAME, "conectar");
			putValue(SHORT_DESCRIPTION, "conectar a Netgames Server");
		}
		public void actionPerformed(ActionEvent e) {
			String mensagem = atorJogador.conectar();
			JOptionPane.showMessageDialog(null, mensagem); // aqui deve chamar o notificar, porem da classe pai
		}
	}
	private class SwingAction_1 extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public SwingAction_1() {
			putValue(NAME, "desconectar");
			putValue(SHORT_DESCRIPTION, "desconectar de Netgames Server");
		}
		public void actionPerformed(ActionEvent e) {
			String mensagem = atorJogador.desconectar();
			JOptionPane.showMessageDialog(null, mensagem); // aqui deve chamar o notificar, porem da classe pai
		}
	}
	private class SwingAction_2 extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public SwingAction_2() {
			putValue(NAME, "iniciar partida");
			putValue(SHORT_DESCRIPTION, "iniciar partida do seu jogo");
		}
		public void actionPerformed(ActionEvent e) {
			String mensagem = atorJogador.iniciarPartida();
			JOptionPane.showMessageDialog(null, mensagem);
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
