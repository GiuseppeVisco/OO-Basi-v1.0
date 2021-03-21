package controller;
import javax.swing.*;

import javax.swing.table.DefaultTableModel;

import entity.*;
import dao.*;
import gui.*;
import java.util.ArrayList;


public class Controller {
	
	private LoginFrame loginFrame;
	private RestaurantFrame restaurantFrame;
	private RiderFrame riderFrame;
	private MenuFrame menuFrame;
	private UtenteDAO utenteDAO = new UtenteDAO();
	private ProdottoDAO prodottoDAO = new ProdottoDAO();
	private Consegna consegna = new Consegna();
	private ConsegnaDAO consegnaDAO = new ConsegnaDAO();
	private RiderDAO riderDAO = new RiderDAO();
	private StoricoConsegneFrame storicoConsegneFrame;
	private AllergeneDAO allergeneDAO = new AllergeneDAO();
	private RicercaDAO ricercaDAO = new RicercaDAO();
	private RistoranteDAO ristoranteDAO = new RistoranteDAO();
	private ClosingFrame closingFrame;
	
	public static void main(String[] args) {
		
		Controller c = new Controller();
		
	}
	
	public Controller() {
		openLoginFrame();
	}
	
	public void openLoginFrame() {
		loginFrame = new LoginFrame(this);
		loginFrame.setVisible(true);	
	}
	
	public void controllaCredenzialiInserite(String username,char[] password) {		
		boolean checked=utenteDAO.controllaCredenziali(username,password);				
		if(checked==false) {
			loginFrame.cleanFields();
			JOptionPane.showMessageDialog(null, "Password o Username incorretti, riprovare.");
		}
		else {
			if(utenteDAO.controllaTipoUtente(username)) {
				consegna.setUsernameUtente(username);
				storicoConsegneFrame = new StoricoConsegneFrame(this);
				loginFrame.setVisible(false);
				storicoConsegneFrame.setVisible(true);
			}
			else {
			consegna.setUsernameUtente(username);			
			apriRestaurantFrame();
			}
	}
}

	public void controllaRiderDisponibili(String s) {
		boolean check=riderDAO.controllaDisponibilità(s);
		if(check) {
			this.setIdRiderConsegna(s);
			apriMenuFrame();
		}
		else {
			JOptionPane.showMessageDialog(null, "Non ci sono rider disponibili con questo mezzo.");
		}
	}
	public void apriRestaurantFrame() {
		loginFrame.setVisible(false);
		restaurantFrame = new RestaurantFrame(this);
		restaurantFrame.setVisible(true);
	}
	
	public void ristoranteSelezionato(String s) {
		consegna.setIndirizzoRistorante(s);
	}

	public void apriRiderFrame() {
		restaurantFrame.setVisible(false);
		riderFrame = new RiderFrame(this);
		riderFrame.setVisible(true);
	}
	
	public void apriMenuFrame() {		
		
		riderFrame.setVisible(false);
		menuFrame = new MenuFrame(this);
		menuFrame.setVisible(true);
	}
	
	public String getUsernameConsegna() {
		String username = consegna.getUsernameUtente();
		return username;
	}
	
	public String getIndirizzoConsegna() {
		String indirizzoConsegna = utenteDAO.getIndirizzoPerUsername(consegna.getUsernameUtente()); 
		return indirizzoConsegna;
	}
	
	public String getNegozioConsegna() {
		String indirizzoRistorante = consegna.getIndirizzoRistorante();
		return indirizzoRistorante;
	}
	
	public void aggiornaStoricoConsegne() {    
		consegnaDAO.inserisciConsegna(consegna.getIndirizzoRistorante(), utenteDAO.getIndirizzoPerUsername(consegna.getUsernameUtente()), consegna.getTotale(), consegna.getUsernameUtente(),consegna.getIdRider(), consegna.getVeicoloUtilizzato());
	}
	
	public void aggiornaConteggioRider() {
		riderDAO.updateCount(getIdRiderConsegna());
	}
	
	public int getIdRiderConsegna() {
		int id = consegna.getIdRider();
		return id;
	}
	public void setIdRiderConsegna(String mezzoRider) {
		consegna.setIdRider(riderDAO.getIdRider(mezzoRider));		
	}
	
