package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import VO.Filme;
import VO.ProducaoAssistida;
import VO.Producao;
import VO.Usuario;
import controller.FilmeController;
import controller.FilmesAssistidosController;
import controller.ProducaoController;
import controller.ProduçãoAssistidaController;
import controller.UsuarioController;

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
	private static Producao producaoTemp;
	
	/**
	 * Create the frame.
	 */
	public TelaInicial(Usuario usuario) {
		this.usuarioLogado = usuario;
//		usuarioLogado.setIdUsuario(1);
		
		ProducaoController controle = new ProducaoController();

		producaoTemp = controle.buscaProducaoNaoAssistido(usuarioLogado);
		
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 18));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 754, 518);		
		//Método busca Producao
		
		
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

		
		menuBar.setVisible(false);
		
		
		
		
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
		lblTitulo.setText(producaoTemp.getTitulo());
		
		JLabel lblAno = new JLabel("Ano");
		lblAno.setBounds(106, 192, 267, 14);
		getContentPane().add(lblAno);
		lblAno.setHorizontalAlignment(SwingConstants.CENTER);
		lblAno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAno.setText(producaoTemp.getAno() + "");
		
		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setBounds(106, 217, 267, 14);
		getContentPane().add(lblGenero);
		lblGenero.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGenero.setText(producaoTemp.getGenero() + "");
		
		JLabel lblDiretor = new JLabel("Diretor");
		lblDiretor.setBounds(106, 242, 267, 17);
		getContentPane().add(lblDiretor);
		lblDiretor.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiretor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDiretor.setText(producaoTemp.getDiretor() + "");
		
		JLabel lblAtores = new JLabel("Atores");
		lblAtores.setBounds(106, 267, 267, 14);
		getContentPane().add(lblAtores);
		lblAtores.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtores.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAtores.setText(producaoTemp.getArtistas() + "");
		
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
		lblDurao.setText(producaoTemp.getDuracao() + "");

		
		JButton btnSim = new JButton("SIM");
		btnSim.setBounds(645, 7, 83, 433);
		getContentPane().add(btnSim);
		
		
		btnSim.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		
		JButton btnS1 = new JButton("1");
		
		btnS1.setBounds(645, 348, 83, 59);
		getContentPane().add(btnS1);
		
		JButton btnS2 = new JButton("2");
		btnS2.setBounds(645, 278, 83, 59);
		getContentPane().add(btnS2);
		
		JButton btnS3 = new JButton("3");
		btnS3.setBounds(645, 208, 83, 59);
		getContentPane().add(btnS3);
		
		JButton btnS4 = new JButton("4");
		btnS4.setBounds(645, 138, 83, 59);
		getContentPane().add(btnS4);
		
		JButton btnS5 = new JButton("5");
		btnS5.setBounds(645, 68, 83, 59);
		getContentPane().add(btnS5);
		
		JLabel lblNota = new JLabel("Nota");
		lblNota.setHorizontalAlignment(SwingConstants.CENTER);
		lblNota.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNota.setBounds(106, 368, 267, 14);
		getContentPane().add(lblNota);
		
		JLabel lblImagem = new JLabel("New label");
		lblImagem.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagem.setBounds(387, 113, 224, 294);
		getContentPane().add(lblImagem);
		
		JLabel lblUltimaProducao = new JLabel("\u00DAltimo filme");
		lblUltimaProducao.setHorizontalAlignment(SwingConstants.CENTER);
		lblUltimaProducao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUltimaProducao.setBounds(106, 430, 529, 14);
		getContentPane().add(lblUltimaProducao);
		
		btnNao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				producaoTemp = buscaProducaoAssistida(usuarioLogado);
				
				lblTitulo.setText(producaoTemp.getTitulo());
				lblAno.setText(producaoTemp.getAno() + "");
				lblDiretor.setText(producaoTemp.getDuracao() + "");
				lblGenero.setText(producaoTemp.getGenero() + "");
//				lblNota.setText(producaoTemp.getNota());
				lblSinopse.setText(producaoTemp.getSinopse());
				lblAtores.setText(producaoTemp.getArtistas() + "");
				lblDurao.setText(producaoTemp.getDuracao() + "");
				revalidate();
			}
		});
		
		
		
		
		btnS1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lblNota.setText("1");
				btnSim.show();
				revalidate();
				
				btnS1.hide();
				btnS2.hide();
				btnS3.hide();
				btnS4.hide();
				btnS5.hide();
//				ProducaoAssistida producaoAssitida = new ProducaoAssistida(usuarioLogado, producaoTemp, 1);
//				ProduçãoAssistidaController controle = new ProduçãoAssistidaController();
//				controle.cadastrarProducaoAssitida(producaoAssitida);
				
				cadastrarFilmeAssitido(usuarioLogado, producaoTemp, 1);
				
//				cadastrarFilmeAssistido(usuarioLogado, producaoTemp);
				
					producaoTemp = buscaProducaoAssistida(usuarioLogado);
					
					lblTitulo.setText(producaoTemp.getTitulo());
					lblAno.setText(producaoTemp.getAno() + "");
					lblDiretor.setText(producaoTemp.getDuracao() + "");
					lblGenero.setText(producaoTemp.getGenero() + "");
