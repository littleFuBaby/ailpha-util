package com.ailpha.practice.stream;

import java.io.*;
import java.util.Date;

public class DownloadFileInstance {

	public static void main(String[] args) {
		System.out.println("begin:" + new Date());
		File file = new File("E:\\Document\\��������˹.mkv");
		if(file.exists()){
			System.out.println(file.length()/1024/1024d);
			try {
				InputStream is = new FileInputStream(file);
				OutputStream os = new FileOutputStream(new File("e:\\"+file.getName()));
				byte[] bytes = new byte[1024];
				while(is.read(bytes)!= -1){
					os.write(bytes);
				}
				is.close();
				os.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("end:" + new Date());
	}

}
