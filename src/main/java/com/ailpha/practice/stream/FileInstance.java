package com.ailpha.practice.stream;

import java.io.*;
import java.util.Arrays;

public class FileInstance {
	public static void main(String[] args) {
		// File
		File file = new File("e:\\");
		if(file.exists()){
			if(file.isDirectory()){
				File[] fileArray = file.listFiles();
				System.out.println(Arrays.toString(fileArray));
			}
			System.out.println(file.getParent());
		}
		
		// OutputStream
		file = new File("e:\\fys.txt");
		if(!file.exists()){
			try {
				OutputStream os = new FileOutputStream(file);
				byte[] bytes = "fuyunsong".getBytes();
				os.write(bytes);
				os.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// InputStream
		if(file.exists()){
			try {
				InputStream is = new FileInputStream(file);
				byte[] bytes = new byte[1024];
				int result = 0;
				while(result != -1){
					result = is.read(bytes);
				}
				System.out.println(new String(bytes));
				is.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// Writer
		if(file.exists()){
			try {
				Writer writer = new FileWriter(file ,true);
				writer.append("0822");
				writer.flush();
				writer.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// Reader
		if(file.exists()){
			try {
				Reader reader = new FileReader(file);
				char[] chars = new char[1024];
				reader.read(chars);
				System.out.println(Arrays.toString(chars));
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// OutputStreamWriter
		if(file.exists()){
			try {
				Writer writer = new OutputStreamWriter(new FileOutputStream(file));
				writer.write("I LOVE YOU");
				writer.flush();
				writer.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// InputStreamReader
		if(file.exists()){
			try {
				Reader reader = new InputStreamReader(new FileInputStream(file));
				char[] chars = new char[1024];
				reader.read(chars);
				System.out.println(Arrays.toString(chars));
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
