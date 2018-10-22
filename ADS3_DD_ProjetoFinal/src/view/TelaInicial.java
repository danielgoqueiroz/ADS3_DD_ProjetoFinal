package src.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import src.VO.Filme;
import src.VO.Usuario;
import src.controller.FilmeController;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class TelaInicial extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static Usuario usuarioLogado;
	private static Filme filmeTemp;
	
	
	public static Usuario getUsuarioLogado() {
		return usuarioLogado;
	}
	
	public static void setUsuarioLogado(Usuario usuarioLogado) {
		usuarioLogado = usuarioLogado;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaInicial() {
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 18));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 754, 518);		
		//Método busca Filme
		
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnUsuario = new JMenu("Usu\u00E1rio");
		menuBar.add(mnUsuario);
		
		JMenuItem mntmInserir = new JMenuItem("Inserir");
		mntmInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane = new CadastrarUsuarioPanel();
				setContentPane(contentPane);
				revalidate();
				
			}
		});
		mnUsuario.add(mntmInserir);
		
		JMenu mnNewMenu = new JMenu("Filme");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Cadastrar");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane = new CadastrarFilmePanel();
				setContentPane(contentPane);
				revalidate();
			}
		});
		
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Escolher Filmes Assistidos");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				contentPane = new 
				
			}
		});
		menuBar.add(mntmNewMenuItem_1);
		
		JButton btnNao = new JButton("N\u00C3O");
		btnNao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscaFilme();
			}
		});
		btnNao.setFont(new Font("Tahoma", Font.PLAIN, 18));
		getContentPane().add(btnNao, BorderLayout.WEST);
		
		JButton btnSim = new JButton("SIM");
		btnSim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscaFilme();
			}
		});
		
		btnSim.setFont(new Font("Tahoma", Font.PLAIN, 18));
		getContentPane().add(btnSim, BorderLayout.EAST);
		
		JLabel lblJVi = new JLabel("J\u00E1 Viu?");
		lblJVi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblJVi.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblJVi, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Nome");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(169, 167, 267, 14);
		panel.add(lblTitulo);
		
		JLabel lblAno = new JLabel("Ano");
		lblAno.setHorizontalAlignment(SwingConstants.CENTER);
		lblAno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAno.setBounds(169, 192, 267, 14);
		panel.add(lblAno);
		
		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGenero.setBounds(169, 217, 267, 14);
		panel.add(lblGenero);
		
		JLabel lblDiretor = new JLabel("Diretor");
		lblDiretor.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiretor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDiretor.setBounds(169, 242, 267, 17);
		panel.add(lblDiretor);
		
		JLabel lblAtores = new JLabel("Atores");
		lblAtores.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtores.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAtores.setBounds(169, 267, 267, 14);
		panel.add(lblAtores);
		
		JLabel label = new JLabel("Categoria");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(169, 292, 267, 14);
		panel.add(label);
		
		JLabel lblSinopse = new JLabel("Sinopse");
		lblSinopse.setVerticalAlignment(SwingConstants.TOP);
		lblSinopse.setHorizontalAlignment(SwingConstants.CENTER);
		lblSinopse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSinopse.setBounds(169, 317, 267, 80);
		panel.add(lblSinopse);
		
		JLabel lblNota = new JLabel("Nota");
		lblNota.setHorizontalAlignment(SwingConstants.CENTER);
		lblNota.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNota.setBounds(169, 408, 267, 14);
		panel.add(lblNota);
		
		JLabel lblDurao = new JLabel("Dura\u00E7\u00E3o");
		lblDurao.setHorizontalAlignment(SwingConstants.CENTER);
		lblDurao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDurao.setBounds(169, 393, 267, 14);
		panel.add(lblDurao);
		
//		Login contentPane = new Login();
//		setContentPane(contentPane);
//		revalidate();
		
		menuBar.setVisible(false);
		
		
		filmeTemp = buscaFilme();
		lblTitulo.setText(filmeTemp.getTitulo());
		lblAno.setText(filmeTemp.getAno() + "");
		lblDiretor.setText(filmeTemp.getDuracao() + "");
		lblGenero.setText(filmeTemp.getGenero() + "");
		lblNota.setText(filmeTemp.getNota());
		lblSinopse.setText(filmeTemp.getSinopse());
		lblAtores.setText(filmeTemp.getArtistas() + "");
		lblDurao.setText(filmeTemp.getDuracao() + "");
		

		
		
		
	}
	
	
//	public void  login() {
////		Usuario usuario = null;
//		
//		
//	}
	
//	public void iniciaTelaEscolha() {
//		JPanel contentPane2 = new CadastrarUsuarioPanel();
//		this.setContentPane(contentPane2);
//		this.revalidate();
//
//	};
	
	public void setUser(Usuario usuario) {
		this.usuarioLogado = usuario;
		System.out.println("Usuário logado: " + usuario.toString());
	}
	
	public Filme buscaFilme() {
		FilmeController controle = new FilmeController();
		Filme filme = controle.buscaFilme();
		System.out.println(filme.toString());
		
		return filme;
		
		
	}

}
