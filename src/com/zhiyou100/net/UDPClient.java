package com.zhiyou100.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * UDP通信的客户端，用来向服务端发送数据报并可接受服务端响应的数据。
 * socket使用完毕之后要进行关闭，一般在finally块中。
 * @author ayuw
 *
 */
public class UDPClient {
	private String ip;//指定数据要发送的目标的ip
	private int port;//指定数据到达目标ip后通过哪个端口进入计算机
	private DatagramSocket client;//数据发送的客户端
	
	
	private DatagramPacket receivePacket;//用来接收服务器响应的数据
	private DatagramPacket sendPacket;//用来向服务器发送数据
	
	
	
	public UDPClient() {
	}
	
	public UDPClient( String ip,int port) {
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
		byte[] receiveBuffer = new byte[1024];//接收数据的缓冲区
		byte[] sendBuffer = new byte[1024];//发送数据的缓冲区
		System.out.println("客户端启动成功...............");
		try {
			sendBuffer = "这个是客户端的测试数据".getBytes();//要发送的内容，构建成字节数组
			client = new DatagramSocket();//初始化发送客户端，不需要指定地址和端口，这些信息在packet中设置
			/*
			 * 发送数据的包，要设置发送哪些数据，以及数据的长度和目标地址端口
			 */
			sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, InetAddress.getByName(ip), this.port);
			client.send(sendPacket);//发送数据
			
			/*
			 * 初始化接收数据的包
			 */
			receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
			/*
			 * 接收服务器响应的数据
			 */
			client.receive(receivePacket);
			
			/*
			 * 将服务器响应的数据构建成字符串
			 */
			String receiveStr = new String(receivePacket.getData(), 0, receivePacket.getLength());
			System.out.println("客户端接受到服务器响应的数据为：" + receiveStr);
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(client != null && !client.isClosed()){
				client.close();
			}
		}
	}
	public static void main(String[] args) {
		new UDPClient("192.168.7.182",9999).init();
	}

}
