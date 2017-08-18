package com.zhiyou100.desginpatterns.command;

public class NoodleWithNoSaltCommand implements ICommand {
	private Receiver receiver;

	public NoodleWithNoSaltCommand() {
	}

	public NoodleWithNoSaltCommand( Receiver receiver) {
		this.receiver = receiver;
	}

	public Receiver getReceiver() {
		return receiver;
	}

	public void setReceiver(Receiver receiver) {
		this.receiver = receiver;
	}

	@Override
	public void execute() {
		receiver.cooking("һ�벻Ҫ�β�Ҫ���������");
	}

}
