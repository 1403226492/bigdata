package com.zhiyou100.net.chatv1;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatServer {
	private String ip;
	private int port;
	
	private ServerSocket server;
	private Socket socket;
	/**
	 * 
	 */
	public ChatServer() {
		super();
	}
	
	
	/**
	 * @param ip
	 * @param port
	 */
	public ChatServer(String ip, int port) {
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
	
	public void init() {
		System.out.println("服务器启动中............");
		try {
			server = new ServerSocket(this.port, 100, InetAddress.getByName(ip));
			while(true) {
				socket = server.accept();
				SendMessageRunnable sendMessage = new SendMessageRunnable(socket);
				ReceiveMessageRunnable receiveMessage = new ReceiveMessageRunnable(socket);
				new Thread(sendMessage,"发送消息线程").start();
				new Thread(receiveMessage).start();
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(socket != null && !socket.isClosed()){
					socket.close();
				}
				if(server != null && !server.isClosed()){
					server.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new ChatServer("192.168.7.182",8888).init();
	}
}
