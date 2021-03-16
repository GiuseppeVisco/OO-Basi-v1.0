package entity;
import java.util.ArrayList;

import controller.*;

public class Consegna {
	
	
	Controller controller;
	String idConsegna;
	String usernameUtente;
	String indirizzoConsegna;
	int idRider;
	String indirizzoRistorante;
	ArrayList<Prodotto> ordine = new ArrayList<Prodotto>();
	double totale;

	

	public void setIndirizzoConsegna(String indirizzoConsegna) {
		this.indirizzoConsegna = indirizzoConsegna;
	}
	
	public void setRider(int idRider) {
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

	public String getIdConsegna() {
		return idConsegna;
	}

	public void setIdConsegna(String idConsegna) {
		this.idConsegna = idConsegna;
	}

	public String getIndirizzoConsegna() {
		return indirizzoConsegna;
	}

	public int getIdRider() {
		return idRider;
	}

	public void setIdRider(int i) {
		this.idRider = i;
	}
	
	//Metodo set prodotti
	//Metodo calcolo totale
	
}
