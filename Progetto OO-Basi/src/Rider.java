
import java.util.*;

public class Rider extends Utente {

    private Veicolo veicolo;
    private Ordine[] conteggio = new Ordine[3];
    
	public Rider(String nome, String cognome, String email, String password, Veicolo veicolo) {
		super(nome, cognome, email,password);
		this.veicolo = veicolo;
	}



	public Veicolo getVeicolo() {
		return veicolo;
	}

	public void setVeicolo(Veicolo veicolo) {
		this.veicolo = veicolo;
	}

	//Necessario getter e setter per l'array di ordini ?
	
	public Ordine[] getConteggio() {
		return conteggio;
	}

	public void setConteggio(Ordine[] conteggio) {
		this.conteggio = conteggio;
	}
}