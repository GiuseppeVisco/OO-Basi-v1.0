package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RistoranteDAO {
	
	private PreparedStatement statement;

	public RistoranteDAO() {
		try {
			Class.forName("org.postgresql.Driver");
			}
		catch (ClassNotFoundException e){
			System.out.println("Class Not Found: \n"+e);
			}
	}

	
		public String  ricavaRistoranteAdmin(String emailAdmin) {
			String ristorante = null;
		try {
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProgettoTest","postgres","informatica");    
			statement = con.prepareStatement("SELECT indirizzo_ristorante FROM utente JOIN ristoranti ON user_id = admin_id WHERE email LIKE ? ");
			statement.setString(1, emailAdmin);			
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
			ristorante = rs.getString("indirizzo_ristorante");
			}
			//- Release delle risorse
			rs.close();
			statement.close();
			con.close();
		}
		
		catch (SQLException e) {
			System.out.println("Class Not Found: \n"+e);
		}
		
		return ristorante;
		}
}


