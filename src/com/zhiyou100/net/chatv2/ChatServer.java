package com.zhiyou100.net.chatv2;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatServer {
	private String ip;
	private int port;
	
	private ServerSocket server;
	private Socket socket;
	
	private Map<String, Socket> socketMap = new HashMap<String, Socket>();
	private List<String> messageList = new ArrayList<String>();
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
		DataInputStream dis = null;
		try {
			server = new ServerSocket(this.port, 100, InetAddress.getByName(ip));
			System.out.println("............服务器："+server.getLocalSocketAddress()+",启动成功............");
			//String remoteIp = null;
			String registerInfo = null;
			while(true) {
				socket = server.accept();
				dis = new DataInputStream(socket.getInputStream());
				registerInfo = dis.readUTF();
				System.out.println("客户端：" + registerInfo +":已经连接，客户端IP为：" + ((InetSocketAddress)socket.getRemoteSocketAddress()).getAddress().getHostAddress());
				//remoteIp = ((InetSocketAddress)socket.getRemoteSocketAddress()).getAddress().getHostAddress();
				socketMap.put(registerInfo, socket);//每个socket连接过来之后都要注册一下
				ServerMessageRunnable serverMessageRunnable = new ServerMessageRunnable(socket, socketMap, messageList,registerInfo);
				new Thread(serverMessageRunnable).start();
				
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
