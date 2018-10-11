package src.view;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;

public class UsuarioPanel extends JPanel {
	private JTextField textNome;
	private JTextField textNickname;
	private JTextField textEmail;
	private JTextField textTelefone;
	private JPasswordField passSenha;
	private JPasswordField passSenhaConfirmacao;

	/**
	 * Create the panel.
	 */
	public UsuarioPanel() {
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblEmail = new JLabel("E-Mail");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblConfirmeASenha = new JLabel("Confirme a Senha");
		lblConfirmeASenha.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textNome = new JTextField();
		textNome.setColumns(10);
		
		textNickname = new JTextField();
		textNickname.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		
		textTelefone = new JTextField();
		textTelefone.setColumns(10);
		
		JButton btnInserir = new JButton("Inserir");
		
		JButton btnBuscar = new JButton("Buscar");
		
		passSenha = new JPasswordField();
		
		passSenhaConfirmacao = new JPasswordField();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnInserir, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNome, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
								.addComponent(lblEmail, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
								.addComponent(lblNickname, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
								.addComponent(lblTelefone, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
								.addComponent(lblSenha, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
								.addComponent(lblConfirmeASenha, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(passSenhaConfirmacao, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(textNome, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
									.addComponent(textNickname, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
									.addComponent(textEmail, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
									.addComponent(textTelefone, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
									.addComponent(passSenha)))))
					.addGap(117))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNome))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNickname)
						.addComponent(textNickname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblEmail)
						.addComponent(textEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblTelefone)
						.addComponent(textTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSenha)
						.addComponent(passSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblConfirmeASenha)
						.addComponent(passSenhaConfirmacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnInserir)
						.addComponent(btnBuscar))
					.addContainerGap(91, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
}
