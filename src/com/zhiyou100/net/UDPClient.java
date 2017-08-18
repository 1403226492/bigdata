package com.zhiyou100.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * UDPͨ�ŵĿͻ��ˣ����������˷������ݱ����ɽ��ܷ������Ӧ�����ݡ�
 * socketʹ�����֮��Ҫ���йرգ�һ����finally���С�
 * @author ayuw
 *
 */
public class UDPClient {
	private String ip;//ָ������Ҫ���͵�Ŀ���ip
	private int port;//ָ�����ݵ���Ŀ��ip��ͨ���ĸ��˿ڽ�������
	private DatagramSocket client;//���ݷ��͵Ŀͻ���
	
	
	private DatagramPacket receivePacket;//�������շ�������Ӧ������
	private DatagramPacket sendPacket;//�������������������
	
	
	
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
		byte[] receiveBuffer = new byte[1024];//�������ݵĻ�����
		byte[] sendBuffer = new byte[1024];//�������ݵĻ�����
		System.out.println("�ͻ��������ɹ�...............");
		try {
			sendBuffer = "����ǿͻ��˵Ĳ�������".getBytes();//Ҫ���͵����ݣ��������ֽ�����
			client = new DatagramSocket();//��ʼ�����Ϳͻ��ˣ�����Ҫָ����ַ�Ͷ˿ڣ���Щ��Ϣ��packet������
			/*
			 * �������ݵİ���Ҫ���÷�����Щ���ݣ��Լ����ݵĳ��Ⱥ�Ŀ���ַ�˿�
			 */
			sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, InetAddress.getByName(ip), this.port);
			client.send(sendPacket);//��������
			
			/*
			 * ��ʼ���������ݵİ�
			 */
			receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
			/*
			 * ���շ�������Ӧ������
			 */
			client.receive(receivePacket);
			
			/*
			 * ����������Ӧ�����ݹ������ַ���
			 */
			String receiveStr = new String(receivePacket.getData(), 0, receivePacket.getLength());
			System.out.println("�ͻ��˽��ܵ���������Ӧ������Ϊ��" + receiveStr);
			
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
