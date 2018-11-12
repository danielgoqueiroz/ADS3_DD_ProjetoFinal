package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import VO.Artista;
import VO.Producao;
import VO.Usuario;
import controller.ProducaoController;
import javax.swing.ListSelectionModel;

public class ListarProducoes extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel model;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarProducoes frame = new ListarProducoes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ListarProducoes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(ListarProducoes.class.getResource("/extras/eye-2317618_960_720.png")));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		scrollPane = new JScrollPane();

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setEnabled(true);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Tipo", "Produção", "Genero", "Diretor", "Ano" }));
		scrollPane.setViewportView(table);
		model = (DefaultTableModel) table.getModel();

		scrollPane.setBounds(356, 118, 279, 75);
		getContentPane().add(scrollPane);

		ProducaoController pc = new ProducaoController();

		ArrayList<Producao> producoes = pc.buscarProducoes();

		for (Producao producao : producoes) {

			Object[] values = new Object[5];

			values[0] = producao.getTipo();
			values[1] = producao.getTitulo();
			values[2] = producao.getGenero().getDescricao();
			values[3] = producao.getDiretor();
			values[4] = producao.getAno();

			model.addRow(values);
		}
	}

}