//					lblNota.setText(producaoTemp.getNota());
					lblSinopse.setText(producaoTemp.getSinopse());
					lblAtores.setText(producaoTemp.getArtistas() + "");
					lblDurao.setText(producaoTemp.getDuracao() + "");
					revalidate();
				
				
				btnSim.show();
			}

			
		});
		
		
		btnS2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNota.setText("2");				
				btnSim.show();
				revalidate();
				
				btnS1.hide();
				btnS2.hide();
				btnS3.hide();
				btnS4.hide();
				btnS5.hide();
				
				cadastrarFilmeAssitido(usuarioLogado, producaoTemp, 2);
				
//				cadastrarFilmeAssistido(usuarioLogado, producaoTemp);
				
					producaoTemp = buscaProducaoAssistida(usuarioLogado);
					
					lblTitulo.setText(producaoTemp.getTitulo());
					lblAno.setText(producaoTemp.getAno() + "");
					lblDiretor.setText(producaoTemp.getDuracao() + "");
					lblGenero.setText(producaoTemp.getGenero() + "");
//					lblNota.setText(producaoTemp.getNota());
					lblSinopse.setText(producaoTemp.getSinopse());
					lblAtores.setText(producaoTemp.getArtistas() + "");
					lblDurao.setText(producaoTemp.getDuracao() + "");
					revalidate();
				
				
				btnSim.show();
				
			}
		});
		
		btnS3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNota.setText("3");
				btnSim.show();
				revalidate();
				
				btnS1.hide();
				btnS2.hide();
				btnS3.hide();
				btnS4.hide();
				btnS5.hide();
				
				cadastrarFilmeAssitido(usuarioLogado, producaoTemp, 3);
				
//				cadastrarFilmeAssistido(usuarioLogado, producaoTemp);
				
					producaoTemp = buscaProducaoAssistida(usuarioLogado);
					
					lblTitulo.setText(producaoTemp.getTitulo());
					lblAno.setText(producaoTemp.getAno() + "");
					lblDiretor.setText(producaoTemp.getDuracao() + "");
					lblGenero.setText(producaoTemp.getGenero() + "");
//					lblNota.setText(producaoTemp.getNota());
					lblSinopse.setText(producaoTemp.getSinopse());
					lblAtores.setText(producaoTemp.getArtistas() + "");
					lblDurao.setText(producaoTemp.getDuracao() + "");
					revalidate();
				
				
				btnSim.show();
				
			}
		});
		
		btnS4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNota.setText("4");
				btnSim.show();
				revalidate();
				
				btnS1.hide();
				btnS2.hide();
				btnS3.hide();
				btnS4.hide();
				btnS5.hide();
				
				cadastrarFilmeAssitido(usuarioLogado, producaoTemp, 4);
				
//				cadastrarFilmeAssistido(usuarioLogado, producaoTemp);
				
					producaoTemp = buscaProducaoAssistida(usuarioLogado);
					
					lblTitulo.setText(producaoTemp.getTitulo());
					lblAno.setText(producaoTemp.getAno() + "");
					lblDiretor.setText(producaoTemp.getDuracao() + "");
					lblGenero.setText(producaoTemp.getGenero() + "");
//					lblNota.setText(producaoTemp.getNota());
					lblSinopse.setText(producaoTemp.getSinopse());
					lblAtores.setText(producaoTemp.getArtistas() + "");
					lblDurao.setText(producaoTemp.getDuracao() + "");
					revalidate();
				
				
				btnSim.show();
				
			}
		});
		
		btnS5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNota.setText("5");
				btnSim.show();
				revalidate();
				
				btnS1.hide();
				btnS2.hide();
				btnS3.hide();
				btnS4.hide();
				btnS5.hide();
				
				cadastrarFilmeAssitido(usuarioLogado, producaoTemp, 5);
				
//				cadastrarFilmeAssistido(usuarioLogado, producaoTemp);
					lblUltimaProducao.setText(producaoTemp.toString());
					producaoTemp = buscaProducaoAssistida(usuarioLogado);
					
					lblTitulo.setText(producaoTemp.getTitulo());
					lblAno.setText(producaoTemp.getAno() + "");
					lblDiretor.setText(producaoTemp.getDuracao() + "");
					lblGenero.setText(producaoTemp.getGenero() + "");
//					lblNota.setText(producaoTemp.getNota());
					lblSinopse.setText(producaoTemp.getSinopse());
					lblAtores.setText(producaoTemp.getArtistas() + "");
					lblDurao.setText(producaoTemp.getDuracao() + "");
					
					revalidate();
				
				
				btnSim.show();
				
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

	
	public Producao buscaProducaoAssistida(Usuario usuario) {
		ProducaoController controle = new ProducaoController();
		
//		System.out.println(filme.toString());
		
		return controle.buscaProducaoNaoAssistido(usuario);
	}
	
	private void cadastrarFilmeAssitido(Usuario usuarioLogado, Producao producaoTemp, int nota) {
		FilmesAssistidosController controle = new FilmesAssistidosController();
		ProducaoAssistida filmeAssitido = new ProducaoAssistida(usuarioLogado, producaoTemp, nota);
		
		controle.cadastrarProducaoAssistidaPorUsuario(filmeAssitido);
		
//		
	}
	
	public static Usuario getUsuarioLogado() {
		return usuarioLogado;
	}
	
	public static void setUsuarioLogado(Usuario usuarioLogado) {
		usuarioLogado = usuarioLogado;
	}
}
