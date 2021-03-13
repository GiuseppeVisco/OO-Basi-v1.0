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
	private Consegna nuovaConsegna;
	//Prodotto prodotto = new Prodotto();
	
	
	public static void main(String[] args) {					
		Controller c = new Controller();		
	}
	
	public Controller() {
		loginFrame = new LoginFrame(this);
		loginFrame.setVisible(true);	
		nuovaConsegna = new Consegna();
	}
	
	public void check(String username,String password) {		
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
	
//Prendere l'id del rider in base al mezzo e alla disponibilità	
//	public void mezzoSelezionato(String s) {
//		nuovaConsegna.setRider(s);
//	}
	public void openRiderFrame() {
		restaurantFrame.setVisible(false);
		riderFrame = new RiderFrame(this);
		riderFrame.setVisible(true);
	}
	
	public void openMenuFrame() {
		riderFrame.setVisible(false);
		menuFrame = new MenuFrame();
		menuFrame.setVisible(true);
	}

}
