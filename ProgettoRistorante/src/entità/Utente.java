package entità;

public class Utente {
	
	private String CF;
	private String nome;
	private String cognome;
	private String indirizzoResidenza;
	private String numeroCellulare;
	private String email;
	private String passwordUtente;
	private boolean isRider = false;
	
	
	
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	
	public String getIndirizzoResidenza() {
		return indirizzoResidenza;
	}
	public void setIndirizzoResidenza(String indirizzoResidenza) {
		this.indirizzoResidenza = indirizzoResidenza;
	}
	
	
	public String getNumeroCellulare() {
		return numeroCellulare;
	}
	public void setNumeroCellulare(String numeroCellulare) {
		this.numeroCellulare = numeroCellulare;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getPasswordUtente() {
		return passwordUtente;
	}
	public void setPasswordUtente(String passwordUtente) {
		this.passwordUtente = passwordUtente;
	}
	
	
	public boolean isRider() {
		return isRider;
	}
	public void setRider(boolean isRider) {
		this.isRider = isRider;
	}
	
	
	public String getCF() {
		return CF;
	}
	public void setCF(String cF) {
		CF = cF;
	}
	

}
