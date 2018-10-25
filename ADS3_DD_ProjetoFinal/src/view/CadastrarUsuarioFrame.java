package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import VO.Usuario;
import controller.UsuarioController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class CadastrarUsuarioFrame extends JFrame {
	private JTextField textTelefone;
	private JPasswordField textConfSenha;
	private JPasswordField textSenha;
	private JTextField textNick;
	private JTextField textEmail;
	private JTextField textNome;
	private JLabel lblNome;
	private JLabel lblEmail;
	private JLabel lblNick;
	private JLabel lblConfSenha;
	private JLabel lblSenha;
	private JLabel lblTelefone;
	private JLabel lblInfo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarUsuarioFrame frame = new CadastrarUsuarioFrame();
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
	public CadastrarUsuarioFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		getContentPane().setLayout(null);
		
		lblNome = new JLabel("Nome");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setBounds(45, 39, 108, 14);
		getContentPane().add(lblNome);
		
		lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(45, 67, 108, 14);
		getContentPane().add(lblEmail);
		
		lblNick = new JLabel("Nick");
		lblNick.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNick.setBounds(45, 14, 108, 14);
		getContentPane().add(lblNick);
		
		lblConfSenha = new JLabel("Confirmacao da Senha");
		lblConfSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConfSenha.setBounds(45, 118, 108, 14);
		getContentPane().add(lblConfSenha);
		
		lblSenha = new JLabel("Senha");
		lblSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSenha.setBounds(45, 92, 108, 14);
		getContentPane().add(lblSenha);
		
		lblTelefone = new JLabel("Telefone");
		lblTelefone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefone.setBounds(45, 144, 108, 14);
		getContentPane().add(lblTelefone);
		
		lblInfo = new JLabel("");
		lblInfo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblInfo.setBounds(58, 263, 306, 14);
		getContentPane().add(lblInfo);
		
		textTelefone = new JTextField();
		textTelefone.setColumns(10);
		textTelefone.setBounds(157, 141, 207, 20);
		getContentPane().add(textTelefone);
		
		textConfSenha = new JPasswordField();
		textConfSenha.setBounds(157, 115, 207, 20);
		getContentPane().add(textConfSenha);
		
		textSenha = new JPasswordField();
		textSenha.setBounds(157, 89, 207, 20);
		getContentPane().add(textSenha);
		
		textNick = new JTextField();
		textNick.setToolTipText("");
		textNick.setColumns(10);
		textNick.setBounds(157, 11, 207, 20);
		getContentPane().add(textNick);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(157, 64, 207, 20);
		getContentPane().add(textEmail);
		
		textNome = new JTextField();
		textNome.setColumns(10);
		textNome.setBounds(157, 36, 207, 20);
		getContentPane().add(textNome);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(268, 199, 96, 23);
		getContentPane().add(btnSalvar);
		
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Usuario usuario = new Usuario();
				
				usuario.setNome(textNome.getText());
				usuario.setEmail(textEmail.getText());
				usuario.setNickname(textNick.getText());
				String senha = verificaCampoSenha();
				if (senha.equals("")) {
					JOptionPane.showMessageDialog(null, "Senhas não conferem.");
				} else {
					usuario.setSenha(senha);

				}
				usuario.setTelefone(textTelefone.getText());
				
				UsuarioController controle = new UsuarioController();
				
				try {
					JOptionPane.showMessageDialog(null, controle.salvar(usuario));
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, e.getMessage() + "");
					
				}
			
			}

			
		});
		
		textEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				UsuarioController controller = new UsuarioController();
				Usuario usuario = controller.verificaEmailUsuario(textEmail.getText()+"");
				
				if (usuario != null) {
					textEmail.setForeground(Color.RED);
					lblInfo.setText("Email já cadastrado.");
					textConfSenha.setEnabled(false);
					textTelefone.setEnabled(false);
					btnSalvar.setEnabled(false);
				} else {
						textEmail.setForeground(Color.BLACK);
						lblInfo.setText("Email valido.");
						textConfSenha.setEnabled(true);
						textTelefone.setEnabled(true);
						btnSalvar.setEnabled(true);
				}
			}
		});
		
		textNick.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				UsuarioController controller = new UsuarioController();
				Usuario usuario = controller.verificaNickUsuario(textNick.getText()+"");
				
				if (usuario != null) {
					textNick.setForeground(Color.RED);
					lblInfo.setText("Usuário já cadastrado.");
//					textNome.setText(usuario.getNome());
//					textTelefone.setText(usuario.getTelefone());
//					textEmail.setText(usuario.getEmail());
//					textNick.setSelectedTextColor(Color.red);
					textEmail.setEnabled(false);
					textSenha.setEnabled(false);
					textConfSenha.setEnabled(false);
					textTelefone.setEnabled(false);
					btnSalvar.setEnabled(false);
				} else if
					(usuario == null) {
						textNick.setForeground(Color.BLACK);
						lblInfo.setText("Usuário valido.");
						textEmail.setEnabled(true);
						textSenha.setEnabled(true);
						textConfSenha.setEnabled(true);
						textTelefone.setEnabled(true);
						btnSalvar.setEnabled(true);
					
					}
					
				}
			
		});
		
		
		
	}
	private String verificaCampoSenha() {
		char[] senhaChar = textSenha.getPassword(); 
		char[] senha2Char = textConfSenha.getPassword();
		String senhaVerificada = "";
		String senha = "";
		String senha2 = "";
		
		for (int i = 0; i < senhaChar.length; i ++ ) {
			senha += senhaChar[i];
		}
		
		
		for (int i = 0; i < senha2Char.length; i ++ ) {
			senha2 += senha2Char[i];
		}
		
		if (senha.equals(senha2)) {
			senhaVerificada = senha;
		} else {
			senhaVerificada = "";
		}
		
		return senhaVerificada;
		
	}
}

