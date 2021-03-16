package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RistoranteDAO {
	private PreparedStatement st;

	public RistoranteDAO() {
		try {
			Class.forName("org.postgresql.Driver");
			}
		catch (ClassNotFoundException e){
			System.out.println("Class Not Found: \n"+e);
			}
	}

	
		public String  ricavaRistoranteAdmin(String emailAdmin) {
			String temp = "";
		try {
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProgettoTest","postgres","informatica");    
			st = con.prepareStatement("SELECT indirizzo_ristorante FROM utente JOIN ristoranti ON user_id = admin_id WHERE email LIKE ? ");
			st.setString(1, emailAdmin);			
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
			temp = rs.getString("indirizzo_ristorante");
			}
			//- Release delle risorse
			rs.close();
			st.close();
			con.close();
		}
		
		catch (SQLException e) {
		}
		
		return temp;
		}
}


