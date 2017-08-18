package com.zhiyou100.net.chatv2;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient {
	private String ip;
	private int port;
	
	private String uniqueId;
	
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
	public ChatClient(String ip, int port,String uniqueId) {
		this.ip = ip;
		this.port = port;
		this.uniqueId = uniqueId;
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
	
	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public void init(String targetId){
		DataOutputStream dos = null;
		try {
			socket = new Socket(this.ip, this.port);
			System.out.println(socket.getInetAddress()+"本人ID为：" + uniqueId +"启动中................");
			dos = new DataOutputStream(socket.getOutputStream()); 
			dos.writeUTF(uniqueId);
			SendMessageRunnable sendMessage = new SendMessageRunnable(socket,targetId,uniqueId);
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
