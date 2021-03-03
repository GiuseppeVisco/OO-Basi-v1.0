
import java.util.*;

public class Prodotto {
	
    private double prezzo;
    private String nome;
    private Allergene allergeni [];
    
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Allergene[] getAllergeni() {
		return allergeni;
	}
	public void setAllergeni(Allergene[] allergeni) {
		this.allergeni = allergeni;
	}
}