package src.view;

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

import src.VO.Usuario;
import src.controller.UsuarioController;
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
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		
		password = new JPasswordField();
		
		textUsuario = new JTextField();
		
		textUsuario.setColumns(10);
		
		JLabel label_1 = new JLabel("Usuario");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JButton btnNovoUsuario = new JButton("Criar Usu\u00E1rio");
		btnNovoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNovoUsuario.setEnabled(false);
		
		JButton btnLogin = new JButton("Login");
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
						JOptionPane.showMessageDialog(null, "Login de " + usuarioLogin.toString() + " realizado com sucesso.");
						TelaInicial tela = new TelaInicial();
						tela.setVisible(true);
						
						
					}
					
			}
		});
		btnLogin.setEnabled(false);
		GroupLayout groupLayout_1 = new GroupLayout(getContentPane());
		groupLayout_1.setHorizontalGroup(
			groupLayout_1.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout_1.createSequentialGroup()
					.addGap(97)
					.addGroup(groupLayout_1.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout_1.createSequentialGroup()
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(textUsuario, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout_1.createSequentialGroup()
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(password, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout_1.createSequentialGroup()
							.addGap(46)
							.addComponent(btnNovoUsuario, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(129, Short.MAX_VALUE))
		);
		groupLayout_1.setVerticalGroup(
			groupLayout_1.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout_1.createSequentialGroup()
					.addGap(80)
					.addGroup(groupLayout_1.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout_1.createSequentialGroup()
							.addGap(3)
							.addComponent(label_1))
						.addComponent(textUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(groupLayout_1.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout_1.createSequentialGroup()
							.addGap(3)
							.addComponent(label))
						.addComponent(password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(groupLayout_1.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNovoUsuario)
						.addComponent(btnLogin))
					.addContainerGap(106, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout_1);
		
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
		});
	}
	
	
	public Usuario getUsuarioLogin() {
		return this.usuarioLogin;
	
	}
}
