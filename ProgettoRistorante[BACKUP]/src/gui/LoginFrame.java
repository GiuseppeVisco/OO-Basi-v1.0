package gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;

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

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField passwordField;
	
	Controller controller;

	/**
	 * Create the frame.
	 */
	public LoginFrame(Controller c) {
		controller =c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 523);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		usernameField = new JTextField();
		usernameField.setBounds(302, 150, 223, 38);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		JLabel usernameLabel = new JLabel("USERNAME");
		usernameLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		usernameLabel.setBounds(183, 154, 89, 26);
		contentPane.add(usernameLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(302, 233, 223, 38);
		contentPane.add(passwordField);
		
		JLabel passwordLabel = new JLabel("PASSWORD");
		passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		passwordLabel.setBounds(183, 233, 89, 26);
		contentPane.add(passwordLabel);
		
		JButton loginButton = new JButton("LOGIN");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.checkCr(usernameField.getText(),passwordField.getText());
			}
		});
		loginButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		loginButton.setBounds(358, 334, 107, 45);
		contentPane.add(loginButton);
	}
		
	public void cleanFields() {
		usernameField.setText(null);
		passwordField.setText(null);
	}

}
