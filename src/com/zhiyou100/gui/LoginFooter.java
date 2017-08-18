package com.zhiyou100.gui;

import javax.swing.JButton;
import javax.swing.JPanel;

public class LoginFooter extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1943181760043132855L;

	private JButton submitBtn;
	private JButton cancelBtn;
	public LoginFooter() {
		submitBtn = new JButton("提交");
		cancelBtn = new JButton("取消");
		this.add(submitBtn);
		this.add(cancelBtn);
	}
	public JButton getSubmitBtn() {
		return submitBtn;
	}
	public void setSubmitBtn(JButton submitBtn) {
		this.submitBtn = submitBtn;
	}
	public JButton getCancelBtn() {
		return cancelBtn;
	}
	public void setCancelBtn(JButton cancelBtn) {
		this.cancelBtn = cancelBtn;
	}
	
	
}
