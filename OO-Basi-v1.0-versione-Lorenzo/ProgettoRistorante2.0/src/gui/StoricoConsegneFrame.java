package gui;



import controller.Controller;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.ListSelectionModel;


public class StoricoConsegneFrame extends JFrame {

	JPanel contentPane;
	JTable storicoTable;
	DefaultTableModel model;
	JTextField nomeText;
	JPanel panel;
	JButton ricercaPerIdButton;
	JTextField cercaIdRiderText;
	Controller controller;

	public StoricoConsegneFrame(Controller x) {
		setResizable(false);
		controller = x;
		setTitle("Storico consegne");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 300, 955, 523);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane storicoPanel = new JScrollPane();
		storicoPanel.setBounds(10, 110, 919, 231);
		contentPane.add(storicoPanel);	
				
				storicoTable = new JTable();
				storicoTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				storicoTable.setCellSelectionEnabled(true);
				storicoTable.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
				storicoTable.setFont(new Font("Lucida Sans", Font.BOLD, 12));
				storicoPanel.setViewportView(storicoTable);
				storicoTable.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
							"Id Consegna", "Indirizzo Ristorante", "Email Utente", "Indirizzo di consegna", "Rider ID", "Veicolo Utilizzato","Totale pagato", "Stato consegna"
					}
				));
				
				JLabel storicoLabel = new JLabel("STORICO CONSEGNE");
				storicoLabel.setFont(new Font("Lucida Sans", Font.BOLD, 19));
				storicoLabel.setHorizontalAlignment(SwingConstants.CENTER);
				storicoLabel.setBounds(314, 11, 274, 52);
				contentPane.add(storicoLabel);
				
				panel = new JPanel();
				panel.setBackground(Color.LIGHT_GRAY);
				panel.setBorder(new TitledBorder(null, "Ristorante in:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel.setBounds(0, 11, 210, 52);
				contentPane.add(panel);
				panel.setLayout(null);
				
				
				nomeText = new JTextField();
				nomeText.setBackground(Color.WHITE);
				nomeText.setBounds(6, 16, 196, 25);
				panel.add(nomeText);
				nomeText.setEditable(false);
				nomeText.setColumns(10);
				nomeText.setText(controller.fornisciRistoranteAdmin());	
				
				JButton confermaConsegneButton = new JButton("Conferma consegna");
				confermaConsegneButton.setFont(new Font("Calibri", Font.BOLD, 15));
				confermaConsegneButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						controller.settaConsegnato();  					
						model.setRowCount(0);
						model = controller.ricavaConsegne(model);
						controller.decrementaConteggioRider();
					}
				});
				confermaConsegneButton.setBounds(517, 390, 236, 40);
				contentPane.add(confermaConsegneButton);
				
				JPanel idResearchPanel = new JPanel();
				idResearchPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
				idResearchPanel.setBounds(10, 352, 236, 124);
				contentPane.add(idResearchPanel);
				idResearchPanel.setLayout(null);
				
				ricercaPerIdButton = new JButton("Cerca per Id rider");
				ricercaPerIdButton.setFont(new Font("Tahoma", Font.BOLD, 12));
				ricercaPerIdButton.setBounds(45, 42, 148, 40);
				idResearchPanel.add(ricercaPerIdButton);
				ricercaPerIdButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String s = cercaIdRiderText.getText();
						controller.riempiTabella(model, s);
					}
				});
				
				cercaIdRiderText = new JTextField();
				cercaIdRiderText.setHorizontalAlignment(SwingConstants.CENTER);
				cercaIdRiderText.setBounds(91, 16, 59, 20);
				idResearchPanel.add(cercaIdRiderText);
				cercaIdRiderText.setColumns(10);
				
				JButton resetButton = new JButton("Reset");
				resetButton.setFont(new Font("Tahoma", Font.BOLD, 12));
				resetButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						model.setRowCount(0);
						model = controller.ricavaConsegne(model);
					}
				});
				resetButton.setBounds(74, 92, 89, 23);
				idResearchPanel.add(resetButton);
				
				JLabel idLabel = new JLabel("ID");
				idLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
				idLabel.setHorizontalAlignment(SwingConstants.RIGHT);
				idLabel.setBounds(35, 19, 46, 14);
				idResearchPanel.add(idLabel);
				
				JButton logOutButton = new JButton("Logout");
				logOutButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						controller.logOutAdmin();
					}
				});
				logOutButton.setFont(new Font("Tahoma", Font.BOLD, 11));
				logOutButton.setBounds(818, 398, 85, 32);
				contentPane.add(logOutButton);

				model = (DefaultTableModel) storicoTable.getModel();
				model = controller.ricavaConsegne(model);
	}
}
