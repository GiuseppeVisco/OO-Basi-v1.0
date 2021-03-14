package entity;
import java.util.ArrayList;

import controller.*;

public class Consegna {
	
	
	Controller controller;
	
	String usernameUtente;
	String indirizzoConsegna;
	String idRider;
	String indirizzoRistorante;
	ArrayList<Prodotto> ordine = new ArrayList<Prodotto>();
	double totale;
	
//	public Consegna(Controller controller, Utente utente, Rider riderAssegnato, String indirizzoRistorante,
//			ArrayList<Prodotto> ordine, double totale) {
//		super();
//		this.controller = controller;
//		this.utente = utente;
//		this.riderAssegnato = riderAssegnato;
//		this.indirizzoRistorante = indirizzoRistorante;
//		this.ordine = ordine;
//		this.totale = totale;
//	}
//  Creare un costruttore che richiede tutti i parametri e inserirli soltanto alla fine ?
	

	public void setIndirizzoConsegna(String indirizzoConsegna) {
		this.indirizzoConsegna = indirizzoConsegna;
	}
	
	public void setRider(String idRider) {
		this.idRider = idRider;
	}
	
	public void setIndirizzoRistorante(String indirizzoRistorante) {
		this.indirizzoRistorante = indirizzoRistorante;
	}
	
	public String getIndirizzoRistorante() {
		return indirizzoRistorante;
	}

	public String getUsernameUtente() {
		return usernameUtente;
	}

	public void setUsernameUtente(String usernameUtente) {
		this.usernameUtente = usernameUtente;
	}

	public double getTotale() {
		return totale;
	}

	public void setTotale(double totale) {
		this.totale = totale;
	}
	
	//Metodo set prodotti
	//Metodo calcolo totale
	
}
