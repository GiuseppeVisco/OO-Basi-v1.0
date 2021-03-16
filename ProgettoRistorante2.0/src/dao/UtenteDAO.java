package dao;
import entity.*;

import java.sql.*;
import controller.*;
import gui.*;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UtenteDAO {
	private PreparedStatement st;
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
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProgettoTest","postgres","informatica");
        
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
	
	public String ricavaIndirizzoResidenza(String username) {
		String temp = "non trovato";
		try {
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProgettoTest","postgres","informatica");
    
			st = con.prepareStatement("SELECT indirizzo from utente WHERE email = ?");
			st.setString(1, username);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				temp = rs.getString("indirizzo");
				
			}
	}
	catch (SQLException e) {
		System.out.println("Class Not Found: \n"+e);
	}	
	return temp;
	}
	
	
	
	
	public boolean checkTipoUtente(String em) {

		int flag = 0;
		try {
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProgettoTest","postgres","informatica");
		    Statement st = con.createStatement();
		    ResultSet rs = st.executeQuery("SELECT email, admin FROM utente");
		    while (rs.next()) {
		        String Emaill = rs.getString("email");
		        boolean isAdmin = rs.getBoolean("admin");
		        if ((em.equals(Emaill)) && (isAdmin == false)) 
		        	flag = 1;		        			        	
	        }
		    rs.close();
     	    st.close();
     	    con.close();
		}
	    catch (SQLException e) {
	    	System.out.println("Class Not Found: \n"+e);
	        }
	   	if (flag == 1)
	   		return false;
	    else 
	    	return true;
	}
}
