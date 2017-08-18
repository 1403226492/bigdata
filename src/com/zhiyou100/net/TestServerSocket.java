package com.zhiyou100.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 网络通信的服务器端，用来接收客户端的连接请求，并向客户端发送响应信息。
 * 网络编程过程中，牵涉到的输入流，输出流，ServerSocket，Socket在使用完毕后一定要关闭。
 * 一般放到finally块中处理。
 * @author ayuw
 *
 */
public class TestServerSocket {
	
	/**
	 * 记录服务端监控的IP地址
	 */
	private String ip;
	
	/**
	 * 记录服务端监控的端口
	 */
	private int port;
	
	/**
	 * ServerSocket用来接收客户端的连接，接收到连接后，打开新的Socket和客户端进行通信
	 */
	private ServerSocket serverSocket;
	
	/**
	 * 和客户端进行通信的Socket
	 */
	private Socket socket;
	
	public TestServerSocket(String ip,int port) {
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
		System.out.println("服务器启动成功............................");
		DataInputStream dis = null;
		DataOutputStream dos = null;
		String line = null;
		
		try {
			
			/*
			 * 让ServerSocket监听特定的端口
			 */
			serverSocket = new ServerSocket(port);
			
			/*
			 * 接收到客户端的连接请求后，打开一个新的Socket和客户端进行通信；
			 * 如果一直没有客户端连接，则该方法一直阻塞在这里，直到得到了客户端的连接请求。
			 */
			socket = serverSocket.accept();
			
			/*
			 * 输入流，用来得到客户端发送的数据
			 */
			dis = new DataInputStream(socket.getInputStream());
			
			/*
			 * 输出流用来向客户端发送数据
			 */
			dos = new DataOutputStream(socket.getOutputStream());
			
			line = dis.readUTF();//读取客户端发送的数据，放到line变量中
			System.out.println("收到客户端:"+socket.getRemoteSocketAddress()+"发送的：" +  line +"信息" );
			/*
			 *发送响应信息给客户端 
			 */
			dos.writeUTF("我收到你的投诉申请：" + line  +"正式确定不予处理！");
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if (dos != null) {
					dos.close();
				}
				if(dis != null){
					dis.close();
				}
				if(socket !=null && !socket.isClosed()){
					socket.close();
				}
				if(serverSocket != null && !serverSocket.isClosed()){
					serverSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new TestServerSocket("", 8888).init();
	}

}
