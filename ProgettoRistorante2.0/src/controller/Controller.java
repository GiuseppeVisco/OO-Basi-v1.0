package controller;
import javax.swing.*;



import entity.*;
import dao.*;
import gui.*;
import java.util.ArrayList;


public class Controller {
	
	LoginFrame loginFrame;
	RestaurantFrame restaurantFrame;
	RiderFrame riderFrame;
	MenuFrame menuFrame;
	UtenteDAO utenteDAO = new UtenteDAO();
	Ordine ordine = new Ordine();
	ProdottoDAO prodottoDAO = new ProdottoDAO();
	Consegna consegna = new Consegna();
	ConsegnaDAO consegnaDAO;
	RiderDAO riderDAO = new RiderDAO();
	StoricoConsegneFrame2 storicoConsegneFrame;
	AllergeneDAO allergeneDAO = new AllergeneDAO();
	RicercaDAO ricercaDAO = new RicercaDAO();
	
	public static void main(String[] args) {
		
		Controller c = new Controller();
		
	}
	
	public Controller() {
		loginFrame = new LoginFrame(this);
		loginFrame.setVisible(true);

		
	}
	
	public void checkCredentials(String username,String password) {		
		boolean checked=utenteDAO.checkCredentials(username,password);				
		if(checked==false) {
			loginFrame.cleanFields();
			JOptionPane.showMessageDialog(null, "Password o Username incorretti, riprovare.");
		}
		else {
			if(utenteDAO.checkTipoUtente(username)) {
				consegna.setUsernameUtente(username);
				storicoConsegneFrame = new StoricoConsegneFrame2(consegna);
				loginFrame.setVisible(false);
				storicoConsegneFrame.setVisible(true);
			}
			else {
			consegna.setUsernameUtente(username);			
			openRestaurantFrame();
			}
	}
}

	public void checkRiderAvailable(String s) {
		boolean check=riderDAO.checkAvailability(s);
		if(check) {
			this.setIdRiderConsegna(s);
			openMenuFrame();
		}
		else {
			JOptionPane.showMessageDialog(null, "Non ci sono rider disponibili con questo mezzo.");
		}
	}
	public void openRestaurantFrame() {
		loginFrame.setVisible(false);
		restaurantFrame = new RestaurantFrame(this);
		restaurantFrame.setVisible(true);
	}
	
	public void backToLogin() {		
		restaurantFrame.setVisible(false);
		loginFrame = new LoginFrame(this);
		loginFrame.setVisible(true);
	}
	
	public void ristoranteSelezionato(String s) {
		consegna.setIndirizzoRistorante(s);
	}

	public void openRiderFrame() {
		restaurantFrame.setVisible(false);
		riderFrame = new RiderFrame(this);
		riderFrame.setVisible(true);
	}
	
	public void openMenuFrame() {		
		
		riderFrame.setVisible(false);
		menuFrame = new MenuFrame(this, consegna);
		menuFrame.setVisible(true);
	}
	
	public String getUsernameConsegna() {
		String temp = consegna.getUsernameUtente();
		return temp;
	}
	public String getIndirizzoConsegna() {
		String temp = utenteDAO.ricavaIndirizzoResidenza(consegna.getUsernameUtente()); 
		return temp;
	}
	
	public String getNegozioConsegna() {
		String temp = consegna.getIndirizzoRistorante();
		return temp;
	}
	

	
	public void aggiornaStoricoConsegne() {    
		consegnaDAO = new ConsegnaDAO();
		consegnaDAO.insertConsegna(consegna.getIndirizzoRistorante(), utenteDAO.ricavaIndirizzoResidenza(consegna.getUsernameUtente()), consegna.getTotale(), consegna.getUsernameUtente(),consegna.getIdRider(), consegna.getVeicoloUtilizzato());
	}
	public void updateRiderCount() {
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

	
	public String  ricavaDescrizioneProdotto(JList<String> tempJlist) {
		String prodottoSelezionato = tempJlist.getSelectedValue();
		String testoDescrizione = "";
		ArrayList<Prodotto> temp2 = null;
		temp2 = prodottoDAO.CaricaProdotti();
		for(Prodotto prodotto: temp2) {
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
}



