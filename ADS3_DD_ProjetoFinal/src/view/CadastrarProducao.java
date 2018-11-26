package view;
import java.awt.Dimension;
import java.awt.Toolkit;
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
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
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
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import VO.Artista;
import VO.EnumTipoProducao;
import VO.Genero;
import VO.Producao;
import controller.ArtistaController;
import controller.GeneroController;
import controller.ProducaoController;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

@SuppressWarnings("serial")
public class CadastrarProducao extends JInternalFrame {

	private JLabel lblTitulo;
	private JLabel lblAno;
	private JLabel lblGenero;
	private JLabel lblDiretor;
	private JLabel lblAtor;
	private JLabel lblSinopse;
	private JLabel lblDuraoqtdtemp;
	private JLabel lblImagemcapa;
	private JPanel contentPane;
	private JLabel lblTipo;
	private JTextField textDiretor;
	private JFormattedTextField textAno;
	private JTextField textTitulo;
	private JTextField textImage;
	private JTextPane textPaneSinopse;
	private JComboBox<Genero> cbGenero;
	private JButton btnCadastrar;
	private JButton btnAdicionarArtista;
	private JButton btnImagem;
	private JComboBox<EnumTipoProducao> cbTipo;
	private JComboBox<Artista> cbAtores;
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel model;
	private JButton btnRemover;
	private JFormattedTextField textDuracaoQtdTemp;
	private byte[] image;
	private GeneroController gc;
	private ArtistaController ac;
	private List<Genero> generos;
	private List<Artista> artistas;

	public CadastrarProducao(boolean adicionar, Producao prod) {
		setClosable(true);

		if (adicionar) {
			setTitle("Cadastrar Produ\u00E7\u00E3o");
		} else
			setTitle("Atualizar Produ\u00E7\u00E3o");

		gc = new GeneroController();
		ac = new ArtistaController();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 703, 281);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblTitulo = new JLabel("Titulo");
		lblTitulo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTitulo.setBounds(10, 42, 85, 14);
		contentPane.add(lblTitulo);

		lblAno = new JLabel("Ano");
		lblAno.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAno.setBounds(10, 71, 85, 14);
		contentPane.add(lblAno);

		lblGenero = new JLabel("Genero");
		lblGenero.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGenero.setBounds(10, 97, 85, 14);
		contentPane.add(lblGenero);

		lblDiretor = new JLabel("Diretor");
		lblDiretor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDiretor.setBounds(10, 126, 85, 14);
		contentPane.add(lblDiretor);

		lblAtor = new JLabel("Atores");
		lblAtor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAtor.setBounds(348, 14, 52, 14);
		contentPane.add(lblAtor);

