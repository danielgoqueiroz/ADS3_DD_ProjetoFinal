package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListarProducoes extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel model;
	ArrayList<Producao> producoes;

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(ListarProducoes.class.getResource("/extras/eye-2317618_960_720.png")));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		scrollPane = new JScrollPane();

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setEnabled(true);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Tipo", "Produção", "Genero", "Diretor", "Ano","idProducao" }));
		scrollPane.setViewportView(table);
		model = (DefaultTableModel) table.getModel();
		contentPane.setLayout(null);

		scrollPane.setBounds(5, 5, 424, 216);
		getContentPane().add(scrollPane);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(table.getSelectedRow() >= 0) {
										
					int idProducao = (int)model.getValueAt(table.getSelectedRow(), 5);
					Producao prod = null;
					for (Producao producao : producoes) 
					{
						if(idProducao == producao.getIdProducao()) {
							prod = producao;
							break;
						}
					}
					
					dispose();
					CadastrarProducaoFrame producao = new CadastrarProducaoFrame(false, prod);
					producao.setVisible(true);					
					
				}else {
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
	}
}
