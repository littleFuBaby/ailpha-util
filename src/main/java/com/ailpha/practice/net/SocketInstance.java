package com.ailpha.practice.net;

import java.net.Socket;
import java.util.Scanner;

public class SocketInstance {
	
	public static void main(String[] args) throws Exception {
		
		// set server
		Socket server = new Socket("127.0.0.1", 8888);
		
		// input
		Scanner input = new Scanner(server.getInputStream());
		
		// print data
		System.out.println("Server response:");
		while(input.hasNextLine()){
			System.out.println(input.nextLine());
		}
		
		input.close();
		server.close();
		
	}

}
