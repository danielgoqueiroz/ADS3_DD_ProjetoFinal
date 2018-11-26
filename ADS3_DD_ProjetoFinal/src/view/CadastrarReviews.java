package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import VO.Artista;
import VO.Genero;
import VO.Producao;
import VO.ProducoesAssistidas;
import VO.Usuario;
import controller.GeneroController;
import controller.ProducaoController;
import controller.ProducoesAssistidasController;

public class CadastrarReviews extends JInternalFrame {

	private static Usuario usuarioLogado;
	private static Producao producao;
	private JTextField textAno;
	private JTextField textDiretor;
	private JTable table;
	private JTextField textDucaracao_QtdTemporada;
	private JTextField textMedia;
	private JTextArea textSinopse;
	private FileOutputStream fos;
	private JLabel lblTitulo;
	private JLabel lblDuracao_QtdTemporadas;
	private JLabel lblImagem;
	private JLabel lblMedia;
	private DefaultTableModel model;
	private JLabel lblDiretor;
	private JLabel lblAtores;
	private JLabel lblSinopse;
	private JLabel lblAno;
	private JLabel lblGenero;
	private JLabel lblVolteAAvaliar;
	private JLabel lblNt1;
	private JLabel lblNt2;
	private JLabel lblNt3;
	private JLabel lblNt4;
	private JLabel lblNt5;
	private JLabel lblValCinco;
	private JLabel lblAvaliar;
	private JScrollPane scrollPane;
	private JButton btnReiniciar;
	private JButton btnProximo;
	private ArrayList<Producao> producoesNaoAssistidas;
	private JComboBox<Genero> cbGenero;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Usuario usuario = new Usuario();
					usuario.setIdUsuario(27);
					CadastrarReviews frame = new CadastrarReviews(usuario);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CadastrarReviews(Usuario usuario) {
		usuarioLogado = usuario;
		buscaListaProducoesNaoAssistidas(usuarioLogado);

		setClosable(true);

		setBounds(100, 100, 738, 484);
		getContentPane().setLayout(null);

		lblImagem = new JLabel("");
		lblImagem.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagem.setBounds(10, 14, 329, 379);
		getContentPane().add(lblImagem);

		lblAno = new JLabel("Ano");
		lblAno.setHorizontalAlignment(SwingConstants.LEFT);
		lblAno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAno.setBounds(361, 50, 62, 14);
		getContentPane().add(lblAno);

		lblDiretor = new JLabel("Diretor");
		lblDiretor.setHorizontalAlignment(SwingConstants.LEFT);
		lblDiretor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDiretor.setBounds(361, 100, 62, 17);
		getContentPane().add(lblDiretor);

		textAno = new JTextField();
		textAno.setText("");
		textAno.setEnabled(false);
		textAno.setColumns(10);
		textAno.setBounds(430, 47, 86, 20);
		getContentPane().add(textAno);

		textDiretor = new JTextField();
		textDiretor.setText("");
		textDiretor.setEnabled(false);
		textDiretor.setColumns(10);
		textDiretor.setBounds(430, 100, 279, 20);
		getContentPane().add(textDiretor);

		lblGenero = new JLabel("Genero");
		lblGenero.setHorizontalAlignment(SwingConstants.LEFT);
		lblGenero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGenero.setBounds(360, 75, 64, 14);
		getContentPane().add(lblGenero);

		lblAtores = new JLabel("Atores");
		lblAtores.setHorizontalAlignment(SwingConstants.LEFT);
		lblAtores.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAtores.setBounds(361, 128, 62, 14);
		getContentPane().add(lblAtores);

		scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);

		table = new JTable();
		table.setEnabled(false);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Codigo", "Artista" }));
		scrollPane.setViewportView(table);
		model = (DefaultTableModel) table.getModel();

		scrollPane.setBounds(430, 128, 279, 75);
		getContentPane().add(scrollPane);

		table.removeColumn(table.getColumnModel().getColumn(0));

		lblSinopse = new JLabel("Sinopse");
		lblSinopse.setHorizontalAlignment(SwingConstants.LEFT);
		lblSinopse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSinopse.setBounds(361, 209, 62, 22);
		getContentPane().add(lblSinopse);

		textSinopse = new JTextArea();
		textSinopse.setText("");
		textSinopse.setLineWrap(true);
		textSinopse.setEditable(false);
		textSinopse.setBounds(430, 212, 279, 97);
		getContentPane().add(textSinopse);

