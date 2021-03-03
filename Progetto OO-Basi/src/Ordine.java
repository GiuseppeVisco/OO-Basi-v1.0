
import java.util.*;

public class Ordine {

    public Ordine() {
    }

    ArrayList<Prodotto> items = new ArrayList<Prodotto>();
    private double totale;
    private Cliente cliente;
    private String Orario_consegna;
    private Ristorante ristorante;
    private Stato statoOrdine;
    
    public double calcolaTotale() {
    	for(Prodotto i: items) {
    		totale+=i.getPrezzo();
    	}
		return totale;
    }
}