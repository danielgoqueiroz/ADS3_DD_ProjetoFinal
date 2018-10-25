package src.testes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class testeassitidos extends JFrame {

	private JPanel contentPane;
	private int nota;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testeassitidos frame = new testeassitidos();
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
	public testeassitidos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 494, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnS1 = new JButton("");
		btnS1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nota = 1;
				
			}
		});
		btnS1.setIcon(new ImageIcon(testeassitidos.class.getResource("/extras/gold-star-png-1 - Copia.png")));
		btnS1.setBounds(379, 322, 83, 59);
		contentPane.add(btnS1);
		
		JButton btnS2 = new JButton("");
		btnS2.setIcon(new ImageIcon(testeassitidos.class.getResource("/extras/gold-star-png-2.png")));
		btnS2.setBounds(379, 252, 83, 59);
		contentPane.add(btnS2);
		
		JButton btnS3 = new JButton("");
		btnS3.setIcon(new ImageIcon(testeassitidos.class.getResource("/extras/gold-star-png-3.png")));
		btnS3.setBounds(379, 182, 83, 59);
		contentPane.add(btnS3);
		
		JButton btnS4 = new JButton("");
		btnS4.setIcon(new ImageIcon(testeassitidos.class.getResource("/extras/gold-star-png-4.png")));
		btnS4.setBounds(379, 112, 83, 59);
		contentPane.add(btnS4);
		
		JButton btnS5 = new JButton("");
		btnS5.setIcon(new ImageIcon(testeassitidos.class.getResource("/extras/gold-star-png-5.png")));
		btnS5.setBounds(379, 42, 83, 59);
		contentPane.add(btnS5);
		
		JLabel lblNewLabel = new JLabel("Quantas estrelas merece?");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(47, 22, 366, 39);
		contentPane.add(lblNewLabel);
	}

}
