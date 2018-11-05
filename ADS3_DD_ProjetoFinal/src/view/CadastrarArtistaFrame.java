package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import VO.Artista;
import controller.ArtistaController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CadastrarArtistaFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarArtistaFrame frame = new CadastrarArtistaFrame();
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
	public CadastrarArtistaFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 347, 133);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(47, 30, 46, 14);
		contentPane.add(lblNome);
		
		textNome = new JTextField();
		textNome.setBounds(94, 27, 212, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(216, 67, 89, 20);
		contentPane.add(btnSalvar);
		
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Artista artista = new Artista();
				
				artista.setNome(textNome.getText());
				//artista.setDtNascimento(textNome.getText());				
				
				ArtistaController controle = new ArtistaController();
				
				Artista artistaTemp = controle.buscarArtistaPorNome(textNome.getText() + "");
				
				if(artistaTemp == null) {
					try {
						JOptionPane.showMessageDialog(null, controle.salvar(artista));
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null, e.getMessage() + "");
					
					}
				} else {
					JOptionPane.showMessageDialog(contentPane, "Artista: " + artistaTemp.getNome() + " j� cadastrado.");
			
				}
			}
			
		});
		
	}
}
