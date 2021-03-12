package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controller;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JTable;
import java.awt.Color;

public class ResearchFrame extends JFrame {

	private JPanel contentPane;
	private Controller controller;
	private JTable table;
	
	public ResearchFrame(Controller c) {
		controller = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1176, 661);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBackground(Color.WHITE);
		table.setBounds(777, 533, 267, -419);
		contentPane.add(table);
	}
}
