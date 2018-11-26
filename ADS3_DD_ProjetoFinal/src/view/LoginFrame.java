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

@SuppressWarnings("serial")
public class LoginFrame extends JFrame {

	private Usuario usuarioLogin;
	private JPasswordField textSenha;
	private JTextField textUsuario;
	private JLabel lblSenha;
	private JLabel lblUsuario;
	private JButton btnNovoUsuario;
	private JButton btnLogin;

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

	public LoginFrame() {

		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginFrame.class.getResource("/extras/eye-2317618_960_720.png")));
		setTitle("Quais produções cinematográficas você já assistiu?");
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 469, 179);

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGap(0, 564, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGap(0, 354, Short.MAX_VALUE));

		lblSenha = new JLabel("Senha");
		lblSenha.setBounds(65, 57, 89, 14);
		lblSenha.setVerticalAlignment(SwingConstants.TOP);
		lblSenha.setHorizontalAlignment(SwingConstants.RIGHT);

		textSenha = new JPasswordField();
		textSenha.setBounds(166, 54, 186, 20);

		textUsuario = new JTextField();
		textUsuario.setBounds(166, 28, 186, 20);

		textUsuario.setColumns(10);

		lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(65, 31, 89, 14);
		lblUsuario.setVerticalAlignment(SwingConstants.TOP);
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);

		btnNovoUsuario = new JButton("Criar Usu\u00E1rio");
		btnNovoUsuario.setBounds(118, 86, 114, 21);
		btnNovoUsuario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CadastrarUsuario tela = new CadastrarUsuario(null, true);
				tela.setVisible(true);

			}
		});
		btnNovoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNovoUsuario.setEnabled(false);

		btnLogin = new JButton("Login");
		btnLogin.setBounds(238, 86, 114, 21);
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Usuario usuario = new Usuario();
				usuario.setNickname(textUsuario.getText());
				char[] senhaChar = textSenha.getPassword();
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
					dispose();
				}

			}
		});
		btnLogin.setEnabled(false);
		getContentPane().setLayout(null);
		getContentPane().add(lblUsuario);
		getContentPane().add(textUsuario);
		getContentPane().add(lblSenha);
		getContentPane().add(textSenha);
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
}
