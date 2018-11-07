package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import VO.Artista;
import VO.EnumTipoProducao;
import VO.Genero;
import VO.Producao;
import controller.ArtistaController;
import controller.GeneroController;
import controller.ProducaoController;

public class CadastrarProducaoFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textDiretor;
	private JTextField textAno;
	private JTextField textTitulo;
	private JTextField textImage;
	private JTextPane textPaneSinopse;
	private JComboBox<Genero> cbGenero;
	private JButton btnCadastrar;
	private JButton btnAdicionar;
	private JComboBox<EnumTipoProducao> cbTipo;
	private JComboBox<Artista> cbAtores;
	private JTable table;
	private JButton btnRemover;
	private JTextField textDuracaoQtdTemp;
	private byte[] image;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					CadastrarProducaoFrame frame = new CadastrarProducaoFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CadastrarProducaoFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 703, 281);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTitulo.setBounds(10, 42, 85, 14);
		contentPane.add(lblTitulo);

		JLabel lblAno = new JLabel("Ano");
		lblAno.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAno.setBounds(10, 71, 85, 14);
		contentPane.add(lblAno);

		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGenero.setBounds(10, 97, 85, 14);
		contentPane.add(lblGenero);

		JLabel lblDiretor = new JLabel("Diretor");
		lblDiretor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDiretor.setBounds(10, 126, 85, 14);
		contentPane.add(lblDiretor);

		JLabel lblAtor = new JLabel("Atores");
		lblAtor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAtor.setBounds(348, 14, 52, 14);
		contentPane.add(lblAtor);

		JLabel lblSinopse = new JLabel("Sinopse");
		lblSinopse.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSinopse.setBounds(43, 186, 52, 14);
		contentPane.add(lblSinopse);

		textPaneSinopse = new JTextPane();
		textPaneSinopse.setBounds(105, 183, 236, 46);
		contentPane.add(textPaneSinopse);

		textDiretor = new JTextField();
		textDiretor.setColumns(10);
		textDiretor.setBounds(105, 123, 236, 20);
		contentPane.add(textDiretor);

		textDuracaoQtdTemp = new JTextField();
		textDuracaoQtdTemp.setBounds(277, 65, 64, 20);
		contentPane.add(textDuracaoQtdTemp);
		textDuracaoQtdTemp.setColumns(10);

		cbTipo = new JComboBox<EnumTipoProducao>();
		cbTipo.setModel(new DefaultComboBoxModel<>(EnumTipoProducao.values()));

		JLabel lblDuraoqtdtemp = new JLabel("Dura\u00E7\u00E3o");
		lblDuraoqtdtemp.setBounds(201, 68, 85, 14);
		contentPane.add(lblDuraoqtdtemp);

		cbTipo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (cbTipo.getSelectedIndex() == 0) {
					lblDuraoqtdtemp.setText("Dura��o (Min.)");
				} else if (cbTipo.getSelectedIndex() == 1) {
					lblDuraoqtdtemp.setText("Temporadas");
				}
			}
		});

		cbTipo.setBounds(105, 11, 236, 20);
		contentPane.add(cbTipo);

		GeneroController gc = new GeneroController();

		final List<Genero> generos = gc.listarTodos();

		cbGenero = new JComboBox<Genero>(new Vector<>(generos));
		cbGenero.setBounds(105, 94, 236, 20);
		contentPane.add(cbGenero);

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

		ArtistaController ac = new ArtistaController();
		final List<Artista> artistas = ac.listarTodos();
		cbAtores = new JComboBox<Artista>(new Vector<>(artistas));
		cbAtores.setBounds(410, 11, 145, 20);
		contentPane.add(cbAtores);

		cbAtores.setRenderer(new DefaultListCellRenderer() {
			@Override
			public java.awt.Component getListCellRendererComponent(final JList<?> list, final Object value,
					final int index, final boolean isSelected, final boolean cellHasFocus) {
				super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				if (value instanceof Artista)
					setText(((Artista) value).getNome());

				return this;
			}
		});

		textAno = new JTextField();
		textAno.setColumns(10);
		textAno.setBounds(105, 65, 86, 20);
		contentPane.add(textAno);

		textTitulo = new JTextField();
		textTitulo.setColumns(10);
		textTitulo.setBounds(105, 39, 236, 20);
		contentPane.add(textTitulo);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(371, 39, 285, 108);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Codigo", "Artista" }));
		scrollPane.setViewportView(table);

		DefaultTableModel model = (DefaultTableModel) table.getModel();

		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Producao producao = new Producao();

				producao.setTipo((EnumTipoProducao) cbTipo.getSelectedItem());
				producao.setTitulo(textTitulo.getText());

				String ano = textAno.getText();
				if (ano.isEmpty())
					ano = "0";

				producao.setAno(Integer.parseInt(ano));
				producao.setSinopse(textPaneSinopse.getText());
				producao.setGenero((Genero) cbGenero.getSelectedItem());
				producao.setDiretor(textDiretor.getText());
				producao.setCapa(image);

				String duracaoQtdTemp = textDuracaoQtdTemp.getText();
				if (duracaoQtdTemp.isEmpty())
					duracaoQtdTemp = "0";

				if (producao.getTipo() == EnumTipoProducao.Filme) {

					producao.setDuracao(Integer.parseInt(duracaoQtdTemp));
					producao.setQtdTemporadas(0);
				}

				if (producao.getTipo() == EnumTipoProducao.Serie) {
					producao.setQtdTemporadas(Integer.parseInt(duracaoQtdTemp));
					producao.setDuracao(0);
				}

				ArrayList<Artista> listArtistas = new ArrayList<Artista>();

				for (int i = 0; i < model.getRowCount(); i++) {
					Artista artista = new Artista();

					artista.setIdArtista((int) model.getValueAt(i, 0));
					artista.setNome((String) model.getValueAt(i, 1));

					listArtistas.add(artista);
				}

				producao.setArtistas(listArtistas);

				ProducaoController controle = new ProducaoController();

				try {
					JOptionPane.showMessageDialog(null, controle.salvar(producao));
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage() + "");

				}

			}
		});
		btnCadastrar.setBounds(565, 206, 91, 23);
		contentPane.add(btnCadastrar);

		textImage = new JTextField();
		textImage.setEditable(false);
		textImage.setText("");
		textImage.setBounds(105, 152, 185, 20);
		contentPane.add(textImage);
		textImage.setColumns(10);

		JButton btnImagem = new JButton("...");
		btnImagem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
				chooser.showSaveDialog(null);
				File f = chooser.getSelectedFile();
				new ImageIcon(f.getAbsolutePath());
				textImage.setText(f.getAbsolutePath());

				try {
					image = Files.readAllBytes(f.toPath());

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//				lblImagem.setIcon(icon);
				revalidate();

			}
		});
		btnImagem.setBounds(300, 151, 41, 23);
		contentPane.add(btnImagem);

		JLabel lblImagemcapa = new JLabel("Imagem(capa)");
		lblImagemcapa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblImagemcapa.setBounds(10, 155, 85, 14);
		contentPane.add(lblImagemcapa);

		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipo.setBounds(10, 14, 85, 14);
		contentPane.add(lblTipo);

		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(565, 10, 91, 23);
		contentPane.add(btnAdicionar);

		btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.removeRow(table.getSelectedRow());

				if (model.getRowCount() == 0) {
					btnRemover.setEnabled(false);
				}
			}
		});
		btnRemover.setBounds(371, 151, 285, 23);
		contentPane.add(btnRemover);
		btnRemover.setEnabled(false);

		table.removeColumn(table.getColumnModel().getColumn(0));

		btnAdicionar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Object[] values = new Object[2];

				values[0] = ((Artista) cbAtores.getSelectedItem()).getIdArtista();
				values[1] = ((Artista) cbAtores.getSelectedItem()).getNome();

				boolean encontrado = false;

				for (int i = 0; i < model.getRowCount(); i++) {
					if (values[0] == model.getValueAt(i, 0)) {
						encontrado = true;
						JOptionPane.showMessageDialog(null, "Artista j� inserido");
						break;
					}
				}

				if (!encontrado)
					model.addRow(values);
			}
		});

		table.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btnRemover.setEnabled(true);
			}
		});
	}
}
