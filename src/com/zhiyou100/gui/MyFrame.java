package com.zhiyou100.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class MyFrame extends JFrame {
	private LoginHeader header ;
	private LoginBody body;
	private LoginFooter footer;
	/**
	 * 
	 */
	private static final long serialVersionUID = 2756803353775939407L;
	
	public MyFrame() {
			this.setTitle("学生成绩查询系统");
			this.setLayout(new BorderLayout());
			
			header = new LoginHeader();
			body = new LoginBody();
			footer = new LoginFooter();
			this.getContentPane().add(header, BorderLayout.NORTH);
			this.getContentPane().add(body, BorderLayout.CENTER);
			this.getContentPane().add(footer, BorderLayout.SOUTH);
			event(footer);
			this.getContentPane().setBackground(new Color(0, 80, 80));
			this.getContentPane().setForeground(Color.MAGENTA);
			this.setBounds(300,300,300,300);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//this.pack();
			this.setVisible(true);
	}

	private void event(LoginFooter footer) {
		footer.getSubmitBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = body.getUsernameField().getText();
				String password = body.getPasswordField().getText();
				if("admin".equals(username) && "admin".equals(password)){
					MyFrame.this.setVisible(false);
					new LoginSuccess();
				}
			}
		});
		footer.getCancelBtn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) {
		new MyFrame();
	}
}
