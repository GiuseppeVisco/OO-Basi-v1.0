package gui;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import controller.*;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import java.awt.Color;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField passwordField;
	Controller controller;
	private JPanel panel;
	private JLabel logoLabel;


	public LoginFrame(Controller c) {
		setResizable(false);
		controller =c;
		setTitle("Log In");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 300, 955, 523);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(474, 160, 416, 189);
		contentPane.add(panel);
		panel.setLayout(null);

		
		usernameField = new JTextField();
		usernameField.setBounds(146, 35, 223, 38);
		panel.add(usernameField);
		usernameField.setColumns(10);
		
		JLabel usernameLabel = new JLabel("USERNAME");
		usernameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		usernameLabel.setBounds(25, 40, 89, 26);
		panel.add(usernameLabel);
		usernameLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		passwordField = new JPasswordField();
		passwordField.setBounds(146, 84, 223, 38);
		panel.add(passwordField);
		
		JLabel passwordLabel = new JLabel("PASSWORD");
		passwordLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		passwordLabel.setBounds(36, 89, 89, 26);
		panel.add(passwordLabel);
		passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton loginButton = new JButton("LOGIN");
		loginButton.setBounds(311, 140, 95, 38);
		panel.add(loginButton);
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.checkCredentials(usernameField.getText(),passwordField.getText());
			}
		});
		loginButton.setFont(new Font("Calibri", Font.BOLD, 12));
		
		logoLabel = new JLabel("");
		ImageIcon image = new ImageIcon(this.getClass().getResource("/logoSmall.png"));
		logoLabel.setIcon(image);
		logoLabel.setBounds(22, 104, 442, 243);
		contentPane.add(logoLabel);
	}
	
	public void cleanFields() {
		usernameField.setText(null);
		passwordField.setText(null);
	}
}
