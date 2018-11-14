package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import VO.Artista;
import VO.EnumNivel;
import VO.Genero;
import VO.Producao;
import VO.ProducoesAssistidas;
import VO.Usuario;
import controller.GeneroController;
import controller.ProducaoController;
import controller.ProducoesAssistidasController;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;

public class TelaInicial extends JFrame {

	private static final long serialVersionUID = 1L;
	private static Usuario usuarioLogado;
	private static Producao producao;
	private JTextField textAno;
	private JTextField textDiretor;
	private JTable table;
	private JTextField textNota;
	private JTextField textDuracaoQtdTempodara;
	private JComboBox<Genero> cbGenero;
	private JTextArea textSinopse;
	private FileOutputStream fos;
	private JLabel lblTitulo;
	private JButton btnRecarregar;
	private JLabel lblImagem;
	private DefaultTableModel model;
	private JLabel lblDiretor;
	private JLabel lblAtores;
	private JLabel lblSinopse;
	private JLabel lblDurao;
	private JLabel lblNota;
	private JButton btnNao;
	private JButton btnSim;
	private JLabel lblJVi;
	private JLabel lblAno;
	private JLabel lblGenero;
	private JButton btnS1;
	private JButton btnS2;
	private JButton btnS3;
	private JButton btnS4;
	private JButton btnS5;

