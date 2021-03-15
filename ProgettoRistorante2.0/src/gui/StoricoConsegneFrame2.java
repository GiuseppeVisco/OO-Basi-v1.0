package gui;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
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
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;

public class StoricoConsegneFrame2 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	DateFormat dateFormat = new SimpleDateFormat("DD/MM/YY");
	Date date = new Date();
	Calendar calendar = Calendar.getInstance();
	DefaultTableModel model;
	ConsegnaDAO consegnaDAO = new ConsegnaDAO();
	RistoranteDAO ristoranteDAO = new RistoranteDAO();
	Consegna consegna;
	private JTextField nomeTxt;
	private JPanel panel;

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
		scrollPane.setBounds(10, 185, 919, 268);
		contentPane.add(scrollPane);
		
				
				table = new JTable();		
				table.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
				table.setFont(new Font("Lucida Sans", Font.PLAIN, 11));
				scrollPane.setViewportView(table);
				table.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
							"Id Consegna", "Email Utente", "Indirizzo Ristorante", "Indirizzo di consegna", "Rider ID", "Totale pagato"
					}
				));
				
				JLabel lblNewLabel = new JLabel("STORICO CONSEGNE");
				lblNewLabel.setFont(new Font("Lucida Sans", Font.BOLD, 19));
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setBounds(316, 51, 274, 52);
				contentPane.add(lblNewLabel);
				
				panel = new JPanel();
				panel.setBorder(new TitledBorder(null, "Ristorante in:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel.setBounds(10, 110, 210, 52);
				contentPane.add(panel);
				panel.setLayout(null);
				
				
				nomeTxt = new JTextField();
				nomeTxt.setBounds(6, 16, 196, 25);
				panel.add(nomeTxt);
				nomeTxt.setEditable(false);
				nomeTxt.setColumns(10);
				nomeTxt.setText(ristoranteDAO.ricavaRistoranteAdmin(consegna.getUsernameUtente()));													
				model = (DefaultTableModel) table.getModel();
				
				 ArrayList<Consegna> temp = null;
			        temp = consegnaDAO.listaConsegne(ristoranteDAO.ricavaRistoranteAdmin(consegna.getUsernameUtente()));			        
			        for(Consegna consegna :temp) { 
			        	model.addRow(new Object[] {"["+consegna.getIdConsegna()+"]",consegna.getUsernameUtente(), consegna.getIndirizzoRistorante(), consegna.getIndirizzoConsegna(), consegna.getIdRider(), ""+consegna.getTotale()+"€" });
			        }
	}
}
