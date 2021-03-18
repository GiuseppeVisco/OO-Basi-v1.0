package dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import entity.Prodotto;
import java.util.ArrayList;


public class ProdottoDAO {
	private PreparedStatement st;
	public ProdottoDAO() {	
		
		try {
			Class.forName("org.postgresql.Driver");
			}
		catch (ClassNotFoundException e){
			System.out.println("Class Not Found: \n"+e);
			}
		}
	
	public ArrayList<Prodotto> CaricaProdotti() {
		ArrayList<Prodotto> listaProdotti = new ArrayList<>();		
		try {
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProgettoTest","postgres","angolo98");    
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT nome_piatto, costo, descrizione_piatto FROM menù");			
				while (rs.next()) {
					Prodotto prodotto = new Prodotto();																	
					prodotto.setNomeProdotto(rs.getString("nome_piatto"));
					prodotto.setPrezzoProdotto(rs.getFloat("costo"));
					prodotto.setDescrizione(rs.getString("descrizione_piatto"));
					
					listaProdotti.add(prodotto);
					
				}
				//- Release delle risorse
				rs.close();
				st.close();
				con.close();
		}
	
		catch (SQLException e) {
			System.out.println("Class Not Found: \n"+e);
		}
		return listaProdotti;
	}
	
	public double restituisciPrezzo(String nomeProdotto) {
		double temp = -1;
		try {

			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProgettoTest","postgres","angolo98");    

			st = con.prepareStatement("SELECT costo FROM menù WHERE nome_piatto = ?");
			st.setString(1, nomeProdotto);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
			temp = rs.getDouble("costo");				
			}
			//- Release delle risorse
			rs.close();
			st.close();
			con.close();
	    }
	    catch (SQLException e) {
	    	System.out.println("Class Not Found: \n"+e);
	    }
		return temp;
	}
}

