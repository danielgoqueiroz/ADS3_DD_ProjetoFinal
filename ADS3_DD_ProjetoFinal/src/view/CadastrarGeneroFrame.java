package view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import VO.Genero;
import controller.GeneroController;

public class CadastrarGeneroFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
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

	public CadastrarGeneroFrame() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(CadastrarGeneroFrame.class.getResource("/extras/eye-2317618_960_720.png")));
		setTitle("Cadastrar Gênero");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 398, 108);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(25, 28, 39, 14);
		contentPane.add(lblNome);

		textNome = new JTextField();
		textNome.setBounds(65, 25, 212, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(280, 25, 89, 20);
		contentPane.add(btnSalvar);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

		btnSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Genero genero = new Genero();
				genero.setDescricao(textNome.getText());

				GeneroController controle = new GeneroController();

				Genero generoTemp = controle.buscaGeneroPorNome(textNome.getText() + "");

				if (generoTemp == null) {
					try {
						JOptionPane.showMessageDialog(null, controle.salvar(genero));
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null, e.getMessage() + "");						
					}
				} else {
					JOptionPane.showMessageDialog(contentPane,
							"Gênero " + generoTemp.getDescricao() + " já cadastrado!");

				}
				
				textNome.setText("");
			}
		});
	}
}