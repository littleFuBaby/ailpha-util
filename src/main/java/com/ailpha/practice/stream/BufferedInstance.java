package com.ailpha.practice.stream;

import java.io.*;

public class BufferedInstance {

	public static void main(String[] args) throws IOException {
		// BufferedOutputStream
		// BufferedInputStream
		File file = new File("e:\\fuys.txt");
		BufferedOutputStream output = null;
		BufferedInputStream input = null;
		byte[]bytes = new byte[1024];
		if(file.exists()){
			output = new BufferedOutputStream(new FileOutputStream(file));
			output.write("fuys".getBytes());
			output.close();
			
			input = new BufferedInputStream(new FileInputStream(file));
			input.read(bytes);
			System.out.println(new String(bytes,0,512));
			input.close();
			
		}
		
		
		input = new BufferedInputStream(System.in);
		input.read(bytes);
		System.out.println(new String(bytes,0,512));
		// BufferedWriter
		// BufferedReader
		BufferedWriter output2 = new BufferedWriter(new OutputStreamWriter(System.out));
		output2.write("hello world");
		
		BufferedReader input2 = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("please enter password");
		String str = input2.readLine();
		System.out.println("password is " + str);
		
		input.close();
		output2.close();
		input2.close();
	}

}
