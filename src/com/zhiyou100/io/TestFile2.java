package com.zhiyou100.io;

import java.io.File;

public class TestFile2 {

	public static void main(String[] args) {
		File file = new File("D:\\bigdatafiles\\docs\\20160808\\20160808���ñʼ�.docx");
		
		System.out.println("�ļ��Ƿ���ڣ�" + file.exists());
		System.out.println("�Ƿ�ΪĿ¼��" + file.isDirectory());
		System.out.println("�ļ������ƣ�" + file.getName());
		System.out.println("�ļ���·����" + file.getPath());
		System.out.println("�ļ��Ƿ�ɶ���" + file.canRead());
		System.out.println("�ļ��Ƿ��д��" + file.canWrite());
		System.out.println("�ļ��Ĵ�С�� " + (file.length()/1024)+"K");
		System.out.println("�ļ��Ƿ����أ�" + file.isHidden());
		System.out.println("�ļ�����޸�ʱ�䣺" + String.format("%1$tF %1$tT", file.lastModified()));
	}

}
