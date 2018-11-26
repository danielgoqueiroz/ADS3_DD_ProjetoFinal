package view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import VO.Usuario;
import controller.UsuarioController;

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
			@Override
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
//		Frame.getWindows().

		setIconImage(
				Toolkit.getDefaultToolkit().getImage(LoginFrame.class.getResource("/extras/eye-2317618_960_720.png")));
		setTitle("Quais produções cinematográficas você já assistiu?");
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 469, 179);

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout
				.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGap(0, 564, Short.MAX_VALUE));
		groupLayout
				.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGap(0, 354, Short.MAX_VALUE));

		JLabel label = new JLabel("Senha");
		label.setBounds(65, 57, 89, 14);
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setHorizontalAlignment(SwingConstants.RIGHT);

		password = new JPasswordField();
		password.setBounds(166, 54, 186, 20);

		textUsuario = new JTextField();
		textUsuario.setBounds(166, 28, 186, 20);

		textUsuario.setColumns(10);

		JLabel label_1 = new JLabel("Usuario");
		label_1.setBounds(65, 31, 89, 14);
		label_1.setVerticalAlignment(SwingConstants.TOP);
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);

		JButton btnNovoUsuario = new JButton("Criar Usu\u00E1rio");
		btnNovoUsuario.setBounds(118, 86, 114, 21);
		btnNovoUsuario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CadastrarUsuario tela = new CadastrarUsuario(textUsuario.getText() + "");
				tela.setVisible(true);

			}
		});
		btnNovoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNovoUsuario.setEnabled(false);

		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(238, 86, 114, 21);
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnLogin.addActionListener(new ActionListener() {
			@Override
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
					PainelPrincipal painelPrincipal = new PainelPrincipal(usuarioLogin);
					painelPrincipal.setVisible(true);
					painelPrincipal.setTitle(usuarioLogin.toString());
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

		this.getRootPane().setDefaultButton(btnLogin);
		textUsuario.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				UsuarioController controle = new UsuarioController();

				if (controle.verificaNickUsuario(textUsuario.getText()) == null) {
					btnNovoUsuario.setEnabled(true);
					btnLogin.setEnabled(false);

				} else {
					btnLogin.setEnabled(true);
				}
				;
			}

			@Override
			public void focusGained(FocusEvent arg0) {
				btnLogin.setEnabled(false);
				btnNovoUsuario.setEnabled(false);
			}
		});

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
	}

	public Usuario getUsuarioLogin() {
		return usuarioLogin;

	}
}
