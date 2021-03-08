package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class RicercaPrezzo {
	String [] risultato;{
	try {
		Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/projectristoranteoodb","ProjectRistorante-OO-BD","Peron");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("Select nome_piatto,costo from menu where costo<'1.00'");
		ArrayList<String> list = new ArrayList<String>();
		while (rs.next()) {
			list.add(rs.getString("nome_piatto"));
		}
		risultato = new String[list.size()];
		risultato = list.toArray(risultato);
		//- Release of the resources
		rs.close();
	    st.close();
	    con.close();
		}
		
	    catch (SQLException e) {System.out.println("Class Not Found: \n"+e);}
}}
