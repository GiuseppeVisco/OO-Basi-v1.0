package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.ArrayList;


public class AllergeneDAO {	
	
	private PreparedStatement st;
	
	public AllergeneDAO() {
		try {
			Class.forName("org.postgresql.Driver");
			}
		catch (ClassNotFoundException e){
			System.out.println("Class Not Found: \n"+e);
			}
	}
	
	public ArrayList fornisciAllergeni(String nomeProdotto) {
		ArrayList<String> allergeniList = new ArrayList<>();
		try {			
				Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProgettoTest","postgres","angolo98");        

				st = con.prepareStatement("SELECT nome_allergene FROM allergeni NATURAL JOIN allergeniassociati NATURAL JOIN menù WHERE nome_piatto = ?");
				st.setString(1, nomeProdotto);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					String temp = rs.getString("nome_allergene");
					allergeniList.add(temp);
				}
				//- Release delle risorse
				rs.close();
				st.close();
				con.close();
		}
		catch (SQLException e) {
			System.out.println("Class Not Found: \n"+e);
		}
		return allergeniList;
	}
}