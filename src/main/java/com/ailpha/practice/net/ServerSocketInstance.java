package com.ailpha.practice.net;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketInstance {
	
	public static void main(String[] args) throws Exception {
		// set server port
		ServerSocket server = new ServerSocket(8888);
		
		System.out.println("Waiting for client ... ");
		
		// accept client
		Socket client = server.accept();
		
		// output date
		PrintStream output = new PrintStream(client.getOutputStream());
		output.println("Welcome to Server!");
		
		output.close();
		client.close();
		server.close();
		
	}

}
