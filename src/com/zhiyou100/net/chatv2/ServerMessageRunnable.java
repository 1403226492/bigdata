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
		String target = null;// 连接的客户端要和哪个客户端进行通信
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
				
				System.out.println("服务器端收到：" + remoteIp + "发送给：" + target +"的消息：" + readedMessage.substring(readedMessage.indexOf("=")+1));
				
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
							dos.writeUTF(fromUser + "|" + readedMessage);//由于要使用读到的消息的头部信息，所以这里取消截取的操作
						//}
						
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			//先不关闭任何资源
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
	 * 检查输入的内容是不是命令
	 * @param readedMessage
	 * @return
	 */
	private boolean hasCommand(String readedMessage) {
		boolean ret = false;
		//001|002=XXXXXXX
		//~
		/*
		 *等号后边所有内容都被截取了 
		 *如果内容满足~XXXXX
		 */
		String tempStr = readedMessage.substring(readedMessage.indexOf("=")+1);
		ret = (tempStr.charAt(0) == '~');
		return ret;
	}

}
