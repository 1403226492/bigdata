package com.zhiyou100.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * UDP��̵ķ������ˣ����ȵȴ���һֱ���ͻ��˷��������ݱ���
 * ע�⣺socketʹ����Ϻ�Ҫ�رգ���finally���С�
 * @author ayuw
 *
 */
public class UDPServer {
	
	/**
	 * ��������������˵��׼�ص����ĸ��������ĸ��˿ڣ�ip��������ĸ�������port
	 * ��������ĸ��˿ڣ�server�������˭�ڼ��
	 */
	private String ip;
	private int port;
	private DatagramSocket server;
	
	/**
	 * ����������ܺͷ��͵����ݡ��������Ϊ����������
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
		byte[] receiveBuffer = new byte[1024];//�������ݵĻ�����
		byte[] sendBuffer = new byte[1024];//�������ݵĻ�����
		System.out.println("����������ɹ�...............");
		try {
			/*
			 * ��ʼ���������ˣ�ָ����ص����ĸ��������ĸ��˿�
			 */
			server = new DatagramSocket(this.port,InetAddress.getByName(ip));
			/*
			 * ��ʼ���������ݵĿ���
			 */
			receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
			server.receive(receivePacket);//�������ݵ����ܿ���
			
			/*
			 *�����յ������ݹ������ַ��� 
			 */
			String receiveStr = new String(receivePacket.getData(), 0, receivePacket.getLength());
			System.out.println("����˽��յ����ݣ�" + receiveStr);
			
			/*
			 * ��ȡ���ݷ��Ͷ˵ĵ�ַ
			 */
			InetAddress address = receivePacket.getAddress();
			/*
			 * ��ȡ���ݷ��Ͷ˵ķ������ݵĶ˿ڣ����������ݰ�������˿�ԭ·��ȥ
			 */
			int clientPort = receivePacket.getPort();
			
			//System.out.println("�˿ڣ�" + clientPort);
			
			sendBuffer = "��ã������Ƿ���������Ӧ����Ϣ��".getBytes();//Ҫ���͵�����
			
			/*
			 * ���տͻ��˷������ݹ�����ʱ��ʹ�õĶ˿ںͿͻ��˵ĵ�ַ���������ݱ�
			 */
			sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, address, clientPort);
			server.send(sendPacket);//������Ӧ����
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
