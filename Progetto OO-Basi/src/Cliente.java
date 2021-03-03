
import java.util.*;

public class Cliente extends Utente {
	
    private String Carta_di_credito;
    private String indirizzo;
    private ArrayList<Ordine> ordine= new ArrayList<Ordine>();
    
	public Cliente(String nome, String cognome, String email, String password, String carta_di_credito,
			String indirizzo) {
		super(nome, cognome, email,password);
		Carta_di_credito = carta_di_credito;
		this.indirizzo = indirizzo;
	}

	public String getCarta_di_credito() {
		return Carta_di_credito;
	}
	public void setCarta_di_credito(String carta_di_credito) {
		Carta_di_credito = carta_di_credito;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
}