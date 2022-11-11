package com.ailpha.practice.stream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MemoryStreamInstance {

	public static void main(String[] args) throws IOException {
		
		// ByteArrayInputStream
		byte[] buf = "fuyunsong".getBytes();
		ByteArrayInputStream input = new ByteArrayInputStream(buf);
		
		// ByteArrayOutputStream
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		int result = 0;
		List<Byte> list = new ArrayList<>();
		while((result = input.read())!=-1){
			list.add((byte)result);
			System.out.println((char)result);
			output.write(result);
		}
		int size = list.size();
		int foot = 0;
		byte[]bytes = new byte[size];
		for (Byte byte1 : list) {
			bytes[foot++] = byte1;
		}
		System.out.println(new String(bytes,0,size));
		System.out.println(output.toString());

		input.close();
		output.close();

	}

}
