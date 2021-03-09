package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JButton;

public class OrderFrame extends JFrame {

	private JPanel contentPane;
	private JComboBox prezzoBox;
	/**
	 * 
	 * @wbp.nonvisual location=212,189
	 */
	
	/**
	 * Create the frame.
	 */
	public OrderFrame() {
		setTitle("Ricerca");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Alergeni");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(21, 67, 130, 13);
		contentPane.add(lblNewLabel);
		
		
		JComboBox allergeniBox = new JComboBox();
		allergeniBox.setBounds(161, 65, 167, 19);
		allergeniBox.setModel(new DefaultComboBoxModel(new String[] {null, "Arachidi","Cereali e derivati", "Crostacei", "Uova", "Pesce", "Soia", "Latte ", "Frutta a guscio", "Sedano", "Senape", "Sesamo", "Anidride solforosa e solfiti", "Lupini", "Molluschi"}));
		contentPane.add(allergeniBox);
		
	    		
		JLabel lblNewLabel_1 = new JLabel("Prezzo");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(21, 95, 135, 13);
		contentPane.add(lblNewLabel_1);
		
		prezzoBox = new JComboBox();
		prezzoBox.setBounds(161, 92, 167, 19);
		prezzoBox.setModel(new DefaultComboBoxModel(new String[] {null, "Basso", "Medio", "Alto"}));
		contentPane.add(prezzoBox);
		
		JLabel lblNewLabel_1_1 = new JLabel("Veicolo Rider");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(21, 123, 135, 13);
		contentPane.add(lblNewLabel_1_1);
		
		JComboBox veicoloBox = new JComboBox();
		veicoloBox.setBounds(161, 121, 167, 19);
		veicoloBox.setModel(new DefaultComboBoxModel(new String[] {null, "Auto", "Bicicletta", "Moto","Motorino"}));
		contentPane.add(veicoloBox);
		
		JButton btnNewButton = new JButton("CERCA");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton.setBounds(192, 179, 94, 21);
		contentPane.add(btnNewButton);
	}
}
