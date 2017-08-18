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
			System.out.println(socket.getInetAddress() +"������................");
			SendMessageRunnable sendMessage = new SendMessageRunnable(socket);
			ReceiveMessageRunnable receiveMessage = new ReceiveMessageRunnable(socket);
			new Thread(sendMessage,"�ͻ��˷����߳�").start();
			new Thread(receiveMessage,"�ͻ��˽����߳�").start();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			
		}
		
	}
}
