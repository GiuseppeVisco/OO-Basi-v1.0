package gui;

import java.awt.BorderLayout;
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

import entity.Prodotto;
import dao.ProdottoDAO;
import java.util.ArrayList;

public class MenuFrame extends JFrame {
	ProdottoDAO prodottoDAO = new ProdottoDAO();
    public ArrayList<String> listaProdottiJl = new ArrayList<>();
    public MenuFrame() {
    	setTitle("Men\u00F9");
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 523);
		
        ArrayList<Prodotto> temp = null;
        temp = prodottoDAO.CaricaProdotti();
        for(Prodotto prodotto :temp) {
        	listaProdottiJl.add(prodotto.getNomeProdotto()+" ["+prodotto.getPrezzoProdotto()+"€]");       	
        }
        
        MyListModel lm = new MyListModel();
        getContentPane().setLayout(null);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(164, 114, 150, 205);
        getContentPane().add(scrollPane);
        JList l = new JList(lm);
        scrollPane.setViewportView(l);
        l.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(426, 114, 150, 205);
        getContentPane().add(scrollPane_1);
        
        JList list = new JList();
        scrollPane_1.setViewportView(list);
        
        JButton btnNewButton = new JButton("Aggiungi >");
        btnNewButton.setBounds(327, 151, 97, 23);
        getContentPane().add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("< Rimuovi");
        btnNewButton_1.setBounds(321, 243, 92, 23);
        getContentPane().add(btnNewButton_1);
        
        JButton btnNewButton_2 = new JButton("Conferma");
        btnNewButton_2.setBounds(455, 330, 105, 30);
        getContentPane().add(btnNewButton_2);
        
        JButton btnNewButton_3 = new JButton("Log Out");
        btnNewButton_3.setBounds(10, 414, 89, 23);
        getContentPane().add(btnNewButton_3);
        
        JLabel lblNewLabel = new JLabel("Men\u00F9 Principale");
        lblNewLabel.setBounds(164, 89, 113, 23);
        getContentPane().add(lblNewLabel);
        
        JLabel lblCarrello = new JLabel("Carrello");
        lblCarrello.setBounds(426, 89, 81, 23);
        getContentPane().add(lblCarrello);
        
        JButton btnNewButton_4 = new JButton("Ricerca");
        btnNewButton_4.setBounds(188, 334, 89, 23);
        getContentPane().add(btnNewButton_4);
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