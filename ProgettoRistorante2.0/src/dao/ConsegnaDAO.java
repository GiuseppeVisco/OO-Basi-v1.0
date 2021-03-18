package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Consegna;
import controller.*;

public class ConsegnaDAO {	
	Controller controller;
	Consegna consegna = new Consegna();
	RistoranteDAO ristoranteDAO = new RistoranteDAO();
	private PreparedStatement st;
	
	public ConsegnaDAO() {
		try {
			Class.forName("org.postgresql.Driver");
			}
		catch (ClassNotFoundException e){
			System.out.println("Class Not Found: \n"+e);
			}
	}
	
	//SALVARE LA CONSEGNA COME ONSEGNA E NON COME ATTRIBUTI SINGOLI?
	public void insertConsegna(String ristorantePartenza, String indirizzoConsegna, double costoTotale, String usernameUtente, int idRiderAssegnato, String veicoloRider) {
		try {
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProgettoTest","postgres","angolo98");

			st = con.prepareStatement("INSERT INTO consegne(ristorante_di_partenza, indirizzo_consegna, costo_totale, mail_utente, id_rider, stato_consegna, veicolo_utilizzato) VALUES (?,?,?,?,?,?,?)");
			st.setString(1, ristorantePartenza);
			st.setString(2, indirizzoConsegna);
			st.setDouble(3, costoTotale);
			st.setString(4, usernameUtente);
			st.setInt(5, idRiderAssegnato);
			st.setString(6,"In consegna");
			st.setString(7, veicoloRider);
			
			ResultSet rs = st.executeQuery();
			
			//- Release delle risorse
			rs.close();
			st.close();
			con.close();
		}

		catch (SQLException e) {
			System.out.println("Class Not Found: \n"+e);
		}	
	}
	
	public ArrayList<Consegna> listaConsegne (String ristoranteAssegnato) {
		ArrayList<Consegna> listaStorico = new ArrayList<Consegna>();
		try {
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProgettoTest","postgres","angolo98");
			st = con.prepareStatement("SELECT * from consegne WHERE ristorante_di_partenza LIKE ?");
			st.setString(1, ristoranteAssegnato);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String ristorantePartenza = rs.getString("ristorante_di_partenza");
				String indirizzoConsegna = rs.getString("indirizzo_consegna");
				double costoTotale = rs.getDouble("costo_totale");
				String mailUtente = rs.getString("mail_utente");
				int idRider = rs.getInt("id_rider");
				String idConsegna = rs.getString("id_consegna");
				String statoConsegna = rs.getString("stato_consegna");
				String veicoloUtilizzato = rs.getString("veicolo_utilizzato");
				Consegna consegna = new Consegna();
				consegna.setIndirizzoRistorante(ristorantePartenza);
				consegna.setIndirizzoConsegna(indirizzoConsegna);
				consegna.setTotale(costoTotale);
				consegna.setUsernameUtente(mailUtente);
				consegna.setRider(idRider);
				consegna.setIdConsegna(idConsegna);
				consegna.setStatoConsegna(statoConsegna);
				consegna.setVeicoloUtilizzato(veicoloUtilizzato);
				
				listaStorico.add(consegna);
				
			}
		// Release delle risorse
			rs.close();
			st.close();
			con.close();
		}
		catch (SQLException e) {
			System.out.println("Class Not Found: \n"+e);
		}
		return listaStorico;
	}
	
	public void aggiornaStatoConsegne(String ristorantePartenza) {
		try {			
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProgettoTest","postgres","angolo98");
			st = con.prepareStatement("update consegne set stato_consegna = 'Consegnato' where ristorante_di_partenza like ?");
			st.setString(1, ristorantePartenza);
			ResultSet rs = st.executeQuery();

			// Release delle risorse
						rs.close();
						st.close();
						con.close();
			}
		catch (SQLException e) {
			System.out.println("Class Not Found: \n"+e);
		}
	}
	
	
	public void resettaConsegneAssegnate() {
		try {
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProgettoTest","postgres","angolo98");
			st = con.prepareStatement("update rider set consegne_assegnate = '0'");
			
			ResultSet rs = st.executeQuery();

			// Release delle risorse
						rs.close();
						st.close();
						con.close();
			}
		catch (SQLException e) {
			System.out.println("Class Not Found: \n"+e);
		}
	}
	
	public void cancellaConsegna(int idConsegna) {
		
		try {
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProgettoTest","postgres","angolo98");
			st = con.prepareStatement("delete from consegne where id_consegna = ?");
			st.setInt(1, idConsegna);
			
			ResultSet rs = st.executeQuery();

			// Release delle risorse
						rs.close();
						st.close();
						con.close();
			}
		catch (SQLException e) {
			System.out.println("Class Not Found: \n"+e);
		}
		
	}
	
	public ArrayList<Consegna> cercaPerIdRider(int riderId, String ristoranteAssegnato) {
		ArrayList<Consegna> listaStoricoPerIdRider = new ArrayList<Consegna>();
		try {
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProgettoTest","postgres","angolo98");
			st = con.prepareStatement("SELECT * from consegne WHERE ristorante_di_partenza LIKE ? AND id_rider = ?");
			st.setString(1, ristoranteAssegnato);
			st.setInt(2, riderId);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {				
				Consegna consegna = new Consegna();
				
				consegna.setIndirizzoRistorante(rs.getString("ristorante_di_partenza"));
				consegna.setIndirizzoConsegna(rs.getString("indirizzo_consegna"));
				consegna.setTotale(rs.getDouble("costo_totale"));
				consegna.setUsernameUtente(rs.getString("mail_utente"));
				consegna.setRider(rs.getInt("id_rider"));
				consegna.setIdConsegna(rs.getString("id_consegna"));
				consegna.setStatoConsegna(rs.getString("stato_consegna"));
				consegna.setVeicoloUtilizzato(rs.getString("veicolo_utilizzato"));
				
				listaStoricoPerIdRider.add(consegna);
			}
		// Release delle risorse
			rs.close();
			st.close();
			con.close();
		}
		catch (SQLException e) {
			System.out.println("Class Not Found: \n"+e);
		}
		return listaStoricoPerIdRider;
		
	}
}
