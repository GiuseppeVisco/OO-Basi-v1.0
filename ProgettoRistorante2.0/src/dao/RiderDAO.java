package dao;

import java.sql.Connection;
import java.sql.DriverManager;
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
	
	public ArrayList<String> printName(String mezzoRider) {
		ArrayList<String> nomiRider = new ArrayList<String>();
		try {
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/projectristoranteoodb","postgres","informatica");
    
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT nome,veicolo FROM rider");
				while (rs.next()) {
					String nomeRider = rs.getString("nome");
					String veicolo = rs.getString("veicolo");
						if ((mezzoRider.equals(veicolo))) {
							nomiRider.add(veicolo);
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
	
	return nomiRider;
	}

	}


