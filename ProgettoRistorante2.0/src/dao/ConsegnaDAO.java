package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.*;

public class ConsegnaDAO {	
	Controller controller;
	private PreparedStatement st;
	
	public ConsegnaDAO() {
		try {
			Class.forName("org.postgresql.Driver");
			}
		catch (ClassNotFoundException e){
			System.out.println("Class Not Found: \n"+e);
			}
	}
	
	public void insertConsegna(String ristorantePartenza, String indirizzoConsegna, double costoTotale, String usernameUtente, int idRiderAssegnato) {
		try {
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProgettoTest","postgres","angolo98");
    
			st = con.prepareStatement("INSERT INTO consegne(ristorante_di_partenza, indirizzo_consegna, costo_totale, mail_utente, id_rider) VALUES (?,?,?,?,?)");
			st.setString(1, ristorantePartenza);
			st.setString(2, indirizzoConsegna);
			st.setDouble(3, costoTotale);
			st.setString(4, usernameUtente);
			st.setInt(5, idRiderAssegnato);
			
			ResultSet rs = st.executeQuery();
		}
		catch (SQLException e) {
		}	
	}
}
