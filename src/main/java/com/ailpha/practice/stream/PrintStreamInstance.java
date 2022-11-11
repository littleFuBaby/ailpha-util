package com.ailpha.practice.stream;

import java.io.*;

public class PrintStreamInstance {

	public static void main(String[] args) throws IOException {
		File file = new File("e:\\fuys.txt");
		if(file.exists()){
			OutputStream os = new FileOutputStream(file);
			os.write("fuyunsong".getBytes());
			os.close();
			
			PrintStream ps = new PrintStream(os);
			ps.println("oh my god");
			ps.close();

			ps = new PrintStream(new FileOutputStream(file));
			ps.println("oh my godess");
			ps.close();
			
			InputStream is = new FileInputStream(file);
			byte[] bytes =  new byte[1024];
			is.read(bytes);
			System.out.println(new String(bytes,0,bytes.length));
			is.close();
			
		}
	}

}
