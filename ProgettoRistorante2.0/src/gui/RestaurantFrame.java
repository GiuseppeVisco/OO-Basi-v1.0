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
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

public class RestaurantFrame extends JFrame {

	private JPanel contentPane;
	private Controller controller;
	private ButtonGroup group;
	private String indirizzoRistorante;
	
	public RestaurantFrame(Controller c) {
		setTitle("Selezione sede");
		controller = c;
		group = new ButtonGroup();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 300, 501, 456);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSelezionaLaSede = new JLabel("Seleziona la sede pi\u00F9 vicina");
		lblSelezionaLaSede.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelezionaLaSede.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 22));
		lblSelezionaLaSede.setBounds(47, 33, 275, 29);
		contentPane.add(lblSelezionaLaSede);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(50, 71, 166, 266);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JRadioButton button_1 = new JRadioButton("Via Marina 18");
		button_1.setBounds(6, 16, 137, 21);
		panel.add(button_1);
		button_1.setFont(new Font("Calibri", Font.PLAIN, 12));
		
		group.add(button_1);
		
		JRadioButton button_3 = new JRadioButton("Via Terracina 89");
		button_3.setBounds(6, 104, 137, 21);
		panel.add(button_3);
		button_3.setFont(new Font("Calibri", Font.PLAIN, 12));
		group.add(button_3);
		
		JRadioButton button_4 = new JRadioButton("Via Claudio 35");
		button_4.setBounds(6, 152, 137, 21);
		panel.add(button_4);
		button_4.setFont(new Font("Calibri", Font.PLAIN, 12));
		group.add(button_4);
		
		JRadioButton button_2 = new JRadioButton("Via Roma 24");
		button_2.setBounds(6, 61, 137, 21);
		panel.add(button_2);
		button_2.setFont(new Font("Calibri", Font.PLAIN, 12));
		group.add(button_2);
		
		JRadioButton button_5 = new JRadioButton("Via Foria 9");
		button_5.setBounds(6, 199, 137, 21);
		panel.add(button_5);
		button_5.setFont(new Font("Calibri", Font.PLAIN, 12));
		group.add(button_5);
		
		JRadioButton button_6 = new JRadioButton("Viale Augusto 67");
		button_6.setBounds(6, 239, 137, 21);
		panel.add(button_6);
		button_6.setFont(new Font("Calibri", Font.PLAIN, 12));
		group.add(button_6);
		
		JButton selectionButton = new JButton("CONTINUA");
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
		selectionButton.setBounds(268, 182, 116, 50);
		contentPane.add(selectionButton);
		
	}

	public String getIndirizzoRistorante() {
		return indirizzoRistorante;	
	}
}
