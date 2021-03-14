package gui;

import controller.Controller;
import entity.Prodotto;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;

import dao.ConsegnaDAO;
import entity.Consegna;

public class StoricoConsegneFrame extends JFrame {
    Controller controller;
    private JPanel contentPane;
    ConsegnaDAO consegnaDAO = new ConsegnaDAO();


    public StoricoConsegneFrame(Controller c) {
    	setTitle("Storico consegne");
        controller = c;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(10, 25, 814, 412);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(0, 6, 0, 0));

        JLabel j0 = new JLabel("ID CONSEGNA");
        JLabel j1 = new JLabel("EMAIL UTENTE");
        JLabel j2 = new JLabel("INDIRIZZO RISTORANTE");
        JLabel j3 = new JLabel("INDIRIZZO CONSEGNA");
        JLabel j4 = new JLabel("ID RIDER");
        JLabel j5 = new JLabel("COSTO TOTALE");
        j0.setFont(new Font("Serif", Font.BOLD, 15));
        j1.setFont(new Font("Serif", Font.BOLD, 15));
        j2.setFont(new Font("Serif", Font.BOLD, 15));
        j3.setFont(new Font("Serif", Font.BOLD, 15));
        j4.setFont(new Font("Serif", Font.BOLD, 15));
        j5.setFont(new Font("Serif", Font.BOLD, 15));
        contentPane.add(j0);
        contentPane.add(j1);
        contentPane.add(j2);
        contentPane.add(j3);
        contentPane.add(j4);
        contentPane.add(j5);


        ArrayList<Consegna> temp = null;
        temp = consegnaDAO.listaConsegne();
        for(Consegna consegna :temp) {
        
        	JLabel p = new JLabel("["+consegna.getIdConsegna()+"]");
            JLabel y = new JLabel(consegna.getUsernameUtente());
            JLabel v = new JLabel(consegna.getIndirizzoRistorante());
            JLabel b = new JLabel(consegna.getIndirizzoConsegna());
            JLabel f = new JLabel(consegna.getIdRider());
            JLabel n = new JLabel(""+consegna.getTotale()+"€");
            
            
            contentPane.add(p);
            contentPane.add(y);
            contentPane.add(v);
            contentPane.add(b);
            contentPane.add(f);
            contentPane.add(n);
        }
       

    }



}