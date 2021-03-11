package controller;
import javax.swing.*;


import dao.*;
import gui.*;

public class Controller {
	
	LoginFrame loginFrame;
	SelezioneRistoranteFrame selezioneRistoranteFrame;
	SelezioneMezzoRiderFrame selezioneMezzoRiderFrame;
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
	
	public void backToLogin() {
		
		selezioneRistoranteFrame.setVisible(false);
		loginFrame = new LoginFrame(this);
		loginFrame.setVisible(true);
	}
	
	public void ristoranteSelezionato(int x) {
		

		switch (x) {
		case 0: JOptionPane.showMessageDialog(null, "Hai selezionato Ristorante 1.");
				selezioneRistoranteFrame.setVisible(false);
				selezioneMezzoRiderFrame = new SelezioneMezzoRiderFrame(this);
				selezioneMezzoRiderFrame.setVisible(true);
				//salva scelta su db tramite metodo DAO?
		break;
		case 1: JOptionPane.showMessageDialog(null, "Hai selezionato Ristorante 2.");
				selezioneRistoranteFrame.setVisible(false);
				selezioneMezzoRiderFrame = new SelezioneMezzoRiderFrame(this);
				selezioneMezzoRiderFrame.setVisible(true);
				//salva scelta su db tramite metodo DAO?
		break;
		case 2: JOptionPane.showMessageDialog(null, "Hai selezionato Ristorante 3.");
				selezioneRistoranteFrame.setVisible(false);
				selezioneMezzoRiderFrame = new SelezioneMezzoRiderFrame(this);
				selezioneMezzoRiderFrame.setVisible(true);
				//salva scelta su db tramite metodo DAO?
		break;
		case 3: JOptionPane.showMessageDialog(null, "Hai selezionato Ristorante 4.");	
				selezioneRistoranteFrame.setVisible(false);
				selezioneMezzoRiderFrame = new SelezioneMezzoRiderFrame(this);
				selezioneMezzoRiderFrame.setVisible(true);
				//salva scelta su db tramite metodo DAO?
		break;
		default: JOptionPane.showMessageDialog(null, "Seleziona un ristorante");
		}
	}
}
