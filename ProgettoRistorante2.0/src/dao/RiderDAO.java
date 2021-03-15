package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RiderDAO {
	
	
	
	public RiderDAO() {	
		try {

			Class.forName("org.postgresql.Driver");

			}

			catch (ClassNotFoundException e)
			{
			System.out.println("Class Not Found: \n"+e);
			}
	} 
	
	public boolean checkAvailability(String mezzoRider) {
		boolean check = false;
		
		try {
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/projectristoranteoodb","postgres","informatica");
    
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT veicolo, cap_numero_consegne_raggiunto FROM rider");
				while (rs.next()) {
					String veicoloDB = rs.getString("veicolo");
					boolean completoDB = rs.getBoolean("cap_numero_consegne_raggiunto");
						if ((mezzoRider.equals(veicoloDB)) && (completoDB==false)) {
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
	//In base al veicolo scelto del rider ritorna l'id del primo rider disponibile con quel mezzo
	public int getIdRider(String veicoloRider) {
		
		int id_rider = 0;
		
		try {
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/projectristoranteoodb","postgres","informatica");
    
			PreparedStatement st = con.prepareStatement("SELECT id_rider FROM rider WHERE cap_numero_consegne_raggiunto = 'false' and veicolo =?");
			st.setString(1, veicoloRider);
			st.setMaxRows(1);
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				id_rider = rs.getInt("id_rider");				
				}
        //- Release delle risorse
            rs.close();
            st.close();
            con.close();
            
		}
	
catch (SQLException e) {
    System.out.println("Class Not Found: \n"+e);
}
	
	return id_rider;
	}

	}
