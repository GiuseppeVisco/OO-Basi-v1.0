package entity;

public class Rider {
	
	private String idRider;
	Consegna[] consegnaAssegnata = new Consegna[3];
	Veicolo mioVeicolo;
	
	public String getIdRider() {
		return idRider;
	}
	public void setIdRider(String idRider) {
		this.idRider = idRider;
	}
	public Consegna[] getConsegnaAssegnata() {
		return consegnaAssegnata;
	}
	public void setConsegnaAssegnata(Consegna[] consegnaAssegnata) {
		this.consegnaAssegnata = consegnaAssegnata;
	}
	public Veicolo getMioVeicolo() {
		return mioVeicolo;
	}
	public void setMioVeicolo(Veicolo mioVeicolo) {
		this.mioVeicolo = mioVeicolo;
	}
	
	
	
}