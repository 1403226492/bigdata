package com.zhiyou100.net.chatv1;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class SendMessageRunnable implements Runnable {
	private Socket socket;
	
	public SendMessageRunnable(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		BufferedReader keyboard = null;
		DataOutputStream dos = null;
		
		try {
			keyboard = new BufferedReader(new InputStreamReader(System.in));
			dos = new DataOutputStream(socket.getOutputStream());
			
			String line = null;
			while(true){
				line = keyboard.readLine();
				if(line.equals("bye")){
					break;
				}
				dos.writeUTF(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(keyboard != null){
					keyboard.close();
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

}
