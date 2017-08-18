package com.zhiyou100.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * 从键盘扫描输入的内容，写入到指定的文件中。
 * 1.从键盘扫描，意味着键盘要提供数据源供程序使用，这种情况下使用输入流；
 * 2.扫描的内容要写到文件中，这个时候，文件作为数据的目的地，使用输出流；
 * 处理的内容为文本，使用字符流，这个是时候需要使用的是：FileWriter。
 * @author ayuw
 *
 */
public class TestScanner {

	public static void main(String[] args) {
		File destFile = new File("abc.log");
		Scanner scanner = null;
		FileWriter writer = null;
		
		try {
			scanner = new Scanner(System.in);
			writer = new FileWriter(destFile,true);
			String line = null;
			while((line = scanner.nextLine()) != null){
				if("bye".equals(line)){
					break;
				}
				writer.write(line);
				writer.write("\r\n");
			}
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(scanner!=null){
					scanner.close();
				}
				if(writer!=null){
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
