package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controller;
import entity.Veicolo;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RiderFrame extends JFrame {

	private JPanel contentPane;
	Controller controller;
	ButtonGroup group;
	
	public RiderFrame(Controller c) {
		controller = c;
		group = new ButtonGroup();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel riderLabel = new JLabel("Seleziona il mezzo di trasporto del rider:");
		riderLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		riderLabel.setBounds(49, 25, 295, 25);
		contentPane.add(riderLabel);
		
		JRadioButton riderButton_1 = new JRadioButton("Automobile");
		riderButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		riderButton_1.setBounds(49, 74, 103, 21);
		contentPane.add(riderButton_1);
		
		JRadioButton riderButton_2 = new JRadioButton("Moto");
		riderButton_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		riderButton_2.setBounds(49, 111, 103, 21);
		contentPane.add(riderButton_2);
		
		JRadioButton riderButton_3 = new JRadioButton("Motorino");
		riderButton_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		riderButton_3.setBounds(49, 151, 103, 21);
		contentPane.add(riderButton_3);
		
		JRadioButton riderButton_4 = new JRadioButton("Bicicletta");
		riderButton_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		riderButton_4.setBounds(49, 189, 103, 21);
		contentPane.add(riderButton_4);
		
		JButton selectionButton = new JButton("SELEZIONA");
		selectionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				controller.setRiderVehicle()
//				Richiamo il dao e cerco un rider con quel veicolo che sia disponibile
				controller.openMenuFrame();
			}
		});
		selectionButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		selectionButton.setBounds(288, 213, 102, 34);
		contentPane.add(selectionButton);
		
		group.add(riderButton_1);
		group.add(riderButton_2);
		group.add(riderButton_3);
		group.add(riderButton_4);
	}

}