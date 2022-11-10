package com.ailpha.common.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 文件操作类
 *
 * @author ailpha
 *
 */
public class FilesUtil {
	
	private static Logger logger = LoggerFactory.getLogger(FilesUtil.class);
	
	/**
	 * create new file name to save
	 * @param fileName
	 * @return
	 */
	public static String createFileNameToSave(String fileName){
		if(fileName == null || "".equals(fileName)){
			return null;
		}
		if(!fileName.contains(".")){
			return UUID.randomUUID().toString();
		}
		return UUID.randomUUID() + fileName.substring(fileName.lastIndexOf("."));
	}
	
	/**
	 * save file
	 * @param is file-inputStream
	 * @param finalFilePath finally-saving-filepath
	 */
	public static boolean saveFile(InputStream is,String finalFilePath){
		boolean flag = true;
		File finalFile = new File(finalFilePath);
		if(!finalFile.getParentFile().exists()){
			finalFile.getParentFile().mkdirs();
		}
		OutputStream os = null;
		try {
			os = new FileOutputStream(finalFile);
			byte[] bytes = new byte[1024];
			int temp = 0;
			while((temp = is.read(bytes))!=-1){
				os.write(bytes, 0, temp);
			}
		} catch (Exception e) {
			flag = false;
			logger.error("Reading inputStream or Writing outputStream throws Exception .", e);
		}finally{
			try {
				os.close();
			} catch (Exception e2) {
				logger.error("OutputStream can't be closed and throw Exception .", e2);
			}
		}
		return flag ;
	}

}
