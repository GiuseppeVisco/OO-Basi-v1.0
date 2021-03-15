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

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class StoricoConsegneFrame2 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	DateFormat dateFormat = new SimpleDateFormat("DD/MM/YY");
	Date date = new Date();
	Calendar calendar = Calendar.getInstance();
	DefaultTableModel model;
	ConsegnaDAO consegnaDAO = new ConsegnaDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StoricoConsegneFrame2 frame = new StoricoConsegneFrame2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StoricoConsegneFrame2() {
		setTitle("Storico consegne");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 776, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 185, 740, 105);
		contentPane.add(scrollPane);
		
				
				table = new JTable();		
				scrollPane.setViewportView(table);
				table.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
							"Id Consegna", "Email Utente", "Indirizzo Ristorante", "Indirizzo di consegna", "Rider ID", "Totale pagato"
					}
				));
				
				JLabel lblNewLabel = new JLabel("STORICO CONSEGNE");
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setBounds(277, 99, 144, 32);
				contentPane.add(lblNewLabel);
				model = (DefaultTableModel) table.getModel();
																	
				
				 ArrayList<Consegna> temp = null;
			        temp = consegnaDAO.listaConsegne();
			        for(Consegna consegna :temp) { 
			        	model.addRow(new Object[] {"["+consegna.getIdConsegna()+"]",consegna.getUsernameUtente(), consegna.getIndirizzoRistorante(), consegna.getIndirizzoConsegna(), consegna.getIdRider(), ""+consegna.getTotale()+"€" });
			        }
	}
}
