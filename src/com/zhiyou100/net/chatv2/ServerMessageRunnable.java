package com.zhiyou100.net.chatv2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServerMessageRunnable implements Runnable {
	private Socket socket;

	private Map<String, Socket> socketMap = new HashMap<String, Socket>();
	private List<String> messageList = new ArrayList<String>();
	private String fromUser;

	/**
	 * @param socket
	 * @param socketMap
	 * @param messageList
	 */
	public ServerMessageRunnable(Socket socket, Map<String, Socket> socketMap, List<String> messageList,String fromUser) {
		this.socket = socket;
		this.socketMap = socketMap;
		this.messageList = messageList;
		this.fromUser = fromUser;
	}

	@Override
	public void run() {
		DataInputStream dis = null;
		String remoteIp = null;
		String readedMessage = null;
		String target = null;// ���ӵĿͻ���Ҫ���ĸ��ͻ��˽���ͨ��
		boolean hasCommand = false;
		try {
			while (true) {
				dis = new DataInputStream(socket.getInputStream());
				readedMessage = dis.readUTF();
				
				messageList.add(readedMessage);
				target = readedMessage.substring(0, readedMessage.indexOf("="));
				remoteIp = ((InetSocketAddress) socket.getRemoteSocketAddress()).getAddress().getHostAddress();
				hasCommand = hasCommand(readedMessage);
				//~ls
				if(hasCommand){
					dealCommand(socket,readedMessage);
					continue;
				}
				
				System.out.println("���������յ���" + remoteIp + "���͸���" + target +"����Ϣ��" + readedMessage.substring(readedMessage.indexOf("=")+1));
				
				if (socketMap != null && socketMap.size() > 0) {
					Socket temp = null;
					DataOutputStream dos = null;
					if (socketMap.containsKey(target)) {
						temp = socketMap.get(target);
						dos = new DataOutputStream(temp.getOutputStream());
//						
//						hasCommand = hasCommand(readedMessage);
//						
//						if(hasCommand){
//							dealCommand(socket,readedMessage);
//						}else{
//							
							//001|002=XXXXXX
							dos.writeUTF(fromUser + "|" + readedMessage);//����Ҫʹ�ö�������Ϣ��ͷ����Ϣ����������ȡ����ȡ�Ĳ���
						//}
						
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			//�Ȳ��ر��κ���Դ
		}
	}

	private void dealCommand(Socket srcSocket, String readedMessage) {
		String tempStr = readedMessage.substring(readedMessage.indexOf("=")+1);
		//~ls
		String command = tempStr.substring(1, 3);
		
		try {
			DataOutputStream dos = new DataOutputStream(srcSocket.getOutputStream());
			if(command.equals("ls")){
				dos.writeUTF(getAllOnlineUsers(socketMap));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String getAllOnlineUsers(Map<String, Socket> socketMap2) {
		StringBuffer sb = new StringBuffer();
		if(socketMap2 != null && socketMap2.size()>0){
			for (Map.Entry<String, Socket> entry : socketMap2.entrySet()) {
				sb.append(entry.getKey()+",");
			}
		}
		String  ret = sb.substring(0, sb.length()-1);
		return ret;
	}

	/**
	 * �������������ǲ�������
	 * @param readedMessage
	 * @return
	 */
	private boolean hasCommand(String readedMessage) {
		boolean ret = false;
		//001|002=XXXXXXX
		//~
		/*
		 *�Ⱥź���������ݶ�����ȡ�� 
		 *�����������~XXXXX
		 */
		String tempStr = readedMessage.substring(readedMessage.indexOf("=")+1);
		ret = (tempStr.charAt(0) == '~');
		return ret;
	}

}
