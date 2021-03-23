package dao;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;


public class AllergeneDAO {	
	
	private PreparedStatement statement;
	
	public AllergeneDAO() {
		try {
			Class.forName("org.postgresql.Driver");
			}
		catch (ClassNotFoundException e){
			System.out.println("Class Not Found: \n"+e);
			}
	}
	
	public ArrayList<String> fornisciAllergeni(String nomeProdotto) {
		ArrayList<String> allergeniList = new ArrayList<>();
		try {			
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProgettoTest","postgres","informatica");       

				statement = con.prepareStatement("SELECT nome_allergene FROM allergeni NATURAL JOIN allergeniassociati NATURAL JOIN menù WHERE nome_piatto = ?");
				statement.setString(1, nomeProdotto);
				ResultSet rs = statement.executeQuery();
				while (rs.next()) {
					String nomeAllergene = rs.getString("nome_allergene");
					allergeniList.add(nomeAllergene);
				}
				//- Release delle risorse
				rs.close();
				statement.close();
				con.close();
		}
		catch (SQLException e) {
			System.out.println("Class Not Found: \n"+e);
		}
		return allergeniList;
	}
}