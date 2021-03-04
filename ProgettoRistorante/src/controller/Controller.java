package controller;
import dao.*;
import gui.*;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import gui.FinestraPrincipale;

import gui.HomePage_Rider;

public class Controller {

	FinestraPrincipale fp;
	HomePage_Rider hpr;
	HomePage_cliente hpc;
	UtenteDAO b = new UtenteDAO();
	
	public static void main(String[] args) {
		
			Controller c = new Controller();
			
		        //Step 1 - Caricare il driver
		        try {
		            Class.forName("org.postgresql.Driver");
		            }
	
		        catch (ClassNotFoundException e)
		        {
		            System.out.println("Class Not Found: \n"+e);
		        }
	}
	
	public Controller() {
			fp = new FinestraPrincipale(this);
			fp.setVisible(true);
		}
		
	public void Mactch(String em, String pw) {
		
		boolean ck = false;
		boolean rt = true;
				
		ck = b.checkLogin(em, pw );
		if (ck == true)
			{
				fp.setVisible(false);
					if(rt == b.checkTipoUtente(em))
						{
							hpr = new HomePage_Rider(this);
							hpr.setVisible(true);
						}
					else
						{
							hpc = new HomePage_cliente();
							hpc.setVisible(true);
						}
			}
			
		else 
			JOptionPane.showMessageDialog(null, "Email e password non corretti");
		
	}
}
