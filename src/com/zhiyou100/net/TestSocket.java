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
 * ����ͨ�ŵĿͻ��ˣ�����ͨ��ip��ַ���������Ͷ˿���������˽���ͨ�š�
 * ͨ�Ź�����ʹ�õ����������������Socket����֮��һ��Ҫ�رգ�һ�����finally���д���
 * @author ayuw
 *
 */
public class TestSocket {
	
	/**
	 * �ͻ���Ҫ���ӵ�ip��ַ
	 */
	private String ip;
	
	/**
	 * ����˼����Ķ˿ڣ�����˿�Ҫ�ͷ��������������Ķ˿ڱ���һ�¡�
	 */
	private int port;
	
	/**
	 * ͨ�ſͻ��ˣ���������ͷ����������ӣ��Լ����ܷ���������Ӧ��Ϣ���ɷ�����Ϣ��
	 */
	private Socket socket;
	
	/**
	 * �ͻ�����Ҫ���ӵķ�������ַ��װ��
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
			 * �½��ͻ���Socket
			 */
			socket = new Socket();
			
			/*
			 * �ͻ���Socket���ӷ���˼����ĵ�ַ�Ͷ˿�
			 */
			socket.connect(address);
			System.out.println("�ͻ��˷�������.................");
			
			/*
			 * ��������������ȡ��������Ӧ����Ϣ
			 */
			dis = new DataInputStream(socket.getInputStream());
			/*
			 * ������������������������Ϣ
			 */
			dos = new DataOutputStream(socket.getOutputStream());
			
			/*
			 * ���̣�������ȡ���̵�����
			 */
			keyboard = new BufferedReader(new InputStreamReader(System.in));
			String line = null;
			System.out.println("����д�����������ݣ�");
			line = keyboard.readLine();//���ռ��̵�һ������
			dos.writeUTF(line);
			String retBack = dis.readUTF();//�õ�����������Ӧ��
			System.out.println("��������Ӧ����ϢΪ�� " + retBack);
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
