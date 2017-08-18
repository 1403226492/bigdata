package com.zhiyou100.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 将该java文件输出到控制台，根据我们的设计原则，要操作的对象是文件（当前java文件），文件是作为数据
 * 的提供者为程序服务，所以要选择输入流；该文件是纯文本文件，有限选择字符流（FileReader）；由于我们心理
 * 的特殊需要有，这里选择FileInputStream作为输入流；
 * 
 * 最终要实现的效果是将该java文件的内容，逐行打印到控制台，要操作的对象是控制台，对程序来说程序是作为数据提供者，
 * 传输到控制台供控制台显示，所有使用输出流；输入流优先选择的是FileReader，那么打印到控制台优先选择PrintWriter，
 * 这里就使用PrintWriter
 * 
 * @author ayuw
 *
 */
public class TestFileInputStream {

	public static void main(String[] args) {
		// testReadFile1();
		File javaFile = new File(
				"D:\\devtools\\bigdataworkspace\\bigdata\\src\\com\\zhiyou100\\io\\TestFileInputStream.java");

		FileInputStream fis = null;
		PrintWriter writer = null;

		try {
			fis = new FileInputStream(javaFile);
			writer = new PrintWriter(System.out);
			byte[] buffer = new byte[1024];
			while (fis.read(buffer) != -1) {
				writer.write(new String(buffer));
			}
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void testReadFile1() {
		File javaFile = new File(
				"D:\\devtools\\bigdataworkspace\\bigdata\\src\\com\\zhiyou100\\io\\TestFileInputStream.java");

		FileInputStream fis = null;
		PrintWriter writer = null;

		try {
			fis = new FileInputStream(javaFile);
			writer = new PrintWriter(System.out);
			int readed = 0;
			while ((readed = fis.read()) != -1) {
				writer.write(readed);
			}
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
