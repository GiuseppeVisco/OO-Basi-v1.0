package dao;
import entity.*;
import java.sql.*;
import controller.*;
import gui.*;


public class UtenteDAO {
	
	Controller controller;
	
	public UtenteDAO() {	
		try {

			Class.forName("org.postgresql.Driver");

			}

			catch (ClassNotFoundException e)
			{
			System.out.println("Class Not Found: \n"+e);
			}
	} 
	
	public boolean checkCredentials(String username,String password) {
		boolean check = false;
		try {
				Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/progetto","postgres","informatica");
        
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("SELECT username, password FROM utente");
					while (rs.next()) {
						String usernameDB = rs.getString("username");
						String passwordDB = rs.getString("password");
							if ((username.equals(usernameDB)) && (password.equals(passwordDB))) {
								check = true;
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
		
		return check;
	}
	
}
