package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import VO.Geradorplanilhas;
import VO.Producao;
import VO.Usuario;
import controller.ProducaoController;

public class ListarProducoesAssistidas extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel model;
	private JButton btnGerarRelatrio;
	ArrayList<Producao> producoesTemp;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Usuario usuario = new Usuario();
					usuario.setIdUsuario(1);
					ListarProducoesAssistidas frame = new ListarProducoesAssistidas(usuario);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ListarProducoesAssistidas(Usuario usuario) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 366);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(ListarProducoesAssistidas.class.getResource("/extras/eye-2317618_960_720.png")));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);

		table = new JTable();
		table.setEnabled(false);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Tipo", "Produção", "Nota", "Genero", "Diretor", "Ano" }));
		scrollPane.setViewportView(table);
		model = (DefaultTableModel) table.getModel();

		scrollPane.setBounds(356, 118, 279, 75);
		getContentPane().add(scrollPane);

		btnGerarRelatrio = new JButton("Gerar Relat\u00F3rio");
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
		contentPane.add(btnGerarRelatrio, BorderLayout.SOUTH);

		ProducaoController pc = new ProducaoController();

		ArrayList<Producao> producoes = pc.buscarProducoesAssistidas(usuario);

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

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
	}

}
