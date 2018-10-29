package view;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.sun.imageio.spi.InputStreamImageInputStreamSpi;
import com.sun.org.apache.bcel.internal.generic.CALOAD;

import javafx.scene.image.Image;
import jdk.internal.org.xml.sax.InputSource;
import jdk.internal.util.xml.impl.Input;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JSeparator;

public class CadastrarFilmePanel extends JPanel {
	private JTextField txtTitulo;
	private JTextField textAno;
	private JLabel lblGenero;
	private JTextField textDiretor;
	private JLabel lblDiretor;
	private JTextField textAtorAtriz;
	private JLabel lblAtoratriz;
	private JTextPane textSinopse;
	private JLabel lblSinopse;
	private JTextField textDuracao;
	private JLabel lblDuracao;
	private JButton btnNewButton;
	private JLabel lblImagem;

	/**
	 * Create the panel.
	 */
	public CadastrarFilmePanel() {
		
		JLabel lblNewLabel = new JLabel("Titulo");
		lblNewLabel.setBounds(10, 87, 85, 14);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(105, 84, 185, 20);
		txtTitulo.setColumns(10);
		
		JLabel lblAno = new JLabel("Ano");
		lblAno.setBounds(10, 115, 85, 14);
		lblAno.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textAno = new JTextField();
		textAno.setBounds(105, 112, 86, 20);
		textAno.setColumns(10);
		
		lblGenero = new JLabel("Genero");
		lblGenero.setBounds(10, 144, 85, 14);
		lblGenero.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textDiretor = new JTextField();
		textDiretor.setBounds(105, 170, 185, 20);
		textDiretor.setColumns(10);
		
		lblDiretor = new JLabel("Diretor");
		lblDiretor.setBounds(10, 173, 85, 14);
		lblDiretor.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textAtorAtriz = new JTextField();
		textAtorAtriz.setBounds(105, 197, 185, 20);
		textAtorAtriz.setColumns(10);
		
		lblAtoratriz = new JLabel("AtorAtriz");
		lblAtoratriz.setBounds(10, 199, 85, 14);
		lblAtoratriz.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textSinopse = new JTextPane();
		textSinopse.setBounds(105, 251, 322, 141);
		
		lblSinopse = new JLabel("Sinopse");
		lblSinopse.setBounds(10, 251, 85, 14);
		lblSinopse.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textDuracao = new JTextField();
		textDuracao.setBounds(105, 225, 86, 20);
		textDuracao.setColumns(10);
		
		lblDuracao = new JLabel("Duracao");
		lblDuracao.setBounds(10, 228, 85, 14);
		lblDuracao.setHorizontalAlignment(SwingConstants.RIGHT);
		
		btnNewButton = new JButton("+");
		btnNewButton.setBounds(300, 196, 41, 23);
		
		JComboBox cmbGenero = new JComboBox();
		cmbGenero.setBounds(105, 141, 185, 20);
		cmbGenero.setModel(new DefaultComboBoxModel(new String[] {"", "Terror", "A\u00E7\u00E3o", "Suspense", "Com\u00E9dia", "Drama", "Policial"}));
		
		JButton btnNewButton_1 = new JButton("Cadastrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.setBounds(346, 410, 81, 23);
		
		JLabel lblImagemText = new JLabel("Imagem");
		lblImagemText.setBounds(436, 42, 178, 14);
		lblImagemText.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JButton btnCarregarImagem = new JButton("Carregar Imagem");
		btnCarregarImagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFileChooser chooser = new JFileChooser();
				chooser.showSaveDialog(null);
				File f = chooser.getSelectedFile();
				ImageIcon icon = new ImageIcon(f.getAbsolutePath());
				lblImagemText.setText(f.getName());
				lblImagem.setIcon(icon);
				revalidate();
				
				
			}
		});
		btnCarregarImagem.setBounds(497, 247, 125, 23);
		setLayout(null);
		add(lblImagemText);
		add(btnCarregarImagem);
		add(lblNewLabel);
		add(txtTitulo);
		add(lblAno);
		add(textAno);
		add(lblAtoratriz);
		add(textAtorAtriz);
		add(btnNewButton);
		add(lblDuracao);
		add(textDuracao);
		add(lblGenero);
		add(cmbGenero);
		add(lblDiretor);
		add(textDiretor);
		add(btnNewButton_1);
		add(lblSinopse);
		add(textSinopse);
		
		lblImagem = new JLabel("imagemLabel");
		lblImagem.setBackground(Color.GRAY);
		lblImagem.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagem.setBounds(497, 67, 125, 175);
		add(lblImagem);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(461, 42, 8, 223);
		add(separator);

	}
}
