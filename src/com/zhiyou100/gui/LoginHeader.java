package com.zhiyou100.gui;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class LoginHeader extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8873401223477295519L;

	private JLabel headerLabel;
	
	public LoginHeader() {
		headerLabel = new JLabel("µÇ           Â¼");
		headerLabel.setBackground(Color.CYAN);
		headerLabel.setForeground(Color.BLUE);
		this.add(headerLabel);
	}
}
