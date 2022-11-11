package com.ailpha.practice.stream;

import java.io.IOException;

public class SystemIOInstance {

	public static void main(String[] args) throws IOException {
		// outputstream
		System.err.println("error");
		System.out.println("nihao");
		
		// inputstream
		byte[] bytes = new byte[128];
		System.in.read(bytes);
		System.out.println(new String(bytes,0,bytes.length));
		
	}

}
