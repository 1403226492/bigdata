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
	 * 根据指定的目录和扩展名查找该目录以及子目录下指定扩展名的文件
	 * @param directory 要查找的目录
	 * @param fileType 要查找的文件扩展名
	 * @return
	 */
	public static List<File> listFilesByType(File directory,String fileType){
		/*
		 * 编码小技巧，保证返回的List不为空，不会出现NullPointerException
		 */
		List<File> ret = new ArrayList<File>();
		File[] files = directory.listFiles();
		
		/*
		 * 返回数组要进行空判断
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
			System.out.println("请指定要创建文件的所处目录。");
			ret = false;
		}
		if(fileName == null || fileName.trim().equals("")){
			System.out.println("请指定要创建文件的名称。");
			ret = false;
		}
		if(!directory.exists()){//如果目录不存在，则创建该目录
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
	 * 删除指定文件夹下的文件，不包含目录
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
	 * 将指定目录及其子目录下的指定扩展名的文件重命名为新的扩展名，以添加扩展名的方式
	 * @param directory
	 * @param currentExt
	 * @param extName
	 */
	public static void renameFiles(File directory,String currentExt,String extName){
		List<File> filesList = listFilesByType(directory, currentExt);
		for(File file : filesList){
			file.renameTo(new File(file.getAbsolutePath()+extName));
		}
		System.out.println("重命名完毕>>>>>>>>>>");
	}
	
	/**
	 * 将指定的一个文件复制到指定的地方
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
	 * 将给定的文件列表压缩到指定的压缩包中（zip）
	 * 
	 * 1.由于要读取所有给定的文件，这些给定的文件要提供数据给程序，要使用输入流；
	 * 2.由于要操作的对象是文件，无法确认文件是文本文件或者是图片，视频等其他类型，所以要采用，
	 * 字节流。
	 * 3.输入流中的字节流是InputStream体系的，由于要操作的是文件，可以选择FileInputStream，
	 * 或者使用对FileInputStream进行进一步的包装类型。
	 * 
	 * 
	 * a.由于要写内容到压缩文件中，压缩文件对程序来说要是有程序的数据，需要使用输出流。
	 * b.输出流要操作的内容为zip，无法确认是字节流还是字符流，这个时候就需要选择字节流。
	 * c.鉴于a，b描述的情况，使用ZipOutputStream
	 * @param zipFile
	 * @param files
	 * @return
	 */
	public static boolean zipFiles(File zipFile,List<File> files){
		boolean ret = false;
		
		/*
		 * 用来向压缩文件中写内容
		 */
		ZipOutputStream zos = null;
		
		/*
		 * 用来读取每一个给定的被压缩的文件
		 */
		FileInputStream fis = null;
		
		try {
			if(!zipFile.exists()){//如果压缩文件不存在，则创建一个新的压缩文件
				zipFile.createNewFile();
			}
			
			/*
			 * 将压缩文件和压缩流进行关联
			 */
			zos = new ZipOutputStream(new FileOutputStream(zipFile));
			if(files!=null && !files.isEmpty()){
				ZipEntry entry = null;//用来放到压缩文件中的一个一个的压缩条目
				
				/*
				 * 读取被压缩文件需要的缓冲区，一般设置为2的n次方倍
				 */
				byte[] buffer = new byte[1024];
				
				
				long startTime = 0;//记录压缩的开始时间
				long endTime = 0;//记录压缩的结束时间
				for(File file : files){//遍历所有的压缩文件
					startTime = System.currentTimeMillis();
					if(nameMap.containsKey(file.getName())){
						Integer value = nameMap.get(file.getName());
						value++;//自动拆包
						nameMap.put(file.getName(), value);
						String newFileName = parseFileName(file.getName());
						/*
						 * 初始化压缩条目
						 */
						entry = new ZipEntry(newFileName);
						
					}else{
						nameMap.put(file.getName(), 0);
						/*
						 * 初始化压缩条目
						 */
						entry = new ZipEntry(file.getName());
					}
					
					
					/*
					 * 将压缩条目放到压缩文件中，这个是条目中还没有内容，
					 * 需要进一步的写内容到压缩条目中。
					 */
					zos.putNextEntry(entry);
					
					/*
					 * 初始化读取被压缩文件的输入流，供压缩输出流写出
					 */
					fis = new FileInputStream(file);
					while(fis.read(buffer) != -1){
						zos.write(buffer);
					}
					/*
					 * 由于每次读取一个被压缩文件，该文件使用完毕之后就不再使用了，
					 * 需要在使用完之后关闭该输入流，以释放其占用的资源。
					 */
					fis.close();
					endTime = System.currentTimeMillis();
					System.out.println("文件：" + file.getName() +" 压缩完成，共用时" +(endTime - startTime) +"毫秒...");
				}
			}
			ret = true;
			System.out.println("共压缩： " + files.size() +"个文件！");
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
