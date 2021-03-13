package entity;

import java.util.ArrayList;

public class Prodotto {
	
	private float prezzoProdotto;	
	private String nomeProdotto;
	private String Descrizione;
	ArrayList<Allergene> allergene = new ArrayList<Allergene>();

	
	public float getPrezzoProdotto() {
		return prezzoProdotto;
	}

	public void setPrezzoProdotto(float prezzoProdotto) {
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
