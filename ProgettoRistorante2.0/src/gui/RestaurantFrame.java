package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controller;
import entity.Consegna;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RestaurantFrame extends JFrame {

	private JPanel contentPane;
	private Controller controller;
	private ButtonGroup group;
	private String indirizzoRistorante;
	
	public RestaurantFrame(Controller c) {
		controller = c;
		group = new ButtonGroup();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 333, 456);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Seleziona il ristorante: ");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(56, 35, 275, 29);
		contentPane.add(label);
		
		JRadioButton button_1 = new JRadioButton("Via Marina 18");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_1.setBounds(56, 87, 137, 21);
		contentPane.add(button_1);
		
		JRadioButton button_3 = new JRadioButton("Via Terracina 89");
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_3.setBounds(56, 175, 137, 21);
		contentPane.add(button_3);
		
		JRadioButton button_4 = new JRadioButton("Via Claudio 35");
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_4.setBounds(56, 223, 137, 21);
		contentPane.add(button_4);
		
		JRadioButton button_2 = new JRadioButton("Via roma 24");
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_2.setBounds(56, 132, 137, 21);
		contentPane.add(button_2);
		
		JRadioButton button_5 = new JRadioButton("Via Foria 9");
		button_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_5.setBounds(56, 270, 137, 21);
		contentPane.add(button_5);
		
		JRadioButton button_6 = new JRadioButton("Viale Augusto 67");
		button_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_6.setBounds(56, 310, 137, 21);
		contentPane.add(button_6);
		
		group.add(button_1);
		group.add(button_2);
		group.add(button_3);
		group.add(button_4);
		group.add(button_5);
		group.add(button_6);
		
		JButton selectionButton = new JButton("SELEZIONA");
		selectionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(button_1.isSelected()) {
					indirizzoRistorante = button_1.getText();
					controller.ristoranteSelezionato(indirizzoRistorante);
					controller.openRiderFrame();
				}
				else if(button_2.isSelected()) {
					indirizzoRistorante = button_2.getText();
					controller.ristoranteSelezionato(indirizzoRistorante);
					controller.openRiderFrame();
				}
				else if(button_3.isSelected()) {
					indirizzoRistorante = button_3.getText();
					controller.ristoranteSelezionato(indirizzoRistorante);
					controller.openRiderFrame();
				}
				else if(button_4.isSelected()) {
					indirizzoRistorante = button_4.getText();
					controller.ristoranteSelezionato(indirizzoRistorante);
					controller.openRiderFrame();
				}
				else if(button_5.isSelected()) {
					indirizzoRistorante = button_5.getText();
					controller.ristoranteSelezionato(indirizzoRistorante);
					controller.openRiderFrame();
				}
				else if(button_6.isSelected()) {
					indirizzoRistorante = button_6.getText();
					controller.ristoranteSelezionato(indirizzoRistorante);
					controller.openRiderFrame();
				}
				else {
					JOptionPane.showMessageDialog(null, "Selezionare un ristorante.");
				}
				
			}
		});
		selectionButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		selectionButton.setBounds(193, 364, 102, 34);
		contentPane.add(selectionButton);
		
	}

	public String getIndirizzoRistorante() {
		return indirizzoRistorante;	
	}
}
