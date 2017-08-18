package com.zhiyou100.net.chatv2;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

import com.zhiyou100.net.chatv2.utils.LogUtils;
import com.zhiyou100.net.chatv2.utils.PropertiesUtils;

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
			String recordString = null;
			while(true){
				try{
					readed = dis.readUTF();
					recordString = parseRecordFromMessage(readed);
					if(recordString != null && !recordString.trim().equals("")){
						LogUtils.writeLog(recordString, new File("d:\\client_log_" + getToUser(recordString) +".log"));
					}
				}catch(SocketException e){
					break;
				}catch(EOFException e){
					break;
				}catch (Exception e) {
					e.printStackTrace();
				}
				if(readed.equals("bye")){
					break;
				}
				/*
				 * 001,002
				 * 002|001=µØ·½Èø·Ò
				 */
				if(readed != null && ((readed.trim().indexOf("|")) >= 0)){
					System.out.println(PropertiesUtils.getNicknameByAccount(readed.substring(0,readed.indexOf("|"))) + " :" + readed.substring(readed.indexOf("=")+1));
				}else{
					System.out.println(readed);
				}
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
	private String getToUser(String recordString) {
		String ret = null;
		ret = recordString.split("\\|")[1];
		return ret;
	}
	/**
	 * 001|002=XXXXXX
	 * @param readed
	 * @return
	 */
	private String parseRecordFromMessage(String readed) {
		StringBuffer sb = new StringBuffer();
		if(readed != null && readed.indexOf("|") >=0){
			sb.append(readed.substring(0,readed.indexOf("|")) +"|") ;
			sb.append(readed.substring(readed.indexOf("|")+1,readed.indexOf("=")) +"|");
			sb.append(String.format("%1$tF %1$tT", System.currentTimeMillis()) +"|");
			sb.append(readed.substring(readed.indexOf("=")+1));
		}
		return sb.toString();
	}

}
