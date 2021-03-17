package dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


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
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProgettoTest","postgres","angolo98");
    
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT veicolo, consegne_assegnate FROM rider");
				while (rs.next()) {
					String veicoloDB = rs.getString("veicolo");
					int completoDB = rs.getInt("consegne_assegnate");
						if ((mezzoRider.equals(veicoloDB)) && (completoDB < 3)) {
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
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProgettoTest","postgres","angolo98");
    
			PreparedStatement st = con.prepareStatement("SELECT id_rider FROM rider WHERE consegne_assegnate < 3 and veicolo =?");
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
	
	public void updateCount(int idRider) {
		
		try {
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProgettoTest","postgres","angolo98");
    
			PreparedStatement st = con.prepareStatement("update rider set consegne_assegnate = consegne_assegnate+1 WHERE id_rider = ?");
			st.setInt(1, idRider);
			st.executeQuery();

        //- Release delle risorse
            st.close();
            con.close();
		}
catch (SQLException e) {
    System.out.println("Class Not Found: \n"+e);
		}
	}
}
