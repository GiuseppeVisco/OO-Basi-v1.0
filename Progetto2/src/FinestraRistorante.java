import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import java.awt.Color;

import javax.swing.JLabel;
import java.awt.Font;

public class FinestraRistorante extends JFrame implements ActionListener {

	private JFrame contentPane = new JFrame();
	private JLabel l1 = new JLabel("SELEZIONARE IL RISTORANTE:");
	private JLabel l2 = new JLabel("");
	private String[] ristoranti = {"Via Giulio Cesare 13","Via San Ciro 10","Via Marina 5"};
	private JComboBox cb1 = new JComboBox(ristoranti);
	
	public FinestraRistorante() {
		contentPane.setTitle("Finestra Ristorante");
		contentPane.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane.setBounds(100, 100, 420, 185);
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.getContentPane().setLayout(null);
		contentPane.setVisible(true);
		
		
		
		cb1.setBackground(Color.WHITE);
		cb1.setBounds(44, 64, 212, 28);
		contentPane.getContentPane().add(cb1);
		cb1.addActionListener(this);
		
		
		l1.setFont(new Font("Tahoma", Font.BOLD, 12));
		l1.setBounds(44, 26, 212, 26);
		contentPane.getContentPane().add(l1);
		
		l2.setFont(new Font("Tahoma", Font.BOLD, 12));
		l2.setBounds(106, 134, 212, 26);
		contentPane.getContentPane().add(l2);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==cb1) {
			contentPane.dispose();
			Menu m1 = new Menu();
			}
	}
}
