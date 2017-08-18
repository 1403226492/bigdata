package com.zhiyou100.net;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * 网络通信的客户端，用来通过ip地址或者域名和端口与服务器端进行通信。
 * 通信过程中使用的输入流，输出流，Socket用完之后一定要关闭，一般放在finally块中处理。
 * @author ayuw
 *
 */
public class TestSocket {
	
	/**
	 * 客户端要连接的ip地址
	 */
	private String ip;
	
	/**
	 * 服务端监听的端口，这个端口要和服务器真正监听的端口保持一致。
	 */
	private int port;
	
	/**
	 * 通信客户端，用来发起和服务器的连接，以及接受服务器的响应信息并可发送信息。
	 */
	private Socket socket;
	
	/**
	 * 客户端需要连接的服务器地址封装器
	 */
	private SocketAddress address;
	
	public TestSocket(String ip,int port) {
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
		address = new InetSocketAddress(ip, port);
		
		
		DataInputStream dis = null;
		DataOutputStream dos = null;
		BufferedReader keyboard = null;
		
		try {
			
			/*
			 * 新建客户端Socket
			 */
			socket = new Socket();
			
			/*
			 * 客户端Socket连接服务端监听的地址和端口
			 */
			socket.connect(address);
			System.out.println("客户端发起连接.................");
			
			/*
			 * 输入流，用来获取服务器响应的信息
			 */
			dis = new DataInputStream(socket.getInputStream());
			/*
			 * 输出流，用来向服务器发送信息
			 */
			dos = new DataOutputStream(socket.getOutputStream());
			
			/*
			 * 键盘，用来获取键盘的输入
			 */
			keyboard = new BufferedReader(new InputStreamReader(System.in));
			String line = null;
			System.out.println("请填写您的申诉内容：");
			line = keyboard.readLine();//接收键盘的一行输入
			dos.writeUTF(line);
			String retBack = dis.readUTF();//得到服务器的响应新
			System.out.println("服务器响应的信息为： " + retBack);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(keyboard != null){
					keyboard.close();
				}
				if(dis != null){
					dis.close();
				}
				if(dos != null){
					dos.close();
				}
				if(socket != null && !socket.isClosed()){
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new  TestSocket("127.0.0.1", 8888).init();
	}

}
