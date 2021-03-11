package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controller.Controller;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelezioneRistoranteFrame extends JFrame {

	private JPanel contentPane;
	Controller controller;
	
	public SelezioneRistoranteFrame(Controller c) {
		controller = c;
		setTitle("Selezione Ristorante");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String[] ristorantiString = { "NomeRistorante1", "NomeRistorante2", "NomeRistorante3", "NomeRistorante4" };
		JComboBox listaRistoranti = new JComboBox(ristorantiString);
		//comboBox.setModel(new DefaultComboBoxModel(new String[] {"NomeRistorante1", "NomeRistorante2", "NomeRistorante3"}));
		listaRistoranti.setToolTipText("cz<c");
		listaRistoranti.setBounds(101, 113, 179, 23);
		contentPane.add(listaRistoranti);
		
		JLabel lblNewLabel = new JLabel("Scegli il ristorante");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(101, 69, 178, 33);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Conferma");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBounds(290, 113, 103, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Indietro");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.backToLogin();
			}
		});
		btnNewButton_1.setBounds(10, 227, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
