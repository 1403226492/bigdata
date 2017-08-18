package com.zhiyou100.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * UDP编程的服务器端，首先等待。一直到客户端发送了数据报。
 * 注意：socket使用完毕后要关闭，在finally块中。
 * @author ayuw
 *
 */
public class UDPServer {
	
	/**
	 * 用来解决服务器端到底监控的是哪个机器的哪个端口，ip解决的是哪个机器，port
	 * 解决的是哪个端口，server解决的是谁在监控
	 */
	private String ip;
	private int port;
	private DatagramSocket server;
	
	/**
	 * 用来保存接受和发送的数据。可以理解为是两个筐子
	 */
	private DatagramPacket receivePacket;
	private DatagramPacket sendPacket;
	
	
	
	public UDPServer() {
	}
	
	public UDPServer( String ip,int port) {
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
		byte[] receiveBuffer = new byte[1024];//接受数据的缓冲区
		byte[] sendBuffer = new byte[1024];//发送数据的缓冲区
		System.out.println("服务端启动成功...............");
		try {
			/*
			 * 初始化服务器端，指定监控的是哪个网卡的哪个端口
			 */
			server = new DatagramSocket(this.port,InetAddress.getByName(ip));
			/*
			 * 初始化接受数据的筐子
			 */
			receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
			server.receive(receivePacket);//接收数据到接受筐子
			
			/*
			 *将接收到的数据构建成字符串 
			 */
			String receiveStr = new String(receivePacket.getData(), 0, receivePacket.getLength());
			System.out.println("服务端接收到数据：" + receiveStr);
			
			/*
			 * 获取数据发送端的地址
			 */
			InetAddress address = receivePacket.getAddress();
			/*
			 * 获取数据发送端的发送数据的端口，用来将数据按照这个端口原路进去
			 */
			int clientPort = receivePacket.getPort();
			
			//System.out.println("端口：" + clientPort);
			
			sendBuffer = "你好，这里是服务器端响应的消息。".getBytes();//要发送的内容
			
			/*
			 * 按照客户端发送数据过来的时候使用的端口和客户端的地址来发送数据报
			 */
			sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, address, clientPort);
			server.send(sendPacket);//发送响应数据
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(server != null && !server.isClosed()){
				server.close();
			}
		}
	}
	public static void main(String[] args) {
		new UDPServer("192.168.7.182",9999).init();
	}

}
