
import java.util.*;

public class Utente {
	
    private String Nome;
    private String Cognome;
    private String email;
    
	public Utente(String nome, String cognome,String email) {
		super();
		this.Nome = nome;
		this.Cognome = cognome;
		this.email = email;
	}

    public void setNome(String Nome) {
    	this.Nome = Nome;
    }
	public String getCognome() {
		return Cognome;
	}
	public void setCognome(String cognome) {
		Cognome = cognome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return Nome;
	}
    
    }
