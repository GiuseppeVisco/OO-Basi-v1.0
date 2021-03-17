package gui;


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


	public LoginFrame(Controller c) {
		controller =c;
		setTitle("Log In");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 300, 955, 523);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(363, 119, 455, 208);
		contentPane.add(panel);
		panel.setLayout(null);

		
		usernameField = new JTextField();
		usernameField.setBounds(146, 47, 223, 38);
		panel.add(usernameField);
		usernameField.setColumns(10);
		
		JLabel usernameLabel = new JLabel("USERNAME");
		usernameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		usernameLabel.setBounds(26, 52, 89, 26);
		panel.add(usernameLabel);
		usernameLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		passwordField = new JPasswordField();
		passwordField.setBounds(146, 140, 223, 38);
		panel.add(passwordField);
		
		JLabel passwordLabel = new JLabel("PASSWORD");
		passwordLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		passwordLabel.setBounds(28, 145, 89, 26);
		panel.add(passwordLabel);
		passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton loginButton = new JButton("LOGIN");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.checkCredentials(usernameField.getText(),passwordField.getText());
			}
		});
		loginButton.setFont(new Font("Calibri", Font.BOLD, 12));
		loginButton.setBounds(711, 345, 107, 45);
		contentPane.add(loginButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 206, 209), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 206, 209)));
		panel_1.setBounds(35, 180, 259, 87);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome Ristorante");
		lblNewLabel.setBounds(0, 0, 259, 87);
		panel_1.add(lblNewLabel);
		lblNewLabel.setBackground(new Color(128, 128, 128));
		lblNewLabel.setFont(new Font("Script MT Bold", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	public void cleanFields() {
		usernameField.setText(null);
		passwordField.setText(null);
	}
}
