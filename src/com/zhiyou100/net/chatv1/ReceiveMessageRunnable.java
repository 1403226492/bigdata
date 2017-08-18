package com.zhiyou100.net.chatv1;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

public class ReceiveMessageRunnable implements  Runnable {
	private Socket socket;
	
	public ReceiveMessageRunnable(Socket socket) {
		this.socket = socket;
	}
	@Override
	public void run() {
		DataInputStream dis = null;
		
		try {
			dis = new DataInputStream(socket.getInputStream());
			
			String readed = null;
			while(true){
				try{
					readed = dis.readUTF();
				}catch(SocketException e){
					break;
				}catch(EOFException e){
					break;
				}
				if(readed.equals("bye")){
					break;
				}
				System.out.println("Ω” ’µΩ£∫ " + socket.getInetAddress() +" :" + readed);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(dis != null){
					dis.close();
				}
				if(socket != null && !socket.isClosed()){
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
