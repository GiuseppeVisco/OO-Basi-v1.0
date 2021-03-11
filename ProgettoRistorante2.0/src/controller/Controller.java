package controller;
import javax.swing.*;

import entity.*;
import dao.*;
import gui.*;

public class Controller {
	
	LoginFrame loginFrame;
	SelezioneRistoranteFrame selezioneRistoranteFrame;
	SelezioneMezzoRiderFrame selezioneMezzoRiderFrame;
	OrderFrame orderFrame;
	UtenteDAO utenteDAO = new UtenteDAO();
	Ordine ordine = new Ordine();
	
	
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
				ordine.setNegozioDiPartenza("Ristorante 1");
											
				//salva scelta su db tramite metodo DAO?
		break;
		case 1: JOptionPane.showMessageDialog(null, "Hai selezionato Ristorante 2.");
				selezioneRistoranteFrame.setVisible(false);
				selezioneMezzoRiderFrame = new SelezioneMezzoRiderFrame(this);
				selezioneMezzoRiderFrame.setVisible(true);
				ordine.setNegozioDiPartenza("Ristorante 2");				
				//salva scelta su db tramite metodo DAO?
		break;
		case 2: JOptionPane.showMessageDialog(null, "Hai selezionato Ristorante 3.");
				selezioneRistoranteFrame.setVisible(false);
				selezioneMezzoRiderFrame = new SelezioneMezzoRiderFrame(this);
				selezioneMezzoRiderFrame.setVisible(true);
				ordine.setNegozioDiPartenza("Ristorante 3");
				//salva scelta su db tramite metodo DAO?
		break;
		case 3: JOptionPane.showMessageDialog(null, "Hai selezionato Ristorante 4.");	
				selezioneRistoranteFrame.setVisible(false);
				selezioneMezzoRiderFrame = new SelezioneMezzoRiderFrame(this);
				selezioneMezzoRiderFrame.setVisible(true);
				ordine.setNegozioDiPartenza("Ristorante 4");
				//salva scelta su db tramite metodo DAO?
		break;
		default: JOptionPane.showMessageDialog(null, "Seleziona un ristorante");
		}
	}
	
public void veicoloSelezionato(int x) {
		
		switch (x) {
		case 0: JOptionPane.showMessageDialog(null, "Hai selezionato Motorino");
				selezioneMezzoRiderFrame.setVisible(false);
				orderFrame = new OrderFrame();
				orderFrame.setVisible(true);
				ordine.setVeicoloRider("Motorino");
				//salva scelta su db tramite metodo DAO?
		break;
		case 1: JOptionPane.showMessageDialog(null, "Hai selezionato Moto");
				selezioneMezzoRiderFrame.setVisible(false);
				orderFrame = new OrderFrame();
				orderFrame.setVisible(true);
				ordine.setVeicoloRider("Moto");
				//salva scelta su db tramite metodo DAO?
		break;
		case 2: JOptionPane.showMessageDialog(null, "Hai selezionato Bicicletta");
				selezioneMezzoRiderFrame.setVisible(false);
				orderFrame = new OrderFrame();
				orderFrame.setVisible(true);
				ordine.setVeicoloRider("Bicicletta");
				//salva scelta su db tramite metodo DAO?
		break;
		case 3: JOptionPane.showMessageDialog(null, "Hai selezionato Automobile");
				selezioneMezzoRiderFrame.setVisible(false);
				orderFrame = new OrderFrame();
				orderFrame.setVisible(true);
				ordine.setVeicoloRider("Automobile");
				//salva scelta su db tramite metodo DAO?
		break;		
		default: JOptionPane.showMessageDialog(null, "Seleziona un veicolo");
		
		}
		
		//TEST PER VEDERE SE L'ORDINE VIENE AGGIORNATO
		String f = ordine.getVeicoloRider();
		String g = ordine.getNegozioDiPartenza();
		System.out.println("Il negozio selezionato è: "+g);
		System.out.println("Il veicolo dell'ordine è: "+f);
		
	}
}
