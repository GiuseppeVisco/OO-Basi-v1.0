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

	private JPanel contentPane;
	private JTable storicoTable;
	DefaultTableModel model;
	private JTextField nomeTxt;
	private JPanel panel;
	private JButton ricercaPerIdButton;
	private JTextField cercaIdRiderTxt;
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 110, 919, 231);
		contentPane.add(scrollPane);	
				
				storicoTable = new JTable();
				storicoTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				storicoTable.setCellSelectionEnabled(true);
				storicoTable.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
				storicoTable.setFont(new Font("Lucida Sans", Font.BOLD, 12));
				scrollPane.setViewportView(storicoTable);
				storicoTable.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
							"Id Consegna", "Indirizzo Ristorante", "Email Utente", "Indirizzo di consegna", "Rider ID", "Veicolo Utilizzato","Totale pagato", "Stato consegna"
					}
				));
				
				JLabel lblNewLabel = new JLabel("STORICO CONSEGNE");
				lblNewLabel.setFont(new Font("Lucida Sans", Font.BOLD, 19));
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setBounds(314, 11, 274, 52);
				contentPane.add(lblNewLabel);
				
				panel = new JPanel();
				panel.setBackground(Color.LIGHT_GRAY);
				panel.setBorder(new TitledBorder(null, "Ristorante in:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel.setBounds(0, 11, 210, 52);
				contentPane.add(panel);
				panel.setLayout(null);
				
				
				nomeTxt = new JTextField();
				nomeTxt.setBackground(Color.WHITE);
				nomeTxt.setBounds(6, 16, 196, 25);
				panel.add(nomeTxt);
				nomeTxt.setEditable(false);
				nomeTxt.setColumns(10);
				nomeTxt.setText(controller.fornisciRistoranteAdmin());	
				
				JButton confermaConsegneButton = new JButton("Conferma consegne effettuate");
				confermaConsegneButton.setFont(new Font("Calibri", Font.BOLD, 15));
				confermaConsegneButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						controller.resettaCounterConsegneRider();
						controller.settaConsegnato();  					
						model.setRowCount(0);
						model = controller.ricavaConsegne(model);					     
					}
				});
				confermaConsegneButton.setBounds(693, 365, 236, 40);
				contentPane.add(confermaConsegneButton);
				
				JButton rimuoviConsegnaButton = new JButton("Rimuovi consegna");
				rimuoviConsegnaButton.setFont(new Font("Tahoma", Font.BOLD, 12));
				rimuoviConsegnaButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(storicoTable.getSelectedColumn() == 0) {
							Object temp = 0;
							temp = model.getValueAt(storicoTable.getSelectedRow(), storicoTable.getSelectedColumn() );
							String s = temp.toString();
							controller.rimuoviConsegnaTabella(model, s);
							model.removeRow(storicoTable.getSelectedRow());
						}
						else JOptionPane.showMessageDialog(null, "Errore, Seleziona una casella ID Consegna");								
					}
				});
				rimuoviConsegnaButton.setBounds(447, 363, 236, 40);
				contentPane.add(rimuoviConsegnaButton);
				
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
						String s = cercaIdRiderTxt.getText();
						controller.riempiTabella(model, s);
					}
				});
				
				cercaIdRiderTxt = new JTextField();
				cercaIdRiderTxt.setHorizontalAlignment(SwingConstants.CENTER);
				cercaIdRiderTxt.setBounds(91, 16, 59, 20);
				idResearchPanel.add(cercaIdRiderTxt);
				cercaIdRiderTxt.setColumns(10);
				
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
				
				JLabel lblNewLabel_1 = new JLabel("ID");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
				lblNewLabel_1.setBounds(35, 19, 46, 14);
				idResearchPanel.add(lblNewLabel_1);
				
				JButton btnNewButton = new JButton("Logout");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						controller.logOutAdmin();
					}
				});
				btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
				btnNewButton.setBounds(843, 436, 85, 32);
				contentPane.add(btnNewButton);

				 model = (DefaultTableModel) storicoTable.getModel();
				model = controller.ricavaConsegne(model);
	}
}
