package src.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import src.VO.Filme;
import src.VO.FilmesAssistidos;
import src.VO.Usuario;
import src.controller.FilmeController;
import src.controller.FilmesAssistidosController;

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
import javax.swing.JSlider;
import javax.swing.ImageIcon;

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
		getContentPane().setLayout(null);
		
//		Login contentPane = new Login();
//		setContentPane(contentPane);
//		revalidate();
		
		menuBar.setVisible(false);
		
		
		filmeTemp = buscaFilme();
<<<<<<< HEAD
		
		JButton btnNao = new JButton("N\u00C3O");
		btnNao.setBounds(7, 7, 89, 433);
		getContentPane().add(btnNao);
		
		btnNao.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblJVi = new JLabel("J\u00E1 Viu?");
		lblJVi.setBounds(106, 11, 529, 22);
		getContentPane().add(lblJVi);
		lblJVi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblJVi.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblTitulo = new JLabel("Nome");
		lblTitulo.setBounds(106, 167, 267, 14);
		getContentPane().add(lblTitulo);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setText(filmeTemp.getTitulo());
		
		JLabel lblAno = new JLabel("Ano");
		lblAno.setBounds(106, 192, 267, 14);
		getContentPane().add(lblAno);
		lblAno.setHorizontalAlignment(SwingConstants.CENTER);
		lblAno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAno.setText(filmeTemp.getAno() + "");
		
		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setBounds(106, 217, 267, 14);
		getContentPane().add(lblGenero);
		lblGenero.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGenero.setText(filmeTemp.getGenero() + "");
		
		JLabel lblDiretor = new JLabel("Diretor");
		lblDiretor.setBounds(106, 242, 267, 17);
		getContentPane().add(lblDiretor);
		lblDiretor.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiretor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDiretor.setText(filmeTemp.getDuracao() + "");
		
		JLabel lblAtores = new JLabel("Atores");
		lblAtores.setBounds(106, 267, 267, 14);
		getContentPane().add(lblAtores);
		lblAtores.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtores.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAtores.setText(filmeTemp.getArtistas() + "");
		
		JLabel lblSinopse = new JLabel("Sinopse");
		lblSinopse.setBounds(106, 292, 267, 68);
		getContentPane().add(lblSinopse);
		lblSinopse.setHorizontalAlignment(SwingConstants.CENTER);
		lblSinopse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblDurao = new JLabel("Dura\u00E7\u00E3o");
		lblDurao.setBounds(106, 393, 267, 14);
		getContentPane().add(lblDurao);
		lblDurao.setHorizontalAlignment(SwingConstants.CENTER);
		lblDurao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDurao.setText(filmeTemp.getDuracao() + "");
=======
		//lblTitulo.setText(filmeTemp.getTitulo());
		//lblAno.setText(filmeTemp.getAno() + "");
		//lblDiretor.setText(filmeTemp.getDuracao() + "");
		//lblGenero.setText(filmeTemp.getGenero() + "");
		//lblNota.setText(filmeTemp.getNota());
		//lblSinopse.setText(filmeTemp.getSinopse());
		//lblAtores.setText(filmeTemp.getArtistas() + "");
		//lblDurao.setText(filmeTemp.getDuracao() + "");
