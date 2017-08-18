package com.zhiyou100.io.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


public class FileUtils {
	
	private static Map<String, Integer> nameMap = new HashMap<String, Integer>();
	
	/**
	 * ����ָ����Ŀ¼����չ�����Ҹ�Ŀ¼�Լ���Ŀ¼��ָ����չ�����ļ�
	 * @param directory Ҫ���ҵ�Ŀ¼
	 * @param fileType Ҫ���ҵ��ļ���չ��
	 * @return
	 */
	public static List<File> listFilesByType(File directory,String fileType){
		/*
		 * ����С���ɣ���֤���ص�List��Ϊ�գ��������NullPointerException
		 */
		List<File> ret = new ArrayList<File>();
		File[] files = directory.listFiles();
		
		/*
		 * ��������Ҫ���п��ж�
		 */
		if(files!=null && files.length>0){
			for (File f:files) {
				if(f.isDirectory()){
					ret.addAll(listFilesByType(f, fileType));
				}else{
					if(f.getName().endsWith(fileType)){
						ret.add(f);
					}
				}
			}
		}
		
		return ret;
	}
	
	public static boolean createFile(File directory,String fileName){
		boolean ret = false;
		if(directory == null){
			System.out.println("��ָ��Ҫ�����ļ�������Ŀ¼��");
			ret = false;
		}
		if(fileName == null || fileName.trim().equals("")){
			System.out.println("��ָ��Ҫ�����ļ������ơ�");
			ret = false;
		}
		if(!directory.exists()){//���Ŀ¼�����ڣ��򴴽���Ŀ¼
			directory.mkdirs();
		}
		File targetFile = new File(directory,fileName);
		try {
			if(!targetFile.exists()){
				ret = targetFile.createNewFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	/**
	 * ɾ��ָ���ļ����µ��ļ���������Ŀ¼
	 * @param dir
	 * @return
	 */
	public static boolean  deleteFiles(File dir){
		boolean ret = false;
		if(dir == null || !dir.exists()){
			ret = false;
		}
		File[] toDeletes = dir.listFiles();
		if(toDeletes != null && toDeletes.length>0){
			for(File file : toDeletes){
				if (file.isDirectory()) {
					deleteFiles(file);
				}else{
					file.delete();
				}
			}
			
			ret = true;
		}
		return ret;
	}
	
	/**
	 * ��ָ��Ŀ¼������Ŀ¼�µ�ָ����չ�����ļ�������Ϊ�µ���չ�����������չ���ķ�ʽ
	 * @param directory
	 * @param currentExt
	 * @param extName
	 */
	public static void renameFiles(File directory,String currentExt,String extName){
		List<File> filesList = listFilesByType(directory, currentExt);
		for(File file : filesList){
			file.renameTo(new File(file.getAbsolutePath()+extName));
		}
		System.out.println("���������>>>>>>>>>>");
	}
	
	/**
	 * ��ָ����һ���ļ����Ƶ�ָ���ĵط�
	 * @param srcFile
	 * @param destFile
	 */
	public static void copyFile(File srcFile,File destFile){
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		if(destFile!=null && !destFile.isDirectory() && !destFile.exists()){
			try {
				destFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			fis = new FileInputStream(srcFile);
			fos = new FileOutputStream(destFile);
			byte[] buffer = new byte[1024];
			while (fis.read(buffer) != -1) {
				fos.write(buffer);
			} 
			fos.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(fis !=null){
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * ���������ļ��б�ѹ����ָ����ѹ�����У�zip��
	 * 
	 * 1.����Ҫ��ȡ���и������ļ�����Щ�������ļ�Ҫ�ṩ���ݸ�����Ҫʹ����������
	 * 2.����Ҫ�����Ķ������ļ����޷�ȷ���ļ����ı��ļ�������ͼƬ����Ƶ���������ͣ�����Ҫ���ã�
	 * �ֽ�����
	 * 3.�������е��ֽ�����InputStream��ϵ�ģ�����Ҫ���������ļ�������ѡ��FileInputStream��
	 * ����ʹ�ö�FileInputStream���н�һ���İ�װ���͡�
	 * 
	 * 
	 * a.����Ҫд���ݵ�ѹ���ļ��У�ѹ���ļ��Գ�����˵Ҫ���г�������ݣ���Ҫʹ���������
	 * b.�����Ҫ����������Ϊzip���޷�ȷ�����ֽ��������ַ��������ʱ�����Ҫѡ���ֽ�����
	 * c.����a��b�����������ʹ��ZipOutputStream
	 * @param zipFile
	 * @param files
	 * @return
	 */
	public static boolean zipFiles(File zipFile,List<File> files){
		boolean ret = false;
		
		/*
		 * ������ѹ���ļ���д����
		 */
		ZipOutputStream zos = null;
		
		/*
		 * ������ȡÿһ�������ı�ѹ�����ļ�
		 */
		FileInputStream fis = null;
		
		try {
			if(!zipFile.exists()){//���ѹ���ļ������ڣ��򴴽�һ���µ�ѹ���ļ�
				zipFile.createNewFile();
			}
			
			/*
			 * ��ѹ���ļ���ѹ�������й���
			 */
			zos = new ZipOutputStream(new FileOutputStream(zipFile));
			if(files!=null && !files.isEmpty()){
				ZipEntry entry = null;//�����ŵ�ѹ���ļ��е�һ��һ����ѹ����Ŀ
				
				/*
				 * ��ȡ��ѹ���ļ���Ҫ�Ļ�������һ������Ϊ2��n�η���
				 */
				byte[] buffer = new byte[1024];
				
				
				long startTime = 0;//��¼ѹ���Ŀ�ʼʱ��
				long endTime = 0;//��¼ѹ���Ľ���ʱ��
				for(File file : files){//�������е�ѹ���ļ�
					startTime = System.currentTimeMillis();
					if(nameMap.containsKey(file.getName())){
						Integer value = nameMap.get(file.getName());
						value++;//�Զ����
						nameMap.put(file.getName(), value);
						String newFileName = parseFileName(file.getName());
						/*
						 * ��ʼ��ѹ����Ŀ
						 */
						entry = new ZipEntry(newFileName);
						
					}else{
						nameMap.put(file.getName(), 0);
						/*
						 * ��ʼ��ѹ����Ŀ
						 */
						entry = new ZipEntry(file.getName());
					}
					
					
					/*
					 * ��ѹ����Ŀ�ŵ�ѹ���ļ��У��������Ŀ�л�û�����ݣ�
					 * ��Ҫ��һ����д���ݵ�ѹ����Ŀ�С�
					 */
					zos.putNextEntry(entry);
					
					/*
					 * ��ʼ����ȡ��ѹ���ļ�������������ѹ�������д��
					 */
					fis = new FileInputStream(file);
					while(fis.read(buffer) != -1){
						zos.write(buffer);
					}
					/*
					 * ����ÿ�ζ�ȡһ����ѹ���ļ������ļ�ʹ�����֮��Ͳ���ʹ���ˣ�
					 * ��Ҫ��ʹ����֮��رո������������ͷ���ռ�õ���Դ��
					 */
					fis.close();
					endTime = System.currentTimeMillis();
					System.out.println("�ļ���" + file.getName() +" ѹ����ɣ�����ʱ" +(endTime - startTime) +"����...");
				}
			}
			ret = true;
			System.out.println("��ѹ���� " + files.size() +"���ļ���");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(zos != null){
				try {
					zos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return ret;
	}

	private static String parseFileName(String name) {
		//abc.java abc_1.java
		String ret = null;
		String nameWithoutExt = name.substring(0, name.lastIndexOf("."));
		String extName = name.substring(name.lastIndexOf("."));
		ret = nameWithoutExt +"_" + nameMap.get(name) + extName;
		return ret;
	}
	
}
