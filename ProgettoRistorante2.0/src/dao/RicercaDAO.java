package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.*;

public class RicercaDAO {
	Controller controller;
	private PreparedStatement st;
	
	public RicercaDAO() {
		try {
			Class.forName("org.postgresql.Driver");
			}
		catch (ClassNotFoundException e){
			System.out.println("Class Not Found: \n"+e);
			}
	}
	
	public ArrayList<String> trovaProdottoPerAllergeni(String nomeAllergene) {
		ArrayList<String> listaProdottiDaEliminare = new ArrayList();
		try {			
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/projectristoranteoodb","postgres","informatica");
			
			st = con.prepareStatement("SELECT menu.nome_piatto from menù NATURAL JOIN allergeniassociati NATURAL JOIN allergeni WHERE nome_allergene LIKE ?");
			st.setString(1, nomeAllergene);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String temp = "";
				temp = rs.getString("nome_piatto");
				
				listaProdottiDaEliminare.add(temp);
			}
			
			//- Release delle risorse
			rs.close();
			st.close();
			con.close();
		}
		catch (SQLException e) {
		}	
		
		return listaProdottiDaEliminare;
	}
	
	
	public ArrayList<String> trovaProdottoPerPrezzoBasso() {
		ArrayList<String> listaProdottiDaAggiungere = new ArrayList();
		try {			
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProgettoTest","postgres","angolo98");
			
			st = con.prepareStatement("SELECT nome_piatto from menu  WHERE costo > 0 and costo < 3 ");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String temp = "";
				temp = rs.getString("nome_piatto");
				
				listaProdottiDaAggiungere.add(temp);
			}
			
			//- Release delle risorse
			rs.close();
			st.close();
			con.close();
		}
		catch (SQLException e) {
		}	
		
		return listaProdottiDaAggiungere;
	}
	
	
	public ArrayList<String> trovaProdottoPerPrezzoMedio() {
		ArrayList<String> listaProdottiDaAggiungere2 = new ArrayList();
		try {			
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProgettoTest","postgres","angolo98");
			
			st = con.prepareStatement("SELECT nome_piatto from menu where costo >= 3 and costo < 6 ");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String temp = "";
				temp = rs.getString("nome_piatto");
				
				listaProdottiDaAggiungere2.add(temp);
			}
			
			//- Release delle risorse
			rs.close();
			st.close();
			con.close();
		}
		catch (SQLException e) {
		}	
		
		return listaProdottiDaAggiungere2;
	}
	
	
	public ArrayList<String> trovaProdottoPerPrezzoAlto() {
		ArrayList<String> listaProdottiDaAggiungere3 = new ArrayList();
		try {			
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProgettoTest","postgres","angolo98");
			
			st = con.prepareStatement("SELECT menu.nome_piatto from menu  WHERE costo >= 6");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String temp = "";
				temp = rs.getString("nome_piatto");
				
				listaProdottiDaAggiungere3.add(temp);
			}
			
			//- Release delle risorse
			rs.close();
			st.close();
			con.close();
		}
		catch (SQLException e) {
		}	
		
		return listaProdottiDaAggiungere3;
	}
	
}
