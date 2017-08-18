package com.zhiyou100.io.homework;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class VidioMgr {
	public static void main(String[] args) throws IOException, InterruptedException {
		Runtime runtime = Runtime.getRuntime();
		
		String exeFile = "C:\\Program Files (x86)\\Thunder Network\\XMP\\V5.2.3.4936\\Bin\\XMP.exe";
		String resource = " d:\\易经的智慧23小畜卦-小有畜聚.rmvb ";
		Process process = runtime.exec(exeFile + resource);
		
		TimeUnit.SECONDS.sleep(10);
		
		process.destroy();
	}
}
