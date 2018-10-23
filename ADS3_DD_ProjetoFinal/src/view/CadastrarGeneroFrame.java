package src.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import src.VO.Genero;
import src.VO.Usuario;
import src.controller.GeneroController;
import src.controller.UsuarioController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CadastrarGeneroFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarGeneroFrame frame = new CadastrarGeneroFrame();
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
	public CadastrarGeneroFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 109);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(54, 30, 39, 14);
		contentPane.add(lblNome);
		
		textNome = new JTextField();
		textNome.setBounds(94, 27, 212, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(320, 26, 89, 20);
		contentPane.add(btnSalvar);
		
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Genero genero = new Genero();
				
				genero.setDescricao(textNome.getText());
				
				
				GeneroController controle = new GeneroController();
				
				try {
					JOptionPane.showMessageDialog(null, controle.salvar(genero));
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, e.getMessage() + "");
					
				}
			
			}

			
		});
		
	}
}
