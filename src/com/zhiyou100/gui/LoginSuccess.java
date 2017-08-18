package com.zhiyou100.gui;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class LoginSuccess extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4578881465810737503L;

	private JScrollPane pane;
	private JTable table;
	
	public LoginSuccess() {
		table = new JTable(DB.data, DB.columnsName);
		pane = new JScrollPane(table);
		this.add(pane);
		this.setBounds(300,300,300,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
