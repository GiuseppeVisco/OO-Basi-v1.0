package dao;
import entità.Utente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class UtenteDAO {
	

	public boolean checkLogin(String em, String pw) {
		boolean flag = false;
			try {
					Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/projectristoranteoodb","ProjectRistorante-OO-BD","Peron");
            
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery("SELECT email, passwordutente FROM utente");
						while (rs.next()) {
							String Emaill = rs.getString("email");
							String Passwordd = rs.getString("passwordutente");
								if ((em.equals(Emaill)) && (pw.equals(Passwordd))) {
									flag = true;
									JOptionPane.showMessageDialog(null, "Email e Password corretti"); 
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
		
		if (flag == true)
			return true;
		else
		return false;
}
	
	
	
	public boolean checkTipoUtente(String em) {
		
		int flag = 0;
		try {
				Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/projectristoranteoodb","ProjectRistorante-OO-BD","Peron");
		        Statement st = con.createStatement();
		        ResultSet rs = st.executeQuery("SELECT email, rider FROM utente");
		        while (rs.next()) {
		        	String Emaill = rs.getString("email");
		        	boolean isR = rs.getBoolean("rider");
		        		if ((em.equals(Emaill)) && (isR == false)) 
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