	public TelaInicial(Usuario usuario) {
		usuarioLogado = usuario;

		setResizable(false);
		setFont(new Font("Tahoma", Font.PLAIN, 12));
		setForeground(Color.WHITE);
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(TelaInicial.class.getResource("/extras/eye-2317618_960_720.png")));

		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 18));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 754, 424);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnUsuario = new JMenu("Usu\u00E1rio");
		menuBar.add(mnUsuario);

		JMenuItem mntmInserir = new JMenuItem("Inserir");
		mntmInserir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				CadastrarUsuarioFrame cadastro = new CadastrarUsuarioFrame("");
				revalidate();

			}
		});
		mnUsuario.add(mntmInserir);

		JMenu mnNewMenu = new JMenu("Filme");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Cadastrar");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				CadastrarProducaoFrame producao = new CadastrarProducaoFrame(true, null);
				producao.setVisible(true);
				
			}
		});

		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Escolher Filmes Assistidos");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		menuBar.add(mntmNewMenuItem_1);
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);

		table = new JTable();
		table.setEnabled(false);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Codigo", "Artista" }));
		scrollPane.setViewportView(table);
		model = (DefaultTableModel) table.getModel();

		scrollPane.setBounds(356, 118, 279, 75);
		getContentPane().add(scrollPane);

		table.removeColumn(table.getColumnModel().getColumn(0));

		textAno = new JTextField();
		textAno.setEnabled(false);
		textAno.setBounds(356, 66, 86, 20);
		getContentPane().add(textAno);
		textAno.setColumns(10);

		cbGenero = new JComboBox<Genero>();

		GeneroController gc = new GeneroController();

		final List<Genero> generos = gc.listarTodos();

		cbGenero = new JComboBox<Genero>(new Vector<>(generos));

		cbGenero.setEnabled(false);
		cbGenero.setBounds(518, 66, 117, 20);
		getContentPane().add(cbGenero);

		cbGenero.setRenderer(new DefaultListCellRenderer() {
			@Override
			public java.awt.Component getListCellRendererComponent(final JList<?> list, final Object value,
					final int index, final boolean isSelected, final boolean cellHasFocus) {
				super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				if (value instanceof Genero)
					setText(((Genero) value).getDescricao());

				return this;
			}
		});

		textDiretor = new JTextField();
		textDiretor.setEnabled(false);
		textDiretor.setBounds(356, 90, 279, 20);
		getContentPane().add(textDiretor);
		textDiretor.setColumns(10);

		textSinopse = new JTextArea();
		textSinopse.setLineWrap(true);
		textSinopse.setBounds(356, 207, 279, 75);
		getContentPane().add(textSinopse);

		textNota = new JTextField();
		textNota.setEnabled(false);
		textNota.setBounds(356, 290, 86, 20);
		getContentPane().add(textNota);
		textNota.setColumns(10);

		textDuracaoQtdTempodara = new JTextField();
		textDuracaoQtdTempodara.setEnabled(false);
		textDuracaoQtdTempodara.setBounds(518, 290, 117, 20);
		getContentPane().add(textDuracaoQtdTempodara);
		textDuracaoQtdTempodara.setColumns(10);

		btnNao = new JButton("N\u00C3O");

		btnNao.setForeground(Color.BLACK);
		btnNao.setBounds(7, 7, 89, 330);

		getContentPane().add(btnNao);

		btnNao.setFont(new Font("Tahoma", Font.PLAIN, 18));

		lblJVi = new JLabel("Voc\u00EA j\u00E1 viu?");
		lblJVi.setBounds(106, 11, 529, 22);
		getContentPane().add(lblJVi);
		lblJVi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblJVi.setHorizontalAlignment(SwingConstants.CENTER);

		lblTitulo = new JLabel("Nome");
		lblTitulo.setBounds(106, 44, 529, 22);
		getContentPane().add(lblTitulo);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);

		lblAno = new JLabel("Ano");
		lblAno.setBounds(272, 69, 77, 14);
		getContentPane().add(lblAno);
		lblAno.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAno.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblGenero = new JLabel("Genero");
		lblGenero.setBounds(452, 69, 64, 14);
		getContentPane().add(lblGenero);
		lblGenero.setHorizontalAlignment(SwingConstants.LEFT);
		lblGenero.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblDiretor = new JLabel("Diretor");
		lblDiretor.setBounds(272, 90, 77, 17);
		getContentPane().add(lblDiretor);
		lblDiretor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDiretor.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblAtores = new JLabel("Atores");
		lblAtores.setBounds(272, 118, 77, 14);
		getContentPane().add(lblAtores);
		lblAtores.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAtores.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblSinopse = new JLabel("Sinopse");
		lblSinopse.setBounds(272, 204, 77, 22);
		getContentPane().add(lblSinopse);
		lblSinopse.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSinopse.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblDurao = new JLabel("Dura\u00E7\u00E3o");
		lblDurao.setBounds(452, 293, 64, 14);
		getContentPane().add(lblDurao);
		lblDurao.setHorizontalAlignment(SwingConstants.LEFT);
		lblDurao.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblNota = new JLabel("Nota");
		lblNota.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNota.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNota.setBounds(272, 293, 77, 14);
		getContentPane().add(lblNota);

		lblImagem = new JLabel("");
		lblImagem.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagem.setBounds(106, 69, 170, 241);
		getContentPane().add(lblImagem);

		btnRecarregar = new JButton("Recarregar");
		btnRecarregar.setBounds(106, 336, 529, 23);
		getContentPane().add(btnRecarregar);

		menuBar.setVisible(false);
		if (usuarioLogado.getNivel() == EnumNivel.Admin)
			menuBar.setVisible(true);

		revalidate();

		btnSim = new JButton("SIM");
		btnSim.setBounds(645, 7, 83, 352);
		getContentPane().add(btnSim);

		btnSim.setFont(new Font("Tahoma", Font.PLAIN, 18));

		btnS1 = new JButton("1");

		btnS1.setBounds(645, 287, 83, 50);
		getContentPane().add(btnS1);

		btnS2 = new JButton("2");
		btnS2.setBounds(645, 217, 83, 50);
		getContentPane().add(btnS2);

		btnS3 = new JButton("3");
		btnS3.setBounds(645, 147, 83, 50);
		getContentPane().add(btnS3);

		btnS4 = new JButton("4");
		btnS4.setBounds(645, 77, 83, 50);
		getContentPane().add(btnS4);

		btnS5 = new JButton("5");
		btnS5.setBounds(645, 7, 83, 50);
		getContentPane().add(btnS5);

		producao = new Producao();
		producao.setTitulo("Por enquanto � isso! Volte a avaliar assim que novas produ��es forem cadastradas.");

		populaCamposProducaoComNovoFilme();
		
		btnNao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				populaCamposProducaoComNovoFilme();
			}
		});

		btnS1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarProducaoAssitida(usuarioLogado, producao, 1);
			}

		});

		btnS2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarProducaoAssitida(usuarioLogado, producao, 2);

			}
		});

		btnS3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarProducaoAssitida(usuarioLogado, producao, 3);
			}
		});

		btnS4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cadastrarProducaoAssitida(usuarioLogado, producao, 4);
			}
		});

		btnS5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarProducaoAssitida(usuarioLogado, producao, 5);

			}
		});

		btnSim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				escondeBotoesSim();
			}

		});

		setBounds((1920 / 2) - (getWidth() / 2), (1080 / 2) - (getHeight() / 2), getWidth(), getHeight());
	}

	@SuppressWarnings("deprecation")
	public void RetomaFormOriginal() {
		btnSim.show();
		btnS1.hide();
		btnS2.hide();
		btnS3.hide();
		btnS4.hide();
		btnS5.hide();
		revalidate();
	}

	@SuppressWarnings("deprecation")
	public void escondeBotoesSim() {
		btnSim.hide();
		btnS1.show();
		btnS2.show();
		btnS3.show();
		btnS4.show();
		btnS5.show();
		revalidate();

	}

	public void setUser(Usuario usuario) {
		usuarioLogado = usuario;
		System.out.println("Usu�rio logado: " + usuario.toStringTitulo());
	}

	public Producao buscaProducaoAssistida(Usuario usuario) {
		ProducaoController controle = new ProducaoController();
		return controle.buscaProducaoNaoAssistido(usuario);
	}

	public double BuscarMediaProducao(Producao p) {
		ProducaoController controle = new ProducaoController();
		return controle.BuscarMediaProducao(p);
	}

	private void cadastrarProducaoAssitida(Usuario usuarioLogado, Producao producao, int nota) {

		ProducoesAssistidasController controle = new ProducoesAssistidasController();
		ProducoesAssistidas producaoAssitida = new ProducoesAssistidas(usuarioLogado, producao, nota);
		controle.cadastrarProducaoAssitida(producaoAssitida);

		populaCamposProducaoComNovoFilme();

		RetomaFormOriginal();

	}

	public void populaCamposProducaoComNovoFilme() {

		int rowCount = table.getRowCount();
		for (int i = 0; i < rowCount; i++) {
			model.removeRow(0);
		}

		lblTitulo.setText("Por enquanto � isso! Volte a avaliar assim que novas produ��es forem cadastradas.");
		textAno.setText("");
		textDiretor.setText("");
		textNota.setText("");
		textSinopse.setText("");
		textDuracaoQtdTempodara.setText("");
		lblImagem.setIcon(null);
		btnRecarregar.setEnabled(false);

		producao = buscaProducaoAssistida(usuarioLogado);

		if (producao.getIdProducao() > 0) {

			lblTitulo.setText(producao.getTitulo() + "");
			textAno.setText(producao.getAno() + "");
			textDiretor.setText(producao.getDiretor() + "");
			cbGenero.setSelectedItem(producao.getGenero());
			textSinopse.setText(producao.getSinopse());
			textDuracaoQtdTempodara.setText(producao.getDuracao() + "");
			btnRecarregar.setEnabled(false);
			textNota.setText(String.valueOf(BuscarMediaProducao(producao)));

			ArrayList<Artista> artistas = producao.getArtistas();

			for (Artista artista : artistas) {

				Object[] values = new Object[2];

				values[0] = artista.getIdArtista();
				values[1] = artista.getNome();

				model.addRow(values);
			}

			try {
				File tempFile = File.createTempFile("jpg", "Maniac");
				fos = new FileOutputStream(tempFile);
				fos.write(producao.getCapa());

				ImageIcon icon = new ImageIcon(tempFile.getAbsolutePath());
				lblImagem.setIcon(icon);
			} catch (Exception ex) {
			}

		} else {
			btnRecarregar.setEnabled(true);
		}
		btnSim.show();
		revalidate();

	}

	public static Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public static void setUsuarioLogado(Usuario usuarioLogado) {
		usuarioLogado = usuarioLogado;
	}

}
