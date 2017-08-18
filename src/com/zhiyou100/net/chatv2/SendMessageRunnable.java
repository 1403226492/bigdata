package com.zhiyou100.net.chatv2;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import com.zhiyou100.net.chatv2.utils.LogUtils;

public class SendMessageRunnable implements Runnable {
	private Socket socket;
	private String targetId;
	private String uniqueId;
	public SendMessageRunnable(Socket socket,String targetId,String uniqueId) {
		this.socket = socket;
		this.targetId = targetId;
		this.uniqueId = uniqueId;
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
				dos.writeUTF( targetId + "=" +line);
				LogUtils.writeLog(uniqueId+"|" + targetId +"|" + String.format("%1$tF %1$tT", System.currentTimeMillis())+"|" + line, new File("d:\\client_log_" + uniqueId +".log"));
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
