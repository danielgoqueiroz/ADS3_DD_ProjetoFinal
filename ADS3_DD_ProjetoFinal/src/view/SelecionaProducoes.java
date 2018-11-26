package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import VO.Producao;
import controller.ProducaoController;

public class SelecionaProducoes extends JInternalFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel model;
	ArrayList<Producao> producoes;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					SelecionaProducoes frame = new SelecionaProducoes(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SelecionaProducoes(JDesktopPane desktopPane) {
		setTitle("Selecione para editar produ\u00E7\u00E3o");
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setClosable(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		scrollPane = new JScrollPane();

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setEnabled(true);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Tipo", "Produção", "Genero", "Diretor", "Ano", "idProducao" }));
		scrollPane.setViewportView(table);
		model = (DefaultTableModel) table.getModel();
		contentPane.setLayout(null);

		scrollPane.setBounds(5, 5, 424, 216);
		getContentPane().add(scrollPane);

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (table.getSelectedRow() >= 0) {

					int idProducao = (int) model.getValueAt(table.getSelectedRow(), 5);
					Producao prod = null;
					for (Producao producao : producoes) {
						if (idProducao == producao.getIdProducao()) {
							prod = producao;
							break;
						}
					}

					dispose();

					CadastrarProducao producao = new CadastrarProducao(false, prod);
					if (desktopPane != null) {
						desktopPane.add(producao);
					}
					producao.show();

				} else {
					JOptionPane.showMessageDialog(null, "Selecione uma linha.");
				}

			}
		});
		btnEditar.setBounds(340, 227, 89, 23);
		contentPane.add(btnEditar);

		ProducaoController pc = new ProducaoController();

		producoes = pc.buscarProducoes();

		table.removeColumn(table.getColumnModel().getColumn(5));

		for (Producao producao : producoes) {

			Object[] values = new Object[6];

			values[0] = producao.getTipo();
			values[1] = producao.getTitulo();
			values[2] = producao.getGenero().getDescricao();
			values[3] = producao.getDiretor();
			values[4] = producao.getAno();
			values[5] = producao.getIdProducao();

			model.addRow(values);
		}

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
	}
}
