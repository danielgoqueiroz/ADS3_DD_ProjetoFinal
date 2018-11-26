package view;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import VO.Genero;
import VO.Geradorplanilhas;
import VO.Producao;
import VO.Usuario;
import controller.GeneroController;
import controller.ProducaoController;

@SuppressWarnings("serial")
public class ListarProducoesAssistidas extends JInternalFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel model;
	private JButton btnGerarRelatrio;
	private JComboBox<Genero> cbGenero;
	ArrayList<Producao> producoesTemp;
	private GeneroController gc;
	private List<Genero> generos;
	private JLabel lblGenero;

	public ListarProducoesAssistidas(Usuario usuario) {
		gc = new GeneroController();
		setClosable(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 449, 428);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);

		table = new JTable();
		table.setEnabled(false);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Tipo", "Produção", "Nota", "Genero", "Diretor", "Ano" }));
		scrollPane.setViewportView(table);
		model = (DefaultTableModel) table.getModel();
		contentPane.setLayout(null);

		scrollPane.setBounds(5, 66, 424, 295);
		getContentPane().add(scrollPane);

		btnGerarRelatrio = new JButton("Gerar Relat\u00F3rio");
		btnGerarRelatrio.setBounds(5, 361, 424, 23);
		btnGerarRelatrio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Geradorplanilhas plan = new Geradorplanilhas();
				JFileChooser chooser = new JFileChooser();
				chooser.setDialogTitle("Salvar como... ");
				int resultado = chooser.showSaveDialog(null);
				if (resultado == JFileChooser.APPROVE_OPTION) {
					String caminho = chooser.getSelectedFile().getAbsolutePath();
					plan.gerarPlanilhasProducao(producoesTemp, caminho);
				}

			}
		});
		contentPane.add(btnGerarRelatrio);

		listarGeneros();
		
		cbGenero.setBounds(5, 36, 211, 20);
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
		
		cbGenero.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String genero = cbGenero.getSelectedItem().toString();

				ProducaoController pc = new ProducaoController();

				ArrayList<Producao> producoes = pc.buscarProducoesAssistidas(usuario, genero);

				for (Producao producao : producoes) {

					Object[] values = new Object[6];

					values[0] = producao.getTipo();
					values[1] = producao.getTitulo();
					values[2] = producao.getNota();
					values[3] = producao.getGenero().getDescricao();
					values[4] = producao.getDiretor();
					// values[5] = producao.getArtistas();
					values[5] = producao.getAno();

					model.addRow(values);
				}
				producoesTemp = producoes;
				revalidate();
			}
		});

		lblGenero = new JLabel("Genero");
		lblGenero.setBounds(5, 11, 46, 14);
		contentPane.add(lblGenero);

		ProducaoController pc = new ProducaoController();

		ArrayList<Producao> producoes = pc.buscarProducoesAssistidas(usuario);

		for (Producao producao : producoes) {

			Object[] values = new Object[6];

			values[0] = producao.getTipo();
			values[1] = producao.getTitulo();
			values[2] = producao.getNota();
			values[3] = producao.getGenero().getDescricao();
			values[4] = producao.getDiretor();
			values[5] = producao.getAno();

			model.addRow(values);
		}
		producoesTemp = producoes;

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
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
}
