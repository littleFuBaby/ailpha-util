package com.ailpha.practice.net;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class EchoClientInstance {
	
	public static void main(String[] args) throws Exception {
		Socket client = new Socket("192.168.199.211", 8888);
		boolean flag = true;
		Scanner deviceInput = new Scanner(System.in);
		Scanner serverInput = new Scanner(client.getInputStream());
		deviceInput.useDelimiter("\n");
		serverInput.useDelimiter("\n");
		PrintStream clientOutput = new PrintStream(client.getOutputStream());
		while(flag){
			try {
				client.sendUrgentData(1);
			} catch (Exception e) {
				System.out.println("Connection is broken. Please check your network.");
				break;
			}
			System.out.print("Myself:");
			if(deviceInput.hasNext()){
				String str = deviceInput.next().trim();
				clientOutput.println(str);
				if(str.equalsIgnoreCase("byebye")){
					flag = false;
				}
				if(serverInput.hasNextLine()){
					System.out.println(serverInput.nextLine());
				}
			}
		}
		deviceInput.close();
		serverInput.close();
		clientOutput.close();
		client.close();
	}

}
