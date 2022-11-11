package com.ailpha.practice.net;

import com.ailpha.util.DateUtils;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

class AIServer implements Runnable {
	
	private Socket client;
	
	public AIServer(Socket client){
		this.client = client;
	}
	
	private boolean isConnected(Socket client) {
		if (client == null) {
			return false;
		}
		boolean isCon = true;
		try {
			client.sendUrgentData(1);
		} catch (Exception e) {
			System.out.println(client.getRemoteSocketAddress().toString() + "-Client Connection is broken . Please restart .");
			isCon = false;
		}
		return isCon;
	}
	
	private String call(String str) {
		String res = "AI:";
		switch (str.toLowerCase()) {
		case "hello":
			res += "hello,what can i do for you?";
			break;
		case "byebye":
			res += "Bye,see you next time.";
			break;
		default:
			res += "System is updating . I am very sorry and can't help you .";
			break;
		}
		return res;
	}

	@Override
	public void run() {
		
		if(this.isConnected(this.client)==false){
			return ;
		}

		try {
			
			boolean flag = true;
			
			Scanner clientInput = new Scanner(this.client.getInputStream());
			clientInput.useDelimiter("\n");
			PrintStream serverOutput = new PrintStream(this.client.getOutputStream());
			
			while (flag) {
				
				if(this.isConnected(this.client)==false){
					break;
				}
				
				if (clientInput.hasNextLine()) {
					
					String remoteSocketAdd = this.client.getRemoteSocketAddress().toString();
					
					String clientStr = clientInput.nextLine();
					System.out.println(remoteSocketAdd + "-client:" + clientStr);
					
					String response = this.call(clientStr);
					System.out.println(remoteSocketAdd + "-Server:" + response);
					serverOutput.println(response);
					
					if("byebye".equalsIgnoreCase(clientStr)){
						flag = false;
					}
				}
			}
			serverOutput.close();
			clientInput.close();
			this.client.close();
			
		} catch (Exception e) {
			System.out.println("Please restart .");
			System.err.println(e);
		}
	}
	
}

public class AIServerInstance {

	public static void main(String[] args) throws Exception {
		
		ServerSocket server = new ServerSocket(8888);
		
		boolean flag = true;
		while(flag){
			
			if(DateUtils.beforeHH(18)<=0 || DateUtils.beforeHH(9)>0){
				flag = false;
			}
			new Thread(new AIServer(server.accept())).start();
		}
		
		server.close();
		
	}


}