>>>>>>> branch 'master' of https://github.com/danielgoqueiroz/ADS3_DD_ProjetoFinal.git
		
		JButton btnSim = new JButton("SIM");
		btnSim.setBounds(645, 7, 83, 433);
		getContentPane().add(btnSim);
		
		
		btnSim.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		
		JButton btnS1 = new JButton("");
		
		btnS1.setBounds(645, 348, 83, 59);
		getContentPane().add(btnS1);
		btnS1.setIcon(new ImageIcon(TelaInicial.class.getResource("/extras/gold-star-png-1 - Copia.png")));
		
		JButton btnS2 = new JButton("");
		btnS2.setIcon(new ImageIcon(TelaInicial.class.getResource("/extras/gold-star-png-2.png")));
		btnS2.setBounds(645, 278, 83, 59);
		getContentPane().add(btnS2);
		
		JButton btnS3 = new JButton("");
		btnS3.setIcon(new ImageIcon(TelaInicial.class.getResource("/extras/gold-star-png-3.png")));
		btnS3.setBounds(645, 208, 83, 59);
		getContentPane().add(btnS3);
		
		JButton btnS4 = new JButton("");
		btnS4.setIcon(new ImageIcon(TelaInicial.class.getResource("/extras/gold-star-png-4.png")));
		btnS4.setBounds(645, 138, 83, 59);
		getContentPane().add(btnS4);
		
		JButton btnS5 = new JButton("");
		btnS5.setIcon(new ImageIcon(TelaInicial.class.getResource("/extras/gold-star-png-5.png")));
		btnS5.setBounds(645, 68, 83, 59);
		getContentPane().add(btnS5);
		
		JLabel lblNota = new JLabel("Nota");
		lblNota.setHorizontalAlignment(SwingConstants.CENTER);
		lblNota.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNota.setBounds(106, 368, 267, 14);
		getContentPane().add(lblNota);
		
		btnNao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filmeTemp = buscaFilmeNaoAssistido(usuarioLogado);
				
				//lblTitulo.setText(filmeTemp.getTitulo());
				//lblAno.setText(filmeTemp.getAno() + "");
				//lblDiretor.setText(filmeTemp.getDuracao() + "");
				//lblGenero.setText(filmeTemp.getGenero() + "");
				//lblNota.setText(filmeTemp.getNota());
				//lblSinopse.setText(filmeTemp.getSinopse());
				//lblAtores.setText(filmeTemp.getArtistas() + "");
				lblDurao.setText(filmeTemp.getDuracao() + "");
				revalidate();
			}
		});
		
		
		
		btnS1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lblNota.setText("1");
				filmeTemp.setNota("1");
				btnSim.show();
				revalidate();
				
				btnS1.hide();
				btnS2.hide();
				btnS3.hide();
				btnS4.hide();
				btnS5.hide();
				
				cadastrarFilmeAssitido(usuarioLogado, filmeTemp);
				
			}

			
		});
		
		
		btnS2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNota.setText("2");
				filmeTemp.setNota("2");
				btnSim.show();
				revalidate();
				
				btnS1.hide();
				btnS2.hide();
				btnS3.hide();
				btnS4.hide();
				btnS5.hide();
				
			}
		});
		
		btnS3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNota.setText("3");
				filmeTemp.setNota("3");
				btnSim.show();
				revalidate();
				
				btnS1.hide();
				btnS2.hide();
				btnS3.hide();
				btnS4.hide();
				btnS5.hide();
				
			}
		});
		
		btnS4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNota.setText("4");
				filmeTemp.setNota("4");
				btnSim.show();
				revalidate();
				
				btnS1.hide();
				btnS2.hide();
				btnS3.hide();
				btnS4.hide();
				btnS5.hide();
				
			}
		});
		
		btnS5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNota.setText("5");
				filmeTemp.setNota("5");
				btnSim.show();
				revalidate();
				
				btnS1.hide();
				btnS2.hide();
				btnS3.hide();
				btnS4.hide();
				btnS5.hide();
				
			}
		});
		
		
		btnSim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSim.hide();
				revalidate();
				
				
				btnS1.show();
				btnS2.show();
				btnS3.show();
				btnS4.show();
				btnS5.show();
				
			}

			
		});
	}
	

	
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
	
	public Filme buscaFilmeNaoAssistido(Usuario usuario) {
		FilmeController controle = new FilmeController();
		Filme filme = controle.buscaFilmeNaoAssistido(usuario);
		System.out.println(filme.toString());
		
		return filme;
	}
	
	private void cadastrarFilmeAssitido(Usuario usuarioLogado, Filme filmeTemp) {
		FilmesAssistidosController controle = new FilmesAssistidosController();
		FilmesAssistidos filmeAssitido = new FilmesAssistidos(usuarioLogado, filmeTemp);
		
		controle.cadastrarFilmeAssitido(filmeAssitido);
//		
	}
	
	
}
