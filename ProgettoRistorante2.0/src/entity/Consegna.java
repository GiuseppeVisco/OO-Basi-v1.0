package entity;
import java.util.ArrayList;

import controller.*;

public class Consegna {
	
	
	Controller controller;
	String indirizzoConsegna;
	String idRider;
	String indirizzoRistorante;
	ArrayList<Prodotto> ordine = new ArrayList<Prodotto>();
	private double totale;
	
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
	//Metodo set prodotti
	
	//Metodo calcolo totale
	
}