		lblMedia = new JLabel("M\u00E9dia");
		lblMedia.setHorizontalAlignment(SwingConstants.LEFT);
		lblMedia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMedia.setBounds(554, 50, 62, 14);
		getContentPane().add(lblMedia);

		textMedia = new JTextField();
		textMedia.setText("");
		textMedia.setEnabled(false);
		textMedia.setColumns(10);
		textMedia.setBounds(623, 47, 86, 20);
		getContentPane().add(textMedia);

		textDucaracao_QtdTemporada = new JTextField();
		textDucaracao_QtdTemporada.setText("");
		textDucaracao_QtdTemporada.setEnabled(false);
		textDucaracao_QtdTemporada.setColumns(10);
		textDucaracao_QtdTemporada.setBounds(430, 320, 279, 20);
		getContentPane().add(textDucaracao_QtdTemporada);

		lblDuracao_QtdTemporadas = new JLabel("Dura\u00E7\u00E3o");
		lblDuracao_QtdTemporadas.setHorizontalAlignment(SwingConstants.LEFT);
		lblDuracao_QtdTemporadas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDuracao_QtdTemporadas.setBounds(361, 323, 64, 17);
		getContentPane().add(lblDuracao_QtdTemporadas);

		lblTitulo = new JLabel("Por enquanto \u00E9 isso!");
		lblTitulo.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTitulo.setBounds(361, 14, 351, 25);
		getContentPane().add(lblTitulo);

		lblVolteAAvaliar = new JLabel("Volte a avaliar assim que novas produ\u00E7\u00F5es forem cadastradas.");
		lblVolteAAvaliar.setHorizontalAlignment(SwingConstants.LEFT);
		lblVolteAAvaliar.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblVolteAAvaliar.setBounds(349, 351, 359, 22);
		getContentPane().add(lblVolteAAvaliar);

