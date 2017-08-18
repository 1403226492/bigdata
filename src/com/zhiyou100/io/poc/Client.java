package com.zhiyou100.io.poc;

import java.util.List;
import java.io.File;

import com.zhiyou100.io.util.FileUtils;
import com.zhiyou100.io.util.LogUtils;

public class Client {

	public static void main(String[] args) {
		//System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS").format(new Date(System.currentTimeMillis())));
		//FileUtils.copyFile(new File("myproperties.properties"), new File("d:\\abc.txt"));
		
		List<File> files = FileUtils.listFilesByType(new File("D:\\bigdatafiles"), ".docx");
		
		File destFile = null;
		String fileName = null;
		for (File file : files) {
			fileName = "d:\\test\\" + file.getName();
			destFile = new File(fileName);
			FileUtils.copyFile(file, destFile);
			LogUtils.writeLog("d:\\mylog.log", System.currentTimeMillis()+"," + file.getAbsolutePath()+"," + fileName);
		}
	}

}
