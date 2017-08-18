package com.zhiyou100.net;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class TestURL {

	public static void main(String[] args) {
		//testURL1();
		testURL2();
	}

	public static void testURL1() {
		URL baiduURL = null;
		URLConnection connection = null;
		InputStream is = null;
		FileOutputStream fos = null;
		try {
			baiduURL = new URL("http://image.baidu.com/search/index?tn=baiduimage&ct=201326592&lm=-1&cl=2&ie=gbk&word=%B9%FE%CA%BF%C6%E6&hs=0&fr=ala&ori_query=%E5%93%88%E5%A3%AB%E5%A5%87&ala=0&alatpl=sp&pos=0");
			connection = baiduURL.openConnection();
			
			is = connection.getInputStream();
			fos = new FileOutputStream(new File("d:\\baidu.html"));
			byte[] buffer = new byte[1024];
			while(is.read(buffer) != -1){
				fos.write(buffer);
			}
			fos.flush();
			System.out.println("read finished");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(fos != null){
					fos.close();
				}
				if(is != null){
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void testURL2() {
		URL baiduURL = null;
		HttpURLConnection connection = null;
		InputStream is = null;
		FileOutputStream fos = null;
		try {
			baiduURL = new URL("http://image.baidu.com/search/index?tn=baiduimage&ct=201326592&lm=-1&cl=2&ie=gbk&word=%B9%FE%CA%BF%C6%E6&hs=0&fr=ala&ori_query=%E5%93%88%E5%A3%AB%E5%A5%87&ala=0&alatpl=sp&pos=0");
			connection = (HttpURLConnection) baiduURL.openConnection();
			connection.setRequestMethod("POST");
			System.out.println(connection.getResponseCode());
			System.out.println(connection.getRequestMethod());
			System.out.println(connection.getResponseMessage());
			System.out.println(connection.getURL());
			System.out.println(connection.getContentEncoding());
			System.out.println(connection.getContentType());
			is = connection.getInputStream();
			fos = new FileOutputStream(new File("d:\\baidu.html"));
			byte[] buffer = new byte[1024];
			while(is.read(buffer) != -1){
				fos.write(buffer);
			}
			fos.flush();
			System.out.println("read finished");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(fos != null){
					fos.close();
				}
				if(is != null){
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
