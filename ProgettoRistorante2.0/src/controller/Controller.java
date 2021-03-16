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
	
	public static void main(String[] args) {
		//Creare una nuova consegna ogni volta che si richiama il main???
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
			boolean isAdmin = false;
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
	//UPDATE
	public void checkRiderAvailable(String s) {
		boolean check=riderDAO.checkAvailability(s);
		if(check) {
			this.setIdRider(s);
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
		
		//STAMPA IN CONSOLE L'ID DEL RIDER DISPONIBILE CON QUEL MEZZO, DA CANCELLARE
		System.out.println(consegna.getIdRider());
		
		
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
		consegnaDAO.insertConsegna(consegna.getIndirizzoRistorante(), utenteDAO.ricavaIndirizzoResidenza(consegna.getUsernameUtente()), consegna.getTotale(), consegna.getUsernameUtente(),consegna.getIdRider());
	}
	public void updateRiderCount() {
		riderDAO.updateCount(getIdRider());
	}
	
	public int getIdRider() {
//		int id=riderDAO.getIdRider(getIndirizzoConsegna());
		//int id = riderDAO.getIdRider(getIndirizzoConsegna());
		int id = consegna.getIdRider();
		return id;
	}
	public void setIdRider(String mezzoRider) {
		consegna.setIdRider(riderDAO.getIdRider(mezzoRider));		
	}
}
