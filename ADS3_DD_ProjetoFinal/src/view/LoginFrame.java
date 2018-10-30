package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import VO.Usuario;
import controller.UsuarioController;
import java.awt.Font;

public class LoginFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private Usuario usuarioLogin;
	boolean aparecer = true;
	private JPasswordField password;
	private JTextField textUsuario;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 564, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 354, Short.MAX_VALUE)
		);
		
		JLabel label = new JLabel("Senha");
		label.setBounds(44, 109, 89, 14);
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		
		password = new JPasswordField();
		password.setBounds(145, 106, 186, 20);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(145, 80, 186, 20);
		
		textUsuario.setColumns(10);
		
		JLabel label_1 = new JLabel("Usuario");
		label_1.setBounds(44, 83, 89, 14);
		label_1.setVerticalAlignment(SwingConstants.TOP);
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JButton btnNovoUsuario = new JButton("Criar Usu\u00E1rio");
		btnNovoUsuario.setBounds(97, 138, 114, 21);
		btnNovoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarUsuario novoUsuarioTela = new CadastrarUsuario();
				novoUsuarioTela.setVisible(true);
			}
		});
		btnNovoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNovoUsuario.setEnabled(false);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(217, 138, 114, 21);
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					
					Usuario usuario = new Usuario();
					usuario.setNickname(textUsuario.getText());
					char[] senhaChar = password.getPassword();
					String senha = "";
					for (int i = 0; i < senhaChar.length; i++) {
						senha += senhaChar[i];
					}
					
					usuario.setSenha(senha);
					
					UsuarioController controle = new UsuarioController();
					usuarioLogin = controle.realizaLogin(usuario);
					
					if (usuarioLogin.getIdUsuario() > 0) {
//						JOptionPane.showMessageDialog(null, "Login de " + usuarioLogin.toString() + " realizado com sucesso.");
						TelaInicial tela = new TelaInicial(usuarioLogin);
						tela.setVisible(true);
						
//						tela.setUser(usuarioLogin);
						tela.setTitle(usuarioLogin.toString());
						
						hide();
					}
					
			}
		});
		btnLogin.setEnabled(false);
		getContentPane().setLayout(null);
		getContentPane().add(label_1);
		getContentPane().add(textUsuario);
		getContentPane().add(label);
		getContentPane().add(password);
		getContentPane().add(btnNovoUsuario);
		getContentPane().add(btnLogin);
		
		textUsuario.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				UsuarioController controle = new UsuarioController();
				
				if (controle.verificaNickUsuario(textUsuario.getText()) == null) {
					btnNovoUsuario.setEnabled(true);
					
				} else {
					btnLogin.setEnabled(true);
				};
			}
			@Override
			public void focusGained(FocusEvent arg0) {
				btnLogin.setEnabled(false);
				btnNovoUsuario.setEnabled(false);
			}
		});
	}
	
	
	public Usuario getUsuarioLogin() {
		return this.usuarioLogin;
	
	}
}
