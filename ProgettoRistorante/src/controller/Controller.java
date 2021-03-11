package controller;
import javax.swing.*;

import dao.*;
import entity.Consegna;
import gui.*;

public class Controller {
	private LoginFrame loginFrame;
	private RestaurantFrame restaurantFrame;
	private UtenteDAO utenteDAO = new UtenteDAO();
	private RiderFrame riderFrame;
	
	public static void main(String[] args) {
	
		Controller c = new Controller();
	}
	
	public Controller() {
		
		loginFrame = new LoginFrame(this);
		loginFrame.setVisible(true);
	}
	
	
	
	public void checkCr(String username,String password) {
		
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
	
	public void openRiderFrame() {
		restaurantFrame.setVisible(false);
		riderFrame = new RiderFrame(this);
		riderFrame.setVisible(true);
	}
// Richiamo l'ordine e gli setto il nome del ristorante? 
	
}