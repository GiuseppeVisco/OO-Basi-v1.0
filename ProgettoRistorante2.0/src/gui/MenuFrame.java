package gui;
import dao.UtenteDAO;

import entity.Consegna;
import controller.Controller;
import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListDataListener;
import controller.Controller;
import entity.Prodotto;
import dao.AllergeneDAO;
import dao.ProdottoDAO;
import java.util.ArrayList;

public class MenuFrame extends JFrame {
	ProdottoDAO prodottoDAO = new ProdottoDAO();
	AllergeneDAO allergeneDAO = new AllergeneDAO();
	Controller controller;
	Consegna consegna;
	UtenteDAO utenteDAO;
	
    public ArrayList<String> listaProdottiJl = new ArrayList<>();
    public MenuFrame(Controller c) {
    	controller = c;
    	setTitle("Men\u00F9");
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 523);
		
        ArrayList<Prodotto> temp = null;
        temp = prodottoDAO.CaricaProdotti();
        for(Prodotto prodotto :temp) {
        	listaProdottiJl.add(prodotto.getNomeProdotto());
        }
        
        JInternalFrame checkOutInternalFrame = new JInternalFrame("Check Out");
        checkOutInternalFrame.setBounds(10, 25, 814, 412);
        getContentPane().add(checkOutInternalFrame);
        checkOutInternalFrame.getContentPane().setLayout(null);
        
        JButton btnNewButton = new JButton("Accetta");
        btnNewButton.setBounds(699, 286, 89, 35);
        checkOutInternalFrame.getContentPane().add(btnNewButton);
        

        
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
        
        JTextArea textArea = new JTextArea();
        textArea.setText("?$");
        textArea.setBounds(642, 249, 40, 22);
        checkOutInternalFrame.getContentPane().add(textArea);
        
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

        		
        				int x = listaCarrelloModel.getSize();
        				for(int i = 0; i < x; i++) {
        					String prodotto = listaCarrelloModel.elementAt(i).toString();
        					riepilogoCarrelloModel.addElement(prodotto);;
        			    }
        				listaCarrelloModel.clear();      	
                	
        	checkOutInternalFrame.setVisible(true);
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
        
        JButton ricercaButton = new JButton("Ricerca");
        ricercaButton.setBounds(327, 299, 89, 23);
        getContentPane().add(ricercaButton);
        
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
        			descrizioneTxt.setText(prodotto.getDescrizione()+".\nPREZZO: ["+prodotto.getPrezzoProdotto()+"€]\nALLERGENI: "+listaAllergeni);	
        		}
        		}
        	}
        });
        descrizioneButton.setBounds(174, 334, 103, 23);
        getContentPane().add(descrizioneButton);
        
        
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
