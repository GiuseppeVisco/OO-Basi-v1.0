package dao;
import java.sql.Statement;

import entity.Utente;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UtenteDAO {
	
	private PreparedStatement statement;
	Utente utente;
	
	public UtenteDAO() {	

		try {

			Class.forName("org.postgresql.Driver");

			}

			catch (ClassNotFoundException e)
			{
			System.out.println("Class Not Found: \n"+e);
			}
	} 
	
	public boolean controllaCredenziali(String username,char[] charPassword) {
		
		boolean controllo = false;
		String password = new String(charPassword);
		
		try {
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProgettoTest","postgres","informatica");
        
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("SELECT email, passwordutente FROM utente");
					while (rs.next()) {
						String usernameDB = rs.getString("email");
						String passwordDB = rs.getString("passwordutente");
							if ((username.equals(usernameDB)) && (password.equals(passwordDB))) {
								controllo = true;
								break;
								}
							}
            //- Release delle risorse
	            rs.close();
	            st.close();
	            con.close();
			}
		
   catch (SQLException e) {
        System.out.println("Class Not Found: \n"+e);
    }
		
		return controllo;
	}
	
	public String getIndirizzoPerUsername(String username) {
		String indirizzo = "non trovato";
		try {
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProgettoTest","postgres","informatica");
    
			statement = con.prepareStatement("SELECT indirizzo from utente WHERE email = ?");
			statement.setString(1, username);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				indirizzo = rs.getString("indirizzo");
				
			}
	}
	catch (SQLException e) {
		System.out.println("Class Not Found: \n"+e);
	}	
	return indirizzo;
	}
	
	
	
	
	public boolean controllaTipoUtente(String email) {

		boolean admin = false;
		
		try {
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProgettoTest","postgres","informatica");
			PreparedStatement st = con.prepareStatement("SELECT admin FROM utente WHERE email = ?");    			        	
			st.setString(1, email);
			ResultSet rs = st.executeQuery();
		    
			while (rs.next()) {
				admin = rs.getBoolean("admin");				
				}
			
     	    st.close();
     	    con.close();
		}
	    catch (SQLException e) {
	    	System.out.println("Class Not Found: \n"+e);
	        }
		return admin;

	}
}