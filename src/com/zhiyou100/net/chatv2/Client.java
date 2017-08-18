package com.zhiyou100.net.chatv2;

public class Client {

	public static void main(String[] args) {
		new ChatClient("192.168.7.182", 8888, args[0]).init(args[1]);
	}

}
