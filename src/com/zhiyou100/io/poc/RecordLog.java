package com.zhiyou100.io.poc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class RecordLog {
	public static void main(String[] args) throws Exception {
		File logFile = new File("log.log");
		if (!logFile.exists()) {//如果文件不存在，则创建一个新的
			logFile.createNewFile();
		}
		
		Record record = new Record();
		record.setSrcName("srcName");
		record.setDestName("destName");
		record.setIp("127.0.0.1");
		record.setOperateTime(System.currentTimeMillis());
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(logFile,true));
		
		oos.writeObject(record);
		
		
		record = new Record();
		record.setSrcName("srcName2");
		record.setDestName("destName2");
		record.setOperateTime(System.currentTimeMillis());
		record.setIp("127.0.0.2");
		oos.writeObject(record);
		
		
		oos.flush();
		oos.close();
		System.out.println("operate successed!");
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(logFile));
		
		Object  readed = null;
		try{
			while ((readed = ois.readObject() )!=null) {
				System.out.println(readed);
			}
		}catch(Exception e){
			//e.printStackTrace();
		}finally {
			ois.close();
		}
	}
}