		lblSinopse = new JLabel("Sinopse");
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
	
		
		textDuracaoQtdTemp = new JFormattedTextField();
		textDuracaoQtdTemp.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				mudaMascaraDuracao(textDuracaoQtdTemp);
			}
			@Override
			public void focusGained(FocusEvent e) {
				textDuracaoQtdTemp.setFormatterFactory(null);
			}
		});

		textDuracaoQtdTemp.setBounds(277, 65, 64, 20);
		contentPane.add(textDuracaoQtdTemp);
		textDuracaoQtdTemp.setColumns(10);

		cbTipo = new JComboBox<EnumTipoProducao>();
		cbTipo.setModel(new DefaultComboBoxModel<>(EnumTipoProducao.values()));

		lblDuraoqtdtemp = new JLabel("Dura\u00E7\u00E3o");
		lblDuraoqtdtemp.setBounds(201, 68, 85, 14);
		contentPane.add(lblDuraoqtdtemp);

		textAno = new JFormattedTextField();
		textAno.setBounds(105, 65, 86, 20);
		contentPane.add(textAno);
		textAno.setColumns(10);
		
		textAno.setValue(null);
        
		try {
			MaskFormatter mask = new MaskFormatter();	        
	        mask.setMask("####");
	        textAno.setFormatterFactory(new DefaultFormatterFactory(mask));
		} catch (Exception e) {
		}
		
		textTitulo = new JTextField();
		textTitulo.setColumns(10);
		textTitulo.setBounds(105, 39, 236, 20);
		contentPane.add(textTitulo);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(371, 39, 285, 108);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Codigo", "Artista" }));
		scrollPane.setViewportView(table);

		model = (DefaultTableModel) table.getModel();

		cbTipo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (cbTipo.getSelectedIndex() == 0) {
					lblDuraoqtdtemp.setText("Duração (Min.)");
				} else if (cbTipo.getSelectedIndex() == 1) {
					lblDuraoqtdtemp.setText("Temporadas");
				}
			}
		});

		cbTipo.setBounds(105, 11, 236, 20);
		contentPane.add(cbTipo);

		listarGeneros();

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

		listarArtistas();

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

		if (adicionar)
			btnCadastrar = new JButton("Cadastrar");
		else
			btnCadastrar = new JButton("Atualizar");

		btnCadastrar.setBounds(565, 206, 91, 23);
		contentPane.add(btnCadastrar);

		this.getRootPane().setDefaultButton(btnCadastrar);

		textImage = new JTextField();
		textImage.setEditable(false);
		textImage.setText("");
		textImage.setBounds(105, 152, 185, 20);
		contentPane.add(textImage);
		textImage.setColumns(10);

		btnImagem = new JButton("...");
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

					e.printStackTrace();
				}
				revalidate();

			}
		});
		btnImagem.setBounds(300, 151, 41, 23);
		contentPane.add(btnImagem);

		lblImagemcapa = new JLabel("Imagem(capa)");
		lblImagemcapa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblImagemcapa.setBounds(10, 155, 85, 14);
		contentPane.add(lblImagemcapa);

		lblTipo = new JLabel("Tipo");
		lblTipo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipo.setBounds(10, 14, 85, 14);
		contentPane.add(lblTipo);

		btnAdicionarArtista = new JButton("Adicionar");
		btnAdicionarArtista.setBounds(565, 10, 91, 23);
		contentPane.add(btnAdicionarArtista);

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

		btnAdicionarArtista.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Object[] values = new Object[2];
				int idArtista = ((Artista) cbAtores.getSelectedItem()).getIdArtista();
				
				values[0] = idArtista;
				values[1] = ((Artista) cbAtores.getSelectedItem()).getNome();

				boolean encontrado = false;
				
				if(idArtista > 0)
				{
					for (int i = 0; i < model.getRowCount(); i++) {
						if (values[0] == model.getValueAt(i, 0)) {
							encontrado = true;
							JOptionPane.showMessageDialog(null, "Artista já inserido");
							break;
						}
					}
					if (!encontrado)
						model.addRow(values);
				}
			}
		});

		table.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btnRemover.setEnabled(true);
			}
		});

		if (!adicionar) {

			for (int i = 0; i < cbTipo.getItemCount(); i++) {
				EnumTipoProducao item = cbTipo.getItemAt(i);
				if (item == prod.getTipo()) {
					cbTipo.setSelectedIndex(i);
					break;
				}
			}

			for (int i = 0; i < cbGenero.getItemCount(); i++) {
				Genero item = cbGenero.getItemAt(i);
				if (item.getDescricao().equalsIgnoreCase(prod.getGenero().getDescricao())) {
					cbGenero.setSelectedIndex(i);
					break;
				}
			}

			textTitulo.setText(prod.getTitulo());
			textAno.setText(String.valueOf(prod.getAno()));
			textPaneSinopse.setText(prod.getSinopse());

			textDiretor.setText(prod.getDiretor());

			if (prod.getTipo() == EnumTipoProducao.Filme) {
				textDuracaoQtdTemp.setText(String.valueOf(prod.getDuracao()));
			}

			if (prod.getTipo() == EnumTipoProducao.Serie) {
				textDuracaoQtdTemp.setText(String.valueOf(prod.getQtdTemporadas()));
			}

			for (Artista artista : prod.getArtistas()) {
				Object[] values = new Object[2];

				values[0] = artista.getIdArtista();
				values[1] = artista.getNome();
				model.addRow(values);
			}

		}

		btnCadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int producao = 0;
				if (prod != null)
					producao = prod.getIdProducao();

				addOrUpdate(adicionar, producao);
			}

		});

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

	}

	private void listarArtistas() {
		artistas = ac.listarTodos();
		
		artistas = new ArrayList<Artista>();
		
		Artista vazio = new Artista();
		vazio.setNome("Selecionar...");
		vazio.setIdArtista(0);
		artistas.add(vazio);		
		artistas.addAll(ac.listarTodos());
		
		cbAtores = new JComboBox<Artista>(new Vector<>(artistas));
	}

	private void listarGeneros() {		
		generos = new ArrayList<Genero>();
		
		Genero vazio = new Genero();
		vazio.setDescricao("Selecionar...");
		vazio.setIdGenero(0);
		generos.add(vazio);		
		generos.addAll(gc.listarTodos());
		
		cbGenero = new JComboBox<Genero>(new Vector<>(generos));
	}

	private void addOrUpdate(boolean adicionar, int idProducao) {

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

		if (!adicionar) {
			producao.setIdProducao(idProducao);
		}
		try {
			String msg = controle.salvar(producao);
			JOptionPane.showMessageDialog(null, msg);

			if (msg.contains("cadastrada")) {
				LimparDadosTela();
			}

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage() + "");

		}
	}

	private void LimparDadosTela() {
		textAno.setText("");
		textDiretor.setText("");
		textDuracaoQtdTemp.setText("");
		textImage.setText("");
		textPaneSinopse.setText("");
		textTitulo.setText("");

		int rowCount = table.getRowCount();
		for (int i = 0; i < rowCount; i++) {
			model.removeRow(0);
		}
	}

	private void mudaMascaraDuracao(JFormattedTextField format) {
        try {
            format.setValue(null);
            String nome = format.getText().replaceAll("-", "").replaceAll("\\(", "").replaceAll("\\)", "");
            final MaskFormatter mask = new MaskFormatter();
            switch (nome.length()) {
                case 1:
                    mask.setMask("#");
                    format.setFormatterFactory(new DefaultFormatterFactory(mask));
                    break;
                case 2:
                    mask.setMask("##");
                    format.setFormatterFactory(new DefaultFormatterFactory(mask));
                    break;
                case 3:
                    mask.setMask("###");
                    format.setFormatterFactory(new DefaultFormatterFactory(mask));
                    break;
                default:
                    break;
            }
            format.setText(nome);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
