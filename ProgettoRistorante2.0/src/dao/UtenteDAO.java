package dao;
import entity.*;
import java.sql.*;
import controller.*;
import gui.*;


public class UtenteDAO {
	
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
				Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/projectristoranteoodb","postgres","informatica");
        
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("SELECT email, passwordutente FROM utente");
					while (rs.next()) {
						String usernameDB = rs.getString("email");
						String passwordDB = rs.getString("passwordutente");
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
