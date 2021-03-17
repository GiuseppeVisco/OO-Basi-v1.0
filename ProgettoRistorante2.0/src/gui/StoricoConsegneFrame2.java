package gui;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.ConsegnaDAO;
import entity.Consegna;
import dao.RistoranteDAO;

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
import javax.swing.DropMode;
import javax.swing.border.LineBorder;


public class StoricoConsegneFrame2 extends JFrame {

	private JPanel contentPane;
	private JTable storicoTable;
	DateFormat dateFormat = new SimpleDateFormat("DD/MM/YY");
	Date date = new Date();
	Calendar calendar = Calendar.getInstance();
	DefaultTableModel model;
	ConsegnaDAO consegnaDAO = new ConsegnaDAO();
	RistoranteDAO ristoranteDAO = new RistoranteDAO();
	Consegna consegna;
	private JTextField nomeTxt;
	private JPanel panel;
	private JButton ricercaPerIdButton;
	private JTextField cercaIdRiderTxt;

	public StoricoConsegneFrame2(Consegna c) {
		consegna = c;
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
				nomeTxt.setText(ristoranteDAO.ricavaRistoranteAdmin(consegna.getUsernameUtente()));													
				
				JButton confermaConsegneButton = new JButton("Conferma consegne effettuate");
				confermaConsegneButton.setFont(new Font("Calibri", Font.BOLD, 15));
				confermaConsegneButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						consegnaDAO.resettaConsegneAssegnate(); //resetta a 0 tutte le consegne attive dei rider
						consegnaDAO.aggiornaStatoConsegne(ristoranteDAO.ricavaRistoranteAdmin(consegna.getUsernameUtente()));  //setta a "consegnato" tutte le consegne del ristorante dell'admin
						model.setRowCount(0);
						aggiungiRighe();					     
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
							int idConsegna = Integer.parseInt(s);						
							consegnaDAO.cancellaConsegna(idConsegna);
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
						cercaPerIdRider();
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
						aggiungiRighe();
					}
				});
				resetButton.setBounds(74, 92, 89, 23);
				idResearchPanel.add(resetButton);
				
				JLabel lblNewLabel_1 = new JLabel("ID");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
				lblNewLabel_1.setBounds(35, 19, 46, 14);
				idResearchPanel.add(lblNewLabel_1);

				 model = (DefaultTableModel) storicoTable.getModel();
				 aggiungiRighe();
	}
	
	
	
	public void aggiungiRighe() {
		 ArrayList<Consegna> temp = null;
	     temp = consegnaDAO.listaConsegne(ristoranteDAO.ricavaRistoranteAdmin(consegna.getUsernameUtente()));
	     for(Consegna consegna :temp) { 			        	
	        	model.addRow(new Object[] {consegna.getIdConsegna(),consegna.getIndirizzoRistorante(), consegna.getUsernameUtente(), consegna.getIndirizzoConsegna(), consegna.getIdRider(), consegna.getVeicoloUtilizzato(), ""+consegna.getTotale()+"€", consegna.getStatoConsegna() });
	        }		
	}
	
	public void cercaPerIdRider() {
		String s = cercaIdRiderTxt.getText();
		model.setRowCount(0);
		int idRider = -1;
		int flag = 0;
		try {
		 idRider = Integer.parseInt(s);
		}
		catch(NumberFormatException e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "Errore, inserire un valore numerico");
			flag = 1;
		}
		ArrayList<Consegna> temp = consegnaDAO.cercaPerIdRider(idRider, ristoranteDAO.ricavaRistoranteAdmin(consegna.getUsernameUtente()));
		for(Consegna consegna :temp) { 			        	
        	model.addRow(new Object[] {consegna.getIdConsegna(),consegna.getIndirizzoRistorante(), consegna.getUsernameUtente(), consegna.getIndirizzoConsegna(), consegna.getIdRider(), consegna.getVeicoloUtilizzato(), ""+consegna.getTotale()+"€", consegna.getStatoConsegna() });
        }
		if(flag == 0 && model.getRowCount() == 0) {
			 JOptionPane.showMessageDialog(null, "Il rider selezionato non ha effettuato consegne in questo ristorante");
		}
	}
}
