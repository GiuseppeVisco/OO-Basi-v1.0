package gui;
import dao.UtenteDAO;

import controller.Controller;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListDataListener;
import entity.Prodotto;
import dao.AllergeneDAO;
import dao.ProdottoDAO;
import java.util.ArrayList;
import dao.RicercaDAO;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class MenuFrame extends JFrame {
	ProdottoDAO prodottoDAO = new ProdottoDAO();
	AllergeneDAO allergeneDAO = new AllergeneDAO();
	RicercaDAO ricercaDAO = new RicercaDAO();
	Controller controller;
	UtenteDAO utenteDAO;
	
    public ArrayList<String> listaProdottiJl = new ArrayList<>();
    public MenuFrame(Controller c) {
    	controller = c;
    	riempiMenu();
    	
    	setTitle("Men\u00F9");
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 300, 955, 523);
		               
        JInternalFrame ricercaInternalFrame = new JInternalFrame("Ricerca");
        ricercaInternalFrame.setBounds(20, 99, 645, 267);
        getContentPane().add(ricercaInternalFrame);
        ricercaInternalFrame.getContentPane().setLayout(null);
        
        JInternalFrame checkOutInternalFrame = new JInternalFrame("Check Out");
        checkOutInternalFrame.setBounds(30, 37, 839, 412);
        getContentPane().add(checkOutInternalFrame);
        checkOutInternalFrame.getContentPane().setLayout(null);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_1.setBounds(580, 239, 108, 35);
        checkOutInternalFrame.getContentPane().add(panel_1);
        panel_1.setLayout(null);
        
        JTextArea totaleTxtArea = new JTextArea();
        totaleTxtArea.setBounds(62, 11, 40, 19);
        panel_1.add(totaleTxtArea);
        totaleTxtArea.setEditable(false);
        totaleTxtArea.setText("?$");
                
        JLabel totaleLabel = new JLabel("Totale");
        totaleLabel.setFont(new Font("Calibri", Font.PLAIN, 13));
        totaleLabel.setBounds(6, 16, 46, 14);
        panel_1.add(totaleLabel);
        totaleLabel.setHorizontalAlignment(SwingConstants.RIGHT);              
        
        JTextArea usernameConsegnaTxt = new JTextArea();
        usernameConsegnaTxt.setEditable(false);
        usernameConsegnaTxt.setBounds(241, 106, 165, 22);
        checkOutInternalFrame.getContentPane().add(usernameConsegnaTxt);
        
        JTextArea indirizzoConsegnaTxt = new JTextArea();
        indirizzoConsegnaTxt.setEditable(false);
        indirizzoConsegnaTxt.setBounds(241, 139, 165, 22);
        checkOutInternalFrame.getContentPane().add(indirizzoConsegnaTxt);
        
        JTextArea negozioConsegnaTxt = new JTextArea();
        negozioConsegnaTxt.setEditable(false);
        negozioConsegnaTxt.setBounds(241, 172, 165, 22);
        checkOutInternalFrame.getContentPane().add(negozioConsegnaTxt);
        
        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
        usernameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        usernameLabel.setBounds(95, 111, 136, 14);
        checkOutInternalFrame.getContentPane().add(usernameLabel);
        
        JLabel indirizzoConsegnaLabel = new JLabel("Indirizzo di consegna");
        indirizzoConsegnaLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
        indirizzoConsegnaLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        indirizzoConsegnaLabel.setBounds(95, 144, 136, 14);
        checkOutInternalFrame.getContentPane().add(indirizzoConsegnaLabel);
        
        JLabel negozioPartenzaLabel = new JLabel("Negozio di partenza");
        negozioPartenzaLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
        negozioPartenzaLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        negozioPartenzaLabel.setBounds(95, 177, 136, 14);
        checkOutInternalFrame.getContentPane().add(negozioPartenzaLabel);
        
        JLabel idRiderLabel = new JLabel("Id Rider");
        idRiderLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
        idRiderLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        idRiderLabel.setBounds(95, 210, 136, 14);
        checkOutInternalFrame.getContentPane().add(idRiderLabel);
        
        JScrollPane scrollPane_2 = new JScrollPane();
        scrollPane_2.setBounds(485, 106, 197, 132);
        checkOutInternalFrame.getContentPane().add(scrollPane_2);
        
        MyListModel listaMenuModel = new MyListModel();										//definizioni dei ListModel
        DefaultListModel<String> listaCarrelloModel = new DefaultListModel<String>();
        DefaultListModel<String> riepilogoCarrelloModel = new DefaultListModel<String>();
                       
        JList<String> riepilogoCarrelloJList = new JList<String>(riepilogoCarrelloModel);								//Riepilogo JListCarrello
        scrollPane_2.setViewportView(riepilogoCarrelloJList);
        
        JLabel riepilogoCarelloLabel = new JLabel("Riepilogo carrello");
        riepilogoCarelloLabel.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 17));
        riepilogoCarelloLabel.setBounds(483, 75, 199, 22);
        checkOutInternalFrame.getContentPane().add(riepilogoCarelloLabel);
        
        JTextArea idRiderConsegnaTxt = new JTextArea();
        idRiderConsegnaTxt.setEditable(false);
        idRiderConsegnaTxt.setBounds(241, 205, 165, 19);
        checkOutInternalFrame.getContentPane().add(idRiderConsegnaTxt);
        checkOutInternalFrame.setVisible(false);
        
        getContentPane().setLayout(null);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(196, 110, 206, 205);
        getContentPane().add(scrollPane);
        
        JList<String> listaMenuJList = new JList<String>(listaMenuModel);
        scrollPane.setViewportView(listaMenuJList);
        listaMenuJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(514, 110, 206, 205);
        getContentPane().add(scrollPane_1);
        
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "Descrizione Prodotto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.setBounds(10, 173, 176, 146);
        getContentPane().add(panel);
        panel.setLayout(null);
       
        JTextPane descrizioneTxt = new JTextPane();
        descrizioneTxt.setEditable(false);
        descrizioneTxt.setBounds(10, 16, 156, 124);
        panel.add(descrizioneTxt);        
        descrizioneTxt.setText("Seleziona un prodotto");
        
        JList<String> listaCarrelloJList = new JList<String>(listaCarrelloModel);
       scrollPane_1.setViewportView(listaCarrelloJList);
        
        JLabel menuPrincipaleLabel = new JLabel("Men\u00F9 Principale");
        menuPrincipaleLabel.setBounds(240, 89, 113, 23);
        getContentPane().add(menuPrincipaleLabel);
        
        JLabel lblCarrello = new JLabel("Carrello");
        lblCarrello.setBounds(584, 89, 81, 23);
        getContentPane().add(lblCarrello);
                                               
        JComboBox<String> fasciaPrezzoBox = new JComboBox<String>();
        fasciaPrezzoBox.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Prezzo basso", "Prezzo medio", "Prezzo alto"}));
        fasciaPrezzoBox.setBounds(44, 90, 128, 31);
        ricercaInternalFrame.getContentPane().add(fasciaPrezzoBox);
        
        JComboBox<String> tipoProdottoBox = new JComboBox<String>();
        tipoProdottoBox.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Snack", "Primi", "Secondi", "Bevande"}));
        tipoProdottoBox.setBounds(44, 165, 128, 31);
        ricercaInternalFrame.getContentPane().add(tipoProdottoBox);
        
        JLabel fasciaPrezzoLabel = new JLabel("Fascia di prezzo");
        fasciaPrezzoLabel.setFont(new Font("Calibri", Font.BOLD, 14));
        fasciaPrezzoLabel.setHorizontalAlignment(SwingConstants.LEFT);
        fasciaPrezzoLabel.setBounds(44, 61, 128, 18);
        ricercaInternalFrame.getContentPane().add(fasciaPrezzoLabel);
        
        JLabel eliminaProdottoLabel = new JLabel("Elimina prodotti con allergeni:");
        eliminaProdottoLabel.setFont(new Font("Calibri", Font.BOLD, 14));
        eliminaProdottoLabel.setBounds(246, 36, 195, 18);
        ricercaInternalFrame.getContentPane().add(eliminaProdottoLabel);
        
        JCheckBox cerealiCheck = new JCheckBox("Cereali");
        cerealiCheck.setSelected(false);
        cerealiCheck.setBounds(246, 61, 152, 23);
        ricercaInternalFrame.getContentPane().add(cerealiCheck);
        
        JCheckBox uovaCheck = new JCheckBox("Uova");
        uovaCheck.setBounds(246, 87, 152, 23);
        ricercaInternalFrame.getContentPane().add(uovaCheck);
        
        JCheckBox arachidiCheck = new JCheckBox("Arachidi");
        arachidiCheck.setBounds(246, 113, 152, 23);
        ricercaInternalFrame.getContentPane().add(arachidiCheck);
        
        JCheckBox soiaCheck = new JCheckBox("Soia");
        soiaCheck.setBounds(246, 139, 152, 23);
        ricercaInternalFrame.getContentPane().add(soiaCheck);
        
        JCheckBox latteCheck = new JCheckBox("Latte");
        latteCheck.setBounds(246, 165, 152, 23);
        ricercaInternalFrame.getContentPane().add(latteCheck);
        
        JCheckBox anidrideCheck = new JCheckBox("Anidride solforosa e solfiti");
        anidrideCheck.setBounds(246, 191, 160, 23);
        ricercaInternalFrame.getContentPane().add(anidrideCheck);
        
        
        //////////////// BOTTONI //////////////////////
        
        JButton accettaConsegnaButton = new JButton("Accetta");				//Bottone AccettaConsegna
        accettaConsegnaButton.setFont(new Font("Calibri", Font.BOLD, 15));
        accettaConsegnaButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        			controller.aggiornaStoricoConsegne();
        			controller.updateRiderCount();
        			JOptionPane.showMessageDialog(null, "L'ordine verrà consegnato al più presto.");
        			System.exit(1); 
        	}
        });
        accettaConsegnaButton.setBounds(724, 286, 89, 35);
        checkOutInternalFrame.getContentPane().add(accettaConsegnaButton);

        
        JButton aggiungiButton = new JButton("Aggiungi >");           //Bottone aggiungi
        aggiungiButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {    		
        		switchCarrello(listaMenuJList, listaCarrelloModel);
        	}
        });                
        aggiungiButton.setBounds(415, 147, 97, 23);
        getContentPane().add(aggiungiButton);

        
        JButton rimuoviButton = new JButton("< Rimuovi");				//Bottone rimuovi
        rimuoviButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		rimuoviButton(listaCarrelloJList,listaCarrelloModel,listaMenuModel);
        	}
        });
        rimuoviButton.setBounds(412, 216, 92, 23);
        getContentPane().add(rimuoviButton);               
 
        
        JButton confermaButton = new JButton("Conferma");				//BOTTONE CONFERMA
        confermaButton.setFont(new Font("Calibri", Font.BOLD, 15));
        confermaButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) { 
        		usernameConsegnaTxt.setText(controller.getUsernameConsegna());
        		indirizzoConsegnaTxt.setText(controller.getIndirizzoConsegna());
        		negozioConsegnaTxt.setText(controller.getNegozioConsegna());
        		idRiderConsegnaTxt.setText("["+controller.getIdRiderConsegna()+"]");
        		riepilogo(listaCarrelloModel, riepilogoCarrelloModel, checkOutInternalFrame,totaleTxtArea);        		
        	}
        });
        confermaButton.setBounds(560, 326, 105, 40);
        getContentPane().add(confermaButton);
        
                
        JButton indietroButton = new JButton("Indietro");					//BOTTONE INDIETRO
        indietroButton.setFont(new Font("Calibri", Font.BOLD, 15));
        indietroButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		checkOutInternalFrame.setVisible(false);
        		riepilogoCarrelloModel.clear();      		
        	}
        });
        indietroButton.setBounds(13, 286, 89, 35);
        checkOutInternalFrame.getContentPane().add(indietroButton);

        
        JButton btnNewButton_3 = new JButton("Log Out");  				///BOTTONE LOG OUT
        btnNewButton_3.setFont(new Font("Calibri", Font.BOLD, 15));
        btnNewButton_3.setBounds(10, 414, 89, 23);
        getContentPane().add(btnNewButton_3);
        
        
        JButton descrizioneButton = new JButton("Descrizione");          //Bottone descrizione
        descrizioneButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {        		
        		descrizioneTxt.setText(controller.ricavaDescrizioneProdotto(listaMenuJList));
        	}
        });
        descrizioneButton.setBounds(251, 326, 103, 40);
        getContentPane().add(descrizioneButton);
 
        
        JButton resettaButton = new JButton("Resetta");							//Bottone Resetta
        resettaButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		resetta(resettaButton);  		
        	}
        });
        resettaButton.setEnabled(false);
        resettaButton.setBounds(42, 139, 89, 23);
        getContentPane().add(resettaButton);
                
        
        JButton ricercaButton = new JButton("Ricerca");             //Bottone RICERCA
        ricercaButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ricercaInternalFrame.setVisible(true);
        	}
        });
        ricercaButton.setBounds(42, 108, 89, 23);
        getContentPane().add(ricercaButton);
        
        
        JButton cercaInternalButton = new JButton("Cerca");                   //BOTTONE INTERNAL CERCA
        cercaInternalButton.setFont(new Font("Calibri", Font.BOLD, 15));
        cercaInternalButton.addActionListener(new ActionListener() {
        	
        	public void actionPerformed(ActionEvent e) {
        		
        		int x = fasciaPrezzoBox.getSelectedIndex(); 
        		int y = tipoProdottoBox.getSelectedIndex();
        		
        		listaProdottiJl = controller.ricercaPerPrezzo(x, listaProdottiJl);
        		fasciaPrezzoBox.setSelectedIndex(0);        		
        		
        		if (y != 0) {
        			ArrayList<String> temp = new ArrayList<String>();
        			temp = ricercaDAO.trovaProdottoPerTipo(y);
        			listaProdottiJl.removeAll(temp);
        			tipoProdottoBox.setSelectedIndex(0);
        		}
       		
        		checkAllergeni(cerealiCheck, uovaCheck, arachidiCheck, soiaCheck, latteCheck, anidrideCheck);
        		
        		resettaButton.setEnabled(true);
        		ricercaInternalFrame.setVisible(false);
        	}
 
        });
        cercaInternalButton.setBounds(452, 103, 108, 46);
        ricercaInternalFrame.getContentPane().add(cercaInternalButton);
        
        
        JLabel tipoProdottoLabel = new JLabel("Tipo prodotto");
        tipoProdottoLabel.setHorizontalAlignment(SwingConstants.LEFT);
        tipoProdottoLabel.setFont(new Font("Calibri", Font.BOLD, 14));
        tipoProdottoLabel.setBounds(44, 143, 128, 18);
        ricercaInternalFrame.getContentPane().add(tipoProdottoLabel);
    }

    
    
    
    class MyListModel implements ListModel {      
        public int getSize() {
            return listaProdottiJl.size();
        }       
        public Object getElementAt(int index) {
            return listaProdottiJl.get(index);            
        }      
        public void addListDataListener(ListDataListener l) {
        }       
        public void removeListDataListener(ListDataListener l) {
        }	
    }
       
    
    ///////////METODI PER GLI ACTION LISTENER ///////////////
    
    
    
    public void checkAllergeni(JCheckBox cerealiCheck,JCheckBox uovaCheck,JCheckBox arachidiCheck,JCheckBox soiaCheck,JCheckBox latteCheck,JCheckBox anidrideCheck) {

    	if(cerealiCheck.isSelected()) {		
			ArrayList<String> temp4 = null;
			temp4 = ricercaDAO.trovaProdottoPerAllergeni("cereali e derivati");
			for(String s :temp4) {
				listaProdottiJl.remove(s);
			}
			cerealiCheck.setSelected(false);
		}
		if(uovaCheck.isSelected()) {
			ArrayList<String> temp5 = null;
			temp5 = ricercaDAO.trovaProdottoPerAllergeni("uova");
			for(String s :temp5) {        				
				listaProdottiJl.remove(s);
			}
			uovaCheck.setSelected(false);
		}
		
		if(arachidiCheck.isSelected()) {
			ArrayList<String> temp6 = null;
			temp6 = ricercaDAO.trovaProdottoPerAllergeni("Arachidi");
			for(String s :temp6) {
				listaProdottiJl.remove(s);
			}
			arachidiCheck.setSelected(false);
		}
		
		if(soiaCheck.isSelected()) {
			ArrayList<String> temp7 = null;
			temp7 = ricercaDAO.trovaProdottoPerAllergeni("Soia");
			for(String s :temp7) {
				listaProdottiJl.remove(s);
			}
			soiaCheck.setSelected(false);
		}
		
		if(latteCheck.isSelected()) {
			ArrayList<String> temp8 = null;
			temp8 = ricercaDAO.trovaProdottoPerAllergeni("Latte");
			for(String s :temp8) {
				listaProdottiJl.remove(s);
			}
			latteCheck.setSelected(false);
		}
		       		
		if(anidrideCheck.isSelected()) {
			ArrayList<String> temp9 = null;
			temp9 = ricercaDAO.trovaProdottoPerAllergeni("Anidride solforosa e solfiti");
			for(String s :temp9) {
				listaProdottiJl.remove(s);
			}
			anidrideCheck.setSelected(false);
		}
    }
 
    
    public void switchCarrello(JList<String> listaMenuJList, DefaultListModel<String> listaCarrelloModel) {
		int isSelected = listaMenuJList.getSelectedIndex();
		if(isSelected == -1) {
			return;
		}        		
		String prodottoAggiunto = listaMenuJList.getSelectedValue();
		int size = listaCarrelloModel.getSize();
		if(size == 0) {
			listaCarrelloModel.addElement(prodottoAggiunto);
			return;        			
		}
		for(int i = 0; i < size; i++) {
			String prodotto = listaCarrelloModel.elementAt(i).toString();
			int compare = prodottoAggiunto.compareToIgnoreCase(prodotto);
			if (compare < 0) {
				listaCarrelloModel.add(i, prodottoAggiunto);
				return;
			}
		}
		listaCarrelloModel.addElement(prodottoAggiunto);
	}
  
    
    
   public void rimuoviButton(JList<String> listaCarrelloJList, DefaultListModel<String> listaCarrelloModel, MyListModel listaMenuModel) {
		int isSelected = listaCarrelloJList.getSelectedIndex();
		if(isSelected == -1) {
			return;
		}
		String elementoRimosso = listaCarrelloJList.getSelectedValue();        		
		listaCarrelloModel.remove(isSelected);
		int size = listaMenuModel.getSize();
		if(size == 0) {
			return;
		}
		for(int i = 0; i < size; i++) {
			String prodotto = listaProdottiJl.get(i);
			int compare = elementoRimosso.compareToIgnoreCase(prodotto);
			if (compare < 0) {       				
				return;
			}
		}
   }
 
   
   
   public void resetta(JButton resettaButton) {
		listaProdottiJl.clear();
		ArrayList<Prodotto> temp = null;
       temp = prodottoDAO.CaricaProdotti();
       for(Prodotto prodotto :temp) {
       	listaProdottiJl.add(prodotto.getNomeProdotto());
       }
		resettaButton.setEnabled(false);     
   }
   
  
   
   
   public void riepilogo(DefaultListModel<String> listaCarrelloModel, DefaultListModel<String> riepilogoCarrelloModel, JInternalFrame checkOutInternalFrame, JTextArea totaleTxtArea) {
		
		int x = listaCarrelloModel.getSize();
		for(int i = 0; i < x; i++) {
			String prodotto = listaCarrelloModel.elementAt(i).toString();
			riepilogoCarrelloModel.addElement(prodotto);;
	    }
		listaCarrelloModel.clear();
		int y = riepilogoCarrelloModel.getSize();
		double somma = 0;
		for(int i = 0; i < y; i++) {
			String prodotto = riepilogoCarrelloModel.elementAt(i).toString();
			somma += prodottoDAO.restituisciPrezzo(prodotto);
		}
		if(somma > 0) {
			totaleTxtArea.setText(""+String.format("%.2f", somma)+"€");
			controller.setTotaleConsegna(somma);
			//consegna.setTotale(somma);
			checkOutInternalFrame.setVisible(true);
			}
			else {
				JOptionPane.showMessageDialog(null, "Inserisci qualcosa nel carrello");
			}		
   }

   
   
   
   public void riempiMenu() {
	   ArrayList<Prodotto> temp = null;
       temp = prodottoDAO.CaricaProdotti();
       for(Prodotto prodotto :temp) {
       	listaProdottiJl.add(prodotto.getNomeProdotto());
       }
   }

}   
