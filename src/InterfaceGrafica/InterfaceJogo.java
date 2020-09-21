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
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();
	private AtorJogador atorJogador;

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
		atorJogador = new AtorJogador();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 650, 700);
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
		
		
		
		
		Icon vazio = new ImageIcon(getClass().getResource("vazio.png"));
		Icon azul = new ImageIcon(getClass().getResource("azul.png"));
		Icon vermelho = new ImageIcon(getClass().getResource("vermelho.png"));
		Icon template = new ImageIcon(getClass().getResource("template.png"));

		
		JLabel background = new JLabel();
		background.setBounds(new Rectangle(20, 40, 600, 600));
		background.setIcon(template);				
		background.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
//				click(1,1); 
			}
		});

		
		JLabel vPosicao0 = new JLabel();
		vPosicao0.setBounds(new Rectangle(20, 40, 190, 170));
		vPosicao0.setIcon(vazio);				
		vPosicao0.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
//				click(1,1); 
			}
		});
		
		JLabel vPosicao1 = new JLabel();
		vPosicao1.setBounds(new Rectangle(90, 40, 190, 170));
		vPosicao1.setIcon(azul);				
		vPosicao1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
//				click(1,1); 
			}
		});
//		
		JLabel vPosicao2 = new JLabel();
		vPosicao2.setBounds(new Rectangle(200, 40, 190, 170));
		vPosicao2.setIcon(vermelho);				
		vPosicao2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
//				click(1,1); 
			}
		});
		
//		JLabel VetorPosicao[] = new JLabel[9];
		frame.getContentPane().add(vPosicao0);
		frame.getContentPane().add(vPosicao1);
		frame.getContentPane().add(vPosicao2);
		frame.getContentPane().add(background);


	}
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
			// Necess�rio definir endere�o do servidor e nome do jogador
			String mensagem = atorJogador.conectar("localhost", "nomeJogador?");
			JOptionPane.showMessageDialog(null, mensagem);
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
			JOptionPane.showMessageDialog(null, mensagem);
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
}
