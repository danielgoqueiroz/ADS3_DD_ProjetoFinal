package view;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.sun.glass.ui.GestureSupport;

import javax.swing.SwingConstants;

import jdk.nashorn.internal.scripts.JO;
import VO.Usuario;
import controller.UsuarioController;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textUsuario;
	private JPasswordField password;
	private Usuario usuarioLogin;
	boolean aparecer = true;


	/**
	 * Create the panel.
	 */
	public  Login() {
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textUsuario = new JTextField();
		
		textUsuario.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		
		password = new JPasswordField();
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
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
					
				}
				
				
				
				
			}
		});
		btnLogin.setEnabled(false);
		
		
		
		
		
		
		JButton btnNovoUsuario = new JButton("Criar Usu\u00E1rio");
		btnNovoUsuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				
			}
		});
		
		btnNovoUsuario.setEnabled(false);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(122)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNovoUsuario)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnLogin))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblSenha, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblUsuario, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(12)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(textUsuario)
								.addComponent(password, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))))
					.addContainerGap(104, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(62)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsuario)
						.addComponent(textUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSenha)
						.addComponent(password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLogin)
						.addComponent(btnNovoUsuario))
					.addContainerGap(163, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
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
