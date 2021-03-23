package gui;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controller.Controller;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;

public class RiderFrame extends JFrame {

	JPanel contentPane;
	Controller controller;
	ButtonGroup group;
	private String mezzoRider;
	
	public RiderFrame(Controller c) {
		setResizable(false);
		controller = c;
		group = new ButtonGroup();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 300, 547, 313);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel riderLabel = new JLabel("Seleziona il mezzo di trasporto del rider:");
		riderLabel.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 19));
		riderLabel.setBounds(31, 31, 341, 25);
		contentPane.add(riderLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(76, 74, 115, 158);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JRadioButton riderButton_1 = new JRadioButton("Automobile");
		riderButton_1.setBounds(6, 16, 103, 21);
		panel.add(riderButton_1);
		riderButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		group.add(riderButton_1);
		
		JRadioButton riderButton_2 = new JRadioButton("Moto");
		riderButton_2.setBounds(6, 53, 103, 21);
		panel.add(riderButton_2);
		riderButton_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		group.add(riderButton_2);
		
		JRadioButton riderButton_3 = new JRadioButton("Motorino");
		riderButton_3.setBounds(6, 93, 103, 21);
		panel.add(riderButton_3);
		riderButton_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		group.add(riderButton_3);
		
		JRadioButton riderButton_4 = new JRadioButton("Bicicletta");
		riderButton_4.setBounds(6, 131, 103, 21);
		panel.add(riderButton_4);
		riderButton_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		group.add(riderButton_4);
		
		JButton continuaButton = new JButton("CONTINUA");
		continuaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(riderButton_1.isSelected()) {
				mezzoRider=riderButton_1.getText();
				controller.controllaRiderDisponibili(mezzoRider);
				controller.setIdRiderConsegna(mezzoRider);
				controller.setVeicoloUtilizzato(mezzoRider);
			}
			if(riderButton_2.isSelected()) {
				mezzoRider=riderButton_2.getText();
				controller.controllaRiderDisponibili(mezzoRider);
				controller.setIdRiderConsegna(mezzoRider);
				controller.setVeicoloUtilizzato(mezzoRider);
			}
			if(riderButton_3.isSelected()) {
				mezzoRider=riderButton_3.getText();
				controller.controllaRiderDisponibili(mezzoRider);
				controller.setIdRiderConsegna(mezzoRider);
				controller.setVeicoloUtilizzato(mezzoRider);
			}
			if(riderButton_4.isSelected()) {
				mezzoRider=riderButton_4.getText();
				controller.controllaRiderDisponibili(mezzoRider);
				controller.setIdRiderConsegna(mezzoRider);
				controller.setVeicoloUtilizzato(mezzoRider);
			}
			}
		});
		continuaButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		continuaButton.setBounds(308, 127, 117, 45);
		contentPane.add(continuaButton);
	}

}