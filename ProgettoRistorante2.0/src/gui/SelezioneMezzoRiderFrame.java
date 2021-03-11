package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.Controller;
import javax.swing.DefaultComboBoxModel;

public class SelezioneMezzoRiderFrame extends JFrame {

	private JPanel contentPane;
	Controller controller;

	
	public SelezioneMezzoRiderFrame(Controller c) {
		controller = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
	
	String[] veicoliString = { "Scooter", "Bicicletta elettrica", "Macchina" };
	JComboBox listaVeicoliBox = new JComboBox(veicoliString);
	listaVeicoliBox.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
		}
	});
	
	listaVeicoliBox.setToolTipText("");
	listaVeicoliBox.setBounds(101, 113, 179, 23);
	contentPane.add(listaVeicoliBox);
	
	JLabel lblNewLabel = new JLabel("Scegli il mezzo di trasporto del rider");
	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel.setBounds(101, 69, 178, 33);
	contentPane.add(lblNewLabel);
	
	JButton btnNewButton = new JButton("Conferma");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
					
			controller.veicoloSelezionato(listaVeicoliBox.getSelectedIndex());
		}
	});
	btnNewButton.setBounds(290, 113, 103, 23);
	contentPane.add(btnNewButton);
}

}
