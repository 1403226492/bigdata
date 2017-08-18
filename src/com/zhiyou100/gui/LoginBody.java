package com.zhiyou100.gui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginBody extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel usernameLabel;
	private JTextField usernameField;
	private JLabel passwordLabel;
	private JPasswordField passwordField;
	public LoginBody() {
		usernameLabel = new JLabel("’À∫≈£∫" );
		usernameField = new JTextField(20);
		passwordLabel = new JLabel("√‹¬Î£∫" );
		passwordField = new JPasswordField(20);
		
		this.add(usernameLabel);
		this.add(usernameField);
		this.add(passwordLabel);
		this.add(passwordField);
		
	}
	public JTextField getUsernameField() {
		return usernameField;
	}
	public void setUsernameField(JTextField usernameField) {
		this.usernameField = usernameField;
	}
	public JPasswordField getPasswordField() {
		return passwordField;
	}
	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}
	
	
}
