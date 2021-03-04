package entità;

public class Cliente extends Utente {
	

	private String indirizzo;
	private String dataCreazione;
	private String cartaDiCredito;
	
	
	
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	
	
	public String getDataCreazione() {
		return dataCreazione;
	}
	public void setDataCreazione(String dataCreazione) {
		this.dataCreazione = dataCreazione;
	}
	
	
	public String getCartaDiCredito() {
		return cartaDiCredito;
	}
	public void setCartaDiCredito(String cartaDiCredito) {
		this.cartaDiCredito = cartaDiCredito;
	}

	


}
