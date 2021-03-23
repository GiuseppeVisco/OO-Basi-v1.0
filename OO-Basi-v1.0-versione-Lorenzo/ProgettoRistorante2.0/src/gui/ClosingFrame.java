package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controller;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class ClosingFrame extends JFrame {

	JPanel contentPane;
	Controller controller;
	
	public ClosingFrame(Controller c) {
		setResizable(false);
		controller = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 300, 670, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel infoLabel = new JLabel("Il tuo ordine \u00E8 stato ricevuto e verr\u00E0 consegnato al pi\u00F9 presto.");
		infoLabel.setFont(new Font("Script MT Bold", Font.BOLD, 16));
		infoLabel.setBounds(96, 41, 491, 36);
		contentPane.add(infoLabel);
		
		JButton bottoneContinua = new JButton("Continua gli acquisti");
		bottoneContinua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.apriRestaurantFrame();
				controller.chiudiClosingFrame();
			}
		});
		bottoneContinua.setFont(new Font("Tahoma", Font.BOLD, 11));
		bottoneContinua.setBounds(78, 153, 157, 50);
		contentPane.add(bottoneContinua);
		
		JButton bottoneLogout = new JButton("Logout");
		bottoneLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.logOutUser();
			}
		});
		bottoneLogout.setFont(new Font("Tahoma", Font.BOLD, 11));
		bottoneLogout.setBounds(439, 153, 140, 50);
		contentPane.add(bottoneLogout);
	}
}
