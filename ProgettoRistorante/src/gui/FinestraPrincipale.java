package gui;
import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controller;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JPasswordField;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class FinestraPrincipale extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	public Controller theController;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinestraPrincipale frame = new FinestraPrincipale();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public FinestraPrincipale(Controller c) {
		theController = c;
		setForeground(Color.DARK_GRAY);
		setTitle("Ristorante ");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FinestraPrincipale.class.getResource("/Images/Waiter-icon-presents-vector-food-Graphics-4845855-1-580x386.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 300, 628, 457);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Schermata di login");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNewLabel.setBounds(244, 68, 155, 43);
		lblNewLabel.setForeground(SystemColor.activeCaptionText);
		lblNewLabel.setBackground(Color.PINK);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(285, 169, 114, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setBounds(211, 172, 64, 23);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(211, 227, 76, 21);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Accedi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if (textField.getText().isEmpty()||passwordField.getText().isEmpty() )
					JOptionPane.showMessageDialog(null, "Inserire email e password");
				else 
					
					theController.Mactch(textField.getText(), passwordField.getText());
					
			}
		});
		btnNewButton.setBounds(402, 265, 89, 23);
		contentPane.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(285, 227, 114, 29);
		contentPane.add(passwordField);
	}
}
