package gui;
import dao.UtenteDAO;

import entity.Consegna;
import controller.Controller;
import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.event.ListDataListener;
import controller.Controller;
import entity.Prodotto;
import dao.AllergeneDAO;
import dao.ProdottoDAO;
import java.util.ArrayList;
import java.awt.Button;
import dao.RicercaDAO;

public class MenuFrame extends JFrame {
	ProdottoDAO prodottoDAO = new ProdottoDAO();
	AllergeneDAO allergeneDAO = new AllergeneDAO();
	RicercaDAO ricercaDAO = new RicercaDAO();
	Controller controller;
	Consegna consegna;
	UtenteDAO utenteDAO;
	
    public ArrayList<String> listaProdottiJl = new ArrayList<>();
    public MenuFrame(Controller c, Consegna d) {
    	consegna = d;
    	controller = c;
    	setTitle("Men\u00F9");
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 523);
		
        ArrayList<Prodotto> temp = null;
        temp = prodottoDAO.CaricaProdotti();
        for(Prodotto prodotto :temp) {
        	listaProdottiJl.add(prodotto.getNomeProdotto());
        }
        
        JInternalFrame ricercaInternalFrame = new JInternalFrame("Ricerca");
        ricercaInternalFrame.setBounds(10, 52, 625, 267);
        getContentPane().add(ricercaInternalFrame);
        ricercaInternalFrame.getContentPane().setLayout(null);
        
        JInternalFrame checkOutInternalFrame = new JInternalFrame("Check Out");
        checkOutInternalFrame.setBounds(71, 28, 814, 412);
        getContentPane().add(checkOutInternalFrame);
        checkOutInternalFrame.getContentPane().setLayout(null);
        
        JTextArea totaleTxtArea = new JTextArea();
        totaleTxtArea.setEditable(false);
        totaleTxtArea.setText("?$");
        totaleTxtArea.setBounds(642, 254, 40, 14);
        checkOutInternalFrame.getContentPane().add(totaleTxtArea);
        
