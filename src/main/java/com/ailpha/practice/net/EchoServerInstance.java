package com.ailpha.practice.net;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

class EchoServerThread implements Runnable {
	
	private Socket client;
	public EchoServerThread(Socket client){
		this.client = client;
	}

	@Override
	public void run() {
		try {
			boolean flag = true;
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName + " start");
			Scanner clientInput = new Scanner(client.getInputStream());
			clientInput.useDelimiter("\n");
			PrintStream serverOutput = new PrintStream(client.getOutputStream());
			while (flag) {
				try {
					client.sendUrgentData(1);
				} catch (Exception e) {
					System.out.println(threadName + " | Client Connection is broken.");
					break;
				}
				if(clientInput.hasNext()){
					String input = clientInput.next().trim();
					if (input.equalsIgnoreCase("byebye")) {
						serverOutput.println("ECHO:See you next time");
						flag = false;
					} else {
						serverOutput.println("ECHO:" + input);
					}
				}
			}
			System.out.println(threadName + " end");
			serverOutput.close();
			clientInput.close();
			client.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}


public class EchoServerInstance {

	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(8888);
		System.out.println("ing......");
		boolean flag = true;
		while(flag){
			new Thread(new EchoServerThread(server.accept())).start();
		}
		server.close();
	}
}
