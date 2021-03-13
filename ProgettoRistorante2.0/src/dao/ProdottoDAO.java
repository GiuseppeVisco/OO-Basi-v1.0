package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import entity.Prodotto;
import java.util.ArrayList;
import controller.Controller;
import gui.MenuFrame;

public class ProdottoDAO {
	
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
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/projectristoranteoodb","postgres","informatica");    
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT nome_piatto, costo, descrizione_piatto FROM menù");			
				while (rs.next()) {
					Prodotto prodotto = new Prodotto();												
					
					String nomePiattoDB = rs.getString("nome_piatto");
					float costoDB = rs.getFloat("costo");
					String descrizioneDB = rs.getString("descrizione_piatto");
					
					prodotto.setNomeProdotto(nomePiattoDB);
					prodotto.setPrezzoProdotto(costoDB);
					prodotto.setDescrizione(descrizioneDB);
					
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
}
