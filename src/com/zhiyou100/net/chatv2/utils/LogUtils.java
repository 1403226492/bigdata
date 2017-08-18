package com.zhiyou100.net.chatv2.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.zhiyou100.net.chatv2.entity.ChatRecord;

public class LogUtils {
	public static void writeLog(ChatRecord record,File targetFile){
		if(record ==null || targetFile == null){
			return;
		}
		if(record != null){
			PrintWriter pw = null;
			StringBuilder sb = new StringBuilder();
			sb.append(record.getFromUser()+"|");
			sb.append(record.getToUser()+"|");
			sb.append(String.format("%1$tF %1$tT",record.getChatTime())+"|");
			sb.append(record.getContent());
			if(targetFile !=null && !targetFile.exists()){
				try {
					targetFile.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			try {
				pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(targetFile,true)));
				pw.println(sb.toString());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}finally {
				if(pw != null){
					pw.close();
				}
			}
		}
	}
	
	public static void writeLog(String recordString,File targetFile){
		ChatRecord record = parseRecord(recordString);
		if(record !=null){
			writeLog(record,targetFile);
		}
	}
	
	public static List<ChatRecord> readLog(File srcFile){
		List<ChatRecord> ret = new ArrayList<ChatRecord>();
		if(srcFile != null && srcFile.exists()){
			BufferedReader reader = null;
			String line = null;
			ChatRecord record = null;
			try {
				reader = new BufferedReader(new FileReader(srcFile));
				
				while((line = reader.readLine()) != null){
					record = parseRecord(line);
					if(record != null){
						ret.add(record);
					}
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				if(reader != null){
					try {
						reader.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			
		}
		return ret;
	}

	private static ChatRecord parseRecord(String line) {
		ChatRecord record = null;
		if(line!=null && line.trim().length()>0){
			String[] arrays = line.split("\\|");
			if(arrays != null && arrays.length == 4){
				record = new ChatRecord();
				record.setFromUser(arrays[0]);
				record.setToUser(arrays[1]);
				try {
					record.setChatTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(arrays[2]));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				record.setContent(arrays[3]);
			}
		}
		return record;
	}
}