		btnReiniciar = new JButton("Reiniciar");
		btnReiniciar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				populaCamposProducao();
			}
		});
		btnReiniciar.setEnabled(false);
		btnReiniciar.setBounds(592, 406, 117, 23);
		getContentPane().add(btnReiniciar);

		cbGenero = new JComboBox<Genero>();

		GeneroController gc = new GeneroController();

		final List<Genero> generos = gc.listarTodos();

		cbGenero = new JComboBox<Genero>(new Vector<>(generos));

		cbGenero.setEnabled(false);
		cbGenero.setBounds(430, 74, 279, 20);
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

		lblNt1 = new JLabel("");
		lblNt1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				cadastrarProducaoAssitida(usuarioLogado, producao, 1);
			}
		});
		lblNt1.setIcon(new ImageIcon(CadastrarReviews.class.getResource("/extras/star.png")));
		lblNt1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNt1.setBounds(186, 404, 24, 25);
		getContentPane().add(lblNt1);

		lblNt2 = new JLabel("");
		lblNt2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				cadastrarProducaoAssitida(usuarioLogado, producao, 2);
			}
		});
		lblNt2.setIcon(new ImageIcon(CadastrarReviews.class.getResource("/extras/star.png")));
		lblNt2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNt2.setBounds(215, 404, 24, 25);
		getContentPane().add(lblNt2);

		lblNt3 = new JLabel("");
		lblNt3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				cadastrarProducaoAssitida(usuarioLogado, producao, 3);
			}
		});
		lblNt3.setIcon(new ImageIcon(CadastrarReviews.class.getResource("/extras/star.png")));
		lblNt3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNt3.setBounds(249, 404, 24, 25);
		getContentPane().add(lblNt3);

		lblNt4 = new JLabel("");
		lblNt4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				cadastrarProducaoAssitida(usuarioLogado, producao, 4);
			}
		});
		lblNt4.setIcon(new ImageIcon(CadastrarReviews.class.getResource("/extras/star.png")));
		lblNt4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNt4.setBounds(283, 404, 24, 25);
		getContentPane().add(lblNt4);

		lblNt5 = new JLabel("");
		lblNt5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				cadastrarProducaoAssitida(usuarioLogado, producao, 5);
			}
		});
		lblNt5.setIcon(new ImageIcon(CadastrarReviews.class.getResource("/extras/star.png")));
		lblNt5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNt5.setBounds(315, 404, 24, 25);
		getContentPane().add(lblNt5);

		lblAvaliar = new JLabel("Avaliar:  1");
		lblAvaliar.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAvaliar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAvaliar.setBounds(114, 404, 62, 25);
		getContentPane().add(lblAvaliar);

		lblValCinco = new JLabel("5");
		lblValCinco.setHorizontalAlignment(SwingConstants.LEFT);
		lblValCinco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblValCinco.setBounds(348, 404, 62, 25);
		getContentPane().add(lblValCinco);

		btnProximo = new JButton("Pr\u00F3ximo");
		btnProximo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				populaCamposProducao();
			}
		});
		btnProximo.setBounds(468, 406, 117, 23);
		getContentPane().add(btnProximo);

		producao = new Producao();

		populaCamposProducao();

	}

	public Producao buscaProducaoNaoAssistido(Usuario usuario) {
		Producao prod = new Producao();

		if (!producoesNaoAssistidas.isEmpty()) {
			prod = producoesNaoAssistidas.get(0);
			producoesNaoAssistidas.remove(0);
		} else {

			String[] buttons = { "Sim", "Não" };
			int returnValue = JOptionPane.showOptionDialog(null,
					"Não foi encontrado novas produções. Deseja recomeçar as avaliações?", "",
					JOptionPane.WARNING_MESSAGE, 0, null, buttons, buttons[1]);

			if (returnValue == 0) {
				buscaListaProducoesNaoAssistidas(usuario);
				prod = buscaProducaoNaoAssistido(usuario);
			}
		}

		return prod;
	}

	public void buscaListaProducoesNaoAssistidas(Usuario usuario) {
		ProducaoController controle = new ProducaoController();
		producoesNaoAssistidas = controle.buscaProducoesNaoAssistidas(usuario);
	}

	public double BuscarMediaProducao(Producao p) {
		ProducaoController controle = new ProducaoController();
		return controle.BuscarMediaProducao(p);
	}

	private void cadastrarProducaoAssitida(Usuario usuarioLogado, Producao producao, int nota) {

		ProducoesAssistidasController controle = new ProducoesAssistidasController();
		ProducoesAssistidas producaoAssitida = new ProducoesAssistidas(usuarioLogado, producao, nota);
		controle.cadastrarProducaoAssitida(producaoAssitida);

		populaCamposProducao();
	}

	public void populaCamposProducao() {
		producao = new Producao();

		int rowCount = table.getRowCount();
		for (int i = 0; i < rowCount; i++) {
			model.removeRow(0);
		}

		lblTitulo.setText("Por enquanto é isso!");
		lblVolteAAvaliar.setText("");
		textAno.setText("");
		textDiretor.setText("");
		textMedia.setText("");
		textSinopse.setText("");
		textDucaracao_QtdTemporada.setText("");
		lblImagem.setIcon(null);
		btnReiniciar.setEnabled(false);

		producao = buscaProducaoNaoAssistido(usuarioLogado);

		if (producao.getIdProducao() > 0) {

			lblTitulo.setText(producao.getTitulo() + "");
			textAno.setText(producao.getAno() + "");
			textDiretor.setText(producao.getDiretor() + "");

			for (int i = 0; i < cbGenero.getItemCount(); i++) {
				Genero item = cbGenero.getItemAt(i);
				if (item.getDescricao().equalsIgnoreCase(producao.getGenero().getDescricao())) {
					cbGenero.setSelectedIndex(i);
					break;
				}
			}

			textSinopse.setText(producao.getSinopse());
			textDucaracao_QtdTemporada.setText(producao.getDuracao() + "");
			btnReiniciar.setEnabled(false);
			textMedia.setText(String.valueOf(BuscarMediaProducao(producao)));

			ArrayList<Artista> artistas = producao.getArtistas();

			for (Artista artista : artistas) {

				Object[] values = new Object[2];

				values[0] = artista.getIdArtista();
				values[1] = artista.getNome();

				model.addRow(values);
			}

			for (int i = 0; i < cbGenero.getItemCount(); i++) {
				Genero item = cbGenero.getItemAt(i);
				if (item.getDescricao().equalsIgnoreCase(producao.getGenero().getDescricao())) {
					cbGenero.setSelectedIndex(i);
					break;
				}
			}

			try {
				File tempFile = File.createTempFile("jpg", "temp");
				fos = new FileOutputStream(tempFile);
				fos.write(producao.getCapa());

				ImageIcon icon = new ImageIcon(tempFile.getAbsolutePath());
				lblImagem.setIcon(icon);
			} catch (Exception ex) {
			}

		} else {
			btnReiniciar.setEnabled(true);
			lblVolteAAvaliar.setText("Volte a avaliar assim que novas produções forem cadastradas.");
		}
		revalidate();

	}

}
