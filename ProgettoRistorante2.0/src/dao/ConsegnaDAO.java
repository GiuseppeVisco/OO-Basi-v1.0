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
	public void insertConsegna(String ristorantePartenza, String indirizzoConsegna, double costoTotale, String usernameUtente, int idRiderAssegnato) {
		try {
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProgettoTest","postgres","informatica");

			st = con.prepareStatement("INSERT INTO consegne(ristorante_di_partenza, indirizzo_consegna, costo_totale, mail_utente, id_rider) VALUES (?,?,?,?,?)");
			st.setString(1, ristorantePartenza);
			st.setString(2, indirizzoConsegna);
			st.setDouble(3, costoTotale);
			st.setString(4, usernameUtente);
			st.setInt(5, idRiderAssegnato);
			
			ResultSet rs = st.executeQuery();
			
			//- Release delle risorse
			rs.close();
			st.close();
			con.close();
		}

		catch (SQLException e) {
		}	
	}
	
	public ArrayList<Consegna> listaConsegne (String ristoranteAssegnato) {
		ArrayList<Consegna> listaStorico = new ArrayList();
		try {
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProgettoTest","postgres","informatica");
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
				
				consegna.setIndirizzoRistorante(ristorantePartenza);
				consegna.setIndirizzoConsegna(indirizzoConsegna);
				consegna.setTotale(costoTotale);
				consegna.setUsernameUtente(mailUtente);
				consegna.setRider(idRider);
				consegna.setIdConsegna(idConsegna);
				
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
}
