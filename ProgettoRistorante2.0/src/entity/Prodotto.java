package entity;

import java.util.ArrayList;

public class Prodotto {
	
	private double prezzoProdotto;	
	private String nomeProdotto;
	private String Descrizione;

	
	public double getPrezzoProdotto() {
		return prezzoProdotto;
	}

	public void setPrezzoProdotto(double prezzoProdotto) {
		this.prezzoProdotto = prezzoProdotto;
	}


	public String getNomeProdotto() {
		return nomeProdotto;
	}

	public void setNomeProdotto(String nomeProdotto) {
		this.nomeProdotto = nomeProdotto;
	}

	public String getDescrizione() {
		return Descrizione;
	}

	public void setDescrizione(String descrizione) {
		Descrizione = descrizione;
	}	
}
