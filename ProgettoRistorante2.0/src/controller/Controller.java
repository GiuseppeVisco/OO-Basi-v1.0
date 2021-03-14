package controller;
import javax.swing.*;

import entity.*;
import dao.*;
import gui.*;
import dao.*;

public class Controller {
	
	LoginFrame loginFrame;
	RestaurantFrame restaurantFrame;
	RiderFrame riderFrame;
	OrderFrame orderFrame;
	MenuFrame menuFrame;
	UtenteDAO utenteDAO = new UtenteDAO();
	Ordine ordine = new Ordine();
	ProdottoDAO prodottoDAO = new ProdottoDAO();
	RiderDAO riderDAO = new RiderDAO();
	private Consegna nuovaConsegna = new Consegna();
	//Prodotto prodotto = new Prodotto();
	
	
	public static void main(String[] args) {					
		Controller c = new Controller();	

	}
	
	public Controller() {
		loginFrame = new LoginFrame(this);
		loginFrame.setVisible(true);	
		nuovaConsegna = new Consegna();
	}
	
	public void checkCredentials(String username,String password) {		
		boolean checked=utenteDAO.checkCredentials(username,password);				
		if(checked==false) {
			loginFrame.cleanFields();
			JOptionPane.showMessageDialog(null, "Password o Username incorretti, riprovare.");
		}
		else {
			openRestaurantFrame();
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
		nuovaConsegna.setIndirizzoRistorante(s);
	}
	
	public void openRiderFrame() {
		restaurantFrame.setVisible(false);
		riderFrame = new RiderFrame(this);
		riderFrame.setVisible(true);
	}
	
	public void checkRiderAvailable(String s) {
		boolean check=riderDAO.checkAvailability(s);
		if(check) {
			openMenuFrame();
		}
		else {
			//Metodo che deseleziona i radio button?
			JOptionPane.showMessageDialog(null, "Non ci sono rider disponibili con questo mezzo.");
		}
	}
	
	public void openMenuFrame() {
		riderFrame.setVisible(false);
		menuFrame = new MenuFrame();
		menuFrame.setVisible(true);
	}

}
