package com.zhiyou100.io;

import java.io.File;

public class TestFile2 {

	public static void main(String[] args) {
		File file = new File("D:\\bigdatafiles\\docs\\20160808\\20160808随堂笔记.docx");
		
		System.out.println("文件是否存在：" + file.exists());
		System.out.println("是否为目录：" + file.isDirectory());
		System.out.println("文件的名称：" + file.getName());
		System.out.println("文件的路径：" + file.getPath());
		System.out.println("文件是否可读：" + file.canRead());
		System.out.println("文件是否可写：" + file.canWrite());
		System.out.println("文件的大小： " + (file.length()/1024)+"K");
		System.out.println("文件是否隐藏：" + file.isHidden());
		System.out.println("文件最后修改时间：" + String.format("%1$tF %1$tT", file.lastModified()));
	}

}
