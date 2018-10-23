package src.view;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import src.VO.Usuario;
import src.controller.UsuarioController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import javafx.scene.layout.Border;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class CadastrarUsuarioPanel extends JPanel {
	private JTextField textNome;
	private JTextField textEmail;
	private JTextField textNick;
	private JTextField textTelefone;
	private JLabel lblEmail;
	private JLabel lblNick;
	private JLabel lblSenha;
	private JLabel lblTelefone;
	private JPasswordField password;
	private JPasswordField passwordConfirmacao;
	private JLabel lblConfirmacaosenha;

	/**
	 * Create the panel.
	 */
	public CadastrarUsuarioPanel() {
		
		textNome = new JTextField();
		textNome.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		
		textNick = new JTextField();
		textNick.setToolTipText("");
		
		textNick.setColumns(10);
		
		textTelefone = new JTextField();
		textTelefone.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JButton btnSalvar = new JButton("Salvar");
		
		
		lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		
		lblNick = new JLabel("Nick");
		lblNick.setHorizontalAlignment(SwingConstants.RIGHT);
		
		lblSenha = new JLabel("Senha");
		lblSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		
		lblTelefone = new JLabel("Telefone");
		lblTelefone.setHorizontalAlignment(SwingConstants.RIGHT);
		
		password = new JPasswordField();
		
		passwordConfirmacao = new JPasswordField();
		passwordConfirmacao.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if (verificaCampoSenha().equals("")) {
					JOptionPane.showMessageDialog(null, "Senhas não conferem.");
				};
			}
		});
		
		lblConfirmacaosenha = new JLabel("Confirmacao da Senha");
		lblConfirmacaosenha.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblinfo = new JLabel("info");
		lblinfo.setHorizontalAlignment(SwingConstants.RIGHT);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNick, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblConfirmacaosenha, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSenha, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTelefone, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(textTelefone)
						.addComponent(passwordConfirmacao, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
						.addComponent(password)
						.addComponent(textNick)
						.addComponent(textEmail)
						.addComponent(textNome, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSalvar, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(60, Short.MAX_VALUE))
				.addComponent(lblinfo, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(96)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNome))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmail))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textNick, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNick))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSenha))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordConfirmacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblConfirmacaosenha))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTelefone))
					.addGap(90)
					.addComponent(btnSalvar)
					.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
					.addComponent(lblinfo))
		);
		setLayout(groupLayout);

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
		
		textNick.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				UsuarioController controller = new UsuarioController();
				Usuario usuario = controller.verificaNickUsuario(textNick.getText()+"");
				
				if (usuario != null) {
					textNick.setForeground(Color.RED);
					lblinfo.setText("Usuário já cadastrado.");
//					textNome.setText(usuario.getNome());
//					textTelefone.setText(usuario.getTelefone());
//					textEmail.setText(usuario.getEmail());
//					textNick.setSelectedTextColor(Color.red);
				} else {
					
				}
			}
		});
		
		
	}
	
	private String verificaCampoSenha() {
		char[] senhaChar = password.getPassword(); 
		char[] senha2Char = passwordConfirmacao.getPassword(); 
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
