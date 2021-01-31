import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Menu extends JFrame implements ActionListener{

	private JPanel menu = new JPanel();
	private JRadioButton item1 = new JRadioButton("Pizza   10€");
	private JRadioButton item2 = new JRadioButton("Pasta   6€");
	private JRadioButton item3 = new JRadioButton("Hamburger   8€");
	private JRadioButton item4 = new JRadioButton("Patatine Fritte   4€");
	private JButton bt1 = new JButton("PLACE ORDER");
	private final JTextField tf1 = new JTextField();
	private final JTextField tf2 = new JTextField();
	private final JTextField tf3 = new JTextField();
	private final JTextField tf4 = new JTextField();
//	Creo un istanza di consegna in modo che una volta creato l'ordine da parte
//  dell'utente assegna la consegna tramite un codice al rider
	private	Consegna c1 = new Consegna();
	
	
	public Menu() {
		tf1.setBounds(268, 45, 24, 19);
		tf1.setColumns(10);
		
		setTitle("Men\u00F9");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 425, 456);
		menu.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(menu);
		setVisible(true);
		menu.setLayout(null);

		
		
		item1.setFont(new Font("Tahoma", Font.BOLD, 14));
		item1.setBounds(35, 42, 165, 21);
		menu.add(item1);
		item1.setFocusable(false);
		item1.addActionListener(this);
		
		item2.setFont(new Font("Tahoma", Font.BOLD, 14));
		item2.setBounds(35, 85, 165, 21);
		menu.add(item2);
		item2.setFocusable(false);
		item2.addActionListener(this);
		
		item3.setFont(new Font("Tahoma", Font.BOLD, 14));
		item3.setBounds(35, 129, 165, 21);
		menu.add(item3);
		item3.setFocusable(false);
		item3.addActionListener(this);
		
		item4.setFont(new Font("Tahoma", Font.BOLD, 14));
		item4.setBounds(35, 173, 165, 21);
		menu.add(item4);
		item4.setFocusable(false);
		item4.addActionListener(this);
		
		bt1.setFont(new Font("Tahoma", Font.BOLD, 14));
		bt1.setBounds(110, 255, 148, 41);
		menu.add(bt1);
		bt1.setFocusable(false);
		
		menu.add(tf1);
		tf2.setColumns(10);
		tf2.setBounds(268, 88, 24, 19);
		
		menu.add(tf2);
		tf3.setColumns(10);
		tf3.setBounds(268, 132, 24, 19);
		
		menu.add(tf3);
		tf4.setColumns(10);
		tf4.setBounds(268, 176, 24, 19);
		
		menu.add(tf4);
		bt1.addActionListener(this);
	}

	
	public void actionPerformed(ActionEvent e) {
		int total = 0;
		String message = "";
		
		if(item1.isSelected()) {
			int a1 = Integer.parseInt(tf1.getText());
			total+=(10*a1);
			message+= "Pizza   "+tf1.getText()+"\n";
	}
		
		if(item2.isSelected()) {
			int a = Integer.parseInt(tf2.getText());
			total+=(6*a);
			message+= "Pasta   "+tf2.getText()+"\n";
		}
		if(item3.isSelected()) {
			int a = Integer.parseInt(tf3.getText());
			total+=(8*a);
			message = "Hamburger   "+tf3.getText()+"\n";
		}
		if(item4.isSelected()) {
			int a = Integer.parseInt(tf4.getText());
			total+=(4*a);
			message+= "Patatine Fritte   "+tf4.getText()+"\n";
		}
		if(e.getSource()==bt1) {
		JOptionPane.showMessageDialog(this,message+"\nTotal: "+total+" €");
		String codiceConsegna = c1.getCodiceConsegna();
		}
	}
}
