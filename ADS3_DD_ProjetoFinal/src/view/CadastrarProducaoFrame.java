package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.xml.internal.ws.api.Component;

import VO.Artista;
import VO.Genero;
import controller.ArtistaController;
import controller.GeneroController;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastrarProducaoFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textDuracao;
	private JTextField textDiretor;
	private JTextField textAno;
	private JTextField textTitulo;
	private JTextField textField;
	private JTextPane textPaneSinopse;
	private JTable table;
	private JComboBox<Genero> cbGenero;
	private JButton btnCadastrar;
	private JButton btnAdicionar;
	private JComboBox cbTipo;
	private JComboBox<Artista> cbAtores;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
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

	/**
	 * Create the frame.
	 */
	public CadastrarProducaoFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 281);
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
		lblAtor.setBounds(348, 18, 52, 14);
		contentPane.add(lblAtor);
		
		JLabel lblDuracao = new JLabel("Dura\u00E7\u00E3o");
		lblDuracao.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDuracao.setBounds(197, 71, 51, 14);
		contentPane.add(lblDuracao);
		
		JLabel lblSinopse = new JLabel("Sinopse");
		lblSinopse.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSinopse.setBounds(43, 186, 52, 14);
		contentPane.add(lblSinopse);
		
		textPaneSinopse = new JTextPane();
		textPaneSinopse.setBounds(105, 183, 236, 46);
		contentPane.add(textPaneSinopse);
		
		textDuracao = new JTextField();
		textDuracao.setColumns(10);
		textDuracao.setBounds(255, 65, 85, 20);
		contentPane.add(textDuracao);
		
		textDiretor = new JTextField();
		textDiretor.setColumns(10);
		textDiretor.setBounds(105, 123, 236, 20);
		contentPane.add(textDiretor);
		
		GeneroController gc = new GeneroController();
		
		final List<Genero> generos = gc.listarTodos();
		
		cbGenero = new JComboBox<>(new Vector<>(generos));
		cbGenero.setBounds(105, 94, 236, 20);
		contentPane.add(cbGenero);
		
		cbGenero.setRenderer(new DefaultListCellRenderer() {
            @Override
            public java.awt.Component getListCellRendererComponent(final JList<?> list,
                                                          final Object value,
                                                          final int index,
                                                          final boolean isSelected,
                                                          final boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected,
                                                   cellHasFocus);
                if (value instanceof Genero)
                    setText(((Genero) value).getDescricao());

                return this;
            }
        });
		
		ArtistaController ac = new ArtistaController();
		final List<Artista> artistas = ac.listarTodos();
		cbAtores = new JComboBox<>(new Vector<>(artistas));
		cbAtores.setBounds(410, 15, 145, 20);
		contentPane.add(cbAtores);
		
		cbAtores.setRenderer(new DefaultListCellRenderer() {
            @Override
            public java.awt.Component getListCellRendererComponent(final JList<?> list,
                                                          final Object value,
                                                          final int index,
                                                          final boolean isSelected,
                                                          final boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected,
                                                   cellHasFocus);
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
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			private Object teste;

			public void actionPerformed(ActionEvent e) {
				teste = cbGenero.getSelectedItem();
			
				
			}
		});
		btnCadastrar.setBounds(565, 206, 81, 23);
		contentPane.add(btnCadastrar);
		
		textField = new JTextField();
		textField.setText("");
		textField.setBounds(105, 152, 185, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnImagem = new JButton("...");
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
		
		cbTipo = new JComboBox();
		cbTipo.setModel(new DefaultComboBoxModel(new String[] {"Filme", "S\u00E9rie"}));
		cbTipo.setBounds(105, 11, 236, 20);
		contentPane.add(cbTipo);	
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(565, 14, 81, 23);
		contentPane.add(btnAdicionar);
		
		table = new JTable();
		table.setBounds(410, 46, 236, 126);
		contentPane.add(table);
	}
}
