package com.zhiyou100.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ����ͨ�ŵķ������ˣ��������տͻ��˵��������󣬲���ͻ��˷�����Ӧ��Ϣ��
 * �����̹����У�ǣ�浽�����������������ServerSocket��Socket��ʹ����Ϻ�һ��Ҫ�رա�
 * һ��ŵ�finally���д���
 * @author ayuw
 *
 */
public class TestServerSocket {
	
	/**
	 * ��¼����˼�ص�IP��ַ
	 */
	private String ip;
	
	/**
	 * ��¼����˼�صĶ˿�
	 */
	private int port;
	
	/**
	 * ServerSocket�������տͻ��˵����ӣ����յ����Ӻ󣬴��µ�Socket�Ϳͻ��˽���ͨ��
	 */
	private ServerSocket serverSocket;
	
	/**
	 * �Ϳͻ��˽���ͨ�ŵ�Socket
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
		System.out.println("�����������ɹ�............................");
		DataInputStream dis = null;
		DataOutputStream dos = null;
		String line = null;
		
		try {
			
			/*
			 * ��ServerSocket�����ض��Ķ˿�
			 */
			serverSocket = new ServerSocket(port);
			
			/*
			 * ���յ��ͻ��˵���������󣬴�һ���µ�Socket�Ϳͻ��˽���ͨ�ţ�
			 * ���һֱû�пͻ������ӣ���÷���һֱ���������ֱ���õ��˿ͻ��˵���������
			 */
			socket = serverSocket.accept();
			
			/*
			 * �������������õ��ͻ��˷��͵�����
			 */
			dis = new DataInputStream(socket.getInputStream());
			
			/*
			 * �����������ͻ��˷�������
			 */
			dos = new DataOutputStream(socket.getOutputStream());
			
			line = dis.readUTF();//��ȡ�ͻ��˷��͵����ݣ��ŵ�line������
			System.out.println("�յ��ͻ���:"+socket.getRemoteSocketAddress()+"���͵ģ�" +  line +"��Ϣ" );
			/*
			 *������Ӧ��Ϣ���ͻ��� 
			 */
			dos.writeUTF("���յ����Ͷ�����룺" + line  +"��ʽȷ�����账��");
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