	public void setVeicoloUtilizzato(String veicolo) {
		consegna.setVeicoloUtilizzato(veicolo);
	}

	
	public String  ricavaDescrizioneProdotto(JList<String> prodottoJlist) {
		String prodottoSelezionato = prodottoJlist.getSelectedValue();
		String testoDescrizione = null;
		ArrayList<Prodotto> listaProdotti;
		listaProdotti = prodottoDAO.CaricaProdotti();
		for(Prodotto prodotto: listaProdotti) {
		if(prodottoSelezionato.equals(prodotto.getNomeProdotto())) {
			ArrayList<String> listaAllergeni = new ArrayList<>();
			listaAllergeni = allergeneDAO.fornisciAllergeni(prodottoSelezionato);
			 testoDescrizione = (prodotto.getDescrizione()+".\nPREZZO: ["+String.format("%.2f", prodotto.getPrezzoProdotto())+"€]\nALLERGENI: "+listaAllergeni);
			}		
		}
		return testoDescrizione;
	}
	
	
	public ArrayList<String> ricercaPerPrezzo(int x, ArrayList<String> listaProdotti) {
		ArrayList<String> temp = null;
		ArrayList<String> temp2 = null;
		ArrayList<String> temp3 = null;

		switch(x) {
		case 0: break;
		case 1: temp = ricercaDAO.trovaProdottoPerPrezzoBasso();
				listaProdotti.clear();
				for(String s :temp) {
				listaProdotti.add(s);
				}
				break;
		case 2: temp2 = ricercaDAO.trovaProdottoPerPrezzoMedio();
				listaProdotti.clear();
				for(String s :temp2) {
				listaProdotti.add(s);
				}
				break;
		case 3: temp3 = ricercaDAO.trovaProdottoPerPrezzoAlto();
				listaProdotti.clear();
				for(String s :temp3) {							
				listaProdotti.add(s);
				}
				break;
		}
		return listaProdotti;
	}

	
	public void setTotaleConsegna(double totale) {
		consegna.setTotale(totale);
	}

	public void apriClosingFrame() {
		menuFrame.setVisible(false);
		closingFrame = new ClosingFrame(this);
		closingFrame.setVisible(true);
	}
	
	public void chiudiClosingFrame() {
		closingFrame.setVisible(false);
	}
	
	public void logOutUser() {
		chiudiClosingFrame();
		openLoginFrame();
	}
	
	public void chiudiStoricoConsegneFrame() {
		storicoConsegneFrame.setVisible(false);
	}
	
	public void logOutAdmin() {
		chiudiStoricoConsegneFrame();
		openLoginFrame();
	}
	
	public DefaultTableModel ricavaConsegne(DefaultTableModel model) {
		ArrayList<Consegna> temp = null;
		temp = consegnaDAO.listaConsegne(ristoranteDAO.ricavaRistoranteAdmin(consegna.getUsernameUtente()));
		  for(Consegna consegna :temp) { 			        	
	        	model.addRow(new Object[] {consegna.getIdConsegna(),consegna.getIndirizzoRistorante(), consegna.getUsernameUtente(), consegna.getIndirizzoConsegna(), consegna.getIdRider(), consegna.getVeicoloUtilizzato(), ""+consegna.getTotale()+"€", consegna.getStatoConsegna() });
	        }
		return model;
	}
	
	public DefaultTableModel riempiTabella(DefaultTableModel model, String s) {
		
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
		return model;
	}
	
	public void resettaCounterConsegneRider() {
		consegnaDAO.resettaConsegneAssegnate();
	}
	
	public void settaConsegnato() {
		consegnaDAO.aggiornaStatoConsegne(ristoranteDAO.ricavaRistoranteAdmin(consegna.getUsernameUtente()));
	}
	
	public void rimuoviConsegnaTabella(DefaultTableModel model, String s) {

		int idConsegna = Integer.parseInt(s);						
		consegnaDAO.cancellaConsegna(idConsegna);
		
	}
	
	public String fornisciRistoranteAdmin() {
		String ristorante = ristoranteDAO.ricavaRistoranteAdmin(consegna.getUsernameUtente());
		return ristorante;
	}
	
	public ArrayList<String> resettaButton(ArrayList<String> listaProdottiJl) {
		   
		   ArrayList<Prodotto> temp = null;
	       temp = prodottoDAO.CaricaProdotti();
	       for(Prodotto prodotto :temp) {
	       	listaProdottiJl.add(prodotto.getNomeProdotto());
	       }
	       return listaProdottiJl;
	}
	
	
	public ArrayList<String> riempiMenu(ArrayList<String> listaProdottiJl) {
		
		   ArrayList<Prodotto> temp = null;
	       temp = prodottoDAO.CaricaProdotti();
	       for(Prodotto prodotto :temp) {
	       	listaProdottiJl.add(prodotto.getNomeProdotto());
	       }
	       return listaProdottiJl;
	}

	public ArrayList<String> ricercaProdottoPerTipo(int y) {
		ArrayList<String> temp = new ArrayList<String>();
		temp = ricercaDAO.trovaProdottoPerTipo(y);
		return temp;
	}
	
	public ArrayList<String> fornisciProdottiPerAllergeni(String s) {
		ArrayList<String> temp = null;
		temp = ricercaDAO.trovaProdottoPerAllergeni(s);
		return temp;
	}
	
	
	public double getPrezzo(String prodotto) {
		double prezzo = prodottoDAO.getPrezzoPerNome(prodotto);
		return prezzo;
	}


	
}



