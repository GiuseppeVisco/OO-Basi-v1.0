package controller;
import javax.swing.*;


import dao.*;
import gui.*;

public class Controller {
	
	LoginFrame loginFrame;
	SelezioneRistoranteFrame selezioneRistoranteFrame;
	OrderFrame orderFrame;
	UtenteDAO utenteDAO = new UtenteDAO();
	
	
	public static void main(String[] args) {
		
		
	
		Controller c = new Controller();
		
		
	}
	
	public Controller() {
		loginFrame = new LoginFrame(this);
		loginFrame.setVisible(true);
	}
	
	public void check(String username,String password) {
		
		boolean checked=utenteDAO.checkCredentials(username,password);
		
		if(checked==false) {
			loginFrame.cleanFields();
			JOptionPane.showMessageDialog(null, "Password o Username incorretti, riprovare.");
		}
		else {
			loginFrame.setVisible(false);
			selezioneRistoranteFrame = new SelezioneRistoranteFrame(this);
			//orderFrame = new OrderFrame();
			selezioneRistoranteFrame.setVisible(true);
		}
	}
	
	public void backToLogin()
	{
		selezioneRistoranteFrame.setVisible(false);
		loginFrame = new LoginFrame(this);
		loginFrame.setVisible(true);
	}
}
