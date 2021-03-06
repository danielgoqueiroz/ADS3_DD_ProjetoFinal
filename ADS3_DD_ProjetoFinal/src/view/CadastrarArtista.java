package view;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import VO.Artista;
import controller.ArtistaController;

@SuppressWarnings("serial")
public class CadastrarArtista extends JInternalFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JLabel lblNome;
	private JButton btnSalvar;

	public CadastrarArtista() {
		setClosable(true);
		setResizable(false);

		setTitle("Cadastrar Artista");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 399, 109);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNome = new JLabel("Nome");
		lblNome.setBounds(28, 28, 34, 14);
		contentPane.add(lblNome);

		textNome = new JTextField();
		textNome.setBounds(65, 25, 212, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);

		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(280, 25, 89, 20);
		contentPane.add(btnSalvar);

		this.getRootPane().setDefaultButton(btnSalvar);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

		btnSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Artista artista = new Artista();

				artista.setNome(textNome.getText());

				ArtistaController controle = new ArtistaController();

				Artista artistaTemp = controle.buscarArtistaPorNome(textNome.getText() + "");

				if (artistaTemp == null) {
					try {
						JOptionPane.showMessageDialog(null, controle.salvar(artista));
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null, e.getMessage() + "");

					}
				} else {
					JOptionPane.showMessageDialog(contentPane, "Artista: " + artistaTemp.getNome() + " já cadastrado.");
				}
				textNome.setText("");
			}
		});
	}

}