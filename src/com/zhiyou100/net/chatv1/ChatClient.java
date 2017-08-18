package com.zhiyou100.net.chatv1;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient {
	private String ip;
	private int port;
	
	private Socket socket;

	/**
	 * 
	 */
	public ChatClient() {
		super();
	}

	/**
	 * @param ip
	 * @param port
	 */
	public ChatClient(String ip, int port) {
		this.ip = ip;
		this.port = port;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
	
	public void init(){
		try {
			socket = new Socket(this.ip, this.port);
			System.out.println(socket.getInetAddress() +"启动中................");
			SendMessageRunnable sendMessage = new SendMessageRunnable(socket);
			ReceiveMessageRunnable receiveMessage = new ReceiveMessageRunnable(socket);
			new Thread(sendMessage,"客户端发送线程").start();
			new Thread(receiveMessage,"客户端接收线程").start();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			
		}
		
	}
}
