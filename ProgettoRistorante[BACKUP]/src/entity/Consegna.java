package entity;
import java.util.ArrayList;

import controller.*;

public class Consegna {
	
	
	Controller controller;
	Utente utente = new Utente();
	Rider riderAssegnato = new Rider();
	String indirizzoRistorante;
	ArrayList<Prodotto> ordine = new ArrayList<Prodotto>();
	private double totale;
	
	public Consegna(Controller controller, Utente utente, Rider riderAssegnato, String indirizzoRistorante,
			ArrayList<Prodotto> ordine, double totale) {
		super();
		this.controller = controller;
		this.utente = utente;
		this.riderAssegnato = riderAssegnato;
		this.indirizzoRistorante = indirizzoRistorante;
		this.ordine = ordine;
		this.totale = totale;
	}
//  Creare un costruttore che richiede tutti i parametri e inserirli soltanto alla fine ?

//Metodo totale da gestire nel dao ? 
//	public void setTotale(double totale) {
//		this.totale = totale;
//	}
	
}
