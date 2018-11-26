package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import VO.EnumNivel;
import VO.Genero;
import VO.Producao;
import VO.Usuario;
import controller.GeneroController;

public class PainelPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private static Usuario usuarioLogado;
	private static Producao producao;
	private JComboBox<Genero> cbGenero;
	private FileOutputStream fos;
	private DefaultTableModel model;
	private JMenuItem mntmUpdateProd;
	private ArrayList<Producao> producoesListadas;
	private ArrayList<Producao> producoesNaoAssistidas;
	private JMenu mnGenero;
	private JMenu mnArtista;
	private JMenu mnReview;
	private JMenuItem mntmAddReview;
	private JMenuItem mntmMinhasReviews;
	private JMenuItem mntmAddGenero;
	private JMenuItem mntmAddArtista;
	private JDesktopPane desktopPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Usuario usuario = new Usuario();
					usuario.setIdUsuario(27);
					usuario.setNome("Administrador");
					usuario.setNivel(EnumNivel.Admin);
					usuario.setNickname("Adm");
					PainelPrincipal frame = new PainelPrincipal(usuario);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PainelPrincipal(Usuario usuario) {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(PainelPrincipal.class.getResource("/extras/eye-2317618_960_720.png")));
		usuarioLogado = usuario;
		setFont(new Font("Tahoma", Font.PLAIN, 12));
		setForeground(Color.WHITE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 921, 505);

		this.setTitle("Quais produções cinematográficas você já assistiu?  [" + usuario.toString() + "]");

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnReview = new JMenu("Reviews");
		mnReview.setIcon(new ImageIcon(PainelPrincipal.class.getResource("/extras/review.png")));
		menuBar.add(mnReview);

		mntmAddReview = new JMenuItem("Adicionar Reviews");
		mntmAddReview.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		mntmAddReview.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CadastrarReviews cadRev = new CadastrarReviews(usuarioLogado);
				desktopPane.add(cadRev);
				cadRev.show();
			}
		});
		mnReview.add(mntmAddReview);

		mntmMinhasReviews = new JMenuItem("Relat\u00F3rio - Minhas reviews");
		mntmMinhasReviews.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));
		mntmMinhasReviews.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ListarProducoesAssistidas prodAssistidas = new ListarProducoesAssistidas(usuarioLogado);
				desktopPane.add(prodAssistidas);
				prodAssistidas.show();
			}
		});
		mnReview.add(mntmMinhasReviews);

		JMenu mnProducao = new JMenu("Produ\u00E7\u00E3o");
		mnProducao.setIcon(new ImageIcon(PainelPrincipal.class.getResource("/extras/popcorn.png")));
		menuBar.add(mnProducao);

		JMenuItem mntmAddProd = new JMenuItem("Cadastrar nova");
		mntmAddProd.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0));
		mntmAddProd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				CadastrarProducao producao = new CadastrarProducao(true, null);
				desktopPane.add(producao);
				producao.show();
			}
		});

		mnProducao.add(mntmAddProd);

		mntmUpdateProd = new JMenuItem("Atualizar produ\u00E7\u00F5es");
		mntmUpdateProd.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, 0));
		mntmUpdateProd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SelecionaProducoes producoes = new SelecionaProducoes(desktopPane);
				desktopPane.add(producoes);
				producoes.show();
			}
		});
		mnProducao.add(mntmUpdateProd);

		mnArtista = new JMenu("Artista");
		mnArtista.setIcon(new ImageIcon(PainelPrincipal.class.getResource("/extras/oscar.png")));
		menuBar.add(mnArtista);

		mntmAddArtista = new JMenuItem("Cadastrar novo");
		mntmAddArtista.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0));
		mntmAddArtista.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CadastrarArtista cadArt = new CadastrarArtista();
				desktopPane.add(cadArt);
				cadArt.show();
			}
		});
		mnArtista.add(mntmAddArtista);

		mnGenero = new JMenu("G\u00EAnero");
		mnGenero.setIcon(new ImageIcon(PainelPrincipal.class.getResource("/extras/feelings.png")));
		menuBar.add(mnGenero);

		mntmAddGenero = new JMenuItem("Cadastrar novo");
		mntmAddGenero.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F6, 0));
		mntmAddGenero.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CadastrarGenero cadGenero = new CadastrarGenero();
				desktopPane.add(cadGenero);
				cadGenero.show();
			}
		});
		mnGenero.add(mntmAddGenero);

		JMenu mnUsuario = new JMenu("Usu\u00E1rio");
		mnUsuario.setIcon(new ImageIcon(PainelPrincipal.class.getResource("/extras/profile-user.png")));
		menuBar.add(mnUsuario);

		JMenuItem mntmAddUsuario = new JMenuItem("Cadastrar novo");
		mntmAddUsuario.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F7, 0));
		mntmAddUsuario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new CadastrarUsuario("");
				revalidate();

			}
		});
		mnUsuario.add(mntmAddUsuario);

		cbGenero = new JComboBox<Genero>();

		GeneroController gc = new GeneroController();

		gc.listarTodos();
		if (usuarioLogado.getNivel() == EnumNivel.Admin)
			menuBar.setVisible(true);

		revalidate();

		producao = new Producao();
		producao.setTitulo("Por enquanto é isso! Volte a avaliar assim que novas produções forem cadastradas.");

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

		desktopPane = new JDesktopPane();
		desktopPane.setBackground(UIManager.getColor("Button.background"));
		getContentPane().add(desktopPane, BorderLayout.CENTER);

		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	public static Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public static void setUsuarioLogado(Usuario usuarioLogado) {
		usuarioLogado = usuarioLogado;
	}
}
