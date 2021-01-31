import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JList;
import java.awt.Choice;
import javax.swing.JButton;

public class WelcomePage extends JFrame implements ActionListener{

	private JFrame welcomePageFrame = new JFrame();
	private Choice choice = new Choice();
	private final JLabel lblNewLabel_1 = new JLabel("Scegliere il tipo di veicolo del rider:");
	private JButton bt1 = new JButton("Avanti");
	
	
	public WelcomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		welcomePageFrame.setTitle("Welcome Page");
		welcomePageFrame.setBounds(100, 100, 516, 325);
		welcomePageFrame.getContentPane().setLayout(null);
		
		JLabel lb1 = new JLabel("Benvenuto sul nostro servizio di ordini online:");
		lb1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lb1.setBounds(80, 51, 574, 28);
		welcomePageFrame.getContentPane().add(lb1);
		lb1.setForeground(Color.red);
		
		JList list = new JList();
		list.setBounds(80, 151, 194, -12);
		welcomePageFrame.getContentPane().add(list);
		
		choice.add("Bicicletta");
		choice.add("Motorino");
		choice.add("Macchina");
		choice.setBounds(80, 167, 101, 18);
		welcomePageFrame.getContentPane().add(choice);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(80, 115, 250, 33);
		
		welcomePageFrame.getContentPane().add(lblNewLabel_1);
		welcomePageFrame.setVisible(true);
		
		bt1.setBounds(80, 207, 85, 21);
		welcomePageFrame.getContentPane().add(bt1);
		getContentPane().setLayout(null);
		setSize(420,420);
		bt1.addActionListener(this);
			
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bt1) {
			welcomePageFrame.dispose();
			FinestraRistorante f1 = new FinestraRistorante();
		}
	}
}
