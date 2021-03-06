package view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import VO.EnumNivel;
import VO.Usuario;
import controller.UsuarioController;

@SuppressWarnings("serial")
public class CadastrarUsuario extends JFrame {

	private JFormattedTextField  textTelefone;
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
	private JButton btnSalvar;

	public CadastrarUsuario(Usuario usuario, boolean adicionar) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(CadastrarUsuario.class.getResource("/extras/eye-2317618_960_720.png")));

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 380, 264);
		getContentPane().setLayout(null);

		lblNome = new JLabel("Nome");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setBounds(10, 39, 108, 14);
		getContentPane().add(lblNome);

		lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(10, 67, 108, 14);
		getContentPane().add(lblEmail);

		lblNick = new JLabel("Nick");
		lblNick.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNick.setBounds(10, 14, 108, 14);
		getContentPane().add(lblNick);

		lblConfSenha = new JLabel("Confirmar senha");
		lblConfSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConfSenha.setBounds(10, 118, 108, 14);
		getContentPane().add(lblConfSenha);

		lblSenha = new JLabel("Senha");
		lblSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSenha.setBounds(10, 92, 108, 14);
		getContentPane().add(lblSenha);

		lblTelefone = new JLabel("Telefone");
		lblTelefone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefone.setBounds(10, 144, 108, 14);
		getContentPane().add(lblTelefone);

		lblInfo = new JLabel("");
		lblInfo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblInfo.setBounds(10, 195, 322, 14);
		getContentPane().add(lblInfo);

		textTelefone = new JFormattedTextField();
		textTelefone.setColumns(10);
		textTelefone.setBounds(122, 141, 207, 20);
		getContentPane().add(textTelefone);
		
		textTelefone.setValue(null);
        
		try {
			MaskFormatter mask = new MaskFormatter();
	        
	        mask.setMask("(##)#####-####");
	        textTelefone.setFormatterFactory(new DefaultFormatterFactory(mask));
		} catch (Exception e) {
		}

		textConfSenha = new JPasswordField();
		textConfSenha.setBounds(122, 115, 207, 20);
		getContentPane().add(textConfSenha);

		textSenha = new JPasswordField();
		textSenha.setBounds(122, 89, 207, 20);
		getContentPane().add(textSenha);

		textNick = new JTextField();
		textNick.setToolTipText("");
		textNick.setColumns(10);
		textNick.setBounds(122, 11, 207, 20);
		getContentPane().add(textNick);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(122, 64, 207, 20);
		getContentPane().add(textEmail);

		textNome = new JTextField();
		textNome.setColumns(10);
		textNome.setBounds(122, 36, 207, 20);
		getContentPane().add(textNome);

		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(236, 172, 96, 23);
		getContentPane().add(btnSalvar);

		btnSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int _usuario = 0;
				if (usuario != null)
					_usuario = usuario.getIdUsuario();
				
				addOrUpdate(adicionar, _usuario);

			}
		});

		textEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				UsuarioController controller = new UsuarioController();
				Usuario usuario = controller.verificaEmailUsuario(textEmail.getText() + "");

				if (adicionar) {
					if (usuario != null) {
						textEmail.setForeground(Color.RED);
						lblInfo.setText("Email j� cadastrado.");
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
			}
		});

		textNick.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				UsuarioController controller = new UsuarioController();
				Usuario usuario = controller.verificaNickUsuario(textNick.getText() + "");

				if (adicionar) {
					if (usuario != null) {
						textNick.setForeground(Color.RED);
						lblInfo.setText("Usu�rio j� cadastrado.");
						textEmail.setEnabled(false);
						textSenha.setEnabled(false);
						textConfSenha.setEnabled(false);
						textTelefone.setEnabled(false);
						btnSalvar.setEnabled(false);
					} else if (usuario == null) {
						textNick.setForeground(Color.BLACK);
						lblInfo.setText("Usu�rio valido.");
						textEmail.setEnabled(true);
						textSenha.setEnabled(true);
						textConfSenha.setEnabled(true);
						textTelefone.setEnabled(true);
						btnSalvar.setEnabled(true);	
					}
				}
			}

		});
		
		setTitle("Cadastrar Usu�rio");
		
		if(!adicionar) {
			setTitle("Atualizar Usu�rio");
			btnSalvar.setText("Atualizar");
			textNick.setText(usuario.getNickname());
			textEmail.setText(usuario.getEmail());
			textNome.setText(usuario.getNome());
			textSenha.setText(usuario.getSenha());
			textConfSenha.setText(usuario.getSenha());
			textTelefone.setText(usuario.getTelefone());
		}		
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
	}

	private void fechar() {
		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}

	private void addOrUpdate(boolean adicionar,int idUsuario) {
		Usuario usuario = new Usuario();

		usuario.setNome(textNome.getText());
		usuario.setEmail(textEmail.getText());
		usuario.setNickname(textNick.getText());
		usuario.setNivel(EnumNivel.User);
		String senha = verificaCampoSenha();

		if (senha.equals("")) {
			JOptionPane.showMessageDialog(null, "Senhas n�o conferem.");
		} else {
			usuario.setSenha(senha);

		}
		usuario.setTelefone(textTelefone.getText());

		if (!adicionar) {
			usuario.setIdUsuario(idUsuario);
		}
		
		UsuarioController controle = new UsuarioController();
		try {
			JOptionPane.showMessageDialog(null, controle.salvar(usuario));
			fechar();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage() + "");

		}
	}
	
	private String verificaCampoSenha() {
		char[] senhaChar = textSenha.getPassword();
		char[] senha2Char = textConfSenha.getPassword();
		String senhaVerificada = "";
		String senha = "";
		String senha2 = "";

		for (int i = 0; i < senhaChar.length; i++) {
			senha += senhaChar[i];
		}

		for (int i = 0; i < senha2Char.length; i++) {
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
