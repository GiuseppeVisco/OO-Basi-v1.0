package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entity.Consegna;


public class ConsegnaDAO {	
	
	private PreparedStatement statement;
	private Consegna consegna;
	
	public ConsegnaDAO() {
		try {
			Class.forName("org.postgresql.Driver");
			}
		catch (ClassNotFoundException e){
			System.out.println("Class Not Found: \n"+e);
			}
	}
	
	public void inserisciConsegna(String ristorantePartenza, String indirizzoConsegna, double costoTotale, String usernameUtente, int idRiderAssegnato, String veicoloRider) {
		try {
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProgettoTest","postgres","informatica");

			statement = con.prepareStatement("INSERT INTO consegne(ristorante_di_partenza, indirizzo_consegna, costo_totale, mail_utente, id_rider, stato_consegna, veicolo_utilizzato) VALUES (?,?,?,?,?,?,?)");
			statement.setString(1, ristorantePartenza);
			statement.setString(2, indirizzoConsegna);
			statement.setDouble(3, costoTotale);
			statement.setString(4, usernameUtente);
			statement.setInt(5, idRiderAssegnato);
			statement.setString(6,"In consegna");
			statement.setString(7, veicoloRider);
			
			ResultSet rs = statement.executeQuery();
			
			//- Release delle risorse
			rs.close();
			statement.close();
			con.close();
		}

		catch (SQLException e) {
			System.out.println("Class Not Found: \n"+e);
		}	
	}
	
	public ArrayList<Consegna> getListaConsegne (String ristoranteAssegnato) {
		
		ArrayList<Consegna> listaStorico = new ArrayList<Consegna>();
		
		try {
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProgettoTest","postgres","informatica");
			statement = con.prepareStatement("SELECT * from consegne WHERE ristorante_di_partenza LIKE ?");
			statement.setString(1, ristoranteAssegnato);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				consegna = new Consegna();
				consegna.setIndirizzoRistorante(rs.getString("ristorante_di_partenza"));
				consegna.setIndirizzoConsegna(rs.getString("indirizzo_consegna"));
				consegna.setTotale(rs.getDouble("costo_totale"));
				consegna.setUsernameUtente(rs.getString("mail_utente"));
				consegna.setRider(rs.getInt("id_rider"));
				consegna.setIdConsegna(rs.getString("id_consegna"));
				consegna.setStatoConsegna(rs.getString("stato_consegna"));
				consegna.setVeicoloUtilizzato(rs.getString("veicolo_utilizzato"));
				
				listaStorico.add(consegna);
				
			}
		// Release delle risorse
			rs.close();
			statement.close();
			con.close();
		}
		catch (SQLException e) {
			System.out.println("Class Not Found: \n"+e);
		}
		return listaStorico;
	}
	
	public void aggiornaStatoConsegne(String ristorantePartenza) {
		try {			
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProgettoTest","postgres","informatica");
			statement = con.prepareStatement("update consegne set stato_consegna = 'Consegnato' where ristorante_di_partenza like ?");
			statement.setString(1, ristorantePartenza);
			ResultSet rs = statement.executeQuery();

			// Release delle risorse
						rs.close();
						statement.close();
						con.close();
			}
		catch (SQLException e) {
			System.out.println("Class Not Found: \n"+e);
		}
	}
	
	
	public void resettaConsegneAssegnate() {
		try {
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProgettoTest","postgres","informatica");
			statement = con.prepareStatement("update rider set consegne_assegnate = '0'");
			
			ResultSet rs = statement.executeQuery();

			// Release delle risorse
						rs.close();
						statement.close();
						con.close();
			}
		catch (SQLException e) {
			System.out.println("Class Not Found: \n"+e);
		}
	}
	
	public void cancellaConsegna(int idConsegna) {
		
		try {
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProgettoTest","postgres","informatica");
			statement = con.prepareStatement("delete from consegne where id_consegna = ?");
			statement.setInt(1, idConsegna);
			
			ResultSet rs = statement.executeQuery();

			// Release delle risorse
						rs.close();
						statement.close();
						con.close();
			}
		catch (SQLException e) {
			System.out.println("Class Not Found: \n"+e);
		}
		
	}
	
	public ArrayList<Consegna> cercaPerIdRider(int riderId, String ristoranteAssegnato) {
		ArrayList<Consegna> listaStoricoPerIdRider = new ArrayList<Consegna>();
		try {
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProgettoTest","postgres","informatica");
			statement = con.prepareStatement("SELECT * from consegne WHERE ristorante_di_partenza LIKE ? AND id_rider = ?");
			statement.setString(1, ristoranteAssegnato);
			statement.setInt(2, riderId);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				
				Consegna consegna = new Consegna();
				
				consegna.setIndirizzoRistorante(rs.getString("ristorante_di_partenza"));
				consegna.setIndirizzoConsegna(rs.getString("indirizzo_consegna"));
				consegna.setTotale(rs.getDouble("costo_totale"));
				consegna.setUsernameUtente(rs.getString("mail_utente"));
				consegna.setRider(rs.getInt("id_rider"));
				consegna.setIdConsegna(rs.getString("id_consegna"));
				consegna.setStatoConsegna(rs.getString("stato_consegna"));
				consegna.setVeicoloUtilizzato(rs.getString("veicolo_utilizzato"));
				
				listaStoricoPerIdRider.add(consegna);
				
			}
		// Release delle risorse
			rs.close();
			statement.close();
			con.close();
		}
		catch (SQLException e) {
			System.out.println("Class Not Found: \n"+e);
		}
		return listaStoricoPerIdRider;
		
	}
}
