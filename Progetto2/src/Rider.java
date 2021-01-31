import java.util.ArrayList;

public class Rider {
	
	private String idRider;
	private String veicolo;
	private String indirizzoRistorante;
	private int numeroConsegne = 3;
	private String codiceConsegna;
	Consegna c1 = new Consegna();
	
	public String getIdRider() {
		return idRider;
	}
	
	public void setIdRider(String idRider) {
		this.idRider = idRider;
	}
	
	public void assegnazioneConsegna() {
// Per ogni consegna che si assegna al driver si scala il numero consegne di 1
	}
}