        JButton accettaConsegnaButton = new JButton("Accetta");				//Bottone AccettaConsegna
        accettaConsegnaButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        			controller.aggiornaStoricoConsegne();
        			JOptionPane.showMessageDialog(null, "L'ordine verrà consegnato al più presto.");
        			System.exit(1);       		
        	}
        });
        accettaConsegnaButton.setBounds(699, 286, 89, 35);
        checkOutInternalFrame.getContentPane().add(accettaConsegnaButton);
        

        
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
        
        JLabel lblNewLabel_1 = new JLabel("Username");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_1.setBounds(95, 111, 136, 14);
        checkOutInternalFrame.getContentPane().add(lblNewLabel_1);
        
        JLabel lblNewLabel_1_1 = new JLabel("Indirizzo di consegna");
        lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_1_1.setBounds(95, 144, 136, 14);
        checkOutInternalFrame.getContentPane().add(lblNewLabel_1_1);
        
        JLabel lblNewLabel_1_2 = new JLabel("Negozio di partenza");
        lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_1_2.setBounds(95, 177, 136, 14);
        checkOutInternalFrame.getContentPane().add(lblNewLabel_1_2);
        
        JLabel lblNewLabel_1_3 = new JLabel("Id Rider");
        lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_1_3.setBounds(95, 210, 136, 14);
        checkOutInternalFrame.getContentPane().add(lblNewLabel_1_3);
        
        JScrollPane scrollPane_2 = new JScrollPane();
        scrollPane_2.setBounds(485, 106, 197, 132);
        checkOutInternalFrame.getContentPane().add(scrollPane_2);
        
        MyListModel listaMenuModel = new MyListModel();										//definizioni dei ListModel
        DefaultListModel listaCarrelloModel = new DefaultListModel();
        DefaultListModel riepilogoCarrelloModel = new DefaultListModel();
        
        
        
        JList riepilogoCarrelloJList = new JList(riepilogoCarrelloModel);								//Riepilogo JListCarrello
        scrollPane_2.setViewportView(riepilogoCarrelloJList);
        
        JLabel lblNewLabel_2 = new JLabel("Riepilogo carrello");
        lblNewLabel_2.setBounds(483, 83, 123, 14);
        checkOutInternalFrame.getContentPane().add(lblNewLabel_2);
        
        JTextArea idRiderConsegnaTxt = new JTextArea();
        idRiderConsegnaTxt.setBounds(241, 205, 165, 19);
        checkOutInternalFrame.getContentPane().add(idRiderConsegnaTxt);
        
        
        JLabel lblNewLabel_3 = new JLabel("Totale");
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_3.setBounds(586, 254, 46, 14);
        checkOutInternalFrame.getContentPane().add(lblNewLabel_3);
        checkOutInternalFrame.setVisible(false);
        
        getContentPane().setLayout(null);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(164, 114, 150, 205);
        getContentPane().add(scrollPane);
        
        JList<String> listaMenuJList = new JList(listaMenuModel);
        scrollPane.setViewportView(listaMenuJList);
        listaMenuJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(426, 114, 150, 205);
        getContentPane().add(scrollPane_1);
        
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "Descrizione Prodotto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.setBounds(10, 173, 144, 146);
        getContentPane().add(panel);
        panel.setLayout(null);
       
        JTextPane descrizioneTxt = new JTextPane();
        descrizioneTxt.setEditable(false);
        descrizioneTxt.setBounds(6, 16, 128, 124);
        panel.add(descrizioneTxt);        
        descrizioneTxt.setText("Seleziona un prodotto");
        
        JList<String> listaCarrelloJList = new JList(listaCarrelloModel);
        scrollPane_1.setViewportView(listaCarrelloJList);
        
        JButton aggiungiButton = new JButton("Aggiungi >");
        aggiungiButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {       		
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
        });
                
        aggiungiButton.setBounds(327, 151, 97, 23);
        getContentPane().add(aggiungiButton);
               
        JButton rimuoviButton = new JButton("< Rimuovi");
        rimuoviButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
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
        });
        rimuoviButton.setBounds(324, 220, 92, 23);
        getContentPane().add(rimuoviButton);               
        
        JButton confermaButton = new JButton("Conferma");				//BOTTONE CONFERMA
        confermaButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		usernameConsegnaTxt.setText(controller.getUsernameConsegna());
        		indirizzoConsegnaTxt.setText(controller.getIndirizzoConsegna());
        		negozioConsegnaTxt.setText(controller.getNegozioConsegna());
        		idRiderConsegnaTxt.setText("["+controller.getIdRider()+"]");
       		
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
        				consegna.setTotale(somma);
        	checkOutInternalFrame.setVisible(true);
        				}
        				else {
        					JOptionPane.showMessageDialog(null, "Inserisci qualcosa nel carrello");
        				}
        	}
        });
        confermaButton.setBounds(455, 330, 105, 30);
        getContentPane().add(confermaButton);
        
        JButton btnNewButton_1 = new JButton("Indietro");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		checkOutInternalFrame.setVisible(false);
        		riepilogoCarrelloModel.clear();
        		
        	}
        });
        btnNewButton_1.setBounds(10, 286, 89, 35);
        checkOutInternalFrame.getContentPane().add(btnNewButton_1);
        
        JButton btnNewButton_3 = new JButton("Log Out");
        btnNewButton_3.setBounds(10, 414, 89, 23);
        getContentPane().add(btnNewButton_3);
        
        JLabel lblNewLabel = new JLabel("Men\u00F9 Principale");
        lblNewLabel.setBounds(164, 89, 113, 23);
        getContentPane().add(lblNewLabel);
        
        JLabel lblCarrello = new JLabel("Carrello");
        lblCarrello.setBounds(426, 89, 81, 23);
        getContentPane().add(lblCarrello);
                
        JButton descrizioneButton = new JButton("Descrizione");
        descrizioneButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int isSelected = listaMenuJList.getSelectedIndex();
        		if(isSelected == -1) {
        			return;
        		}        		
        		String prodottoSelezionato = listaMenuJList.getSelectedValue();
        		ArrayList<Prodotto> temp2 = null;
        		temp2 = prodottoDAO.CaricaProdotti();
        		for(Prodotto prodotto: temp2) {
        		if(prodottoSelezionato.equals(prodotto.getNomeProdotto())) {
        			ArrayList<String> listaAllergeni = new ArrayList<>();
        			listaAllergeni = allergeneDAO.fornisciAllergeni(prodottoSelezionato);        			
        			descrizioneTxt.setText(prodotto.getDescrizione()+".\nPREZZO: ["+String.format("%.2f", prodotto.getPrezzoProdotto())+"€]\nALLERGENI: "+listaAllergeni);	
        		}
        		}
        	}
        });
        descrizioneButton.setBounds(174, 334, 103, 23);
        getContentPane().add(descrizioneButton);
        
        JButton resettaButton = new JButton("Resetta");							//Bottone Resetta
        resettaButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		listaProdottiJl.clear();
        		ArrayList<Prodotto> temp = null;
                temp = prodottoDAO.CaricaProdotti();
                for(Prodotto prodotto :temp) {
                	listaProdottiJl.add(prodotto.getNomeProdotto());
                }
        		resettaButton.setEnabled(false);
        		
        	}
        });
        resettaButton.setEnabled(false);
        resettaButton.setBounds(10, 123, 89, 23);
        getContentPane().add(resettaButton);
                
        
        JButton ricercaButton = new JButton("Ricerca");             //Bottone RICERCA
        ricercaButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ricercaInternalFrame.setVisible(true);
        	}
        });
        ricercaButton.setBounds(10, 89, 89, 23);
        getContentPane().add(ricercaButton);
        
        JComboBox fasciaPrezzoBox = new JComboBox();
        fasciaPrezzoBox.setModel(new DefaultComboBoxModel(new String[] {"Standard", "Prezzo basso", "Prezzo medo", "Prezzo alto"}));
        fasciaPrezzoBox.setBounds(44, 90, 128, 22);
        ricercaInternalFrame.getContentPane().add(fasciaPrezzoBox);
        
        JLabel lblNewLabel_4 = new JLabel("Fascia di prezzo");
        lblNewLabel_4.setBounds(44, 65, 128, 14);
        ricercaInternalFrame.getContentPane().add(lblNewLabel_4);
        
        JLabel lblNewLabel_5 = new JLabel("Elimina prodotti con allergeni");
        lblNewLabel_5.setBounds(246, 40, 171, 14);
        ricercaInternalFrame.getContentPane().add(lblNewLabel_5);
        
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
        
        JButton cercaInternalButton = new JButton("Cerca");                   //BOTTONE INTERNAL CERCA
        cercaInternalButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		ArrayList<String> temp = null;
        		ArrayList<String> temp2 = null;
        		ArrayList<String> temp3 = null;
    			int x = fasciaPrezzoBox.getSelectedIndex(); 
        		switch(x) {
        		case 0: break;
        		case 1: temp = ricercaDAO.trovaProdottoPerPrezzoBasso();
        					listaProdottiJl.clear();
    						for(String s :temp) {
    							listaProdottiJl.add(s);
    						}
        				break;
        		case 2: temp2 = ricercaDAO.trovaProdottoPerPrezzoMedio();
        				listaProdottiJl.clear();
						for(String s :temp2) {
							listaProdottiJl.add(s);
						}
						break;
        		case 3: temp3 = ricercaDAO.trovaProdottoPerPrezzoAlto();
        				listaProdottiJl.clear();
						for(String s :temp3) {
							
							listaProdottiJl.add(s);
						}
						break;
        		}
        		
        		if(cerealiCheck.isSelected()) {		
        			ArrayList<String> temp4 = null;
        			temp4 = ricercaDAO.trovaProdottoPerAllergeni("Cereali e derivati");
        			for(String s :temp4) {
        				listaProdottiJl.remove(s);

        			}
        			cerealiCheck.setSelected(false);
        		}
        		if(uovaCheck.isSelected()) {
        			ArrayList<String> temp5 = null;
        			temp5 = ricercaDAO.trovaProdottoPerAllergeni("Uova");
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
        		
        		resettaButton.setEnabled(true);
        		ricercaInternalFrame.setVisible(false);
        	}
        });
        cercaInternalButton.setBounds(477, 113, 89, 23);
        ricercaInternalFrame.getContentPane().add(cercaInternalButton);
        ricercaInternalFrame.setVisible(false);            
    }

    class MyListModel implements ListModel {
        @Override
        public int getSize() {
            return listaProdottiJl.size();
        }
        @Override
        public Object getElementAt(int index) {
            return listaProdottiJl.get(index);            
        }
        @Override
        public void addListDataListener(ListDataListener l) {
        }
        @Override
        public void removeListDataListener(ListDataListener l) {
        }	
    }
}   
